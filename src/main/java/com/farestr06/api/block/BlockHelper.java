package com.farestr06.api.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class BlockHelper {
    
    public static Block makeBlock(Identifier location, AbstractBlock.Settings settings) {
        return Registry.register(Registries.BLOCK, location, new Block(settings));
    }

    public static Block makeBlockAndItem(Identifier location, AbstractBlock.Settings settings) {
        return makeBlockAndItem(location, settings, new Item.Settings());
    }

    public static Block makeBlockAndItem(Identifier location, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        Block block = makeBlock(location, blockSettings);
        makeBlockItem(location, block, itemSettings);
        return block;
    }

    public static Block makeAdvancedBlock(Identifier location, Block advancedBlock) {
        return Registry.register(Registries.BLOCK, location, advancedBlock);
    }

    public static Block makeAdvancedBlockAndItem(Identifier location, Block advancedBlock) {
        return makeAdvancedBlockAndItem(location, advancedBlock, new Item.Settings());
    }

    public static Block makeAdvancedBlockAndItem(Identifier location, Block advancedBlock, Item.Settings itemProperties) {
        makeBlockItem(location, advancedBlock, itemProperties);
        return makeAdvancedBlock(location, advancedBlock);
    }

    public static Item makeBlockItem(Identifier location, Block block) {
        return makeBlockItem(location, block, new Item.Settings());
    }

    public static Item makeBlockItem(Identifier location, Block block, Item.Settings properties) {
            Item blockItem = new BlockItem(block, properties);
            return Registry.register(Registries.ITEM, location, blockItem);
    }
}
