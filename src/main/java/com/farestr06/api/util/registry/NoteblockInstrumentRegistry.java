package com.farestr06.api.util.registry;

import net.fabricmc.fabric.api.util.Block2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

public interface NoteblockInstrumentRegistry extends Block2ObjectMap<Holder.Reference<SoundEvent>> {
    NoteblockInstrumentRegistry INSTANCE = new NoteblockInstrumentRegistryImpl();
}
