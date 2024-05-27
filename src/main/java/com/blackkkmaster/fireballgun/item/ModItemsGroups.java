package com.blackkkmaster.fireballgun.item;

import com.blackkkmaster.fireballgun.FireballGunMain;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {
    private static final ItemGroup GUNS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FIREBALLGUN))
            .displayName(Text.translatable("itemGroup.fireball-gun.guns"))
            .entries((context, entries) -> {
                entries.add(ModItems.FIREBALLGUN);
            })
            .build();
    public static void registerGroups(){
        Registry.register(Registries.ITEM_GROUP, new Identifier(FireballGunMain.MOD_ID, "guns"), GUNS);
    }
}
