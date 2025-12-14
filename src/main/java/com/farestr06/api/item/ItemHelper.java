package com.farestr06.api.item;

import com.farestr06.api.util.LoggerHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class ItemHelper {
    private static void log(ResourceKey<Item> key) {
        LoggerHelper.get(key.location().getNamespace()).debug("Registering item \"{}\" through Farest's API", key.location());
    }

    /**
     * Makes a basic block with default properties/settings.
     * @param block The block that the block item should place
     * @return The registered item
     */
    public static Item makeSimpleBlockItem(Block block) {
        return makeAdvancedBlockItemWithDefaultSettings(block, BlockItem::new);
    }

    public static Item makeSimpleAliasedBlockItem(Block block, ResourceLocation location) {
        return makeAdvancedAliasedBlockItemWithDefaultSettings(block, location, BlockItem::new);
    }

    /**
     * Makes a basic block with custom properties/settings.
     * @param block The block that the block item should place
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    public static Item makeBlockItem(Block block, Item.Properties settings) {
        return makeAdvancedBlockItem(block, BlockItem::new, settings);
    }

    public static Item makeAliasedBlockItem(Block block, ResourceLocation location, Item.Properties settings) {
        return makeAdvancedBlockItemWithUniqueName(block, location, BlockItem::new, settings);
    }

    /**
     * Makes an advanced block item with default properties/settings.
     * @param block The block that the block item should place
     * @param factory The bi-function used to create the block item
     * @return The registered item
     */
    public static Item makeAdvancedBlockItemWithDefaultSettings(Block block, BiFunction<Block, Item.Properties, Item> factory) {
        return makeAdvancedBlockItem(block, factory, new Item.Properties());
    }
    public static Item makeAdvancedAliasedBlockItemWithDefaultSettings(Block block, ResourceLocation location, BiFunction<Block, Item.Properties, Item> factory) {
        return makeAdvancedBlockItemWithUniqueName(block, location, factory, new Item.Properties());
    }

    /**
     * Makes an advanced block item.
     * @param block The block that the block item should place
     * @param factory The bi-function used to create the block item
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    @SuppressWarnings("deprecation")
    public static Item makeAdvancedBlockItem(Block block, BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings) {
        return register(
                keyFromBlock(BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow()), itemSettings -> factory.apply(block, itemSettings), settings.useItemDescriptionPrefix()
        );
    }
    @SuppressWarnings("deprecation")
    public static Item makeAdvancedBlockItemWithUniqueName(Block block, ResourceLocation location, BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings) {
        return register(
                keyOf(location), itemSettings -> factory.apply(block, itemSettings.useItemDescriptionPrefix()), settings.useBlockDescriptionPrefix()
        );
    }

    /**
     * Makes an advanced item with default properties/settings.
     * @param location The item's resource location/ResourceLocation
     * @param factory The function used to create the item
     * @return The registered item
     */
    public static Item makeAdvancedItemWithDefaultSettings(ResourceLocation location, Function<Item.Properties, Item> factory) {
        return register(keyOf(location), factory);
    }

    /**
     * Makes an advanced item.
     * @param location The item's resource location/ResourceLocation
     * @param factory The function used to create the item
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    public static Item makeAdvancedItem(ResourceLocation location, Function<Item.Properties, Item> factory, Item.Properties settings) {
        return register(keyOf(location), factory, settings);
    }

    /**
     * Makes a basic item with custom properties/settings
     * @param location The item's resource location/ResourceLocation
     * @param settings The properties/settings to be applied to the item
     * @return The registered item
     */
    public static Item makeItem(ResourceLocation location, Item.Properties settings) {
        return register(keyOf(location), Item::new, settings);
    }

    /**
     * Makes a basic item with default properties/settings.
     * @param location The item's resource location/ResourceLocation
     * @return The registered item
     */
    public static Item makeSimpleItem(ResourceLocation location) {
        return register(keyOf(location), Item::new, new Item.Properties());
    }

    /**
     * Creates an advanced item with default properties/settings.
     * @param key The resource/registry key, which is used to help with names and models
     * @param factory The function used to create the advanced item
     * @return The registered item
     * @apiNote This method requires a resource/registry key. Ideally, you should use {@link ItemHelper#makeAdvancedItemWithDefaultSettings(ResourceLocation, Function)}, which creates
     * the necessary keys automatically.
     */
    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory) {
        return register(key, factory, new Item.Properties());
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
    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        log(key);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    /**
     * Creates a resource/registry key from a block's resource location/ResourceLocation.
     * @param blockKey The block whose id will be used to creeate the key
     * @return A resource/registry key created from the given block's id
     */
    private static ResourceKey<Item> keyFromBlock(ResourceKey<Block> blockKey) {
        return ResourceKey.create(Registries.ITEM, blockKey.location());
    }

    /**
     * Creates a resource/registry key from a resource location/ResourceLocation.
     * @param location The location/id used to create the key
     * @return A resource/registry key created from the given id
     */
    private static ResourceKey<Item> keyOf(ResourceLocation location) {
        return ResourceKey.create(Registries.ITEM, location);
    }

    public static Function<Item.Properties, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemDescriptionPrefix());
    }
}