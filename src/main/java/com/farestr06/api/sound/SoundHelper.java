package com.farestr06.api.sound;

import com.farestr06.api.util.Translator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public final class SoundHelper {
    public static SoundEvent makeEvent(Identifier id) {
        return makeEvent(id, id);
    }
    public static SoundEvent makeEvent(Identifier registryId, Identifier soundId) {
        return Registry.register(Registries.SOUND_EVENT, registryId, SoundEvent.of(soundId));
    }
    public static SoundEvent makeEvent(Identifier id, String subtitles, Translator translator) {
        return makeEvent(id, id, subtitles, translator);
    }
    public static SoundEvent makeEvent(Identifier registryId, Identifier soundId, String subtitles, Translator translator) {
        SoundEvent event = SoundEvent.of(soundId);
        subtitles(event, subtitles, translator);
        return Registry.register(Registries.SOUND_EVENT, registryId, event);
    }

    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier id) {
        return makeReferenceEvent(id, id);
    }
    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier registryId, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, registryId, SoundEvent.of(soundId));
    }
    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier id, String subtitles, Translator translator) {
        return makeReferenceEvent(id, id, subtitles, translator);
    }
    public static RegistryEntry.Reference<SoundEvent> makeReferenceEvent(Identifier registryId, Identifier soundId, String subtitles, Translator translator) {
        SoundEvent event = SoundEvent.of(soundId);
        subtitles(event, subtitles, translator);
        return Registry.registerReference(Registries.SOUND_EVENT, registryId, event);
    }

    public static void subtitles(SoundEvent event, String subtitles, Translator translator) {
        translator.addSubtitle(event, subtitles);
    }
}
