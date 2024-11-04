package com.farestr06.api.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public final class SoundHelper {
    public static RegistryEntry.Reference<SoundEvent> makeEvent(Identifier id) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier id) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
