package com.farestr06.api.example;

import com.chocohead.mm.api.ClassTinkerers;
import com.farestr06.api.FarestsAPI;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ExampleBlock {

    public static final Block SCREAMER = FarestsAPI.HELPER.registerBlock(
            "screamer", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).instrument(ClassTinkerers.getEnum(NoteBlockInstrument.class, "SCREAMER")))
    );

    public static final Item SCREAMER_ITEM = FarestsAPI.HELPER.registerItem("screamer", new BlockItem(SCREAMER, new Item.Settings())
    );

    public static void register() {
        FarestsAPI.LOGGER.info("Registering example Block...");
    }
}
