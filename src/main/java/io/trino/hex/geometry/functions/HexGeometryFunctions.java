/*
 * Created by Guy Cohen on 2/12/2017.

TODO:
    hex_cover(polygon, size)
 */

package io.trino.hex.geometry.functions;
import io.trino.spi.function.*;
import io.trino.spi.type.ArrayType;
import io.trino.spi.type.StandardTypes;

import static io.airlift.slice.Slices.utf8Slice;
import static java.lang.Math.toIntExact;
import io.trino.spi.block.*;
import io.airlift.slice.Slice;
import com.gojuno.hexgridgeo.PointGeo;

import static io.trino.spi.type.BigintType.BIGINT;
import static io.trino.spi.type.DoubleType.DOUBLE;

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
        return longArrayBlock(neighbors);
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

    @ScalarFunction("hex_qr")
    @Description("Returns q,r for hex code and size")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexQR(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.DOUBLE) double size) {
        return longArrayBlock(HexHelper.hexQR(hex_code, size));
    }

    @ScalarFunction("hex_qr")
    @Description("Returns q,r for hex code at size 512")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexQR(
            @SqlType(StandardTypes.BIGINT) long hex_code) {
        return hexQR(hex_code, 512);
    }

    @ScalarFunction("hex_cover")
    @Description("Returns hex cover for polygon and size")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hexCover(
            @SqlType(StandardTypes.VARCHAR) Slice polygon,
            @SqlType(StandardTypes.DOUBLE) double size) {
        Long[] codes = HexHelper.hexCover(polygon.toStringUtf8(), size);
        if (codes == null) return null;
        return longArrayBlock(codes);
    }

    @ScalarFunction("hex_cover")
    @Description("Returns hex cover for polygon at size 512")
    @SqlType("array(bigint)")
    @SqlNullable
    public static Block hex_cover(
            @SqlType(StandardTypes.VARCHAR) Slice polygon) {
        return hexCover(polygon, 512);
    }

    @ScalarFunction("hex_corners")
    @Description("Returns array(double) of corner points at size 512: {{lon0,lat0},{lon1,lat1}....,{lon0,lat0}}")
    @SqlType("array(array(double))")
    @SqlNullable
    public static Block hex_corners(
            @SqlType(StandardTypes.BIGINT) long hex_code)
    {
        return hex_corners(hex_code, 512);
    }

    @ScalarFunction("hex_corners")
    @Description("Returns array(double) of corner points: {{lon0,lat0},{lon1,lat1}....,{lon0,lat0}}")
    @SqlType("array(array(double))")
    @SqlNullable
    public static Block hex_corners(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.DOUBLE) double size)
    {
        PointGeo[] corners = HexHelper.hexCorners(hex_code, size);
        if (corners.length == 0)
            return null;
        ArrayType arrayType = new ArrayType(DOUBLE);
        BlockBuilder builder = arrayType.createBlockBuilder(null, corners.length+1);
        for (int i=0; i<corners.length; i++) {
            arrayType.writeObject(builder, pointArrayBlock(corners[i].getLon(), corners[i].getLat()));
        }
        arrayType.writeObject(builder, pointArrayBlock(corners[0].getLon(), corners[0].getLat()));
        return builder.build();
    }

    @ScalarFunction("hex_corners")
    @Description("Returns corner points at size 512 in formatted string (eg: wkt, str)")
    @SqlType(StandardTypes.VARCHAR)
    @SqlNullable
    public static Slice hex_corners(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.VARCHAR) Slice format)
    {
        if (format.toStringUtf8().toLowerCase().equals("wkt"))
            return utf8Slice(HexHelper.hexCornersAsWkt(hex_code, 512));
        else if (format.toStringUtf8().toLowerCase().equals("str"))
            return utf8Slice(HexHelper.hexCornersAsStr(hex_code, 512));
        else
            return null;
    }

    @ScalarFunction("hex_corners")
    @Description("Returns corner points in formatted string (eg: wkt, str)")
    @SqlType(StandardTypes.VARCHAR)
    @SqlNullable
    public static Slice hex_corners(
            @SqlType(StandardTypes.BIGINT) long hex_code,
            @SqlType(StandardTypes.DOUBLE) double size,
            @SqlType(StandardTypes.VARCHAR) Slice format)
    {
        if (format.toStringUtf8().toLowerCase().equals("wkt"))
            return utf8Slice(HexHelper.hexCornersAsWkt(hex_code, size));
        else if (format.toStringUtf8().toLowerCase().equals("str"))
            return utf8Slice(HexHelper.hexCornersAsStr(hex_code, size));
        else
            return null;
    }

    public static Block longArrayBlock(Long[] longs) {
        BlockBuilder blockBuilder = BIGINT.createBlockBuilder(null, longs.length);
        for (Long c : longs)
            blockBuilder.writeLong(c);
        return blockBuilder.build();
    }

    public static Block pointArrayBlock(Double x, Double y) {
        BlockBuilder blockBuilder = DOUBLE.createBlockBuilder(null, 2);
        DOUBLE.writeDouble(blockBuilder,x);
        DOUBLE.writeDouble(blockBuilder,y);
        return blockBuilder.build();
    }
}
