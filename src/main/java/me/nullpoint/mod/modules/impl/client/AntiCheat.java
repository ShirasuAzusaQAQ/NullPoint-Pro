package me.nullpoint.mod.modules.impl.client;

import me.nullpoint.api.managers.CommandManager;
import me.nullpoint.mod.modules.Module;
import me.nullpoint.mod.modules.impl.combat.HoleKick;
import me.nullpoint.mod.modules.impl.combat.PistonCrystal;
import me.nullpoint.mod.modules.impl.player.NoSwap;
import me.nullpoint.mod.modules.settings.impl.SliderSetting;

public class AntiCheat extends Module {
    public AntiCheat(){
        super("AntiCheat", Category.Client);
    }
    public static AntiCheat INSTANCE;
    public final SliderSetting boxSize = add(new SliderSetting("HitBoxSize", 0.6, 0, 1, 0.01));
    private boolean needUpdate = true;

    public static double getOffset() {
        if (INSTANCE != null) return INSTANCE.boxSize.getValue() / 2;
        return 0.3;
    }

    @Override
    public void onLogin() {
        needUpdate = true;
    }

    @Override
    public void onUpdate(){
        if(nullCheck()) return;
        if(!needUpdate) return;
        if(mc.isInSingleplayer()) return;
        String server = mc.player.networkHandler.getServerInfo().address.toLowerCase();
        if(server.equals("2b2t.xin")){
            CommandManager.sendChatMessage("Update Config 2B2T.XIN");
            HoleKick.INSTANCE.yawDeceive.setValue(false);
            PistonCrystal.INSTANCE.yawDeceive.setValue(false);
            CombatSetting.INSTANCE.invSwapBypass.setValue(false);
            NoSwap.INSTANCE.disable();
        } else if(server.equals("crystalpvp.cn")){
            CommandManager.sendChatMessage("Update Config CrystalPVP.CN");
            HoleKick.INSTANCE.yawDeceive.setValue(true);
            PistonCrystal.INSTANCE.yawDeceive.setValue(true);
            CombatSetting.INSTANCE.invSwapBypass.setValue(true);
            NoSwap.INSTANCE.enable();
        }
        needUpdate = false;
    }
}
