package com.farestr06.api.mixin;

import com.farestr06.api.item.FarestsItemSettings;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.component.type.DamageResistantComponent;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(Item.Settings.class)
public class SettingsMixin implements FarestsItemSettings {
    @Unique
    private final Item.Settings settings = (Item.Settings) (Object) this;

    @Override
    public Item.Settings copy(Item item) {
        ComponentMap map = item.getComponents();
        settings.component(DataComponentTypes.MAX_STACK_SIZE, map.get(DataComponentTypes.MAX_STACK_SIZE));
        settings.component(DataComponentTypes.MAX_DAMAGE, map.get(DataComponentTypes.MAX_DAMAGE));
        settings.component(DataComponentTypes.RARITY, map.get(DataComponentTypes.RARITY));
        settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS, map.get(DataComponentTypes.ATTRIBUTE_MODIFIERS));
        settings.component(DataComponentTypes.TOOLTIP_DISPLAY, map.get(DataComponentTypes.TOOLTIP_DISPLAY));
        settings.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, map.get(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE));
        settings.component(DataComponentTypes.FOOD, map.get(DataComponentTypes.FOOD));
        settings.component(DataComponentTypes.CONSUMABLE, map.get(DataComponentTypes.CONSUMABLE));
        settings.component(DataComponentTypes.USE_REMAINDER, map.get(DataComponentTypes.USE_REMAINDER));
        settings.component(DataComponentTypes.USE_COOLDOWN, map.get(DataComponentTypes.USE_COOLDOWN));
        settings.component(DataComponentTypes.DAMAGE_RESISTANT, map.get(DataComponentTypes.DAMAGE_RESISTANT));
        settings.component(DataComponentTypes.TOOL, map.get(DataComponentTypes.TOOL));
        settings.component(DataComponentTypes.WEAPON, map.get(DataComponentTypes.WEAPON));
        settings.component(DataComponentTypes.ENCHANTABLE, map.get(DataComponentTypes.ENCHANTABLE));
        settings.component(DataComponentTypes.EQUIPPABLE, map.get(DataComponentTypes.EQUIPPABLE));
        settings.component(DataComponentTypes.REPAIRABLE, map.get(DataComponentTypes.REPAIRABLE));
        settings.component(DataComponentTypes.GLIDER, map.get(DataComponentTypes.GLIDER));
        settings.component(DataComponentTypes.DEATH_PROTECTION, map.get(DataComponentTypes.DEATH_PROTECTION));
        settings.component(DataComponentTypes.BLOCKS_ATTACKS, map.get(DataComponentTypes.BLOCKS_ATTACKS));
        settings.component(DataComponentTypes.PROVIDES_TRIM_MATERIAL, map.get(DataComponentTypes.PROVIDES_TRIM_MATERIAL));
        settings.component(DataComponentTypes.JUKEBOX_PLAYABLE, map.get(DataComponentTypes.JUKEBOX_PLAYABLE));
        settings.component(DataComponentTypes.PROVIDES_BANNER_PATTERNS, map.get(DataComponentTypes.PROVIDES_BANNER_PATTERNS));
        return settings;
    }

    @Override
    public Item.Settings noStack() {
        return settings.maxCount(1);
    }

    @Override
    public Item.Settings stack16() {
        return settings.maxCount(16);
    }

    @Override
    public Item.Settings glint() {
        return settings.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
    }

    @Override
    public Item.Settings uncommon() {
        return settings.rarity(Rarity.UNCOMMON);
    }

    @Override
    public Item.Settings rare() {
        return settings.rarity(Rarity.RARE);
    }

    @Override
    public Item.Settings epic() {
        return settings.rarity(Rarity.EPIC);
    }

    @Override
    public Item.Settings damageResistant(TagKey<DamageType> damageTag) {
        return settings.component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(damageTag));
    }

    @Override
    public Item.Settings deathProtection(ConsumeEffect... onDeathEffects) {
        return settings.component(DataComponentTypes.DEATH_PROTECTION, new DeathProtectionComponent(
                new ArrayList<>(Arrays.asList(onDeathEffects))
        ));
    }

    @Override
    public Item.Settings deathProtection(DeathProtectionComponent component) {
        return settings.component(DataComponentTypes.DEATH_PROTECTION, component);
    }

    @Override
    public Item.Settings blockAttacks(BlocksAttacksComponent blocksAttacksComponent) {
        return settings.component(DataComponentTypes.BLOCKS_ATTACKS, blocksAttacksComponent);
    }

    @Override
    public Item.Settings glider() {
        return settings.component(DataComponentTypes.GLIDER, Unit.INSTANCE);
    }
}
