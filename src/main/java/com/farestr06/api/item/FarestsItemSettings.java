package com.farestr06.api.item;

import net.minecraft.item.Item;
import net.minecraft.text.Text;

public interface FarestsItemSettings {
    Item.Settings explosionProof();
    Item.Settings glint();
    Item.Settings lore(Text... texts);
    Item.Settings stack1();
    Item.Settings stack16();
}
