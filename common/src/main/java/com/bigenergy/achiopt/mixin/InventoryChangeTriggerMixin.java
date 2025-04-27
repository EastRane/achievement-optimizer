package com.bigenergy.achiopt.mixin;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryChangeTrigger.class)
public class InventoryChangeTriggerMixin {

    @Unique
    private int achiopt$ticksSkipped = 0;

    @Inject(method = "trigger(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At("HEAD"),
            cancellable = true)
    private void achiopt$onTrigger(ServerPlayer player, Inventory inventory, ItemStack stack, CallbackInfo ci) {

        int skipTicksAmount = 5;

        achiopt$ticksSkipped++;
        if (achiopt$ticksSkipped <= skipTicksAmount) {
            ci.cancel();
            return;
        }
        achiopt$ticksSkipped = 0;
    }
}
