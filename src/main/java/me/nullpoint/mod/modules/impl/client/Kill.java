package me.nullpoint.mod.modules.impl.client;


import me.nullpoint.mod.modules.Module;


public class Kill extends Module{
    public static Kill INSTANCE;

    public Kill() {
        super("Kill", Category.Client);
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        mc.player.networkHandler.sendChatCommand("kill");
        disable();
    }

}
