package com.farestr06.api.util.exception;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

@Deprecated(forRemoval = true)
@ApiStatus.Internal
public class ItemRegistryFailure extends RegistryFailure{
    public ItemRegistryFailure(Identifier location, Throwable causingException) {
        super(new GameObject("ITEM", location), causingException);
    }
}
