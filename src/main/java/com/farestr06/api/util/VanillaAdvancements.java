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
public final class VanillaAdvancements {
    public static final class Story {
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
        public static final AdvancementEntry OBTAIN_DIAMOND_ARMOR = advancement("story/shiny_gear");
        public static final AdvancementEntry ENCHANT_ITEM = advancement("story/enchant_item");
        public static final AdvancementEntry CURE_ZOMBIE_VILLAGER = advancement("story/cure_zombie_villager");
        public static final AdvancementEntry FOLLOW_ENDER_EYE = advancement("story/follow_ender_eye");
        public static final AdvancementEntry ENTER_THE_END = advancement("story/enter_the_end");
    }

    public static final class Nether {
        public static final AdvancementEntry ROOT = advancement("nether/root");
        public static final AdvancementEntry PARRY_FIRE_CHARGE_AT_GHAST = advancement("nether/return_to_sender");
        public static final AdvancementEntry FIND_BASTION = advancement("nether/find_bastion");
        public static final AdvancementEntry OBTAIN_ANCIENT_DEBRIS = advancement("nether/obtain_ancient_debris");
        public static final AdvancementEntry SEVEN_OVERWORLD_KILOMETERS_VIA_NETHER = advancement("nether/fast_travel");
        public static final AdvancementEntry FIND_FORTRESS = advancement("nether/find_fortress");
        public static final AdvancementEntry OBTAIN_CRYING_OBSIDIAN = advancement("nether/obtain_crying_obsidian");
        public static final AdvancementEntry DISTRACT_PIGLIN = advancement("nether/distract_piglin");
        public static final AdvancementEntry RIDE_STRIDER = advancement("nether/ride_strider");
        public static final AdvancementEntry KILL_GHAST_IN_OVERWORLD = advancement("nether/uneasy_alliance");
        public static final AdvancementEntry LOOT_BASTION = advancement("nether/loot_bastion");
        public static final AdvancementEntry USE_LODESTONE = advancement("nether/use_lodestone");
        public static final AdvancementEntry OBTAIN_FULL_SUIT_NETHERITE_ARMOR = advancement("nether/netherite_armor");
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

    public static final class End {
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
    
