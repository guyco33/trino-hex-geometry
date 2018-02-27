package com.facebook.presto.hex.geometry.functions;

import com.facebook.presto.spi.Plugin;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class HexGeometryFunctionsPlugin
    implements Plugin
{
    @Override
    public Set<Class<?>> getFunctions()
    {
        return ImmutableSet.<Class<?>>builder()
                .add(HexGeometryFunctions.class)
                .build();
    }
}
