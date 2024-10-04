package com.farestr06.api.util.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class NoteblockInstrumentRegistryImpl implements NoteblockInstrumentRegistry {
    private final Map<Block, RegistryEntry.Reference<SoundEvent>> instrumentsByBlock = new HashMap<>();
    private final Map<TagKey<Block>, RegistryEntry.Reference<SoundEvent>> instrumentsByTag = new HashMap<>();
    private volatile Map<Block, RegistryEntry.Reference<SoundEvent>> computedInstruments = null;

    private Map<Block, RegistryEntry.Reference<SoundEvent>> getEntryMap() {
        Map<Block, RegistryEntry.Reference<SoundEvent>> ret = computedInstruments;

        if (ret == null) {
            ret = new IdentityHashMap<>();

            // tags take precedence over blocks
            for (TagKey<Block> tag : instrumentsByTag.keySet()) {
                RegistryEntry.Reference<SoundEvent> entry = instrumentsByTag.get(tag);

                for (RegistryEntry<Block> block : Registries.BLOCK.iterateEntries(tag)) {
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
    public RegistryEntry.Reference<SoundEvent> get(Block block) {
        RegistryEntry.Reference<SoundEvent> event = getEntryMap().get(block);
        return event;
    }

    @Override
    public void add(Block block, RegistryEntry.Reference<SoundEvent> event) {
        instrumentsByBlock.put(block, event);
        computedInstruments = null;
    }

    @Override
    public void add(TagKey<Block> tag, RegistryEntry.Reference<SoundEvent> event) {
        instrumentsByTag.put(tag, event);
    }

    @Override
    public void remove(Block block) {
        add(block, SoundEvents.BLOCK_NOTE_BLOCK_HARP);
    }

    @Override
    public void remove(TagKey<Block> tag) {
        add(tag, SoundEvents.BLOCK_NOTE_BLOCK_HARP);
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
