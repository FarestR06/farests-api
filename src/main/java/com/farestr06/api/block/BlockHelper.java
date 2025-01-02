package com.farestr06.api.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class BlockHelper {
    
    public static Block makeBlock(Identifier id, AbstractBlock.Settings settings) {
        return Registry.register(Registries.BLOCK, id, new Block(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id))));
    }

    public static Block makeBlockAndItem(Identifier id, AbstractBlock.Settings settings) {
        return makeBlockAndItem(id, settings, new Item.Settings());
    }

    public static Block makeBlockAndItem(Identifier id, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        Block block = makeBlock(id, blockSettings);
        makeBlockItem(id, block, itemSettings);
        return block;
    }

    public static Block makeAdvancedBlock(Identifier id, Block advancedBlock) {
        return Registry.register(Registries.BLOCK, id, advancedBlock);
    }

    public static Block makeAdvancedBlockAndItem(Identifier id, Block advancedBlock) {
        return makeAdvancedBlockAndItem(id, advancedBlock, new Item.Settings());
    }

    public static Block makeAdvancedBlockAndItem(Identifier id, Block advancedBlock, Item.Settings settings) {
        makeBlockItem(id, advancedBlock, settings);
        return makeAdvancedBlock(id, advancedBlock);
    }

    public static Item makeBlockItem(Identifier id, Block block) {
        return makeBlockItem(id, block, new Item.Settings());
    }

    public static Item makeBlockItem(Identifier id, Block block, Item.Settings settings) {
            Item blockItem = new BlockItem(block, settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
            return Registry.register(Registries.ITEM, id, blockItem);
    }
}
