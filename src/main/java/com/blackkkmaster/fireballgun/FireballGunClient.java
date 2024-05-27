package com.blackkkmaster.fireballgun;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.api.EnvType;

public class FireballGunClient implements ClientModInitializer {
    @Environment(EnvType.CLIENT)
    public static void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register(PowerCommand::register);
    }
    @Override
    public void onInitializeClient() {
        registerCommands();
    }
}
