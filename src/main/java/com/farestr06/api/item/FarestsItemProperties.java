package com.farestr06.api.item;

import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.tags.TagKey;

public interface FarestsItemProperties {
    default Item.Properties copy(Item item) {
        return new Item.Properties();
    }

    /**
     * Sets an item's maximum stack count to 1, making it unable to stack.
     * @apiNote This is unnecessary for items with durability, as they are already unable to stack.
     */
    default Item.Properties noStack() {
        return new Item.Properties();
    }

    /**
     * Sets an item's maximum stack count to 16, like Signs or Snowballs.
     */
    default Item.Properties stack16() {
        return new Item.Properties();
    }

    /**
     * Gives an item an enchantment glint, like the Enchanted Golden Apple or Bottle o' Enchanting.
     */
    default Item.Properties glint() {
        return new Item.Properties();
    }

    /**
     * <body style="color:rgb(255, 255, 85);">Makes an Item have a rarity of UNCOMMON, such as Chainmail Armor or Netherite Upgrade Smithing Template.</body>
     */
    default Item.Properties uncommon() {
        return new Item.Properties();
    }
    /**
     * <body style="color:rgb(85, 255, 255);">Makes an Item have a rarity of RARE, such as the Enchanted Golden Apple or Trident.</body>
     */
    default Item.Properties rare() {
        return new Item.Properties();
    }
    /**
     * <body style="color:rgb(255, 85, 255);">Makes an Item have a rarity of EPIC, such as the Mace or Dragon Egg.</body>
     */
    default Item.Properties epic() {
        return new Item.Properties();
    }

    /**
     * Makes an item immune to certain types of damage, like Netherite and fire damage or Nether Stars and explosions.
     * @param damageTag Damage types that should not destroy the item
     */
    default Item.Properties damageResistant(TagKey<DamageType> damageTag) {
        return new Item.Properties();
    }

    /**
     * Makes an item prevent death when held, like a Totem of Undying.
     * @param onDeathEffects A series of consumeEffects to apply when the item "pops"
     */
    default Item.Properties deathProtection(ConsumeEffect... onDeathEffects) {
        return new Item.Properties();
    }

    /**
     * Makes an item prevent death when held, like a Totem of Undying.
     * @param component A deathProtectionComponent to apply to the item
     */
    default Item.Properties deathProtection(DeathProtection component) {
        return new Item.Properties();
    }

    /**
     * Makes an item block damage when the player holds the Use key, like a shield.
     * @param component A blocksAttacksComponent, which determines how blocking behaves for the item.
     */
    default Item.Properties blockAttacks(BlocksAttacks component) {
        return new Item.Properties();
    }

    /**
     * Grants the player the ability to glide when the item is in the correct slot, like an Elytra.
     */
    default Item.Properties glider() {
        return new Item.Properties();
    }
}
