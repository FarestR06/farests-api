package com.farestr06.api.example;

import com.chocohead.mm.api.ClassTinkerers;
import com.farestr06.api.FarestsAPI;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExampleBlock {
    public static final Block SCREAMER = Registry.register(Registries.BLOCK, new Identifier("fr06-api", "screamer"),
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).instrument(ClassTinkerers.getEnum(Instrument.class, "SCREAMER"))));
    public static final Item SCREAMER_ITEM = Registry.register(Registries.ITEM, new Identifier("fr06-api", "screamer"),
            new BlockItem(SCREAMER, new Item.Settings()));

    public static void initTestBlock() {
        FarestsAPI.LOGGER.info("Registering example Block...");
    }
}
