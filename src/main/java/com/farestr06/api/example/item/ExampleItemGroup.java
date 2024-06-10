package com.farestr06.api.example.item;

import com.farestr06.api.FarestsAPI;
import com.farestr06.api.example.ExampleBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;

public class ExampleItemGroup {
    public static final ItemGroup EXAMPLE_GROUP = FarestsAPI.HELPER.registerItemGroup("example",
            FabricItemGroup.builder().displayName(Text.literal("Farest's API Examples")).entries((
                    (displayContext, entries) -> entries.add(ExampleBlock.SCREAMER_ITEM)))
                    .build());

    public static void register() {
        FarestsAPI.LOGGER.info("Registering example ItemGroup...");
    }
}
