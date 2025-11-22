package com.farestr06.api.util.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Collections;

public class BlockLootSubProviderAccess extends BlockLootSubProvider {
    private final HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

    public BlockLootSubProviderAccess(HolderLookup.Provider provider) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    public void generate() {
        throw new UnsupportedOperationException("This class is only for accessing helper methods, not generating JSON files!");
    }
}
