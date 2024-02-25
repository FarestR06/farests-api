package com.farestr06.api.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class GlintedItem extends Item {
    public GlintedItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}