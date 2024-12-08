package com.farestr06.api.util;

import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.EnchantmentsPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.predicate.item.ItemSubPredicateTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.List;

public final class LootHelper {
    public static class BlockHelper {
        public static void createGravelLikeDrop(
                BlockLootTableGenerator generator,
                RegistryWrapper.Impl<Enchantment> impl,
                Block replacesGravel,
                ItemConvertible replacesFlint
        ) {
            generator.addDrop(replacesGravel, (Block block) ->
                    generator.dropsWithSilkTouch(
                            block,
                            generator.addSurvivesExplosionCondition(
                                    block, ItemEntry.builder(replacesFlint).conditionally(
                                            TableBonusLootCondition.builder(
                                                    impl.getOrThrow(Enchantments.FORTUNE),
                                                    0.1f, 0.14285715f, 0.25f, 1.0f
                                            )
                                    ).alternatively(ItemEntry.builder(block))
                            )
                    )
            );
        }
        public static void createGildedBlackstoneLikeDrop(
                BlockLootTableGenerator generator,
                RegistryWrapper.Impl<Enchantment> impl,
                Block replacesGildedBlackstone,
                ItemConvertible replacesGoldNugget
        ) {
            generator.addDrop(replacesGildedBlackstone, (Block block) ->
                            generator.dropsWithSilkTouch(
                                    block, generator.addSurvivesExplosionCondition(
                                            block, ItemEntry.builder(replacesGoldNugget).apply(
                                                    SetCountLootFunction.builder(
                                                            UniformLootNumberProvider.create(2.0f, 5.0f)
                                                    )
                                            )
                                    ).conditionally(
                                            TableBonusLootCondition.builder(
                                                    impl.getOrThrow(Enchantments.FORTUNE),
                                                    0.1f, 0.14285715f, 0.25f, 1.0f)
                                    ).alternatively(ItemEntry.builder(block)
                                    )
                            )
            );

        }

        public LootTable.Builder createOakLeavesLikeDrop(
                BlockLootTableGenerator generator,
                RegistryWrapper.Impl<Enchantment> impl,
                Block replacesOakLeaves, Block sapling,
                ItemConvertible replacesApple,
                float ... saplingChance) {
            return generator.leavesDrops(replacesOakLeaves, sapling, saplingChance).pool(
                    LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f)
                    )
                            .conditionally(generator.createWithoutShearsOrSilkTouchCondition())
                            .with(((LeafEntry.Builder<?>)generator.addSurvivesExplosionCondition(
                                    replacesOakLeaves, ItemEntry.builder(replacesApple))
                            )
                                    .conditionally(
                                            TableBonusLootCondition.builder(
                                                    impl.getOrThrow(Enchantments.FORTUNE),
                                                    0.005f, 0.0055555557f, 0.00625f, 0.008333334f, 0.025f
                                    )
                            ))
            );
        }
    }
    public static class EntityHelper {

        public static AnyOfLootCondition.Builder createSmeltLootCondition(RegistryWrapper.WrapperLookup lookup) {
            RegistryWrapper.Impl<Enchantment> impl = lookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
            return AnyOfLootCondition.builder(
                    EntityPropertiesLootCondition.builder(
                            LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true))
                    ),
                    EntityPropertiesLootCondition.builder(
                            LootContext.EntityTarget.DIRECT_ATTACKER,
                            EntityPredicate.Builder.create()
                                    .equipment(
                                            EntityEquipmentPredicate.Builder.create()
                                                    .mainhand(
                                                            ItemPredicate.Builder.create()
                                                                    .subPredicate(
                                                                            ItemSubPredicateTypes.ENCHANTMENTS,
                                                                            EnchantmentsPredicate.enchantments(List.of(new EnchantmentPredicate(impl.getOrThrow(EnchantmentTags.SMELTS_LOOT), NumberRange.IntRange.ANY)))
                                                                    )
                                                    )
                                    )
                    )
            );
        }
    }
}
