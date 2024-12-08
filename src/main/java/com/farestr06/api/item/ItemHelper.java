package com.farestr06.api.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ItemHelper {

    public static Item makeSimpleItem(Identifier id) {
        return makeItem(id, new Item.Settings());
    }
    
    public static Item makeItem(Identifier id, Item.Settings settings) {
        return makeAdvancedItem(id, new Item(settings));
    }

    public static Item makeAdvancedItem(Identifier id, Item advancedItem) {
        return Registry.register(Registries.ITEM, id, advancedItem);
    }
}
