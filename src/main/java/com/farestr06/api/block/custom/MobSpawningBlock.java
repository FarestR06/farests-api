package com.farestr06.api.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.InfestedBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

public abstract class MobSpawningBlock extends InfestedBlock {

    private static EntityType entity;
    public MobSpawningBlock(Block regularBlock, Settings settings, EntityType entityType) {
        super(regularBlock, settings);
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
        if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0 || !tool.isOf(Items.SHEARS))) {
            this.spawnMob(world, pos);
        }
    }
}
