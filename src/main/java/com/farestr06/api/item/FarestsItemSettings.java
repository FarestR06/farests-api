package com.farestr06.api.item;

import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.registry.tag.TagKey;

public interface FarestsItemSettings {
    default Item.Settings copy(Item item) {
        return new Item.Settings();
    }

    default Item.Settings noStack() {
        return new Item.Settings();
    }

    default Item.Settings stack16() {
        return new Item.Settings();
    }

    default Item.Settings glint() {
        return new Item.Settings();
    }

    default Item.Settings uncommon() {
        return new Item.Settings();
    }
    default Item.Settings rare() {
        return new Item.Settings();
    }
    default Item.Settings epic() {
        return new Item.Settings();
    }

    default Item.Settings damageResistant(TagKey<DamageType> damageTag) {
        return new Item.Settings();
    }

    /**
     * Makes an item prevent death when held, like a Totem of Undying.
     * @param onDeathEffects A series of consumeEffects to apply when the item pops
     */
    default Item.Settings deathProtection(ConsumeEffect... onDeathEffects) {
        return new Item.Settings();
    }
    default Item.Settings deathProtection(DeathProtectionComponent component) {
        return new Item.Settings();
    }

    default Item.Settings blockAttacks(BlocksAttacksComponent component) {
        return new Item.Settings();
    }

    default Item.Settings glider() {
        return new Item.Settings();
    }
}
