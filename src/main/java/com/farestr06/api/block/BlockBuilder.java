package com.farestr06.api.block;

import com.farestr06.api.item.ItemBuilder;
import com.farestr06.api.util.GameObjectBuilder;
import com.farestr06.api.util.Translator;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class BlockBuilder extends GameObjectBuilder<Block> {
    private boolean enabled = true;
    private Identifier aliasedLocation = location;
    private AbstractBlock.Settings settings = AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK).registryKey(makeKey());

    public BlockBuilder(Identifier location) {
        super(Registries.BLOCK, location);
    }
    public BlockBuilder(Identifier location, boolean condition) {
        super(Registries.BLOCK, location);
        enabled = condition;
    }
    public BlockBuilder(Identifier blockLocation, Identifier itemLocation) {
        super(Registries.BLOCK, blockLocation);
        this.aliasedLocation = itemLocation;
    }
    public BlockBuilder(Identifier blockLocation, Identifier itemLocation, boolean condition) {
        super(Registries.BLOCK, blockLocation);
        this.aliasedLocation = itemLocation;
        this.enabled = condition;
    }

    public BlockBuilder settings(AbstractBlock.Settings settings) {
        this.settings = settings.registryKey(makeKey());
        return this;
    }

    public BlockBuilder construct(Function<AbstractBlock.Settings, Block> factory) {
        if (enabled) {
            this.gameObject = factory.apply(this.settings);
        }
        return this;
    }

    public BlockBuilder cube() {
        return construct(Block::new);
    }
    public BlockBuilder slab() {
        return construct(SlabBlock::new);
    }
    public BlockBuilder stairs(BlockState baseBlockState) {
        return construct(lSettings -> new StairsBlock(baseBlockState, lSettings));
    }
    public BlockBuilder wall() {
        return construct(WallBlock::new);
    }
    
    private RegistryKey<Block> makeKey() {
        return RegistryKey.of(RegistryKeys.BLOCK, this.location);
    }

    @Override
    public Block build() {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!");
        }
        return Registry.register(this.registry, this.makeKey(), this.gameObject);
    }
    public Block build(String name, Translator translator) {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!" + getExceptionalObject());
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        translator.addBlock(block, name);
        return block;
    }
    public Block buildWithItem() {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!");
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
        Registry.register(
                Registries.ITEM, itemKey,
                new BlockItem(block, new Item.Settings().registryKey(itemKey))
        );
        return block;
    }
    public Block buildWithItem(String name, Translator translator) {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!" + getExceptionalObject());
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
        Registry.register(
                Registries.ITEM, itemKey,
                new BlockItem(block, new Item.Settings().registryKey(itemKey))
        );
        translator.addBlock(block, name);
        return block;
    }
    public Block buildWithItemAndUniqueName() {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!" + getExceptionalObject());
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
        Registry.register(
                Registries.ITEM, itemKey,
                new BlockItem(block, new Item.Settings().registryKey(itemKey).useItemPrefixedTranslationKey())
        );
        return block;
    }
    public Block buildWithItemAndUniqueName(String blockName, String itemName, Translator translator) {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!" + getExceptionalObject());
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
        Item item = Registry.register(
                Registries.ITEM, itemKey,
                new BlockItem(block, new Item.Settings().registryKey(itemKey).useItemPrefixedTranslationKey())
        );
        translator.addBlock(block, blockName);
        translator.addItem(item, itemName);
        return block;
    }
    public Block buildWithItem(Item.Settings itemSettings) {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!");
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
        Registry.register(
                Registries.ITEM, itemKey,
                new BlockItem(block, itemSettings.registryKey(itemKey))
        );
        return block;
    }
    public Block buildWithItemAndUniqueName(Item.Settings itemSettings, String blockName, String itemName, Translator translator) {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed block!");
        }
        Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
        RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
        Item item = Registry.register(
                Registries.ITEM, itemKey,
                new BlockItem(block, itemSettings.registryKey(itemKey).useItemPrefixedTranslationKey())
        );
        translator.addBlock(block, blockName);
        translator.addItem(item, itemName);
        return block;
    }


    @Override
    @Nullable
    public Block buildOptional() {
        if (gameObject != null) {
            return Registry.register(this.registry, this.makeKey(), this.gameObject);
        }
        return null;
    }
    @Nullable
    public Block buildOptional(String name, Translator translator) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            translator.addBlock(block, name);
            return block;
        }
        return null;
    }
    @Nullable
    public Block buildOptionalWithItem() {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, new Item.Settings().registryKey(itemKey))
            );
            return block;
        }
        return null;
    }
    @Nullable
    public Block buildOptionalWithItem(String name, Translator translator) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Item item = Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, new Item.Settings().registryKey(itemKey))
            );
            translator.addBlock(block, name);
            return block;
        }
        return null;
    }

    @Nullable
    public Block buildOptionalWithItemAndUniqueName() {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, new Item.Settings().registryKey(itemKey).useItemPrefixedTranslationKey())
            );
            return block;
        }
        return null;
    }

    @Nullable
    public Block buildOptionalWithItem(String blockName, String itemName, Translator translator) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Item item = Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, new Item.Settings().registryKey(itemKey).useItemPrefixedTranslationKey())
            );
            translator.addBlock(block, blockName);
            translator.addItem(item, itemName);
            return block;
        }
        return null;
    }

    @Nullable
    public Block buildOptionalWithItem(Item.Settings itemSettings) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, itemSettings.registryKey(itemKey))
            );
            return block;
        }
        return null;
    }
    @Nullable
    public Block buildOptionalWithItem(Item.Settings itemSettings, String name, Translator translator) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Item item = Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, itemSettings.registryKey(itemKey))
            );
            translator.addBlock(block, name);
            translator.addItem(item, name);
            return block;
        }
        return null;
    }
    @Nullable
    public Block buildOptionalWithItemAndUniqueName(Item.Settings itemSettings) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, itemSettings.registryKey(itemKey).useItemPrefixedTranslationKey())
            );
            return block;
        }
        return null;
    }
    @Nullable
    public Block buildOptionalWithItemAndUniqueName(Item.Settings itemSettings, String blockName, String itemName, Translator translator) {
        if (gameObject != null) {
            Block block = Registry.register(this.registry, this.makeKey(), this.gameObject);
            RegistryKey<Item> itemKey = ItemBuilder.makeKey(this.aliasedLocation);
            Item item = Registry.register(
                    Registries.ITEM, itemKey,
                    new BlockItem(block, itemSettings.registryKey(itemKey).useItemPrefixedTranslationKey())
            );
            translator.addBlock(block, blockName);
            translator.addItem(item, itemName);
            return block;
        }
        return null;
    }
}
