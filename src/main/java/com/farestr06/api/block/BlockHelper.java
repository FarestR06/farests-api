package com.farestr06.api.block;

import com.farestr06.api.item.ItemHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

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
    public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    /**
     * Makes a block without a corresponding item.
     * @param id The block's resource location/identifier
     * @param factory The function used to create the block
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeBlock(Identifier id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(keyOf(id), factory, settings);
    }

    /**
     * Makes a basic block without a corresponding item.
     * @param id The block's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeSimpleBlock(Identifier id, AbstractBlock.Settings settings) {
        return makeBlock(id, Block::new, settings);
    }

    /**
     * Makes a resource/registry key from a resource location/identifier.
     * @param id The location/id used to create the key
     * @return A resource/registry key created from the given id
     */
    private static RegistryKey<Block> keyOf(Identifier id) {
        return RegistryKey.of(RegistryKeys.BLOCK, id);
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
    public static Block registerWithSimpleItem(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = Registry.register(Registries.BLOCK, key, factory.apply(settings.registryKey(key)));
        ItemHelper.makeSimpleBlockItem(block);
        return block;
    }

    public static Block registerWithSimpleAliasedItem(RegistryKey<Block> key, Identifier itemId, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = Registry.register(Registries.BLOCK, key, factory.apply(settings.registryKey(key)));
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
    public static Block makeBlockAndSimpleItem(Identifier id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return registerWithSimpleItem(keyOf(id), factory, settings);
    }

    public static Block makeBlockAndSimpleAliasedItem(Identifier blockId, Identifier itemId, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return registerWithSimpleAliasedItem(keyOf(blockId), itemId, factory, settings);
    }

    /**
     * Makes a basic block and a corresponding item with default properties/settings.
     * @param id The block's and item's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    public static Block makeSimpleBlockAndSimpleItem(Identifier id, AbstractBlock.Settings settings) {
        return makeBlockAndSimpleItem(id, Block::new, settings);
    }

    public static Block makeSimpleBlockAndSimpleAliasedItem(Identifier blockId, Identifier itemId, AbstractBlock.Settings settings) {
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
    public static Block registerWithItem(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        Block block = Registry.register(Registries.BLOCK, key, factory.apply(blockSettings.registryKey(key)));
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
    public static Block registerWithAliasedItem(RegistryKey<Block> key, Identifier itemId, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        Block block = Registry.register(Registries.BLOCK, key, factory.apply(blockSettings.registryKey(key)));
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
    public static Block makeBlockAndItem(Identifier id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        return registerWithItem(keyOf(id), factory, blockSettings, itemSettings);
    }

    public static Block makeBlockAndAliasedItem(
            Identifier blockId, Identifier itemId, Function<AbstractBlock.Settings, Block> factory,
            AbstractBlock.Settings blockSettings, Item.Settings itemSettings
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
    public static Block makeSimpleBlockAndItem(Identifier id, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
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
            RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings blockSettings, BiFunction<Block, Item.Settings, Item> itemFactory,
            Item.Settings itemSettings
    ) {
        Block block = Registry.register(Registries.BLOCK, key, blockFactory.apply(blockSettings.registryKey(key)));
        ItemHelper.makeAdvancedBlockItem(block, itemFactory, itemSettings);
        return block;
    }
    public static Block registerWithAdvancedAliasedItem(
            RegistryKey<Block> key, Identifier itemId, Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings blockSettings, BiFunction<Block, Item.Settings, Item> itemFactory,
            Item.Settings itemSettings
    ) {
        Block block = Registry.register(Registries.BLOCK, key, blockFactory.apply(blockSettings.registryKey(key)));
        ItemHelper.makeAdvancedAliasedBlockItem(block, itemId, itemFactory, itemSettings);
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
            Identifier id, Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings blockSettings, BiFunction<Block, Item.Settings, Item> itemFactory,
            Item.Settings itemSettings
    ) {
        return registerWithAdvancedItem(keyOf(id), blockFactory, blockSettings, itemFactory, itemSettings);
    }

    public static Block makeBlockAndAdvancedAliasedItem(
            Identifier blockId, Identifier itemId, Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings blockSettings, BiFunction<Block, Item.Settings, Item> itemFactory,
            Item.Settings itemSettings
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
            Identifier id, AbstractBlock.Settings blockSettings,
            BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings
    ) {
        return makeBlockAndAdvancedItem(id, Block::new, blockSettings, factory, settings);
    }

    public static Block makeSimpleBlockAndAdvancedAliasedItem(
            Identifier blockId, Identifier itemId, AbstractBlock.Settings blockSettings,
            BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings
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
            Identifier id, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings,
            BiFunction<Block, Item.Settings, Item> itemFactory
    ) {
        return registerWithAdvancedItem(keyOf(id), blockFactory, settings, itemFactory, new Item.Settings());
    }
    public static Block makeBlockAndAdvancedAliasedItemWithDefaultSettings(
            Identifier blockId, Identifier itemId, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings,
            BiFunction<Block, Item.Settings, Item> itemFactory
    ) {
        return registerWithAdvancedAliasedItem(
                keyOf(blockId), itemId, blockFactory, settings, itemFactory, new Item.Settings()
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
            Identifier id, AbstractBlock.Settings settings, BiFunction<Block, Item.Settings, Item> factory
    ) {
        return makeBlockAndAdvancedItemWithDefaultSettings(id, Block::new, settings, factory);
    }

    public static Block makeSimpleBlockAndAdvancedAliasedItemWithDefaultSettings(
            Identifier blockId, Identifier itemId, AbstractBlock.Settings settings, BiFunction<Block, Item.Settings, Item> factory
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
    public static Block makeOldBlock(Identifier id, AbstractBlock.Settings settings) {
        return Registry.register(Registries.BLOCK, id, new Block(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id))));
    }

    /**
     * Makes a basic block and a corresponding item with default properties/settings
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's and item's resource location/identifier
     * @param settings The properties/settings to be applied to the block
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldBlockAndItem(Identifier id, AbstractBlock.Settings settings) {
        return makeOldBlockAndItem(id, settings, new Item.Settings());
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
    public static Block makeOldBlockAndItem(Identifier id, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
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
    public static Block makeOldAdvancedBlock(Identifier id, Block advancedBlock) {
        return Registry.register(Registries.BLOCK, id, advancedBlock);
    }

    /**
     * Makes an advanced block and a corresponding item with default properties/settings.
     * @deprecated Block creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The block's resource location/identifier
     * @param advancedBlock The block to be registered
     * @return The registered block
     */
    @Deprecated
    public static Block makeOldAdvancedBlockAndItem(Identifier id, Block advancedBlock) {
        return makeOldAdvancedBlockAndItem(id, advancedBlock, new Item.Settings());
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
    public static Block makeOldAdvancedBlockAndItem(Identifier id, Block advancedBlock, Item.Settings settings) {
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
    public static Item makeOldBlockItem(Identifier id, Block block) {
        return makeOldBlockItem(id, block, new Item.Settings());
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
    public static Item makeOldBlockItem(Identifier id, Block block, Item.Settings settings) {
        Item blockItem = new BlockItem(block, settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
        return Registry.register(Registries.ITEM, id, blockItem);
    }

}
