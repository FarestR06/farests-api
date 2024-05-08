package com.farestr06.api.example;

import com.farestr06.api.FarestsAPI;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ExampleSound {

    public static final RegistryEntry<SoundEvent> SCREAMER = registerReference(new Identifier("fr06-api", "block.note_block.screamer"));

    public static RegistryEntry<SoundEvent> registerReference(Identifier id) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void initTestSound() {
        FarestsAPI.LOGGER.info("Registering example SoundEvent...");
    }
}
