package com.farestr06.api.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.StatType;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that maps strings to game objects, so translation can be automated.
 * To use the translator, instantiate it in an easy location, like the mod's entrypoint or language provider.
 * <p>
 * Once all objects are added, use the {@link Translator#translate(FabricLanguageProvider.TranslationBuilder)} method to generate the translations.
 */
public class Translator {
    private final Map<String, String> keyTranslations = new HashMap<>();
    private final Map<ResourceLocation, String> resourceLocationTranslations = new HashMap<>();
    private final Map<Block, String> blockTranslations = new HashMap<>();
    private final Map<Item, String> itemTranslations = new HashMap<>();
    private final Map<ResourceKey<CreativeModeTab>, String> creativeTabTranslations = new HashMap<>();
    private final Map<EntityType<?>, String> entityTranslations = new HashMap<>();
    private final Map<ResourceKey<Enchantment>, String> enchantmentTranslations = new HashMap<>();
    private final Map<Holder<Attribute>, String> attributeTranslations = new HashMap<>();
    private final Map<StatType<?>, String> statTypeTranslations = new HashMap<>();
    private final Map<MobEffect, String> mobEffectTranslations = new HashMap<>();
    private final Map<TagKey<?>, String> tagTranslations = new HashMap<>();
    private final Map<SoundEvent, String> subtitleTranslations = new HashMap<>();

    public void addTranslationKey(String key, String value) {
        keyTranslations.put(key, value);
    }
    public void addResourceLocation(ResourceLocation location, String value) {
        resourceLocationTranslations.put(location, value);
    }
    public void addBlock(Block block, String translation) {
        blockTranslations.put(block, translation);
    }
    public void addItem(Item item, String value) {
        itemTranslations.put(item, value);
    }
    public void addCreativeTab(ResourceKey<CreativeModeTab> tab, String value) {
        creativeTabTranslations.put(tab, value);
    }
    public void addEntity(EntityType<?> entity, String value) {
        entityTranslations.put(entity, value);
    }
    public void addEnchantment(ResourceKey<Enchantment> enchantment, String value) {
        enchantmentTranslations.put(enchantment, value);
    }
    public void addAttribute(Holder<Attribute> attribute, String value) {
        attributeTranslations.put(attribute, value);
    }
    public void addStatType(StatType<?> statType, String value) {
        statTypeTranslations.put(statType, value);
    }
    public void addMobEffect(MobEffect effect, String value) {
        mobEffectTranslations.put(effect, value);
    }
    public void addTag(TagKey<?> tag, String value) {
        tagTranslations.put(tag, value);
    }
    public void addSubtitle(SoundEvent sound, String value) {
        subtitleTranslations.put(sound, value);
    }

    /**
     * Once all objects and translations are added, this method is used to send them to a translation builder.
     * @param builder A translation builder from your mod's language provider
     */
    public void translate(FabricLanguageProvider.TranslationBuilder builder) {
        for (String key : keyTranslations.keySet()) {
            builder.add(key, keyTranslations.get(key));
        }
        for (ResourceLocation location : resourceLocationTranslations.keySet()) {
            builder.add(location, resourceLocationTranslations.get(location));
        }
        for (Block key : blockTranslations.keySet()) {
            builder.add(key, blockTranslations.get(key));
        }
        for (Item key : itemTranslations.keySet()) {
            builder.add(key, itemTranslations.get(key));
        }
        for (ResourceKey<CreativeModeTab> key : creativeTabTranslations.keySet()) {
            builder.add(key, creativeTabTranslations.get(key));
        }
        for (EntityType<?> key : entityTranslations.keySet()) {
            builder.add(key, entityTranslations.get(key));
        }
        for (ResourceKey<Enchantment> key : enchantmentTranslations.keySet()) {
            builder.addEnchantment(key, enchantmentTranslations.get(key));
        }
        for (Holder<Attribute> key : attributeTranslations.keySet()) {
            builder.add(key, attributeTranslations.get(key));
        }
        for (StatType<?> key : statTypeTranslations.keySet()) {
            builder.add(key, statTypeTranslations.get(key));
        }
        for (MobEffect key : mobEffectTranslations.keySet()) {
            builder.add(key, mobEffectTranslations.get(key));
        }
        for (TagKey<?> key : tagTranslations.keySet()) {
            builder.add(key, tagTranslations.get(key));
        }
        for (SoundEvent key : subtitleTranslations.keySet()) {
            builder.add(key, subtitleTranslations.get(key));
        }
    }
}
