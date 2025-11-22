package com.farestr06.api.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.core.particles.ParticleOptions;

/**
 * This class contains easy access to constructors for a bare-bones status effect, usually to modify entity attributes.
 * @apiNote The class is exclusively for basic effects, and cannot be extended. If you want to make a more advanced status effect, consider extending the vanilla {@link MobEffect}.
 * @since 2.5.0
 * @author Jacob D. (FarestR06)
 */
public final class SimpleMobEffect extends MobEffect {

    /**
     * Creates a status effect with generic particles
     * @param category Whether this effect has beneficial, harmful or neutral effects
     * @param color The color of the effect's particles and potions
     */
    public SimpleMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    /**
     * Creates a status effect with unique particles
     * @param category Whether this effect has beneficial, harmful or neutral effects
     * @param color The color of any potions containing this effect
     * @param particleEffect The particle effect that affected entities emit
     */
    public SimpleMobEffect(MobEffectCategory category, int color, ParticleOptions particleEffect) {
        super(category, color, particleEffect);
    }
}
