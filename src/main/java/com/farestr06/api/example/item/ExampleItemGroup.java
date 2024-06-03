package com.farestr06.api.example.item;

import com.farestr06.api.FarestsAPI;
import com.farestr06.api.example.ExampleBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ExampleItemGroup {
    public static final ItemGroup EXAMPLE_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier("fr06-api", "example"),
            FabricItemGroup.builder().displayName(Text.literal("Farest's API Examples")).entries(((displayContext, entries) -> {
                entries.add(ExampleBlock.SCREAMER_ITEM);
            })).build());

    public static void initExampleItemGroup() {
        FarestsAPI.LOGGER.info("Registering example ItemGroup...");
    }
}
