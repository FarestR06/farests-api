package com.farestr06.api.util.registry;

import net.fabricmc.fabric.api.util.Block2ObjectMap;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;

public interface NoteblockInstrumentRegistry extends Block2ObjectMap<RegistryEntry.Reference<SoundEvent>> {
    NoteblockInstrumentRegistry INSTANCE = new NoteblockInstrumentRegistryImpl();
}
