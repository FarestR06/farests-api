package com.farestr06.api.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public final class EffectHelper {
    /**
     * Registers and returns a custom status effect
     * @param id The effect's resource location/identifier
     * @param effect The effect to be registered
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeEffect(Identifier id, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, id, effect);
    }

    /**
     * Creates a simple status effect.
     * @param id The effect's resource location/identifier
     * @param category Whether the effect is beneficial, neutral or harmful
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffect(Identifier id, StatusEffectCategory category, int color) {
        return makeEffect(id, new SimpleStatusEffect(category, color));
    }

    /**
     * Creates a simple status effect with special particle effects.
     * @param id The effect's resource location/identifier
     * @param category Whether the effect is beneficial, neutral or harmful
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectWithSpecialParticles(Identifier id, StatusEffectCategory category, int color, ParticleEffect particles) {
        return makeEffect(id, new SimpleStatusEffect(category, color, particles));
    }

    /**
     * Creates a simple, beneficial status effect.
     * @param id The effect's The effect's resource location/identifier
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectBeneficial(Identifier id, int color) {
        return makeSimpleEffect(id, StatusEffectCategory.BENEFICIAL, color);
    }
    /**
     * Creates a simple, beneficial status effect with special particle effects.
     * @param id The effect's resource location/identifier
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectBeneficialWithSpecialParticles(Identifier id, int color, ParticleEffect particles) {
        return makeSimpleEffectWithSpecialParticles(id, StatusEffectCategory.BENEFICIAL, color, particles);
    }

    /**
     * Creates a simple, neutral status effect.
     * @param id The effect's resource location/identifier
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectNeutral(Identifier id, int color) {
        return makeSimpleEffect(id, StatusEffectCategory.NEUTRAL, color);
    }
    /**
     * Creates a simple, neutral status effect with special particle effects.
     * @param id The effect's resource location/identifier
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectNeutralWithSpecialParticles(Identifier id, int color, ParticleEffect particles) {
        return makeSimpleEffectWithSpecialParticles(id, StatusEffectCategory.NEUTRAL, color, particles);
    }

    /**
     * Creates a simple, harmful status effect.
     * @param id The effect's resource location/identifier
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectHarmful(Identifier id, int color) {
        return makeSimpleEffect(id, StatusEffectCategory.HARMFUL, color);
    }
    /**
     * Creates a simple, harmful status effect with special particle effects.
     * @param id The effect's resource location/identifier
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static RegistryEntry<StatusEffect> makeSimpleEffectHarmfulWithSpecialParticles(Identifier id, int color, ParticleEffect particles) {
        return makeSimpleEffectWithSpecialParticles(id, StatusEffectCategory.HARMFUL, color, particles);
    }
}
