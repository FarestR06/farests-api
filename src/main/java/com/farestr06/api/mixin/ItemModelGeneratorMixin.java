package com.farestr06.api.mixin;

import com.farestr06.api.util.FarestsItemTags;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemModelGenerator.class)
public class ItemModelGeneratorMixin {
    /**
     * The data generator can only register a two-layer armor item for leather armor. This mixin changes that so any items in the
     * <code>fr06-api:has_overlay</code> tag.
     */
    @Redirect(method = "registerArmor", at = @At(value = "INVOKE", target = "Lnet/minecraft/registry/entry/RegistryEntry;matches(Lnet/minecraft/registry/entry/RegistryEntry;)Z"))
    private boolean redirected(RegistryEntry<ArmorMaterial> unused, RegistryEntry<?> unused1, @Local(argsOnly = true) ArmorItem item) {
        ItemStack stack = new ItemStack(item);
        return stack.isIn(FarestsItemTags.HAS_ARMOR_OVERLAY);
    }
}
