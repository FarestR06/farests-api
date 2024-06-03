package com.farestr06.api;

import com.farestr06.api.example.ExampleBlock;
import com.farestr06.api.example.item.ExampleItemGroup;
import com.farestr06.api.example.ExampleSound;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FarestsAPI implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("fr06-api");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("farest");

		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			ExampleSound.initTestSound();
			ExampleBlock.initTestBlock();
			ExampleItemGroup.initExampleItemGroup();
		}
	}
}