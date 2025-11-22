package com.farestr06.api.mixin;

import com.farestr06.api.item.FarestsItemProperties;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.DamageResistant;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Rarity;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(Item.Properties.class)
public class ItemPropertiesMixin implements FarestsItemProperties {
    @Unique
    private final Item.Properties properties = (Item.Properties) (Object) this;

    @Override
    public Item.Properties copy(Item item) {
        DataComponentMap map = item.components();
        properties.component(DataComponents.MAX_STACK_SIZE, map.get(DataComponents.MAX_STACK_SIZE));
        properties.component(DataComponents.MAX_DAMAGE, map.get(DataComponents.MAX_DAMAGE));
        properties.component(DataComponents.RARITY, map.get(DataComponents.RARITY));
        properties.component(DataComponents.ATTRIBUTE_MODIFIERS, map.get(DataComponents.ATTRIBUTE_MODIFIERS));
        properties.component(DataComponents.TOOLTIP_DISPLAY, map.get(DataComponents.TOOLTIP_DISPLAY));
        properties.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, map.get(DataComponents.ENCHANTMENT_GLINT_OVERRIDE));
        properties.component(DataComponents.FOOD, map.get(DataComponents.FOOD));
        properties.component(DataComponents.CONSUMABLE, map.get(DataComponents.CONSUMABLE));
        properties.component(DataComponents.USE_REMAINDER, map.get(DataComponents.USE_REMAINDER));
        properties.component(DataComponents.USE_COOLDOWN, map.get(DataComponents.USE_COOLDOWN));
        properties.component(DataComponents.DAMAGE_RESISTANT, map.get(DataComponents.DAMAGE_RESISTANT));
        properties.component(DataComponents.TOOL, map.get(DataComponents.TOOL));
        properties.component(DataComponents.WEAPON, map.get(DataComponents.WEAPON));
        properties.component(DataComponents.ENCHANTABLE, map.get(DataComponents.ENCHANTABLE));
        properties.component(DataComponents.EQUIPPABLE, map.get(DataComponents.EQUIPPABLE));
        properties.component(DataComponents.REPAIRABLE, map.get(DataComponents.REPAIRABLE));
        properties.component(DataComponents.GLIDER, map.get(DataComponents.GLIDER));
        properties.component(DataComponents.DEATH_PROTECTION, map.get(DataComponents.DEATH_PROTECTION));
        properties.component(DataComponents.BLOCKS_ATTACKS, map.get(DataComponents.BLOCKS_ATTACKS));
        properties.component(DataComponents.PROVIDES_TRIM_MATERIAL, map.get(DataComponents.PROVIDES_TRIM_MATERIAL));
        properties.component(DataComponents.JUKEBOX_PLAYABLE, map.get(DataComponents.JUKEBOX_PLAYABLE));
        properties.component(DataComponents.PROVIDES_BANNER_PATTERNS, map.get(DataComponents.PROVIDES_BANNER_PATTERNS));
        return properties;
    }

    @Override
    public Item.Properties noStack() {
        return properties.stacksTo(1);
    }

    @Override
    public Item.Properties stack16() {
        return properties.stacksTo(16);
    }

    @Override
    public Item.Properties glint() {
        return properties.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true);
    }

    @Override
    public Item.Properties uncommon() {
        return properties.rarity(Rarity.UNCOMMON);
    }

    @Override
    public Item.Properties rare() {
        return properties.rarity(Rarity.RARE);
    }

    @Override
    public Item.Properties epic() {
        return properties.rarity(Rarity.EPIC);
    }

    @Override
    public Item.Properties damageResistant(TagKey<DamageType> damageTag) {
        return properties.component(DataComponents.DAMAGE_RESISTANT, new DamageResistant(damageTag));
    }

    @Override
    public Item.Properties deathProtection(ConsumeEffect... onDeathEffects) {
        return properties.component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                new ArrayList<>(Arrays.asList(onDeathEffects))
        ));
    }

    @Override
    public Item.Properties deathProtection(DeathProtection component) {
        return properties.component(DataComponents.DEATH_PROTECTION, component);
    }

    @Override
    public Item.Properties blockAttacks(BlocksAttacks component) {
        return properties.component(DataComponents.BLOCKS_ATTACKS, component);
    }

    @Override
    public Item.Properties glider() {
        return properties.component(DataComponents.GLIDER, Unit.INSTANCE);
    }
}
