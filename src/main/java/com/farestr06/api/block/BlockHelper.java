package com.farestr06.api.block;

import com.farestr06.api.util.exception.BlockRegistryFailure;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class BlockHelper {
    
    public static Block makeBlock(Identifier location, AbstractBlock.Settings settings) {
        
        try {
            return Registry.register(Registries.BLOCK, location, new Block(settings));
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    public static Block makeBlockAndItem(Identifier location, AbstractBlock.Settings settings) {
        return makeBlockAndItem(location, settings, new Item.Settings());
    }

    public static Block makeBlockAndItem(Identifier location, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {

        try {
            Block block = makeBlock(location, blockSettings);
            makeBlockItem(location, block, itemSettings);
            return block;
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    public static Block makeAdvancedBlock(Identifier location, Block advancedBlock) {

        try {
            return Registry.register(Registries.BLOCK, location, advancedBlock);
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    public static Block makeAdvancedBlockAndItem(Identifier location, Block advancedBlock) {
        return makeAdvancedBlockAndItem(location, advancedBlock, new Item.Settings());
    }

    public static Block makeAdvancedBlockAndItem(Identifier location, Block advancedBlock, Item.Settings itemProperties) {

        try {
            makeBlockItem(location, advancedBlock, itemProperties);
            return makeAdvancedBlock(location, advancedBlock);
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    public static Item makeBlockItem(Identifier location, Block block) {
        return makeBlockItem(location, block, new Item.Settings());
    }

    public static Item makeBlockItem(Identifier location, Block block, Item.Settings properties) {
        
        try {
            Item blockItem = new BlockItem(block, properties);
            return Registry.register(Registries.ITEM, location, blockItem);
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }
}
