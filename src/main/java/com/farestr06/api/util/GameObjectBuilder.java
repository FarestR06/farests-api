package com.farestr06.api.util;

import com.farestr06.api.block.BlockBuilder;
import com.farestr06.api.item.ItemBuilder;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public abstract class GameObjectBuilder<T> {
    protected final Registry<T> registry;
    protected final Identifier location;
    protected T gameObject;

    protected GameObjectBuilder(Registry<T> registry, Identifier location) {
        this.registry = registry;
        this.location = location;
    }

    protected String getExceptionalObject() {
        return " Cause: " + this.location.toString();
    }

    public T build() {
        if (gameObject == null) {
            throw new IllegalStateException("Can't build without a constructed object!");
        }
        return Registry.register(registry, location, gameObject);
    }

    @Nullable
    public T buildOptional() {
        return Registry.register(registry, location, gameObject);
    }

    public static ItemBuilder item(Identifier location) {
        return new ItemBuilder(location);
    }
    public static BlockBuilder block(Identifier location) {
        return new BlockBuilder(location);
    }
    public static ItemBuilder item(Identifier location, boolean condition) {
        return new ItemBuilder(location, condition);
    }
    public static BlockBuilder block(Identifier location, boolean condition) {
        return new BlockBuilder(location, condition);
    }
    public static BlockBuilder block(Identifier blockLocation, Identifier itemLocation) {
        return new BlockBuilder(blockLocation, itemLocation);
    }
    public static BlockBuilder block(Identifier blockLocation, Identifier itemLocation, boolean condition) {
        return new BlockBuilder(blockLocation, itemLocation, condition);
    }
}
