package com.farestr06.api.util;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.ImpossibleCriterion;
import net.minecraft.util.Identifier;

/**
 * A class of blank advancements that represent a vanilla advancement. These fields have no purpose except to hold
 * resource locations, as the datagen method for parenting new advancements with raw Identifiers is marked for removal.
 * @apiNote These advancement entries are meant to be passed into datagen as a parent and should not be registered
 * themselves.
 * @since 2.7.0
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
        /**
         * Suit Up - Protect yourself with a piece of iron armor
         */
        public static final AdvancementEntry OBTAIN_IRON_ARMOR = advancement("story/obtain_armor");
        /**
         * Hot Stuff - Fill a Bucket with lava
         */
        public static final AdvancementEntry FILL_LAVA_BUCKET = advancement("story/lava_bucket");
        /**
         * Isn't It Iron Pick - Upgrade your Pickaxe
         */
        public static final AdvancementEntry CRAFT_IRON_TOOLS = advancement("story/iron_tools");
        /**
         * Not Today, Thank You - Deflect a projectile with a Shield
         */
        public static final AdvancementEntry DEFLECT_ARROW_WITH_SHIELD = advancement("story/deflect_arrow");
        /**
         * Ice Bucket Challenge - Obtain a block of Obsidian
         */
        public static final AdvancementEntry FORM_OBSIDIAN = advancement("story/form_obsidian");
        /**
         * Diamonds! - Acquire diamonds
         */
        public static final AdvancementEntry MINE_DIAMOND = advancement("story/mine_diamond");
        /**
         * We Need to Go Deeper - Build, light and enter a Nether Portal
         */
        public static final AdvancementEntry ENTER_THE_NETHER = advancement("story/enter_the_nether");
        /**
         * Cover Me with Diamonds - Diamond armor saves lives
         */
        public static final AdvancementEntry OBTAIN_DIAMOND_ARMOR = advancement("story/shiny_gear");
        /**
         * Enchanter - Enchant an item at an Enchanting Table
         */
        public static final AdvancementEntry ENCHANT_ITEM = advancement("story/enchant_item");
        /**
         * Zombie Doctor - Weaken and then cure a Zombie Villager
         */
        public static final AdvancementEntry CURE_ZOMBIE_VILLAGER = advancement("story/cure_zombie_villager");
        /**
         * Eye Spy - Follow an Eye of Ender
         */
        public static final AdvancementEntry FOLLOW_ENDER_EYE = advancement("story/follow_ender_eye");
        /**
         * The End? - Enter the End Portal
         */
        public static final AdvancementEntry ENTER_THE_END = advancement("story/enter_the_end");
    }

    public static final class Nether {
        /**
         * Nether - Bring summer clothes
         */
        public static final AdvancementEntry ROOT = advancement("nether/root");
        /**
         * Return to Sender - Destroy a Ghast with a fireball
         */
        public static final AdvancementEntry KILL_GHAST_WITH_FIREBALL = advancement("nether/return_to_sender");
        /**
         * Those Were the Days - Enter a Bastion Remnant
         */
        public static final AdvancementEntry FIND_BASTION = advancement("nether/find_bastion");
        /**
         * Hidden in the Depths - Obtain Ancient Debris
         */
        public static final AdvancementEntry OBTAIN_ANCIENT_DEBRIS = advancement("nether/obtain_ancient_debris");
        /**
         * Subspace Bubble - Use the Nether to travel 7 km in the Overworld
         */
        public static final AdvancementEntry SEVEN_OVERWORLD_KILOMETERS_VIA_NETHER = advancement("nether/fast_travel");
        /**
         * A Terrible Fortress - Break your way into a Nether Fortress
         */
        public static final AdvancementEntry FIND_NETHER_FORTRESS = advancement("nether/find_fortress");
        /**
         * Who is Cutting Onions? - Obtain Crying Obsidian
         */
        public static final AdvancementEntry OBTAIN_CRYING_OBSIDIAN = advancement("nether/obtain_crying_obsidian");
        /**
         * Oh Shiny - Distract Piglins with gold
         */
        public static final AdvancementEntry DISTRACT_PIGLIN = advancement("nether/distract_piglin");
        /**
         * This Boat Has Legs - Ride a Strider with a Warped Fungus on a Stick
         */
        public static final AdvancementEntry RIDE_STRIDER = advancement("nether/ride_strider");
        /**
         * Uneasy Alliance - Rescue a Ghast from the Nether, bring it safely home to the Overworld... and then kill it
         */
        public static final AdvancementEntry KILL_GHAST_IN_OVERWORLD = advancement("nether/uneasy_alliance");
        /**
         * War Pigs - Loot a Chest in a Bastion Remnant
         */
        public static final AdvancementEntry LOOT_BASTION = advancement("nether/loot_bastion");
        /**
         * Country Lode, Take Me Home - Use a Compass on a Lodestone
         */
        public static final AdvancementEntry USE_LODESTONE = advancement("nether/use_lodestone");
        /**
         * Cover Me in Debris - Get a full suit of Netherite armor
         */
        public static final AdvancementEntry OBTAIN_FULL_SUIT_OF_NETHERITE_ARMOR = advancement("nether/netherite_armor");
        /**
         * Spooky Scary Skeleton - Obtain a Wither Skeleton's skull
         */
        public static final AdvancementEntry OBTAIN_WITHER_SKULL = advancement("nether/get_wither_skull");
        /**
         * Into Fire - Relieve a Blaze of its rod
         */
        public static final AdvancementEntry OBTAIN_BLAZE_ROD = advancement("nether/obtain_blaze_rod");
        /**
         * Not Quite "Nine" Lives - Charge a Respawn Anchor to the maximum
         */
        public static final AdvancementEntry CHARGE_RESPAWN_ANCHOR = advancement("nether/charge_respawn_anchor");
        /**
         * Feels Like Home - Take a Strider for a loooong ride on a lava lake in the Overworld
         */
        public static final AdvancementEntry RIDE_STRIDER_IN_OVERWORLD_LAVA = advancement("nether/ride_strider_in_overworld_lava");
        /**
         * Hot Tourist Destinations - Explore all Nether biomes
         */
        public static final AdvancementEntry EXPLORE_NETHER = advancement("nether/explore_nether");
        /**
         * Withering Heights - Summon the Wither
         */
        public static final AdvancementEntry SUMMON_WITHER = advancement("nether/summon_wither");
        /**
         * Local Brewery - Brew a Potion
         */
        public static final AdvancementEntry BREW_POTION = advancement("nether/brew_potion");
        /**
         * Bring Home the Beacon - Construct and place a Beacon
         */
        public static final AdvancementEntry CREATE_BEACON = advancement("nether/create_beacon");
        /**
         * A Furious Cocktail - Have every potion effect applied at the same time
         */
        public static final AdvancementEntry ALL_POTIONS = advancement("nether/all_potions");
        /**
         * Beaconator - Bring a Beacon to full power
         */
        public static final AdvancementEntry CREATE_FULL_BEACON = advancement("nether/create_full_beacon");
        /**
         * How Did We Get Here? - Have every effect applied at the same time
         */
        public static final AdvancementEntry ALL_EFFECTS = advancement("nether/all_effects");
    }

    public static final class End {
        /**
         * The End - Or the beginning?
         */
        public static final AdvancementEntry ROOT = advancement("end/root");
        /**
         * Free the End - Good luck
         */
        public static final AdvancementEntry KILL_ENDER_DRAGON = advancement("end/kill_dragon");
        /**
         * The Next Generation - Hold the Dragon Egg
         */
        public static final AdvancementEntry OBTAIN_DRAGON_EGG = advancement("end/dragon_egg");
        /**
         * Remote Getaway - Escape the island
         */
        public static final AdvancementEntry ENTER_END_GATEWAY = advancement("end/enter_end_gateway");
        /**
         * The End... Again...	Respawn the Ender Dragon
         */
        public static final AdvancementEntry RESPAWN_ENDER_DRAGON = advancement("end/respawn_dragon");
        /**
         * You Need a Mint - Collect Dragon's Breath in a Glass Bottle
         */
        public static final AdvancementEntry BOTTLE_DRAGON_BREATH = advancement("end/dragon_breath");
        /**
         * The City at the End of the Game - Go on in, what could happen?
         */
        public static final AdvancementEntry FIND_END_CITY = advancement("end/find_end_city");
        /**
         * Sky's the Limit - Find Elytra
         */
        public static final AdvancementEntry FIND_ELYTRA = advancement("end/elytra");
        /**
         * Great View From Up Here	Levitate up 50 blocks from the attacks of a Shulker
         */
        public static final AdvancementEntry LEVITATE_FIFTY_METERS = advancement("end/levitate");
    }
    
    public static final class Adventure {
        /**
         * Adventure - Adventure, exploration and combat
         */
        public static final AdvancementEntry ROOT = advancement("adventure/root");
        /**
         * Voluntary Exile - Kill a raid captain. Maybe consider staying away from villages for the time being...
         */
        public static final AdvancementEntry KILL_RAID_CAPTAIN = advancement("adventure/voluntary_exile");
        /**
         * Is It a Bird? - Look at a Parrot through a Spyglass
         */
        public static final AdvancementEntry SPYGLASS_AT_PARROT = advancement("adventure/spyglass_at_parrot");
        /**
         * Monster Hunter - Kill any hostile monster
         */
        public static final AdvancementEntry KILL_A_MONSTER = advancement("adventure/kill_a_mob");
        /**
         * The Power of Books - Read the power signal of a Chiseled Bookshelf using a Comparator
         */
        public static final AdvancementEntry READ_POWER_OF_CHISELED_BOOKSHELF = advancement("adventure/read_power_of_chiseled_bookshelf");
        /**
         * What a Deal! - Successfully trade with a Villager
         */
        public static final AdvancementEntry TRADE = advancement("adventure/trade");
        /**
         * Crafting a New Look - Craft a trimmed armor at a Smithing Table
         */
        public static final AdvancementEntry TRIM_WITH_ANY_ARMOR_PATTERN = advancement("adventure/trim_with_any_armor_pattern");
        /**
         * Sticky Situation - Jump into a Honey Block to break your fall
         */
        public static final AdvancementEntry SLIDE_DOWN_HONEY_BLOCK = advancement("adventure/honey_block_slide");
        /**
         * Ol' Betsy - Shoot a Crossbow
         */
        public static final AdvancementEntry SHOOT_CROSSBOW = advancement("adventure/ol_betsy");
        /**
         * Surge Protector - Protect a Villager from an undesired shock without starting a fire
         */
        public static final AdvancementEntry LIGHTNING_ROD_WITH_VILLAGER_NO_FIRE = advancement("adventure/lightning_rod_with_villager_no_fire");
        /**
         * Caves & Cliffs - Free fall from the top of the world (build limit) to the bottom of the world and survive
         */
        public static final AdvancementEntry FALL_FROM_WORLD_HEIGHT = advancement("adventure/fall_from_world_height");
        /**
         * Respecting the Remnants - Brush a Suspicious block to obtain a Pottery Sherd
         */
        public static final AdvancementEntry SALVAGE_SHERD = advancement("adventure/salvage_sherd");
        /**
         * Sneak 100 - Sneak near a Sculk Sensor or Warden to prevent it from detecting you
         */
        public static final AdvancementEntry AVOID_VIBRATION = advancement("adventure/avoid_vibration");
        /**
         * Sweet Dreams	Sleep in a Bed to change your respawn point
         */
        public static final AdvancementEntry SLEEP_IN_BED = advancement("adventure/sleep_in_bed");
        /**
         * Hero of the Village - Successfully defend a village from a raid
         */
        public static final AdvancementEntry DEFEAT_RAID = advancement("adventure/hero_of_the_village");
        /**
         * Is It a Balloon? - Look at a Ghast through a Spyglass
         */
        public static final AdvancementEntry SPYGLASS_AT_GHAST = advancement("adventure/spyglass_at_ghast");
        /**
         * A Throwaway Joke - Throw a Trident at something. Note: Throwing away your only weapon is not a good idea.
         */
        public static final AdvancementEntry THROW_TRIDENT = advancement("adventure/throw_trident");
        /**
         * It Spreads - Kill a mob near a Sculk Catalyst
         */
        public static final AdvancementEntry KILL_MOB_NEAR_SCULK_CATALYST = advancement("adventure/kill_mob_near_sculk_catalyst");
        /**
         * Take Aim - Shoot something with an Arrow
         */
        public static final AdvancementEntry SHOOT_ARROW = advancement("adventure/shoot_arrow");
        /**
         * Monsters Hunted - Kill one of every hostile monster
         */
        public static final AdvancementEntry KILL_ALL_MOBS = advancement("adventure/kill_all_mobs");
        /**
         * Postmortal - Use a Totem of Undying to cheat death
         */
        public static final AdvancementEntry USE_TOTEM_OF_UNDYING = advancement("adventure/totem_of_undying");
        /**
         * Hired Help - Summon an Iron Golem to help defend a village
         */
        public static final AdvancementEntry SUMMON_IRON_GOLEM = advancement("adventure/summon_iron_golem");
        /**
         * Star Trader - Trade with a Villager at the build height limit
         */
        public static final AdvancementEntry TRADE_AT_BUILD_LIMIT = advancement("adventure/trade_at_world_height");
        /**
         * Smithing with Style - Apply these smithing templates at least once: Spire, Snout, Rib, Ward, Silence, Vex, Tide, Wayfinder
         */
        public static final AdvancementEntry TRIM_WITH_ALL_EXCLUSIVE_ARMOR_PATTERNS = advancement("adventure/trim_with_all_exclusive_armor_patterns");
        /**
         * Two Birds, One Arrow - Kill two Phantoms with a piercing Arrow
         */
        public static final AdvancementEntry TWO_PHANTOMS_PIERCED_WITH_CROSSBOW = advancement("adventure/two_birds_one_arrow");
        /**
         * Who's the Pillager Now? - Give a Pillager a taste of their own medicine
         */
        public static final AdvancementEntry SHOOT_PILLAGER_WITH_CROSSBOW = advancement("adventure/whos_the_pillager_now");
        /**
         * Arbalistic - Kill five unique mobs with one crossbow shot
         */
        public static final AdvancementEntry FIVE_DIFFERENT_MOBS_PIERCED_WITH_CROSSBOW = advancement("adventure/arbalistic");
        /**
         * Careful Restoration -Make a Decorated Pot out of 4 Pottery Sherds
         */
        public static final AdvancementEntry CRAFT_DECORATED_POT_USING_ONLY_SHERDS = advancement("adventure/craft_decorated_pot_using_only_sherds");
        /**
         * Adventuring Time - Discover every biome
         */
        public static final AdvancementEntry VISIT_ALL_BIOMES = advancement("adventure/adventuring_time");
        /**
         * Sound of Music	Make the Meadows come alive with the sound of music from a Jukebox
         */
        public static final AdvancementEntry PLAY_JUKEBOX_IN_MEADOWS = advancement("adventure/play_jukebox_in_meadows");
        /**
         * Light as a Rabbit - Walk on Powder Snow... without sinking in it
         */
        public static final AdvancementEntry WALK_ON_POWDER_SNOW_WITH_LEATHER_BOOTS = advancement("adventure/walk_on_powder_snow_with_leather_boots");
        /**
         * Is It a Plane? - Look at the Ender Dragon through a Spyglass
         */
        public static final AdvancementEntry SPYGLASS_AT_DRAGON = advancement("adventure/spyglass_at_dragon");
        /**
         * Very Very Frightening - Strike a Villager with lightning
         */
        public static final AdvancementEntry STRIKE_VILLAGER_WITH_LIGHTNING = advancement("adventure/very_very_frightening");
        /**
         * Sniper Duel - Kill a Skeleton from at least 50 meters away
         */
        public static final AdvancementEntry SNIPE_SKELETON_FROM_FIFTY_METERS_AWAY = advancement("adventure/sniper_duel");
        /**
         * Bullseye	Hit the bullseye of a Target block from at least 30 meters away
         */
        public static final AdvancementEntry HIT_CENTER_OF_TARGET_FROM_THIRTY_METERS_AWAY = advancement("adventure/bullseye");
        /**
         * Isn't It Scute? - Get Armadillo Scutes from an Armadillo using a Brush
         */
        public static final AdvancementEntry BRUSH_ARMADILLO = advancement("adventure/brush_armadillo");
        /**
         * Minecraft: Trial(s) Edition - Step foot in a Trial Chamber
         */
        public static final AdvancementEntry FIND_TRIAL_CHAMBER = advancement("adventure/minecraft_trials_edition");
        /**
         * Crafters Crafting Crafters - Be near a Crafter when it crafts a Crafter
         */
        public static final AdvancementEntry CRAFT_CRAFTER_WITH_CRAFTER = advancement("adventure/crafters_crafting_crafters");
        /**
         * Lighten Up - Scrape a Copper Bulb with an Axe to make it brighter
         */
        public static final AdvancementEntry CLEAN_COPPER_BULB = advancement("adventure/lighten_up");
        /**
         * Who Needs Rockets? - Use a Wind Charge to launch yourself upwards 8 blocks
         */
        public static final AdvancementEntry SEVEN_BLOCK_JUMP = advancement("adventure/who_needs_rockets");
        /**
         * Under Lock and Key - Use a Trial Key on a Vault
         */
        public static final AdvancementEntry OPEN_REGULAR_VAULT = advancement("adventure/under_lock_and_key");
        /**
         * Revaulting - Use an Ominous Trial Key on an Ominous Vault
         */
        public static final AdvancementEntry OPEN_OMINOUS_VAULT = advancement("adventure/revaulting");
        /**
         * Blowback - Kill a Breeze with a deflected Breeze-shot Wind Charge
         */
        public static final AdvancementEntry KILL_BREEZE_WITH_PARRIED_WIND_CHARGE = advancement("adventure/blowback");
        /**
         * Over-Overkill - Deal 50 hearts of damage in a single hit using the Mace
         */
        public static final AdvancementEntry DEAL_ONE_HUNDRED_DAMAGE_WITH_MACE = advancement("adventure/overoverkill");
    }

    //TODO Add "Husbandry" inner class
    public static final class Husbandry {
        /**
         * Husbandry - The world is full of friends and food
         */
        public static final AdvancementEntry ROOT = advancement("husbandry/root");
        /**
         * Bee Our Guest - Use a Campfire to collect Honey from a Beehive using a Glass Bottle without aggravating the Bees
         */
        public static final AdvancementEntry SAFELY_HARVEST_HONEY = advancement("husbandry/safely_harvest_honey");
        /**
         * The Parrots and the Bats - Breed two animals together
         */
        public static final AdvancementEntry BREED_AN_ANIMAL = advancement("husbandry/breed_an_animal");
        /**
         * You've Got a Friend in Me - Have an Allay deliver items to you
         */
        public static final AdvancementEntry ALLAY_DELIVER_ITEM_TO_PLAYER = advancement("husbandry/allay_deliver_item_to_player");
        /**
         * Whatever Floats Your Goat! - Get in a Boat and float with a Goat
         */
        public static final AdvancementEntry RIDE_A_BOAT_WITH_A_GOAT = advancement("husbandry/ride_a_boat_with_a_goat");
        /**
         * Best Friends Forever - Tame an animal
         */
        public static final AdvancementEntry TAME_AN_ANIMAL = advancement("husbandry/tame_an_animal");
        /**
         * Glow and Behold! - Make the text of any kind of sign glow
         */
        public static final AdvancementEntry MAKE_A_SIGN_GLOW = advancement("husbandry/make_a_sign_glow");
        /**
         * Fishy Business - Catch a fish
         */
        public static final AdvancementEntry REEL_IN_A_FISH = advancement("husbandry/fishy_business");
        /**
         * Total Beelocation - Move a Bee Nest, with 3 Bees inside, using Silk Touch
         */
        public static final AdvancementEntry SILK_TOUCH_BEE_NEST = advancement("husbandry/silk_touch_nest");
        /**
         * Bukkit Bukkit - Catch a Tadpole in a Bucket
         */
        public static final AdvancementEntry TADPOLE_IN_A_BUCKET = advancement("husbandry/tadpole_in_a_bucket");
        /**
         * Smells Interesting - Obtain a Sniffer Egg
         */
        public static final AdvancementEntry OBTAIN_SNIFFER_EGG = advancement("husbandry/obtain_sniffer_egg");
        /**
         * A Seedy Place - Plant a seed and watch it grow
         */
        public static final AdvancementEntry PLANT_SEED = advancement("husbandry/plant_seed");
        /**
         * Wax On - Apply Honeycomb to a Copper block!
         */
        public static final AdvancementEntry APPLY_WAX_TO_COPPER = advancement("husbandry/wax_on");
        /**
         * Two by Two - Breed all the animals!
         */
        public static final AdvancementEntry BRED_ALL_ANIMALS = advancement("husbandry/bred_all_animals");
        /**
         * Birthday Song - Have an Allay drop a Cake at a Note Block
         */
        public static final AdvancementEntry ALLAY_DELIVER_CAKE_TO_NOTE_BLOCK = advancement("husbandry/allay_deliver_cake_to_note_block");
        /**
         * A Complete Catalogue - Tame all Cat variants!
         */
        public static final AdvancementEntry TAME_ALL_CAT_VARIANTS = advancement("husbandry/complete_catalogue");
        /**
         * Tactical Fishing - Catch a Fish... without a Fishing Rod!
         */
        public static final AdvancementEntry FISH_IN_A_BUCKET = advancement("husbandry/tactical_fishing");
        /**
         * When the Squad Hops into Town - Get each Frog variant on a Lead
         */
        public static final AdvancementEntry LEASH_ALL_FROG_VARIANTS = advancement("husbandry/leash_all_frog_variants");
        /**
         * Little Sniffs - Feed a Snifflet
         */
        public static final AdvancementEntry FEED_BABY_SNIFFER = advancement("husbandry/feed_snifflet");
        /**
         * A Balanced Diet - Eat everything that is edible, even if it's not good for you
         */
        public static final AdvancementEntry EAT_ALL_FOODS = advancement("husbandry/balanced_diet");
        /**
         * Serious Dedication - Use a Netherite Ingot to upgrade a Hoe, and then reevaluate your life choices
         */
        public static final AdvancementEntry OBTAIN_NETHERITE_HOE = advancement("husbandry/obtain_netherite_hoe");
        /**
         * Wax Off	Scrape Wax off of a Copper block!
         */
        public static final AdvancementEntry SCRAPE_WAX_OFF_COPPER = advancement("husbandry/wax_off");
        /**
         * The Cutest Predator - Catch an Axolotl in a Bucket
         */
        public static final AdvancementEntry AXOLOTL_IN_A_BUCKET = advancement("husbandry/axolotl_in_a_bucket");
        /**
         * With Our Powers Combined! - Have all Froglights in your inventory
         */
        public static final AdvancementEntry ALL_FROGLIGHTS = advancement("husbandry/froglights");
        /**
         * Planting the Past - Plant any Sniffer seed
         */
        public static final AdvancementEntry PLANT_ANY_SNIFFER_SEED = advancement("husbandry/plant_any_sniffer_seed");
        /**
         * The Healing Power of Friendship! - Team up with an axolotl and win a fight
         */
        public static final AdvancementEntry KILL_AXOLOTL_TARGET = advancement("husbandry/kill_axolotl_target");
        /**
         * Good as New - Repair a damaged Wolf Armor using Armadillo Scutes
         */
        public static final AdvancementEntry REPAIR_WOLF_ARMOR = advancement("husbandry/repair_wolf_armor");
        /**
         * The Whole Pack - Tame one of each Wolf variant
         */
        public static final AdvancementEntry TAME_ALL_WOLF_VARIANTS = advancement("husbandry/whole_pack");
        /**
         * Shear Brilliance - Remove Wolf Armor from a Wolf using Shears
         */
        public static final AdvancementEntry REMOVE_WOLF_ARNOR = advancement("husbandry/remove_wolf_armor");
    }

    private static AdvancementEntry advancement(String path) {
        return Advancement.Builder.createUntelemetered().criterion("impossible", Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions())).build(Identifier.ofVanilla(path));
    }
}