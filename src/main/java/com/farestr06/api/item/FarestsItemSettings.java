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

    /**
     * Sets an item's maximum stack count to 1, making it unable to stack.
     * @apiNote This is unnecessary for items with durability, as they are already unable to stack.
     */
    default Item.Settings noStack() {
        return new Item.Settings();
    }

    /**
     * Sets an item's maximum stack count to 16, like Signs or Snowballs.
     */
    default Item.Settings stack16() {
        return new Item.Settings();
    }

    /**
     * Gives an item an enchantment glint, like the Enchanted Golden Apple or Bottle o' Enchanting.
     */
    default Item.Settings glint() {
        return new Item.Settings();
    }

    /**
     * <body style="color:rgb(255, 255, 85);">Makes an Item have a rarity of UNCOMMON, such as Chainmail Armor or Netherite Upgrade Smithing Template.</body>
     */
    default Item.Settings uncommon() {
        return new Item.Settings();
    }
    /**
     * <body style="color:rgb(85, 255, 255);">Makes an Item have a rarity of RARE, such as the Enchanted Golden Apple or Trident.</body>
     */
    default Item.Settings rare() {
        return new Item.Settings();
    }
    /**
     * <body style="color:rgb(255, 85, 255);">Makes an Item have a rarity of EPIC, such as the Mace or Dragon Egg.</body>
     */
    default Item.Settings epic() {
        return new Item.Settings();
    }

    /**
     * Makes an item immune to certain types of damage, like Netherite and fire damage or Nether Stars and explosions.
     * @param damageTag Damage types that should not destroy the item
     */
    default Item.Settings damageResistant(TagKey<DamageType> damageTag) {
        return new Item.Settings();
    }

    /**
     * Makes an item prevent death when held, like a Totem of Undying.
     * @param onDeathEffects A series of consumeEffects to apply when the item "pops"
     */
    default Item.Settings deathProtection(ConsumeEffect... onDeathEffects) {
        return new Item.Settings();
    }

    /**
     * Makes an item prevent death when held, like a Totem of Undying.
     * @param component A deathProtectionComponent to apply to the item
     */
    default Item.Settings deathProtection(DeathProtectionComponent component) {
        return new Item.Settings();
    }

    /**
     * Makes an item block damage when the player holds the Use key, like a shield.
     * @param component A blocksAttacksComponent, which determines how blocking behaves for the item.
     */
    default Item.Settings blockAttacks(BlocksAttacksComponent component) {
        return new Item.Settings();
    }

    /**
     * Grants the player the ability to glide when the item is in the correct slot, like an Elytra.
     */
    default Item.Settings glider() {
        return new Item.Settings();
    }
}
