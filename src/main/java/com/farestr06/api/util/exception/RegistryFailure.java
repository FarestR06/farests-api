package com.farestr06.api.util.exception;

import org.jetbrains.annotations.ApiStatus;

@Deprecated(forRemoval = true)
@ApiStatus.Internal
public abstract class RegistryFailure extends Error {
    public RegistryFailure(GameObject causingGameObject, Throwable causingException) {
        super("Failed to register " + causingGameObject.registryName() + " " + causingGameObject.location() + "!", causingException);
    }
}
