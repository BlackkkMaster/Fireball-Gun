package com.blackkkmaster.fireballgun.item;

import com.blackkkmaster.fireballgun.FireballGunMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item FIREBALLGUN = registerItem("fireball_gun", new Item(new FabricItemSettings().maxDamage(30).rarity(Rarity.EPIC).fireproof()));
    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FireballGunMain.MOD_ID, id), item);
    }

    public static void register() {
        FireballGunMain.LOGGER.debug("Registering items for " + FireballGunMain.MOD_ID);
    }
}
