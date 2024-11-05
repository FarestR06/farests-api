package com.farestr06.api.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public final class SoundHelper {
    public static SoundEvent makeEvent(Identifier id) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }public static SoundEvent makeEvent(Identifier registryId, Identifier soundId) {
        return Registry.register(Registries.SOUND_EVENT, registryId, SoundEvent.of(soundId));
    }
    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier id) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier registryId, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, registryId, SoundEvent.of(soundId));
    }
}
