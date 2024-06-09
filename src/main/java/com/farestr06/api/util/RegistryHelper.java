package com.farestr06.api.util;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleType;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import org.slf4j.LoggerFactory;


/**
 * A registryHelper simplifies the process of registering game objects using generics.
 * @param <T> A game object. See <code>getRegistryFromObject</code> for a list of compatible types.
 * @see RegistryHelper#getRegistryFromObject(Object)
 */
public class RegistryHelper<T> {

    private final String namespace;

    public RegistryHelper(String modId) {
        this.namespace = modId;
    }

    /**
     * Registers an object of the specified type.
     * @param object An object of the type specified in the type parameter
     * @param name The path used in the object's holder
     * @return The passed in object
     */
    public T add(T object, String name) {
        Registry registry = getRegistryFromObject(object);
        return (T) Registry.register(registry, Identifier.of(namespace, name), object);
    }

    private Registry getRegistryFromObject(T object) {
        if (object instanceof Block) {
            return Registries.BLOCK;
        } if (object instanceof Item) {
            return Registries.ITEM;
        } if (object instanceof Potion) {
            return Registries.POTION;
        } if (object instanceof SoundEvent) {
            return Registries.SOUND_EVENT;
        } if (object instanceof Fluid) {
            return Registries.SOUND_EVENT;
        } if (object instanceof StatusEffect) {
            return Registries.STATUS_EFFECT;
        } if (object instanceof EntityType<?>) {
            return Registries.ENTITY_TYPE;
        } if (object instanceof Enchantment) {
            return Registries.ENCHANTMENT;
        } if (object instanceof PaintingVariant) {
            return Registries.PAINTING_VARIANT;
        } if (object instanceof ParticleType<?>) {
            return Registries.PARTICLE_TYPE;
        } if (object instanceof VillagerType) {
            return Registries.VILLAGER_TYPE;
        } if (object instanceof VillagerProfession) {
            return Registries.VILLAGER_PROFESSION;
        }
        throw new IllegalArgumentException("Object isn't supported");
    }
}
