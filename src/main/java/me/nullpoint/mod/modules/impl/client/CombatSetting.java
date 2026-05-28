package me.nullpoint.mod.modules.impl.client;

import me.nullpoint.mod.modules.Module;
import me.nullpoint.mod.modules.settings.Placement;
import me.nullpoint.mod.modules.settings.SwingSide;
import me.nullpoint.mod.modules.settings.impl.BooleanSetting;
import me.nullpoint.mod.modules.settings.impl.EnumSetting;
import me.nullpoint.mod.modules.settings.impl.SliderSetting;

public class CombatSetting extends Module {
    public static CombatSetting INSTANCE;
    public final EnumSetting<Page> page = add(new EnumSetting<>("Page", Page.General));
    public final BooleanSetting invSwapBypass = add(new BooleanSetting("InvSwapBypass", true, v -> page.getValue() == Page.General));
    public final BooleanSetting lowVersion = add(new BooleanSetting("1.12", false, v -> page.getValue() == Page.General));
    public final BooleanSetting rotateSync = add(new BooleanSetting("RotateSync", true, v -> page.getValue() == Page.General));
    public final BooleanSetting packetPlace = add(new BooleanSetting("PacketPlace", true, v -> page.getValue() == Page.General));
    public final BooleanSetting randomPitch = add(new BooleanSetting("RandomPitch", false, v -> page.getValue() == Page.General));
    public final BooleanSetting rotations = add(new BooleanSetting("ShowRotations", true, v -> page.getValue() == Page.General));
    public final BooleanSetting attackRotate = add(new BooleanSetting("AttackRotate", false, v -> page.getValue() == Page.General));
    public final EnumSetting<Placement> placement = add(new EnumSetting<>("Placement", Placement.Vanilla, v -> page.getValue() == Page.General));
    public final SliderSetting rotateTime = add(new SliderSetting("RotateTime", 0.5, 0, 1, 0.01, v -> page.getValue() == Page.General));
    public final SliderSetting attackDelay = add(new SliderSetting("AttackDelay", 0.2, 0, 1, 0.01, v -> page.getValue() == Page.General));
    public final SliderSetting tp = add(new SliderSetting("TP", 50, 0, 300, 0.01, v -> page.getValue() == Page.General));

    public final BooleanSetting test = add(new BooleanSetting("Test", true, v -> page.getValue() == Page.General));

    public final SliderSetting boxSize = add(new SliderSetting("BoxSize", 0.6, 0, 1, 0.01, v -> page.getValue() == Page.General));
    public final BooleanSetting inventorySync = add(new BooleanSetting("InventorySync", false, v -> page.getValue() == Page.General));
    public final EnumSetting<SwingSide> swingMode = add(new EnumSetting<>("SwingMode", SwingSide.Server, v -> page.getValue() == Page.General));
    public final BooleanSetting obsMode = add(new BooleanSetting("OBSServer", false, v -> page.getValue() == Page.General));
    public final BooleanSetting coordinator = add(new BooleanSetting("Coordinator", true, v -> page.getValue() == Page.General));
    public final SliderSetting actionWindow = add(new SliderSetting("ActionWindow", 40, 0, 200, 1, v -> page.getValue() == Page.General));
    public final SliderSetting burstWindow = add(new SliderSetting("BurstWindow", 100, 0, 500, 1, v -> page.getValue() == Page.General));
    public final SliderSetting emergencyWindow = add(new SliderSetting("EmergencyWindow", 200, 0, 500, 1, v -> page.getValue() == Page.General));
    public final BooleanSetting debugCoordinator = add(new BooleanSetting("DebugCoordinator", false, v -> page.getValue() == Page.General));
    public final BooleanSetting priority = add(new BooleanSetting("Priority", true, v -> page.getValue() == Page.Priority));
    public final SliderSetting anchorAssistPriority = addPriority("AnchorAssist", 70);
    public final SliderSetting anchorAuraPriority = addPriority("AnchorAura", 70);
    public final SliderSetting anchorAuraProPriority = addPriority("AnchorAuraPro", 70);
    public final SliderSetting antiPistonPriority = addPriority("AntiPiston", 65);
    public final SliderSetting auraPriority = addPriority("Aura", 30);
    public final SliderSetting autoAnchorPriority = addPriority("AutoAnchor", 70);
    public final SliderSetting autoCityPriority = addPriority("AutoCity", 50);
    public final SliderSetting autoCityDownPriority = addPriority("AutoCityDown", 50);
    public final SliderSetting autoCityMaxPriority = addPriority("AutoCityMax", 50);
    public final SliderSetting autoClearHeadPriority = addPriority("AutoClearHead", 35);
    public final SliderSetting autoCrystalPriority = addPriority("AutoCrystal", 80);
    public final SliderSetting autoCrystalProPriority = addPriority("AutoCrystalPro", 80);
    public final SliderSetting autoExpPriority = addPriority("AutoEXP", 20);
    public final SliderSetting autoPotPriority = addPriority("AutoPot", 95);
    public final SliderSetting autoRegearPriority = addPriority("AutoRegear", 95);
    public final SliderSetting autoTotemPriority = addPriority("AutoTotem", 100);
    public final SliderSetting autoTrapPriority = addPriority("AutoTrap", 60);
    public final SliderSetting autoTrapProPriority = addPriority("AutoTrapPro", 60);
    public final SliderSetting bedAuraPriority = addPriority("BedAura", 80);
    public final SliderSetting blockerPriority = addPriority("Blocker", 55);
    public final SliderSetting burrowPriority = addPriority("Burrow", 90);
    public final SliderSetting burrowAssistPriority = addPriority("BurrowAssist", 90);
    public final SliderSetting burrowProPriority = addPriority("BurrowPro", 90);
    public final SliderSetting feetTrapPriority = addPriority("FeetTrap", 90);
    public final SliderSetting holeFillerPriority = addPriority("HoleFiller", 10);
    public final SliderSetting holeKickPriority = addPriority("HoleKick", 50);
    public final SliderSetting holeKickProPriority = addPriority("HoleKickPro", 50);
    public final SliderSetting pistonCrystalPriority = addPriority("PistonCrystal", 80);
    public final SliderSetting selfFillPriority = addPriority("SelfFill", 90);
    public final SliderSetting selfFlattenPriority = addPriority("SelfFlatten", 90);
    public final SliderSetting speedMinePriority = addPriority("SpeedMine", 45);
    public final SliderSetting tpauraPriority = addPriority("TPAura", 30);
    public final SliderSetting vAnchorAuraPriority = addPriority("VAnchorAura", 70);
    public final SliderSetting vAutoCityPriority = addPriority("VAutoCity", 50);
    public final SliderSetting vSpeedMinePriority = addPriority("VSpeedMine", 45);
    public final SliderSetting vWebAuraPriority = addPriority("VWebAura", 40);
    public final SliderSetting webAuraPriority = addPriority("WebAura", 40);
    public final SliderSetting webAuraProPriority = addPriority("WebAuraPro", 40);
    public final SliderSetting webCleanerPriority = addPriority("WebCleaner", 35);
    public CombatSetting() {
        super("CombatSetting", Category.Client);
        INSTANCE = this;
    }

