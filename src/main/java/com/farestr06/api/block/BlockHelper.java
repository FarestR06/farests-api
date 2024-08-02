package com.farestr06.api.block;

import com.farestr06.api.util.exception.BlockRegistryFailure;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface BlockHelper {

    static Block makeBlock(Identifier location, AbstractBlock.Settings properties) {
        
        try {
            return Registry.register(Registries.BLOCK, location, new Block(properties));
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    static Block makeBlockAndItem(Identifier location, AbstractBlock.Settings properties) {
        return makeBlockAndItem(location, properties, new Item.Settings());
    }

    static Block makeBlockAndItem(Identifier location, AbstractBlock.Settings blockProperties, Item.Settings itemProperties) {

        try {
            Block block = makeBlock(location, blockProperties);
            makeBlockItem(location, block, itemProperties);
            return block;
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    static Block makeAdvancedBlock(Identifier location, Block advancedBlock) {

        try {
            return Registry.register(Registries.BLOCK, location, advancedBlock);
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    static Block makeAdvancedBlockAndItem(Identifier location, Block advancedBlock) {
        return makeAdvancedBlockAndItem(location, advancedBlock, new Item.Settings());
    }

    static Block makeAdvancedBlockAndItem(Identifier location, Block advancedBlock, Item.Settings itemProperties) {

        try {
            makeBlockItem(location, advancedBlock, itemProperties);
            return makeAdvancedBlock(location, advancedBlock);
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }

    static Item makeBlockItem(Identifier location, Block block) {
        return makeBlockItem(location, block, new Item.Settings());
    }

    static Item makeBlockItem(Identifier location, Block block, Item.Settings properties) {
        
        try {
            Item blockItem = new BlockItem(block, properties);
            return Registry.register(Registries.ITEM, location, blockItem);
        } catch (Exception e) {
            throw new BlockRegistryFailure(location, e);
        }
    }
}
