package com.farestr06.api.util.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class NoteblockInstrumentRegistryImpl implements NoteblockInstrumentRegistry {
    private final Map<Block, Holder.Reference<SoundEvent>> instrumentsByBlock = new HashMap<>();
    private final Map<TagKey<Block>, Holder.Reference<SoundEvent>> instrumentsByTag = new HashMap<>();
    private volatile Map<Block, Holder.Reference<SoundEvent>> computedInstruments = null;

    private Map<Block, Holder.Reference<SoundEvent>> getEntryMap() {
        Map<Block, Holder.Reference<SoundEvent>> ret = computedInstruments;

        if (ret == null) {
            ret = new IdentityHashMap<>();

            // tags take precedence over blocks
            for (TagKey<Block> tag : instrumentsByTag.keySet()) {
                Holder.Reference<SoundEvent> entry = instrumentsByTag.get(tag);

                for (Holder<Block> block : BuiltInRegistries.BLOCK.getTagOrEmpty(tag)) {
                    ret.put(block.value(), entry);
                }
            }

            ret.putAll(instrumentsByBlock);

            computedInstruments = ret;
        }

        return ret;
    }

    @Nullable
    @Override
    public Holder.Reference<SoundEvent> get(Block block) {
        return getEntryMap().get(block);
    }

    @Override
    public void add(Block block, Holder.Reference<SoundEvent> event) {
        instrumentsByBlock.put(block, event);
        computedInstruments = null;
    }

    @Override
    public void add(TagKey<Block> tag, Holder.Reference<SoundEvent> event) {
        instrumentsByTag.put(tag, event);
    }

    @Override
    public void remove(Block block) {
        add(block, SoundEvents.NOTE_BLOCK_HARP);
    }

    @Override
    public void remove(TagKey<Block> tag) {
        add(tag, SoundEvents.NOTE_BLOCK_HARP);
    }

    @Override
    public void clear(Block block) {
        instrumentsByBlock.remove(block);

        computedInstruments = null;
    }

    @Override
    public void clear(TagKey<Block> tag) {
        instrumentsByTag.remove(tag);

        computedInstruments = null;
    }
}