    public static final class Adventure {
        public static final AdvancementEntry ROOT = advancement("adventure/root");
        public static final AdvancementEntry KILL_RAID_CAPTAIN = advancement("adventure/voluntary_exile");
        public static final AdvancementEntry SPYGLASS_AT_PARROT = advancement("adventure/spyglass_at_parrot");
        public static final AdvancementEntry KILL_A_MOB = advancement("adventure/kill_a_mob");
        public static final AdvancementEntry READ_POWER_OF_CHISELED_BOOKSHELF = advancement("adventure/read_power_of_chiseled_bookshelf");
        public static final AdvancementEntry TRADE = advancement("adventure/trade");
        public static final AdvancementEntry TRIM_WITH_ANY_ARMOR_PATTERN = advancement("adventure/trim_with_any_armor_pattern");
        public static final AdvancementEntry HONEY_BLOCK_SLIDE = advancement("adventure/honey_block_slide");
        public static final AdvancementEntry SHOOT_CROSSBOW = advancement("adventure/ol_betsy");
        public static final AdvancementEntry LIGHTNING_ROD_WITH_VILLAGER_NO_FIRE = advancement("adventure/lightning_rod_with_villager_no_fire");
        public static final AdvancementEntry FALL_FROM_WORLD_HEIGHT = advancement("adventure/fall_from_world_height");
        public static final AdvancementEntry SALVAGE_SHERD = advancement("adventure/salvage_sherd");
        public static final AdvancementEntry AVOID_VIBRATION = advancement("adventure/avoid_vibration");
        public static final AdvancementEntry SLEEP_IN_BED = advancement("adventure/sleep_in_bed");
        public static final AdvancementEntry DEFEAT_RAID = advancement("adventure/hero_of_the_village");
        public static final AdvancementEntry SPYGLASS_AT_GHAST = advancement("adventure/spyglass_at_ghast");
        public static final AdvancementEntry THROW_TRIDENT = advancement("adventure/throw_trident");
        public static final AdvancementEntry KILL_MOB_NEAR_SCULK_CATALYST = advancement("adventure/kill_mob_near_sculk_catalyst");
        public static final AdvancementEntry SHOOT_ARROW = advancement("adventure/shoot_arrow");
        public static final AdvancementEntry KILL_ALL_MOBS = advancement("adventure/kill_all_mobs");
        public static final AdvancementEntry USE_TOTEM_OF_UNDYING = advancement("adventure/totem_of_undying");
        public static final AdvancementEntry SUMMON_IRON_GOLEM = advancement("adventure/summon_iron_golem");
        public static final AdvancementEntry TRADE_AT_WORLD_HEIGHT = advancement("adventure/trade_at_world_height");
        public static final AdvancementEntry TRIM_WITH_ALL_EXCLUSIVE_ARMOR_PATTERNS = advancement("adventure/trim_with_all_exclusive_armor_patterns");
        public static final AdvancementEntry TWO_PHANTOMS_PIERCED_WITH_CROSSBOW = advancement("adventure/two_birds_one_arrow");
        public static final AdvancementEntry SHOOT_PILLAGER_WITH_CROSSBOW = advancement("adventure/whos_the_pillager_now");
        public static final AdvancementEntry FIVE_DIFFERENT_MOBS_PIERCED_WITH_CROSSBOW = advancement("adventure/arbalistic");
        public static final AdvancementEntry CRAFT_DECORATED_POT_USING_ONLY_SHERDS = advancement("adventure/craft_decorated_pot_using_only_sherds");
        public static final AdvancementEntry ADVENTURING_TIME = advancement("adventure/adventuring_time");
        public static final AdvancementEntry PLAY_JUKEBOX_IN_MEADOWS = advancement("adventure/play_jukebox_in_meadows");
        public static final AdvancementEntry WALK_ON_POWDER_SNOW_WITH_LEATHER_BOOTS = advancement("adventure/walk_on_powder_snow_with_leather_boots");
        public static final AdvancementEntry SPYGLASS_AT_DRAGON = advancement("adventure/spyglass_at_dragon");
        public static final AdvancementEntry STRIKE_VILLAGER_WITH_LIGHTNING = advancement("adventure/very_very_frightening");
        public static final AdvancementEntry SNIPER_DUEL = advancement("adventure/sniper_duel");
        public static final AdvancementEntry HIT_CENTER_OF_TARGET = advancement("adventure/bullseye");
        public static final AdvancementEntry BRUSH_ARMADILLO = advancement("adventure/brush_armadillo");
        public static final AdvancementEntry FIND_TRIAL_CHAMBER = advancement("adventure/minecraft_trials_edition");
        public static final AdvancementEntry CRAFT_CRAFTER_WITH_CRAFTER = advancement("adventure/crafters_crafting_crafters");
        public static final AdvancementEntry CLEAN_COPPER_BULB = advancement("adventure/lighten_up");
        public static final AdvancementEntry SEVEN_BLOCK_JUMP = advancement("adventure/who_needs_rockets");
        public static final AdvancementEntry OPEN_REGULAR_VAULT = advancement("adventure/under_lock_and_key");
        public static final AdvancementEntry OPEN_OMINOUS_VAULT = advancement("adventure/revaulting");
        public static final AdvancementEntry KILL_BREEZE_WITH_PARRIED_WIND_CHARGE = advancement("adventure/blowback");
        public static final AdvancementEntry DEAL_FIFTY_DAMAGE_WITH_MACE = advancement("adventure/overoverkill");
    }

    
    //TODO Add "Husbandry" inner class

    private static AdvancementEntry advancement(String path) {
        return Advancement.Builder.createUntelemetered().criterion("missingno", Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions())).build(Identifier.of("minecraft", path));
    }
}