    public static double getOffset() {
        if (INSTANCE != null) return INSTANCE.boxSize.getValue() / 2;
        return 0.3;
    }

    private SliderSetting addPriority(String name, double value) {
        return add(new SliderSetting(name, value, 0, 200, 1, v -> page.getValue() == Page.Priority && priority.getValue()));
    }

    public int getPriority(String module, int fallback) {
        if (!priority.getValue()) return fallback;
        return switch (module) {
            case "AnchorAssist" -> anchorAssistPriority.getValueInt();
            case "AnchorAura" -> anchorAuraPriority.getValueInt();
            case "AnchorAuraPro" -> anchorAuraProPriority.getValueInt();
            case "AntiPiston" -> antiPistonPriority.getValueInt();
            case "Aura" -> auraPriority.getValueInt();
            case "AutoAnchor" -> autoAnchorPriority.getValueInt();
            case "AutoCity" -> autoCityPriority.getValueInt();
            case "AutoCityDown" -> autoCityDownPriority.getValueInt();
            case "AutoCityMax" -> autoCityMaxPriority.getValueInt();
            case "AutoClearHead" -> autoClearHeadPriority.getValueInt();
            case "AutoCrystal" -> autoCrystalPriority.getValueInt();
            case "AutoCrystalPro" -> autoCrystalProPriority.getValueInt();
            case "AutoEXP" -> autoExpPriority.getValueInt();
            case "AutoPot" -> autoPotPriority.getValueInt();
            case "AutoRegear" -> autoRegearPriority.getValueInt();
            case "AutoTotem" -> autoTotemPriority.getValueInt();
            case "AutoTrap" -> autoTrapPriority.getValueInt();
            case "AutoTrapPro" -> autoTrapProPriority.getValueInt();
            case "BedAura" -> bedAuraPriority.getValueInt();
            case "Blocker" -> blockerPriority.getValueInt();
            case "Burrow" -> burrowPriority.getValueInt();
            case "BurrowAssist" -> burrowAssistPriority.getValueInt();
            case "BurrowPro" -> burrowProPriority.getValueInt();
            case "FeetTrap" -> feetTrapPriority.getValueInt();
            case "HoleFiller" -> holeFillerPriority.getValueInt();
            case "HoleKick" -> holeKickPriority.getValueInt();
            case "HoleKickPro" -> holeKickProPriority.getValueInt();
            case "PistonCrystal" -> pistonCrystalPriority.getValueInt();
            case "SelfFill" -> selfFillPriority.getValueInt();
            case "SelfFlatten" -> selfFlattenPriority.getValueInt();
            case "SpeedMine" -> speedMinePriority.getValueInt();
            case "TPAura" -> tpauraPriority.getValueInt();
            case "VAnchorAura" -> vAnchorAuraPriority.getValueInt();
            case "VAutoCity" -> vAutoCityPriority.getValueInt();
            case "VSpeedMine" -> vSpeedMinePriority.getValueInt();
            case "VWebAura" -> vWebAuraPriority.getValueInt();
            case "WebAura" -> webAuraPriority.getValueInt();
            case "WebAuraPro" -> webAuraProPriority.getValueInt();
            case "WebCleaner" -> webCleanerPriority.getValueInt();
            default -> fallback;
        };
    }
    @Override
    public void enable() {
        this.state = true;
    }

    @Override
    public void disable() {
        this.state = true;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    public enum Page {
        General,
        Priority
    }
}
