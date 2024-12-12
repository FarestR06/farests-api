package com.farestr06.api.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.InfestedBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

/**
 * An extension of {@link InfestedBlock} that can summon any mob, rather than just Silverfish.
 */
public class MobSpawningBlock extends InfestedBlock {

    public static final MapCodec<MobSpawningBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    (Registries.BLOCK.getCodec().fieldOf("host")).forGetter(MobSpawningBlock::getRegularBlock),
                    MobSpawningBlock.createSettingsCodec(),
                    Registries.ENTITY_TYPE.getCodec().fieldOf("mob").forGetter(MobSpawningBlock::getSpawnedEntity)
            ).apply(instance, MobSpawningBlock::new));

    protected final EntityType<?> entity;

    /**
     * Creates a block based on an existing block that spawns an entity of your choosing when it is broken.
     * @param regularBlock The block that this one should resemble
     * @param settings The block settings
     * @param entityType The type of entity this block should spawn when broken
     */
    public MobSpawningBlock(Block regularBlock, Settings settings, EntityType<?> entityType) {
        super(regularBlock, settings);
        this.entity = entityType;
    }

    @Override
    public MapCodec<? extends InfestedBlock> getCodec() {
        return CODEC;
    }

    public EntityType<?> getSpawnedEntity() {
        return entity;
    }

    protected void spawnMob(ServerWorld world, BlockPos pos) {
        Entity mob = entity.create(world, SpawnReason.TRIGGERED);
        if (mob != null) {
            mob.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
            world.spawnEntity(mob);
        }
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && !EnchantmentHelper.hasAnyEnchantmentsIn(tool, EnchantmentTags.PREVENTS_INFESTED_SPAWNS)){
            this.spawnMob(world, pos);
        }
    }
}
