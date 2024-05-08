package com.farestr06.api.asm;

import com.chocohead.mm.api.ClassTinkerers;
import com.chocohead.mm.api.EnumAdder;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

/**
 * This class can be used as an Early Riser class when using Manningham Mills.
 * It extends the {@link Runnable Runnable} interface and contains extra utilities for adding to various enums.
 * @see java.lang.Runnable
 */
public interface EarlyRiserImpl extends Runnable {

    @Override
    void run();

    /**
     * Creates an EnumAdder that targets the {@link net.minecraft.block.enums.Instrument Instrument} enum. This adder can be used to add custom Note Block instruments.
     * @return An enum adder targeting the {@link net.minecraft.block.enums.Instrument Instrument} enum
     * @apiNote Use the return value like this: <p><code>addEnum("FOO", () -> new Object[]{"bar", soundEventRegistryEntry, Instrument.Type.BAZ});</code></p>
     */
    default EnumAdder getInstrumentAdder() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String instrumentMapping = remapper.mapClassName("intermediary", "net.minecraft.class_2766");
        String registryEntry = remapper.mapClassName("intermediary", "net.minecraft.class_6880");
        String typeMapping = remapper.mapClassName("intermediary", "net.minecraft.class_2766$class_7994");
        return ClassTinkerers.enumBuilder(instrumentMapping, String.class, 'L' + registryEntry + ';', 'L' + typeMapping + ';');
    }
}
