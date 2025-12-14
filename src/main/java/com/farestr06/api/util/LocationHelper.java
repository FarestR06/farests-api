package com.farestr06.api.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

/**
 * A record that can create resource locations, tag keys, and other path-related objects.
 * To use it, create an instance with your mod ID, preferably as a constant in your mod's entrypoint.
 */
public record LocationHelper(String namespace) {
    public ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(this.namespace, path);
    }


    private <T> TagKey<T> tag(ResourceKey<Registry<T>> registryKey, String path) {
        return TagKey.create(registryKey, this.location(path));
    }

    public TagKey<BannerPattern> bannerPatternTag(String path) {
        return this.tag(Registries.BANNER_PATTERN, path);
    }
    public TagKey<Biome> biomeTag(String path) {
        return this.tag(Registries.BIOME, path);
    }
    public TagKey<Block> blockTag(String path) {
        return this.tag(Registries.BLOCK, path);
    }
    public TagKey<DamageType> damageTypeTag(String path) {
        return this.tag(Registries.DAMAGE_TYPE, path);
    }
    public TagKey<Enchantment> enchantmentTag(String path) {
        return this.tag(Registries.ENCHANTMENT, path);
    }
    public TagKey<EntityType<?>> entityTypeTag(String path) {
        return this.tag(Registries.ENTITY_TYPE, path);
    }
    public TagKey<Fluid> fluidTag(String path) {
        return this.tag(Registries.FLUID, path);
    }
    public TagKey<GameEvent> gameEventTag(String path) {
        return this.tag(Registries.GAME_EVENT, path);
    }
    public TagKey<Instrument> instrumentTag(String path) {
        return this.tag(Registries.INSTRUMENT, path);
    }
    public TagKey<Item> itemTag(String path) {
        return this.tag(Registries.ITEM, path);
    }
    public TagKey<PaintingVariant> paintingTag(String path) {
        return this.tag(Registries.PAINTING_VARIANT, path);
    }
    public TagKey<PoiType> poiTypeTag(String path) {
        return this.tag(Registries.POINT_OF_INTEREST_TYPE, path);
    }
    public TagKey<Structure> structureTag(String path) {
        return this.tag(Registries.STRUCTURE, path);
    }
}
