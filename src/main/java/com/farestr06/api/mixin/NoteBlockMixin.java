package com.farestr06.api.mixin;

import com.farestr06.api.util.registry.NoteblockInstrumentRegistry;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Inject(method = "triggerEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;getSoundEvent()Lnet/minecraft/core/Holder;"), cancellable = true)
    private void injected(BlockState state, Level level, BlockPos pos, int type, int data, CallbackInfoReturnable<Boolean> cir, @Local float f) {
        Block block = level.getBlockState(pos.below()).getBlock();
        Holder.Reference<SoundEvent> event = NoteblockInstrumentRegistry.INSTANCE.get(block);
        if (event != null) {
            level.playSeededSound(
                    null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, event, SoundSource.RECORDS, 3.0F, f, level.random.nextLong()
            );
            cir.setReturnValue(true);
        }
    }
}
