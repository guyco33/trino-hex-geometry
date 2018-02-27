/*
 * Created by Guy Cohen on 2/12/2017.

TODO:
    hex_cover(polygon, size)
 */

package com.facebook.presto.hex.geometry.functions;
import com.facebook.presto.spi.function.*;
import com.facebook.presto.spi.type.StandardTypes;
import static java.lang.Math.toIntExact;
import com.facebook.presto.spi.block.*;
import io.airlift.slice.Slice;

import static com.facebook.presto.spi.type.BigintType.BIGINT;
import static com.facebook.presto.spi.type.DoubleType.DOUBLE;

public class HexGeometryFunctions {

    private HexGeometryFunctions() {}

    @ScalarFunction("hex_code")
    @Description("Returns hex id for latitude,longitude and size")
    @SqlType(StandardTypes.BIGINT)
    @SqlNullable
    public static Long hexCode(
            @SqlType(StandardTypes.DOUBLE) double lat,
            @SqlType(StandardTypes.DOUBLE) double lon,
            @SqlType(StandardTypes.DOUBLE) double size) {
        return HexHelper.hexCode(lat, lon, size);
    }

    @ScalarFunction("hex_code")
    @Description("Returns hex id for latitude,longitude and size")
    @SqlType(StandardTypes.BIGINT)
    @SqlNullable
    public static Long hexCode(
            @SqlType(StandardTypes.DOUBLE) double lat,
            @SqlType(StandardTypes.DOUBLE) double lon) {
        return hexCode(lat, lon, 512);
    }

    @ScalarFunction("hex_neighbors")
    @Description("Returns hex codes neighbors for given hex code, layers and size")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexNeighbors(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.INTEGER) long layers,
            @SqlType(StandardTypes.DOUBLE) double size) {

        Long[] neighbors = HexHelper.hexNeighbors(hex_code, toIntExact(layers), size);
        return hexArrayBlock(neighbors);
    }

    @ScalarFunction("hex_neighbors")
    @Description("Returns hex codes neighbors for given hex code and layers in size 512")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexNeighbors(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.INTEGER) long layers) {
        return hexNeighbors(hex_code, toIntExact(layers), 512);
    }

    @ScalarFunction("hex_neighbors")
    @Description("Returns hex codes neighbors for given hex code and size in layer 1")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexNeighbors(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.DOUBLE) double size) {
        return hexNeighbors(hex_code, 1, size);
    }

    @ScalarFunction("hex_neighbors")
    @Description("Returns hex codes neighbors for given hex code in layer 1 and size 512")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexNeighbors(
            @SqlType(StandardTypes.BIGINT) long hex_code) {
        return hexNeighbors(hex_code, 1, 512);
    }

    @ScalarFunction("hex_center")
    @Description("Returns center for hex code and size")
    @SqlType("array(double)")
    @SqlNullable
    public static Block hexCenter(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.DOUBLE) double size) {
        double[] point = HexHelper.hexCenter(hex_code, size);
        return pointArrayBlock(point[0], point[1]);
    }

    @ScalarFunction("hex_center")
    @Description("Returns center for hex code at size 512")
    @SqlType("array(double)")
    @SqlNullable
    public static Block hexCenter(
            @SqlType(StandardTypes.BIGINT) long hex_code) {
        return hexCenter(hex_code, 512);
    }

    @ScalarFunction("hex_cover")
    @Description("Returns hex cover for polygon and size")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexCover(
            @SqlType(StandardTypes.VARCHAR) Slice polygon,
            @SqlType(StandardTypes.DOUBLE) double size) {
        try {
            return hexArrayBlock(HexHelper.hexCover(polygon.toStringUtf8(), size));
        } catch (Exception e) {return null;}
    }

    @ScalarFunction("hex_cover")
    @Description("Returns hex cover for polygon at size 512")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hex_cover(
            @SqlType(StandardTypes.VARCHAR) Slice polygon) {
        return hexCover(polygon, 512);
    }

    public static Block hexArrayBlock(Long[] hex_codes) {
        BlockBuilder blockBuilder = BIGINT.createBlockBuilder(null, hex_codes.length);
        for (Long c : hex_codes)
            blockBuilder.writeLong(c);
        return blockBuilder.build();
    }

    public static Block pointArrayBlock(Double lat, Double lng) {
        BlockBuilder blockBuilder = DOUBLE.createBlockBuilder(null, 2);
        blockBuilder.writeObject(lat);
        blockBuilder.writeObject(lng);
        return blockBuilder.build();
    }
}
