package com.farestr06.api.example;

import com.chocohead.mm.api.ClassTinkerers;
import com.farestr06.api.FarestsAPI;
import com.farestr06.api.util.RegistryHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ExampleBlock {

    public static final RegistryHelper<Block> BLOCK_REGISTRY_HELPER = new RegistryHelper<>("fr06-api");
    public static final RegistryHelper<Item> ITEM_REGISTRY_HELPER = new RegistryHelper<>("fr06-api");

    public static final Block SCREAMER = BLOCK_REGISTRY_HELPER.add(
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).instrument(ClassTinkerers.getEnum(Instrument.class, "SCREAMER"))),
            "screamer"
    );

    public static final Item SCREAMER_ITEM = ITEM_REGISTRY_HELPER.add(new BlockItem(SCREAMER, new Item.Settings()),
            "screamer");

    public static void initTestBlock() {
        FarestsAPI.LOGGER.info("Registering example Block...");
    }
}
