package com.farestr06.api.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ItemHelper {

    public static Item makeSimpleItem(Identifier location) {
        return makeItem(location, new Item.Settings());
    }
    
    public static Item makeItem(Identifier location, Item.Settings settings) {
        return makeAdvancedItem(location, new Item(settings));
    }

    public static Item makeAdvancedItem(Identifier location, Item advancedItem) {
        return Registry.register(Registries.ITEM, location, advancedItem);
    }
}
