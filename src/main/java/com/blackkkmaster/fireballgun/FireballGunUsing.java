package com.blackkkmaster.fireballgun;

import com.blackkkmaster.fireballgun.item.ModItems;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;

public class FireballGunUsing {

    public static void register() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack active_item = player.getStackInHand(hand);
            if (active_item.isOf(ModItems.FIREBALLGUN)) {
                if (!world.isClient) {
                    Vec3d vec3d = player.getRotationVec(1.0f);
                    double x_cord = vec3d.x;
                    double y_cord = vec3d.y;
                    double z_cord = vec3d.z;
                    player.sendMessage(Text.literal(vec3d.x + ", " + vec3d.y + ", " + vec3d.z));
                    FireballEntity fireballEntity = new FireballEntity(world, player, x_cord, y_cord, z_cord, FireballGunMain.POWER);
//                    fireballEntity.setPosition(player.getX() + vec3d.x * 4.0, player.getBodyY(1) + 0.5, fireballEntity.getZ() + vec3d.z * 4.0);
                    fireballEntity.setPosition(player.getX() + vec3d.x, player.getY() + vec3d.x, player.getZ() + vec3d.x);
                    world.spawnEntity(fireballEntity);
                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                }
                if (!player.getAbilities().creativeMode) {
                    active_item.damage(1, player, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                }
            }
            return TypedActionResult.pass(active_item);
        });
    }
}
