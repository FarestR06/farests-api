package com.farestr06.api;

import com.farestr06.api.util.GameObjectBuilder;
import com.farestr06.api.util.registry.NoteblockInstrumentRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CryingObsidianBlock;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Random;


public class FarestsAPI implements ModInitializer {
	public static final String MOD_ID = "fr06-api";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Identifier BONK_ID = Identifier.of(MOD_ID, "block.note_block.bonk");

	private static final RegistryEntry.Reference<SoundEvent> BONK_EVENT = Registry.registerReference(
			Registries.SOUND_EVENT,
			BONK_ID,
			SoundEvent.of(BONK_ID)
	);

	private static final Optional<Block> FUNKY_LOL = GameObjectBuilder
			.block(Identifier.of(MOD_ID, "funky_lol"), FabricLoader.getInstance().isDevelopmentEnvironment())
			.settings(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK))
			.construct(CryingObsidianBlock::new)
			.buildOptionalWithItem(new Item.Settings().food(FoodComponents.GOLDEN_CARROT));

	@Override
	public void onInitialize() {
		if (new Random().nextFloat() < 0.069) {
			LOGGER.info("sigma ohio gyat rizz in ohio"); // nothing to see here move along
		} else LOGGER.info("farest");

		// Add random block to Creative Tab if we're in an IDE
        FUNKY_LOL.ifPresent(block -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> entries.add(block)));

		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			NoteblockInstrumentRegistry.INSTANCE.add(Blocks.BAMBOO_MOSAIC, BONK_EVENT);
		}
	}
}