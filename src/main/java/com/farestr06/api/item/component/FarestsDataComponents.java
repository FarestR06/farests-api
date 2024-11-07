package com.farestr06.api.item.component;

import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

import java.util.function.UnaryOperator;

import static com.farestr06.api.FarestsAPI.MOD_ID;

public class FarestsDataComponents {
    public static final ComponentType<Unit> EXPLOSION_PROOF = register(
            "explosion_proof",
            builder -> builder.codec(Unit.CODEC).packetCodec(PacketCodec.unit(Unit.INSTANCE))
    );

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(MOD_ID, id), (builderOperator.apply(ComponentType.builder())).build());
    }
}
