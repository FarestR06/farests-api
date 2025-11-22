package com.farestr06.api.block;

import com.farestr06.api.item.ItemHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class BlockHelper {

    /**
     * Makes a block without a corresponding item.
     * @param key The resource/registry key, which is used to help with models and loot
     * @param factory The function used to create the block
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     * @apiNote This method requires a resource/registry key. Ideally, you should use the other methods, which create
     * the necessary keys automatically.
     */
    public static Block register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = factory.apply(settings.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    /**
     * Makes a block without a corresponding item.
     * @param id The block's resource location/identifier
     * @param factory The function used to create the block
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeBlock(ResourceLocation id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return register(keyOf(id), factory, settings);
    }

    /**
     * Makes a basic block without a corresponding item.
     * @param id The block's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeSimpleBlock(ResourceLocation id, BlockBehaviour.Properties settings) {
        return makeBlock(id, Block::new, settings);
    }

    /**
     * Makes a resource/registry key from a resource location/identifier.
     * @param id The location/id used to create the key
     * @return A resource/registry key created from the given id
     */
    private static ResourceKey<Block> keyOf(ResourceLocation id) {
        return ResourceKey.create(Registries.BLOCK, id);
    }


    /**
     * Makes a block and a corresponding item with default properties/settings.
     * @param key The resource/registry key, which is used to help with item names, models and loot
     * @param factory The function used to create the block
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     * @apiNote This method requires a resource/registry key. Ideally, you should use the other methods, which create
     * the necessary keys automatically.
     */
    public static Block registerWithSimpleItem(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(settings.setId(key)));
        ItemHelper.makeSimpleBlockItem(block);
        return block;
    }

    public static Block registerWithSimpleAliasedItem(ResourceKey<Block> key, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(settings.setId(key)));
        ItemHelper.makeSimpleAliasedBlockItem(block, itemId);
        return block;
    }

    /**
     * Makes a block and a corresponding item with default properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param factory The function used to create the block
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeBlockAndSimpleItem(ResourceLocation id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return registerWithSimpleItem(keyOf(id), factory, settings);
    }

    public static Block makeBlockAndSimpleAliasedItem(ResourceLocation blockId, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return registerWithSimpleAliasedItem(keyOf(blockId), itemId, factory, settings);
    }

    /**
     * Makes a basic block and a corresponding item with default properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeSimpleBlockAndSimpleItem(ResourceLocation id, BlockBehaviour.Properties settings) {
        return makeBlockAndSimpleItem(id, Block::new, settings);
    }

    public static Block makeSimpleBlockAndSimpleAliasedItem(ResourceLocation blockId, ResourceLocation itemId, BlockBehaviour.Properties settings) {
        return makeBlockAndSimpleAliasedItem(blockId, itemId, Block::new, settings);
    }

    /**
     * Makes a block and a corresponding item with custom properties/settings.
     * @param key The resource/registry key, which is used to help with item names, models and loot
     * @param factory The function used to create the block
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemSettings The properties/settings to be applied to the item
     * @return The registered block
     * @apiNote This method requires a resource/registry key. Ideally, you should use the other methods, which create
     * the necessary keys automatically.
     */
    public static Block registerWithItem(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties blockSettings, Item.Properties itemSettings) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(blockSettings.setId(key)));
        ItemHelper.makeBlockItem(block, itemSettings);
        return block;
    }
    /**
     * Makes a block and a corresponding item with custom properties/settings.
     * @param key The resource/registry key, which is used to help with item names, models and loot
     * @param factory The function used to create the block
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemSettings The properties/settings to be applied to the item
     * @return The registered block
     * @apiNote This method requires a resource/registry key. Ideally, you should use the other methods, which create
     * the necessary keys automatically.
     */
    public static Block registerWithAliasedItem(ResourceKey<Block> key, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties blockSettings, Item.Properties itemSettings) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(blockSettings.setId(key)));
        ItemHelper.makeAliasedBlockItem(block, itemId, itemSettings);
        return block;
    }

    /**
     * Makes a block and a corresponding item with custom properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param factory The function used to create the block
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemSettings The properties/settings to be applied to the item
     * @return The registered block
     */
    public static Block makeBlockAndItem(ResourceLocation id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties blockSettings, Item.Properties itemSettings) {
        return registerWithItem(keyOf(id), factory, blockSettings, itemSettings);
    }

    public static Block makeBlockAndAliasedItem(
            ResourceLocation blockId, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> factory,
            BlockBehaviour.Properties blockSettings, Item.Properties itemSettings
    ) {
        return registerWithAliasedItem(keyOf(blockId), itemId, factory, blockSettings, itemSettings);
    }

    /**
     * Makes a basic block and a corresponding item with custom properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemSettings The properties/settings to be applied to the item
     * @return The registered block
     */
    public static Block makeSimpleBlockAndItem(ResourceLocation id, BlockBehaviour.Properties blockSettings, Item.Properties itemSettings) {
        return registerWithItem(keyOf(id), Block::new, blockSettings, itemSettings);
    }

    /**
     * Makes a block and an advanced corresponding item with custom properties/settings.
     * @param key The resource/registry key, which is used to help with item names, models and loot
     * @param blockFactory The function used to create the block
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemFactory The function used to create the block's item
     * @param itemSettings The properties/settings to be applied to the item
     * @return The registered block
     * @apiNote This method requires a resource/registry key. Ideally, you should use the other methods, which create
     * the necessary keys automatically.
     */
    public static Block registerWithAdvancedItem(
            ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> blockFactory,
            BlockBehaviour.Properties blockSettings, BiFunction<Block, Item.Properties, Item> itemFactory,
            Item.Properties itemSettings
    ) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, key, blockFactory.apply(blockSettings.setId(key)));
        ItemHelper.makeAdvancedBlockItem(block, itemFactory, itemSettings);
        return block;
    }
    public static Block registerWithAdvancedAliasedItem(
            ResourceKey<Block> key, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> blockFactory,
            BlockBehaviour.Properties blockSettings, BiFunction<Block, Item.Properties, Item> itemFactory,
            Item.Properties itemSettings
    ) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, key, blockFactory.apply(blockSettings.setId(key)));
        ItemHelper.makeAdvancedBlockItemWithUniqueName(block, itemId, itemFactory, itemSettings);
        return block;
    }

    /**
     * Makes a block and an advanced corresponding item with custom properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param blockFactory The function used to create the block
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemFactory The function used to create the block's item
     * @param itemSettings The properties/settings to be applied to the item
     * @return The registered block
     */
    public static Block makeBlockAndAdvancedItem(
            ResourceLocation id, Function<BlockBehaviour.Properties, Block> blockFactory,
            BlockBehaviour.Properties blockSettings, BiFunction<Block, Item.Properties, Item> itemFactory,
            Item.Properties itemSettings
    ) {
        return registerWithAdvancedItem(keyOf(id), blockFactory, blockSettings, itemFactory, itemSettings);
    }

    public static Block makeBlockAndAdvancedAliasedItem(
            ResourceLocation blockId, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> blockFactory,
            BlockBehaviour.Properties blockSettings, BiFunction<Block, Item.Properties, Item> itemFactory,
            Item.Properties itemSettings
    ) {
        return registerWithAdvancedAliasedItem(keyOf(blockId), itemId, blockFactory, blockSettings, itemFactory, itemSettings);
    }

    /**
     * Makes a basic block and an advanced corresponding item with custom properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param blockSettings The properties/settings to be applied to the block
     * @param factory The function used to create the block's item
     * @param settings The properties/settings to be applied to the item
     * @return The registered block
     */
    public static Block makeSimpleBlockAndAdvancedItem(
            ResourceLocation id, BlockBehaviour.Properties blockSettings,
            BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings
    ) {
        return makeBlockAndAdvancedItem(id, Block::new, blockSettings, factory, settings);
    }

    public static Block makeSimpleBlockAndAdvancedAliasedItem(
            ResourceLocation blockId, ResourceLocation itemId, BlockBehaviour.Properties blockSettings,
            BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings
    ) {
        return makeBlockAndAdvancedAliasedItem(blockId, itemId, Block::new, blockSettings, factory, settings);
    }

    /**
     * Makes a block and an advanced corresponding item with default properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param blockFactory The function used to create the block
     * @param settings The properties/settings to be applied to the block
     * @param itemFactory The function used to create the block's item
     * @return The registered block
     */
    public static Block makeBlockAndAdvancedItemWithDefaultSettings(
            ResourceLocation id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings,
            BiFunction<Block, Item.Properties, Item> itemFactory
    ) {
        return registerWithAdvancedItem(keyOf(id), blockFactory, settings, itemFactory, new Item.Properties());
    }
    public static Block makeBlockAndAdvancedAliasedItemWithDefaultSettings(
            ResourceLocation blockId, ResourceLocation itemId, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings,
            BiFunction<Block, Item.Properties, Item> itemFactory
    ) {
        return registerWithAdvancedAliasedItem(
                keyOf(blockId), itemId, blockFactory, settings, itemFactory, new Item.Properties()
        );
    }

    /**
     * Makes a basic block and an advanced corresponding item with default properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @param factory The function used to create the block's item
     * @return The registered block
     */
    public static Block makeSimpleBlockAndAdvancedItemWithDefaultSettings(
            ResourceLocation id, BlockBehaviour.Properties settings, BiFunction<Block, Item.Properties, Item> factory
    ) {
        return makeBlockAndAdvancedItemWithDefaultSettings(id, Block::new, settings, factory);
    }

    public static Block makeSimpleBlockAndAdvancedAliasedItemWithDefaultSettings(
            ResourceLocation blockId, ResourceLocation itemId, BlockBehaviour.Properties settings, BiFunction<Block, Item.Properties, Item> factory
    ) {
        return makeBlockAndAdvancedAliasedItemWithDefaultSettings(blockId, itemId, Block::new, settings, factory);
    }


    /**
     * Makes a basic block without a corresponding item.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldBlock(ResourceLocation id, BlockBehaviour.Properties settings) {
        return Registry.register(BuiltInRegistries.BLOCK, id, new Block(settings.setId(ResourceKey.create(Registries.BLOCK, id))));
    }

    /**
     * Makes a basic block and a corresponding item with default properties/settings
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's and item's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldBlockAndItem(ResourceLocation id, BlockBehaviour.Properties settings) {
        return makeOldBlockAndItem(id, settings, new Item.Properties());
    }

    /**
     * Makes a basic block and a corresponding item with custom properties/settings.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's and item's resource location/identifier
     * @param blockSettings The properties/settings to be applied to the block
     * @param itemSettings The properties/settings to be applied to the block's item
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldBlockAndItem(ResourceLocation id, BlockBehaviour.Properties blockSettings, Item.Properties itemSettings) {
        Block block = makeOldBlock(id, blockSettings);
        makeOldBlockItem(id, block, itemSettings);
        return block;
    }

    /**
     * Makes an advanced block without a corresponding item.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's resource location/identifier
     * @param advancedBlock The block to be registered
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldAdvancedBlock(ResourceLocation id, Block advancedBlock) {
        return Registry.register(BuiltInRegistries.BLOCK, id, advancedBlock);
    }

    /**
     * Makes an advanced block and a corresponding item with default properties/settings.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's resource location/identifier
     * @param advancedBlock The block to be registered
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldAdvancedBlockAndItem(ResourceLocation id, Block advancedBlock) {
        return makeOldAdvancedBlockAndItem(id, advancedBlock, new Item.Properties());
    }

    /**
     * Makes an advanced block and a corresponding item with custom properties/settings.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's and item's resource location/identifier
     * @param advancedBlock The block to be registered
     * @param settings The properties/settings to be applied to the block's item
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldAdvancedBlockAndItem(ResourceLocation id, Block advancedBlock, Item.Properties settings) {
        makeOldBlockItem(id, advancedBlock, settings);
        return makeOldAdvancedBlock(id, advancedBlock);
    }

    /**
     * Makes a block item with default properties/settings.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The item's resource location/identifier
     * @param block The block that the item should place
     * @return The registered block item
     */
    @Deprecated
    public static Item makeOldBlockItem(ResourceLocation id, Block block) {
        return makeOldBlockItem(id, block, new Item.Properties());
    }

    /**
     * Makes a block item with custom properties/settings.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The item's resource location/identifier
     * @param block The block that the item should place
     * @param settings The properties/settings to be applied to the block's item
     * @return The registered block item
     */
    @Deprecated
    public static Item makeOldBlockItem(ResourceLocation id, Block block, Item.Properties settings) {
        Item blockItem = new BlockItem(block, settings.setId(ResourceKey.create(Registries.ITEM, id)));
        return Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }

}
