package com.farestr06.api.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;

public final class EffectHelper {
    /**
     * Registers and returns a custom status effect
     * @param location The effect's resource location/identifier
     * @param effect The effect to be registered
     * @return The registered effect
     */
    public static Holder<MobEffect> makeEffect(ResourceLocation location, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, location, effect);
    }

    /**
     * Creates a simple status effect.
     * @param location The effect's resource location/identifier
     * @param category Whether the effect is beneficial, neutral or harmful
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffect(ResourceLocation location, MobEffectCategory category, int color) {
        return makeEffect(location, new SimpleMobEffect(category, color));
    }

    /**
     * Creates a simple status effect with special particle effects.
     * @param location The effect's resource location/identifier
     * @param category Whether the effect is beneficial, neutral or harmful
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectWithSpecialParticles(ResourceLocation location, MobEffectCategory category, int color, ParticleOptions particles) {
        return makeEffect(location, new SimpleMobEffect(category, color, particles));
    }

    /**
     * Creates a simple, beneficial status effect.
     * @param location The effect's The effect's resource location/identifier
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectBeneficial(ResourceLocation location, int color) {
        return makeSimpleEffect(location, MobEffectCategory.BENEFICIAL, color);
    }
    /**
     * Creates a simple, beneficial status effect with special particle effects.
     * @param location The effect's resource location/identifier
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectBeneficialWithSpecialParticles(ResourceLocation location, int color, ParticleOptions particles) {
        return makeSimpleEffectWithSpecialParticles(location, MobEffectCategory.BENEFICIAL, color, particles);
    }

    /**
     * Creates a simple, neutral status effect.
     * @param location The effect's resource location/identifier
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectNeutral(ResourceLocation location, int color) {
        return makeSimpleEffect(location, MobEffectCategory.NEUTRAL, color);
    }
    /**
     * Creates a simple, neutral status effect with special particle effects.
     * @param location The effect's resource location/identifier
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectNeutralWithSpecialParticles(ResourceLocation location, int color, ParticleOptions particles) {
        return makeSimpleEffectWithSpecialParticles(location, MobEffectCategory.NEUTRAL, color, particles);
    }

    /**
     * Creates a simple, harmful status effect.
     * @param location The effect's resource location/identifier
     * @param color The color of the effect's potions and particles
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectHarmful(ResourceLocation location, int color) {
        return makeSimpleEffect(location, MobEffectCategory.HARMFUL, color);
    }
    /**
     * Creates a simple, harmful status effect with special particle effects.
     * @param location The effect's resource location/identifier
     * @param color The color of the effect's potions
     * @param particles The particles emitted by entities with the effect
     * @return The registered effect
     */
    public static Holder<MobEffect> makeSimpleEffectHarmfulWithSpecialParticles(ResourceLocation location, int color, ParticleOptions particles) {
        return makeSimpleEffectWithSpecialParticles(location, MobEffectCategory.HARMFUL, color, particles);
    }
}
