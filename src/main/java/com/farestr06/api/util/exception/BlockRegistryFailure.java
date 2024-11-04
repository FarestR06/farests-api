package com.farestr06.api.util.exception;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

@Deprecated(forRemoval = true)
@ApiStatus.Internal
public class BlockRegistryFailure extends RegistryFailure{
    public BlockRegistryFailure(Identifier location, Throwable causingException) {
        super(new GameObject("BLOCK", location), causingException);
    }
}
