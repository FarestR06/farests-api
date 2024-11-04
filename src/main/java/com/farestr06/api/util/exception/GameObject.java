package com.farestr06.api.util.exception;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

@Deprecated(forRemoval = true)
@ApiStatus.Internal
public record GameObject(String registryName, Identifier location) {
}
