package com.farestr06.api.mixin;

import com.farestr06.api.item.FarestsItemSettings;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;
import java.util.List;

@Mixin(Item.Settings.class)
public abstract class ItemSettingsMixin implements FarestsItemSettings {
    @Shadow public abstract <T> Item.Settings component(ComponentType<T> type, T value);

    @Override
    public Item.Settings glint() {
        return component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
    }

    @Override
    public Item.Settings lore(Text... texts) {
        List<Text> textList = Arrays.stream(texts).toList();
        return component(DataComponentTypes.LORE, new LoreComponent(textList));
    }
}
