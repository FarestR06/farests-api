package com.farestr06.api.mixin;

import com.farestr06.api.util.registry.NoteblockInstrumentRegistry;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NoteBlock;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Inject(method = "onSyncedBlockEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/enums/NoteBlockInstrument;getSound()Lnet/minecraft/registry/entry/RegistryEntry;"), cancellable = true)
    private void injected(BlockState state, World world, BlockPos pos, int type, int data, CallbackInfoReturnable<Boolean> cir, @Local float f) {
        Block block = world.getBlockState(pos.down()).getBlock();
        RegistryEntry.Reference<SoundEvent> event = NoteblockInstrumentRegistry.INSTANCE.get(block);
        if (event != null) {
            world.playSound(
                    null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, event, SoundCategory.RECORDS, 3.0F, f, world.random.nextLong()
            );
            cir.setReturnValue(true);
        }
    }
}
