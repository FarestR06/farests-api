package com.farestr06.api.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.farestr06.api.item.component.FarestsDataComponents.EXPLOSION_PROOF;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Redirect(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean redirected(ItemStack instance, Item item) {
        return instance.contains(EXPLOSION_PROOF);
    }
}
