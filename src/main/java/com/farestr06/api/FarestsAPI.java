package com.farestr06.api;

import com.farestr06.api.util.registry.NoteblockInstrumentRegistry;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FarestsAPI implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

    public static final Logger LOGGER = LoggerFactory.getLogger("fr06-api");

	private static final Identifier BONK_ID = Identifier.of("fr06-api", "block.note_block.bonk");

	private static final RegistryEntry.Reference<SoundEvent> BONK = Registry.registerReference(
			Registries.SOUND_EVENT,
			BONK_ID,
			SoundEvent.of(BONK_ID)
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("farest");

		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			NoteblockInstrumentRegistry.INSTANCE.add(Blocks.BAMBOO_MOSAIC, BONK);
		}
	}
}