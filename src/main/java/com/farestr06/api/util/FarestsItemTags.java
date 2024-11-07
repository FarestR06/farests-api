package com.farestr06.api.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.farestr06.api.FarestsAPI.MOD_ID;

public class FarestsItemTags {
    public static final TagKey<Item> HAS_ARMOR_OVERLAY = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(MOD_ID,"has_overlay")
    );

}
