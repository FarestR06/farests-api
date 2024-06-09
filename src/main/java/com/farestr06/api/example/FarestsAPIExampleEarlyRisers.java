package com.farestr06.api.example;

import com.chocohead.mm.api.EnumAdder;
import com.farestr06.api.asm.EarlyRiserHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.enums.Instrument;

public class FarestsAPIExampleEarlyRisers implements EarlyRiserHelper {

    @Override
    public void run() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            EnumAdder adder = getInstrumentAdder();
            adder.addEnum("SCREAMER", () -> new Object[]{"screamer", ExampleSound.SCREAMER, Instrument.Type.BASE_BLOCK});
            adder.build();
        }
    }
}
