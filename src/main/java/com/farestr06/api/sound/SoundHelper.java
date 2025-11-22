package com.farestr06.api.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public final class SoundHelper {
    public static SoundEvent makeEvent(ResourceLocation location) {
        return makeEvent(location, location);
    }
    public static SoundEvent makeEvent(ResourceLocation registryLocation, ResourceLocation soundLocation) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, registryLocation, SoundEvent.createVariableRangeEvent(soundLocation));
    }

    public static Holder.Reference<SoundEvent> makeReferenceEvent(ResourceLocation location) {
        return makeReferenceEvent(location, location);
    }
    public static Holder.Reference<SoundEvent> makeReferenceEvent(ResourceLocation registryLocation, ResourceLocation soundLocation) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, registryLocation, SoundEvent.createVariableRangeEvent(soundLocation));
    }
}
