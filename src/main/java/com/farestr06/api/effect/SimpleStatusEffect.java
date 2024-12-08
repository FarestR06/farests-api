package com.farestr06.api.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;

/**
 * This class contains easy access to constructors for a bare-bones status effect, usually to modify entity attributes.
 * @apiNote The class is exclusively for basic effects, and cannot be extended. If you want to make a more advanced status effect, consider extending the vanilla {@link StatusEffect}.
 * @since 2.5.0
 * @author Jacob D. (FarestR06)
 */
public final class SimpleStatusEffect extends StatusEffect {

    /**
     * Creates a status effect with generic particles
     * @param category Whether this effect has beneficial, harmful or neutral effects
     * @param color The color of the effect's particles and potions
     */
    public SimpleStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    /**
     * Creates a status effect with unique particles
     * @param category Whether this effect has beneficial, harmful or neutral effects
     * @param color The color of any potions containing this effect
     * @param particleEffect The particle effect that affected entities emit
     */
    public SimpleStatusEffect(StatusEffectCategory category, int color, ParticleEffect particleEffect) {
        super(category, color, particleEffect);
    }
}
