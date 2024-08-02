package com.farestr06.api.util.exception;

import net.minecraft.util.Identifier;

public record GameObject(String registryName, Identifier location) {
}
