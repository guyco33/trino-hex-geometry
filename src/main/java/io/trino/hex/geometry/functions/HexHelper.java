package io.trino.hex.geometry.functions;

import com.gojuno.hexgrid.*;
import com.gojuno.hexgridgeo.*;
import java.util.regex.Pattern;

public class HexHelper
{
    public static Long hexCode(double lat, double lng, double size)
    {
        if (size<0) return null;
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, size, ProjectionSM.INSTANCE);
        Hex hex = grid.hexAt(new PointGeo(lng, lat));
        return grid.hexToCode(hex);
    }

    public static Long[] hexNeighbors(long hex_code, int layers, double size)
    {
        if (size<0 || layers<1) return null;
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, size, ProjectionSM.INSTANCE);
        Hex restoredHex = grid.hexFromCode(hex_code);
        Hex[] neighbors = grid.hexNeighbors(restoredHex, layers);
        Long[] n_codes = new Long[neighbors.length];
        for (int i=0; i<neighbors.length; i++)
            n_codes[i] = grid.hexToCode(neighbors[i]);
        return n_codes;
    }


    public static double[] hexCenter(long hex_code, double size)
    {
        if (size<0) return null;
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, size, ProjectionSM.INSTANCE);
        PointGeo pointGeo = grid.hexCenter(grid.hexFromCode(hex_code));
        return new double[]{pointGeo.getLat(), pointGeo.getLon()};
    }

    public static Long[] hexQR(long hex_code, double size)
    {
        if (size<0) return null;
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, size, ProjectionSM.INSTANCE);
        Hex hex = grid.hexFromCode(hex_code);
        return new Long[]{hex.getQ(), hex.getR()};
    }

    public static Long[] hexCover(String polygon, double size)
    {
        if (size<0) return null;
        PointGeo[] points = pointsFromPolygon(polygon);
        if (points == null || points.length < 2) return null;
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, size, ProjectionSM.INSTANCE);
        Region region = grid.createRegion(points);
        Hex[] hexes = region.getHexes();
        Long[] codes = new Long[hexes.length];
        for (int i=0; i<codes.length; i++)
            codes[i] = grid.hexToCode(hexes[i]);
        return codes;
    }

    public static PointGeo[] pointsFromPolygon(String polygon)
    {
        String start_pattern = "^(\\s)*[Pp][Oo][Ll][Yy][Gg][Oo][Nn](\\s)*[(](\\s)*[(]";
        String end_pattern = "[)](\\s)*[)](\\s)*$";

        try {
            if (!Pattern.matches(start_pattern + "[0-9.,\\-\\s\\t]+" + end_pattern, polygon)) {
                return null;
            }
            PointGeo[] points = null;
            String[] items = polygon.replaceAll(start_pattern, "").replaceAll(end_pattern, "").split(",");
            points = new PointGeo[items.length];
            for (int i = 0; i < points.length; i++) {
                String[] nums = items[i].trim().split("(\\s)+");
                points[i] = new PointGeo(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            }
            return points;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static PointGeo[] hexCorners(long hex_code, double size)
    {
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, size, ProjectionSM.INSTANCE);
        PointGeo[] corners = grid.hexCorners(grid.hexFromCode(hex_code));
        return corners;
    }

    public static String hexCornersAsWkt(long hex_code, double size)
    {
        PointGeo[] corners = hexCorners(hex_code, size);
        StringBuffer wktPolygon = new StringBuffer("POLYGON ((");
        for (int i=0; i<corners.length; i++) {
            wktPolygon.append(corners[i].getLon()+" "+corners[i].getLat()+",");
        }
        wktPolygon.append(corners[0].getLon()+" "+corners[0].getLat()+"))");
        return wktPolygon.toString();
    }

    public static String hexCornersAsStr(long hex_code, double size)
    {
        PointGeo[] corners = hexCorners(hex_code, size);
        StringBuffer wktPolygon = new StringBuffer("[");
        for (int i=0; i<corners.length; i++) {
            wktPolygon.append("["+corners[i].getLon()+","+corners[i].getLat()+"],");
        }
        wktPolygon.append("["+corners[0].getLon()+","+corners[0].getLat()+"]]");
        return wktPolygon.toString();
    }
}
