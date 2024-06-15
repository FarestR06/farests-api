package com.farestr06.api.util;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.ImpossibleCriterion;
import net.minecraft.util.Identifier;

/**
 * A class of blank advancements that represent a vanilla advancement; they have no purpose except to hold resource locations.
 * @apiNote These advancement entries are meant to be passed in as a parent and should not be registered themselves.
 */
public class VanillaAdvancements {
    public static class Story {
        /**
         * Minecraft - The heart and story of the game
         */
        public static final AdvancementEntry ROOT = advancement("story/root");
        /**
         * Stone Age - Mine Stone with your new Pickaxe
         */
        public static final AdvancementEntry MINE_STONE = advancement("story/mine_stone");
        /**
         * Getting an Upgrade - Construct a better Pickaxe
         */
        public static final AdvancementEntry UPGRADE_TOOLS = advancement("story/upgrade_tools");
        /**
         * Acquire Hardware - Smelt an Iron Ingot
         */
        public static final AdvancementEntry SMELT_IRON = advancement("story/smelt_iron");
        public static final AdvancementEntry OBTAIN_ARMOR = advancement("story/obtain_armor");
        public static final AdvancementEntry LAVA_BUCKET = advancement("story/lava_bucket");
        public static final AdvancementEntry IRON_TOOLS = advancement("story/iron_tools");
        public static final AdvancementEntry DEFLECT_ARROW = advancement("story/deflect_arrow");
        public static final AdvancementEntry FORM_OBSIDIAN = advancement("story/form_obsidian");
        public static final AdvancementEntry MINE_DIAMOND = advancement("story/mine_diamond");
        public static final AdvancementEntry ENTER_THE_NETHER = advancement("story/enter_the_nether");
        public static final AdvancementEntry SHINY_GEAR = advancement("story/shiny_gear");
        public static final AdvancementEntry ENCHANT_ITEM = advancement("story/enchant_item");
        public static final AdvancementEntry CURE_ZOMBIE_VILLAGER = advancement("story/cure_zombie_villager");
        public static final AdvancementEntry FOLLOW_ENDER_EYE = advancement("story/follow_ender_eye");
        public static final AdvancementEntry ENTER_THE_END = advancement("story/enter_the_end");
    }

    public static class Nether {
        public static final AdvancementEntry ROOT = advancement("nether/root");
        public static final AdvancementEntry RETURN_TO_SENDER = advancement("nether/return_to_sender");
        public static final AdvancementEntry FIND_BASTION = advancement("nether/find_bastion");
        public static final AdvancementEntry OBTAIN_ANCIENT_DEBRIS = advancement("nether/obtain_ancient_debris");
        public static final AdvancementEntry FAST_TRAVEL = advancement("nether/fast_travel");
        public static final AdvancementEntry FIND_FORTRESS = advancement("nether/find_fortress");
        public static final AdvancementEntry OBTAIN_CRYING_OBSIDIAN = advancement("nether/obtain_crying_obsidian");
        public static final AdvancementEntry DISTRACT_PIGLIN = advancement("nether/distract_piglin");
        public static final AdvancementEntry RIDE_STRIDER = advancement("nether/ride_strider");
        public static final AdvancementEntry UNEASY_ALLIANCE = advancement("nether/uneasy_alliance");
        public static final AdvancementEntry LOOT_BASTION = advancement("nether/loot_bastion");
        public static final AdvancementEntry USE_LODESTONE = advancement("nether/use_lodestone");
        public static final AdvancementEntry NETHERITE_ARMOR = advancement("nether/netherite_armor");
        public static final AdvancementEntry GET_WITHER_SKULL = advancement("nether/get_wither_skull");
        public static final AdvancementEntry OBTAIN_BLAZE_ROD = advancement("nether/obtain_blaze_rod");
        public static final AdvancementEntry CHARGE_RESPAWN_ANCHOR = advancement("nether/charge_respawn_anchor");
        public static final AdvancementEntry RIDE_STRIDER_IN_OVERWORLD_LAVA = advancement("nether/ride_strider_in_overworld_lava");
        public static final AdvancementEntry EXPLORE_NETHER = advancement("nether/explore_nether");
        public static final AdvancementEntry SUMMON_WITHER = advancement("nether/summon_wither");
        public static final AdvancementEntry BREW_POTION = advancement("nether/brew_potion");
        public static final AdvancementEntry CREATE_BEACON = advancement("nether/create_beacon");
        public static final AdvancementEntry ALL_POTIONS = advancement("nether/all_potions");
        public static final AdvancementEntry CREATE_FULL_BEACON = advancement("nether/create_full_beacon");
        public static final AdvancementEntry ALL_EFFECTS = advancement("nether/all_effects");
    }

    public static class End {
        public static final AdvancementEntry ROOT = advancement("end/root");
        public static final AdvancementEntry KILL_DRAGON = advancement("end/kill_dragon");
        public static final AdvancementEntry DRAGON_EGG = advancement("end/dragon_egg");
        public static final AdvancementEntry ENTER_END_GATEWAY = advancement("end/enter_end_gateway");
        public static final AdvancementEntry RESPAWN_DRAGON = advancement("end/respawn_dragon");
        public static final AdvancementEntry DRAGON_BREATH = advancement("end/dragon_breath");
        public static final AdvancementEntry FIND_END_CITY = advancement("end/find_end_city");
        public static final AdvancementEntry ELYTRA = advancement("end/elytra");
        public static final AdvancementEntry LEVITATE = advancement("end/levitate");
    }

    //TODO Add "Adventure" inner class

    //TODO Add "Husbandry" inner class

    protected static AdvancementEntry advancement(String path) {
        return Advancement.Builder.createUntelemetered().criterion("missingno", Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions())).build(Identifier.of("minecraft", path));
    }
}