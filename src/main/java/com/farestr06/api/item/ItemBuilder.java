package com.farestr06.api.item;

import com.farestr06.api.util.GameObjectBuilder;
import com.farestr06.api.util.Translator;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class ItemBuilder extends GameObjectBuilder<Item> {
    private boolean enabled = true;
    private Item.Settings settings = new Item.Settings().registryKey(makeKey());

    public ItemBuilder(Identifier location) {
        super(Registries.ITEM, location);
    }
    public ItemBuilder(Identifier location, boolean condition) {
        super(Registries.ITEM, location);
        enabled = condition;
    }

    public ItemBuilder settings(Item.Settings settings) {
        this.settings = settings.registryKey(makeKey());
        return this;
    }

    public ItemBuilder simpleItem() {
        return construct(Item::new);
    }

    public ItemBuilder construct(Function<Item.Settings, Item> factory) {
        if (enabled) {
            this.gameObject = factory.apply(this.settings);
        }
        return this;
    }

    private RegistryKey<Item> makeKey() {
        return RegistryKey.of(RegistryKeys.ITEM, this.location);
    }
    public static RegistryKey<Item> makeKey(Identifier location) {
        return RegistryKey.of(RegistryKeys.ITEM, location);
    }

    public Item build(String name, Translator translator) {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed item!" + getExceptionalObject());
        }
        Item item = Registry.register(this.registry, this.makeKey(), this.gameObject);
        translator.addItem(item, name);
        return item;
    }
    @Override
    public Item build() {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed item!" + getExceptionalObject());
        }
        return Registry.register(this.registry, this.makeKey(), this.gameObject);
    }

    @Nullable
    public Item buildOptional(String name, Translator translator) {
        if (this.gameObject != null) {
            Item item = Registry.register(this.registry, this.makeKey(), this.gameObject);
            translator.addItem(item, name);
            return item;
        }
        return null;
    }
    @Override
    @Nullable
    public Item buildOptional() {
        if (gameObject != null) {
            return Registry.register(this.registry, this.makeKey(), this.gameObject);
        }
        return null;
    }
}
