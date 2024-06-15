package com.farestr06.api.example;

import com.chocohead.mm.api.EnumAdder;
import com.farestr06.api.asm.EarlyRiserHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.enums.NoteBlockInstrument;

public class FarestsAPIExampleEarlyRisers implements EarlyRiserHelper {

    @Override
    public void run() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            EnumAdder adder = getNoteBlockInstrumentAdder();
            adder.addEnum("SCREAMER", () -> new Object[]{"screamer", ExampleSound.SCREAMER, NoteBlockInstrument.Type.BASE_BLOCK});
            adder.build();
        }
    }
}
