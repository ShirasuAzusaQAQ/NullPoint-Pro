package me.nullpoint.mod.modules.impl.player;

import me.nullpoint.api.events.eventbus.EventHandler;
import me.nullpoint.api.events.impl.PacketEvent;
import me.nullpoint.api.events.eventbus.EventPriority;
import me.nullpoint.asm.accessors.IPlayerPositionLookS2CPacket;
import me.nullpoint.mod.modules.Module;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import java.util.Set;

public class NoRotateSet extends Module {
	public static NoRotateSet INSTANCE;
	public NoRotateSet() {
		super("NoRotateSet", Category.Player);
		INSTANCE = this;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPacketReceive(PacketEvent.Receive event){
		if(nullCheck()) return;
		if(event.getPacket() instanceof PlayerPositionLookS2CPacket packet){
			Set<PositionFlag> flags = packet.getFlags();
			float yaw = flags.contains(PositionFlag.Y_ROT) ? 0.0f : mc.player.getYaw();
			float pitch = flags.contains(PositionFlag.X_ROT) ? 0.0f : mc.player.getPitch();
			((IPlayerPositionLookS2CPacket) packet).setYaw(yaw);
			((IPlayerPositionLookS2CPacket) packet).setPitch(pitch);
		}
	}
}
