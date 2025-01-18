package com.farestr06.api.item;

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

public final class ItemHelper {

    /**
     * Makes a basic block with default properties/settings.
     * @param block The block that the block item should place
     * @return The registered item
     */
    public static Item makeSimpleBlockItem(Block block) {
        return makeAdvancedBlockItemWithDefaultSettings(block, BlockItem::new);
    }

    /**
     * Makes a basic block with custom properties/settings.
     * @param block The block that the block item should place
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    public static Item makeBlockItem(Block block, Item.Settings settings) {
        return makeAdvancedBlockItem(block, BlockItem::new, settings);
    }

    /**
     * Makes an advanced block item with default properties/settings.
     * @param block The block that the block item should place
     * @param factory The bi-function used to create the block item
     * @return The registered item
     */
    public static Item makeAdvancedBlockItemWithDefaultSettings(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return makeAdvancedBlockItem(block, factory, new Item.Settings());
    }

    /**
     * Makes an advanced block item.
     * @param block The block that the block item should place
     * @param factory The bi-function used to create the block item
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    @SuppressWarnings("deprecation")
    public static Item makeAdvancedBlockItem(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register(
                keyFromBlock(block.getRegistryEntry().registryKey()), itemSettings -> factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey()
        );
    }

    /**
     * Makes an advanced item with default properties/settings.
     * @param id The item's resource location/identifier
     * @param factory The function used to create the item
     * @return The registered item
     */
    public static Item makeAdvancedItemWithDefaultSettings(Identifier id, Function<Item.Settings, Item> factory) {
        return register(keyOf(id), factory);
    }

    /**
     * Makes an advanced item.
     * @param id The item's resource location/identifier
     * @param factory The function used to create the item
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    public static Item makeAdvancedItem(Identifier id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return register(keyOf(id), factory, settings);
    }

    /**
     * Makes a basic item with custom properties/settings
     * @param id The item's resource location/identifier
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    public static Item makeItem(Identifier id, Item.Settings settings) {
        return register(keyOf(id), Item::new, settings);
    }

    /**
     * Makes a basic item with default properties/settings.
     * @param id The item's resource location/identifier
     * @return The registered item
     */
    public static Item makeSimpleItem(Identifier id) {
        return register(keyOf(id), Item::new, new Item.Settings());
    }

    /**
     * Creates an advanced item with default properties/settings.
     * @param key The resource/registry key, which is used to help with names and models
     * @param factory The function used to create the advanced item
     * @return The registered item
     * @apiNote This method requires a resource/registry key. Ideally, you should use {@link ItemHelper#makeAdvancedItemWithDefaultSettings(Identifier, Function)}, which creates
     * the necessary keys automatically.
     */
    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory) {
        return register(key, factory, new Item.Settings());
    }

    /**
     * Creates an advanced item with custom properties/settings.
     * @param key The resource/registry key, which is used to help with names and models
     * @param factory The function used to create the item
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     * @apiNote This method requires a resource/registry key. Ideally, you should use the other methods, which create
     * the necessary keys automatically.
     */
    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    /**
     * Creates a resource/registry key from a block's resource location/identifier.
     * @param blockKey The block whose id will be used to creeate the key
     * @return A resource/registry key created from the given block's id
     */
    private static RegistryKey<Item> keyFromBlock(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }

    /**
     * Creates a resource/registry key from a resource location/identifier.
     * @param id The location/id used to create the key
     * @return A resource/registry key created from the given id
     */
    private static RegistryKey<Item> keyOf(Identifier id) {
        return RegistryKey.of(RegistryKeys.ITEM, id);
    }

    /**
     * Makes a basic item with default properties/settings.
     * @param id The item's resource location/identifier
     * @return The registered item
     * @deprecated Item creation has changed significantly since MC 1.21.2, making this method outdated.
     */
    @Deprecated
    public static Item makeOldSimpleItem(Identifier id) {
        return makeOldItem(id, new Item.Settings());
    }

    /**
     * Makes a basic item with custom properties/settings.
     * @param id The item's resource location/identifier
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     * @deprecated Item creation has changed significantly since MC 1.21.2, making this method outdated.
     */
    @Deprecated
    public static Item makeOldItem(Identifier id, Item.Settings settings) {
        return makeOldAdvancedItem(id, new Item(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, id))));
    }

    /**
     * Makes an advanced item.
     * @deprecated Item creation has changed significantly since MC 1.21.2, making this method outdated.
     * @param id The item's resource location/identifier
     * @param advancedItem The item to be registered
     * @return The registered item
     * @apiNote Settings are specified in the Item's constructor.
     */
    @Deprecated
    public static Item makeOldAdvancedItem(Identifier id, Item advancedItem) {
        return Registry.register(Registries.ITEM, id, advancedItem);
    }
}