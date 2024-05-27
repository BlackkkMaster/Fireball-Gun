package com.blackkkmaster.fireballgun;

import com.blackkkmaster.fireballgun.item.ModItems;
import com.blackkkmaster.fireballgun.item.ModItemsGroups;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FireballGunMain implements ModInitializer {
	public static final String MOD_ID = "fireball-gun";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static int POWER = 1;

	@Override
	public void onInitialize() {

		ModItems.register();
		ModItemsGroups.registerGroups();
		FireballGunUsing.register();
	}
}
