package com.farestr06.api.item;

import net.minecraft.item.Item;
import net.minecraft.text.Text;

public interface FarestsItemSettings {
    default Item.Settings explosionProof() {
        throw new UnsupportedOperationException("Method should be called from Item.Settings!");
    }
    default Item.Settings glint() {
        throw new UnsupportedOperationException("Method should be called from Item.Settings!");
    }
    default Item.Settings lore(Text... texts) {
        throw new UnsupportedOperationException("Method should be called from Item.Settings!");
    }
    default Item.Settings stack1() {
        throw new UnsupportedOperationException("Method should be called from Item.Settings!");
    }
    default Item.Settings stack16() {
        throw new UnsupportedOperationException("Method should be called from Item.Settings!");
    }

    default Item.Settings copy(Item item) {
        throw new UnsupportedOperationException("Method should be called from Item.Settings!");
    }
}
