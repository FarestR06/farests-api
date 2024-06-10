package com.farestr06.api.util;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleType;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RegistryHelper {
    
    private final String modId;
    
    public RegistryHelper(String modId) {
        this.modId = modId;
    }

    public SoundEvent registerSound(String path, SoundEvent event) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(modId, path), event);
    }
    public Fluid registerFluid(String path, Fluid fluid) {
        return Registry.register(Registries.FLUID, Identifier.of(modId, path), fluid);
    }
    public StatusEffect registerStatusEffects(String path, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(modId, path), effect);
    }
    public Block registerBlock(String path, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(modId, path), block);
    }

    /**
     * @deprecated In Minecraft 1.21, Enchantments are data-driven, making manual registration unnecessary. The method has been kept for legacy purposes.
     */
    @Deprecated
    public Enchantment registerEnchantment(String path, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, Identifier.of(modId, path), enchantment);
    }
    public EntityType<?> registerEntityType(String path, EntityType<?> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(modId, path), entityType);
    }
    public Item registerItem(String path, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(modId, path), item);
    }
    public ItemGroup registerItemGroup(String path, ItemGroup group) {
        return Registry.register(Registries.ITEM_GROUP, Identifier.of(modId, path), group);
    }
    public ParticleType<?> registerParticle(String path, ParticleType<?> particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(modId, path), particleType);
    }
    public Potion registerPotion(String path, Potion potion) {
        return Registry.register(Registries.POTION, Identifier.of(modId, path), potion);
    }
    /**
     * @deprecated In Minecraft 1.21, PaintingVariants are data-driven, making manual registration unnecessary. The method has been kept for legacy purposes.
     */
    @Deprecated
    public PaintingVariant registerPainting(String path, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, Identifier.of(modId, path), paintingVariant);
    }
}
