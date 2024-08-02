package com.farestr06.api.item;

import com.farestr06.api.util.exception.ItemRegistryFailure;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface ItemHelper {

    static Item makeSimpleItem(Identifier location) {
        try {
            return Registry.register(Registries.ITEM, location, new Item(new Item.Settings()));
        } catch (Exception e) {
            throw new ItemRegistryFailure(location, e);
        }
    }
g
    static Item makeItem(Identifier location, Item.Settings properties) {
        try {
            return Registry.register(Registries.ITEM, location, new Item(properties));
        } catch (Exception e) {
            throw new ItemRegistryFailure(location, e);
        }
    }

    static Item makeAdvancedItem(Identifier location, Item advancedItem) {
        try {
            return Registry.register(Registries.ITEM, location, advancedItem);
        } catch (Exception e) {
            throw new ItemRegistryFailure(location, e);
        }
    }
}
