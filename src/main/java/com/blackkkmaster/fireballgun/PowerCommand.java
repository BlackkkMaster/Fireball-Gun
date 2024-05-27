package com.blackkkmaster.fireballgun;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;

public class PowerCommand {
    private static final PlayerEntity playerEntity = MinecraftClient.getInstance().player;
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(literal("fireball_gun")
                .then(literal("power")
                        .then(argument("value", IntegerArgumentType.integer(0))
                            .executes(context -> {
                                int power = IntegerArgumentType.getInteger(context, "value");
                                if (power > 0 && power < 26) {
                                    FireballGunMain.POWER = power;
                                    if (playerEntity != null)
                                        playerEntity.sendMessage(Text.literal("Успешно установлено " + power));
                                }
                                else
                                    if (playerEntity != null)
                                        playerEntity.sendMessage(Text.literal("Введите число в диапазоне от 1 до 25"));
                                return 1;
                            })
                        )
                )
        );
    }

}
