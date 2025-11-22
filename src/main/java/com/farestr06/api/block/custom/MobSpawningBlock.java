package com.farestr06.api.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GameRules;

/**
 * An extension of {@link InfestedBlock} that can summon any mob, rather than just Silverfish.
 */
public class MobSpawningBlock extends InfestedBlock {

    public static final MapCodec<MobSpawningBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    (BuiltInRegistries.BLOCK.byNameCodec().fieldOf("host")).forGetter(MobSpawningBlock::getHostBlock),
                    MobSpawningBlock.propertiesCodec(),
                    BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("mob").forGetter(MobSpawningBlock::getSpawnedEntity)
            ).apply(instance, MobSpawningBlock::new));

    protected final EntityType<?> entity;

    /**
     * Creates a block based on an existing block that spawns an entity of your choosing when it is broken.
     * @param regularBlock The block that this one should resemble
     * @param properties The block properties
     * @param entityType The type of entity this block should spawn when broken
     */
    public MobSpawningBlock(Block regularBlock, Properties properties, EntityType<?> entityType) {
        super(regularBlock, properties);
        this.entity = entityType;
    }

    @Override
    public MapCodec<? extends InfestedBlock> codec() {
        return CODEC;
    }

    public EntityType<?> getSpawnedEntity() {
        return entity;
    }

    protected void spawnMob(ServerLevel level, BlockPos pos) {
        Entity mob = entity.create(level, EntitySpawnReason.TRIGGERED);
        if (mob != null) {
            mob.snapTo((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
            level.addFreshEntity(mob);
        }
    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack tool, boolean dropExperience) {
        if (level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && !EnchantmentHelper.hasTag(tool, EnchantmentTags.PREVENTS_INFESTED_SPAWNS)){
            this.spawnMob(level, pos);
        }
    }
}
