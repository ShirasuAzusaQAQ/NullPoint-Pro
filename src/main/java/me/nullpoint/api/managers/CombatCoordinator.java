package me.nullpoint.api.managers;

import me.nullpoint.mod.modules.impl.client.CombatSetting;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public class CombatCoordinator {
    public enum Resource {
        AURA,
        HOTBAR,
        INVENTORY,
        ROTATION,
        BLOCK_USE,
        ENTITY_ATTACK,
        MOVEMENT_BURST
    }

    private final Map<Resource, Lease> leases = new EnumMap<>(Resource.class);

    public synchronized boolean tryAcquire(String owner, String action, int priority, long durationMs, Resource... resources) {
        if (CombatSetting.INSTANCE == null || !CombatSetting.INSTANCE.coordinator.getValue()) {
            return true;
        }

        priority = CombatSetting.INSTANCE.getPriority(owner, priority);
        long now = System.currentTimeMillis();
        clearExpired(now);
        for (Resource resource : resources) {
            Lease lease = leases.get(resource);
            if (lease != null && !lease.owner.equals(owner) && lease.priority >= priority) {
                log(owner, action, "blocked by " + lease.owner + " on " + resource);
                return false;
            }
        }

        long expiresAt = now + Math.max(1, durationMs);
        for (Resource resource : resources) {
            Lease lease = leases.get(resource);
            if (lease == null || lease.owner.equals(owner) || lease.priority <= priority) {
                leases.put(resource, new Lease(owner, priority, expiresAt));
            }
        }
        log(owner, action, "accepted");
        return true;
    }

    public long actionWindow() {
        return CombatSetting.INSTANCE == null ? 40 : CombatSetting.INSTANCE.actionWindow.getValueInt();
    }

    public long burstWindow() {
        return CombatSetting.INSTANCE == null ? 100 : CombatSetting.INSTANCE.burstWindow.getValueInt();
    }

    public long emergencyWindow() {
        return CombatSetting.INSTANCE == null ? 200 : CombatSetting.INSTANCE.emergencyWindow.getValueInt();
    }

    public synchronized void clear() {
        leases.clear();
    }

    private void clearExpired(long now) {
        Iterator<Map.Entry<Resource, Lease>> iterator = leases.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().expiresAt <= now) {
                iterator.remove();
            }
        }
    }

    private void log(String owner, String action, String result) {
        if (CombatSetting.INSTANCE != null && CombatSetting.INSTANCE.debugCoordinator.getValue()) {
            System.out.println("[CombatCoordinator] " + owner + " " + action + " " + result);
        }
    }

    private static class Lease {
        private final String owner;
        private final int priority;
        private final long expiresAt;

        private Lease(String owner, int priority, long expiresAt) {
            this.owner = owner;
            this.priority = priority;
            this.expiresAt = expiresAt;
        }
    }
}
