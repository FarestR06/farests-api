package com.farestr06.api;

import com.farestr06.api.util.registry.NoteblockInstrumentRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


public class FarestsAPI implements ModInitializer {
	public static final String MOD_ID = "fr06-api";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final ResourceLocation BONK_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "block.note_block.bonk");

	private static final Holder.Reference<SoundEvent> BONK_EVENT = Registry.registerForHolder(
			BuiltInRegistries.SOUND_EVENT,
			BONK_ID,
			SoundEvent.createVariableRangeEvent(BONK_ID)
	);

	@Override
	public void onInitialize() {
		if (new Random().nextFloat() < 0.067) {
			LOGGER.info("sigma ohio gyat rizz in ohio"); // nothing to see here move along
		} else LOGGER.info("farest");

		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			NoteblockInstrumentRegistry.INSTANCE.add(Blocks.BAMBOO_MOSAIC, BONK_EVENT);
		}
	}
}