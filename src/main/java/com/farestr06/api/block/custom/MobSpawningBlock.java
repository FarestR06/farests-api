package com.farestr06.api.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.InfestedBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

public class MobSpawningBlock extends InfestedBlock {

    private final EntityType<?> entity;
    public MobSpawningBlock(Block regularBlock, Settings settings, EntityType<?> entityType) {
        super(regularBlock, settings);
        this.entity = entityType;
    }

    private void spawnMob(ServerWorld world, BlockPos pos) {
        Entity mob = entity.create(world);
        if (mob != null) {
            mob.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
            world.spawnEntity(mob);
        }
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        if (canSpawn(state, world, pos, tool)) {
            this.spawnMob(world, pos);
        }
    }

    public boolean canSpawn(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool) {
        return world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && !EnchantmentHelper.hasAnyEnchantmentsIn(tool, EnchantmentTags.PREVENTS_INFESTED_SPAWNS);
    }
}
