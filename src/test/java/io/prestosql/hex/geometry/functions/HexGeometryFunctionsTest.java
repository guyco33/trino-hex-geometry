package io.prestosql.hex.geometry.functions;

import org.testng.annotations.Test;
import static io.airlift.slice.Slices.utf8Slice;
import static org.testng.Assert.assertEquals;

public class HexGeometryFunctionsTest {

    @Test
    public void testHex_cover() {
        HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964 55.69297, 37.2419964 55.85427, 37.24343 55.85427, 37.24573 55.85651, 37.24343 55.85875, 37.24573 55.86098, 37.25033 55.86098, 37.25263 55.86322, 37.25033 55.86545, 37.25263 55.86769, 37.25723 55.86769, 37.25953 55.86992, 37.25723 55.87216, 37.25953 55.87439, 37.25723 55.87663, 37.25953 55.87886, 37.26413 55.87886, 37.26643 55.88109, 37.26413 55.88333, 37.26643 55.88556, 37.27103 55.88556, 37.27333 55.8878, 37.27103 55.89003, 37.27333 55.89226, 37.27793 55.89226, 37.28023 55.8945, 37.27793 55.89673, 37.28023 55.89896, 37.28483 55.89896, 37.28713 55.9012, 37.29173 55.9012, 37.29403 55.90343, 37.29863 55.90343, 37.30093 55.90566, 37.30552 55.90566, 37.30782 55.9079, 37.31242 55.9079, 37.31472 55.91013, 37.31932 55.91013, 37.32162 55.91236, 37.32622 55.91236, 37.32852 55.91459, 37.33312 55.91459, 37.33542 55.91683, 37.34002 55.91683, 37.34232 55.91906, 37.34692 55.91906, 37.34922 55.92129, 37.35382 55.92129, 37.35612 55.92352, 37.36072 55.92352, 37.36302 55.92575, 37.36762 55.92575, 37.36992 55.92798, 37.37452 55.92798, 37.37681 55.93022, 37.38141 55.93022, 37.38371 55.93245, 37.38831 55.93245, 37.39061 55.93468, 37.39521 55.93468, 37.39751 55.93691, 37.40211 55.93691, 37.40441 55.93914, 37.40901 55.93914, 37.41131 55.94137, 37.41591 55.94137, 37.41821 55.9436, 37.42281 55.9436, 37.42511 55.94583, 37.42971 55.94583, 37.43201 55.94806, 37.43661 55.94806, 37.43891 55.95029, 37.44351 55.95029, 37.44581 55.95252, 37.4504 55.95252, 37.4527 55.95475, 37.4573 55.95475, 37.4596 55.95698, 37.4642 55.95698, 37.4665 55.95921, 37.4711 55.95921, 37.4734 55.96144, 37.478 55.96144, 37.4803 55.96367, 37.4849 55.96367, 37.4872 55.9659, 37.4918 55.9659, 37.4941 55.96367, 37.4987 55.96367, 37.501 55.9659, 37.5056 55.9659, 37.5079 55.96367, 37.5125 55.96367, 37.5148 55.9659, 37.5194 55.9659, 37.5217 55.96367, 37.52629 55.96367, 37.52859 55.9659, 37.53319 55.9659, 37.53549 55.96367, 37.54009 55.96367, 37.54239 55.9659, 37.54699 55.9659, 37.54929 55.96367, 37.55389 55.96367, 37.55619 55.9659, 37.56079 55.9659, 37.56309 55.96367, 37.56769 55.96367, 37.56999 55.9659, 37.57459 55.9659, 37.57689 55.96367, 37.58149 55.96367, 37.58379 55.9659, 37.58839 55.9659, 37.59069 55.96367, 37.59529 55.96367, 37.59758 55.9659, 37.60218 55.9659, 37.60448 55.96367, 37.60908 55.96367, 37.61138 55.9659, 37.61598 55.9659, 37.61828 55.96367, 37.62288 55.96367, 37.62518 55.9659, 37.62978 55.9659, 37.63208 55.96367, 37.63668 55.96367, 37.63898 55.9659, 37.64358 55.9659, 37.64588 55.96367, 37.65048 55.96367, 37.65278 55.9659, 37.65738 55.9659, 37.65968 55.96367, 37.66428 55.96367, 37.66658 55.96144, 37.67117 55.96144, 37.67347 55.96367, 37.67807 55.96367, 37.68037 55.96144, 37.68497 55.96144, 37.68727 55.96367, 37.69187 55.96367, 37.69417 55.96144, 37.69877 55.96144, 37.70107 55.96367, 37.70567 55.96367, 37.70797 55.96144, 37.71257 55.96144, 37.71487 55.96367, 37.71947 55.96367, 37.72177 55.96144, 37.72637 55.96144, 37.72867 55.96367, 37.73327 55.96367, 37.73557 55.96144, 37.74017 55.96144, 37.74247 55.96367, 37.74706 55.96367, 37.74936 55.96144, 37.75396 55.96144, 37.75626 55.96367, 37.76086 55.96367, 37.76316 55.96144, 37.76776 55.96144, 37.77006 55.96367, 37.77466 55.96367, 37.77696 55.96144, 37.78156 55.96144, 37.78386 55.96367, 37.78846 55.96367, 37.79076 55.96144, 37.79536 55.96144, 37.79766 55.96367, 37.80226 55.96367, 37.80456 55.96144, 37.80916 55.96144, 37.81146 55.96367, 37.81606 55.96367, 37.81835 55.96144, 37.82295 55.96144, 37.82525 55.96367, 37.82985 55.96367, 37.83215 55.96144, 37.83675 55.96144, 37.83905 55.96367, 37.84365 55.96367, 37.84595 55.96144, 37.85055 55.96144, 37.85285 55.96367, 37.85745 55.96367, 37.85975 55.96144, 37.86435 55.96144, 37.86665 55.95921, 37.86435 55.95698, 37.86665 55.95475, 37.87125 55.95475, 37.87355 55.95252, 37.87125 55.95029, 37.87355 55.94806, 37.87815 55.94806, 37.88045 55.94583, 37.87815 55.9436, 37.88045 55.94137, 37.88505 55.94137, 37.88735 55.93914, 37.89194 55.93914, 37.89424 55.93691, 37.89194 55.93468, 37.89424 55.93245, 37.89884 55.93245, 37.90114 55.93022, 37.89884 55.92798, 37.90114 55.92575, 37.90574 55.92575, 37.90804 55.92352, 37.90574 55.92129, 37.90804 55.91906, 37.91264 55.91906, 37.91494 55.91683, 37.91264 55.91459, 37.91494 55.91236, 37.91954 55.91236, 37.92184 55.91013, 37.91954 55.9079, 37.92184 55.90566, 37.92644 55.90566, 37.92874 55.90343, 37.92644 55.9012, 37.92874 55.89896, 37.93334 55.89896, 37.93564 55.89673, 37.94024 55.89673, 37.94254 55.8945, 37.94024 55.89226, 37.94254 55.89003, 37.94714 55.89003, 37.94944 55.8878, 37.94714 55.88556, 37.94944 55.88333, 37.95404 55.88333, 37.95634 55.88109, 37.95404 55.87886, 37.95634 55.87663, 37.96094 55.87663, 37.96324 55.87439, 37.96094 55.87216, 37.96324 55.86992, 37.96094 55.86769, 37.95634 55.86769, 37.95404 55.86545, 37.94944 55.86545, 37.94714 55.86322, 37.94254 55.86322, 37.94024 55.86098, 37.93564 55.86098, 37.93334 55.85875, 37.92874 55.85875, 37.92644 55.85651, 37.92184 55.85651, 37.91954 55.85427, 37.91494 55.85427, 37.91264 55.85204, 37.90804 55.85204, 37.90574 55.8498, 37.90114 55.8498, 37.89884 55.84757, 37.89424 55.84757, 37.89194 55.84533, 37.88735 55.84533, 37.88505 55.84309, 37.88045 55.84309, 37.87815 55.84086, 37.87355 55.84086, 37.87125 55.83862, 37.86665 55.83862, 37.86435 55.83638, 37.85975 55.83638, 37.85745 55.83415, 37.85285 55.83415, 37.85055 55.83191, 37.84595 55.83191, 37.84365 55.82967, 37.83905 55.82967, 37.83675 55.83191, 37.83905 55.83415, 37.83675 55.83638, 37.83215 55.83638, 37.82985 55.83862, 37.82525 55.83862, 37.82295 55.84086, 37.81835 55.84086, 37.81606 55.84309, 37.81146 55.84309, 37.80916 55.84533, 37.81146 55.84757, 37.80916 55.8498, 37.80456 55.8498, 37.80226 55.85204, 37.79766 55.85204, 37.79536 55.85427, 37.79076 55.85427, 37.78846 55.85651, 37.78386 55.85651, 37.78156 55.85875, 37.78386 55.86098, 37.78156 55.86322, 37.77696 55.86322, 37.77466 55.86545, 37.77006 55.86545, 37.76776 55.86769, 37.76316 55.86769, 37.76086 55.86992, 37.75626 55.86992, 37.75396 55.87216, 37.75626 55.87439, 37.75396 55.87663, 37.74936 55.87663, 37.74706 55.87886, 37.74247 55.87886, 37.74017 55.88109, 37.73557 55.88109, 37.73327 55.88333, 37.72867 55.88333, 37.72637 55.88556, 37.72867 55.8878, 37.72637 55.89003, 37.72177 55.89003, 37.71947 55.89226, 37.71487 55.89226, 37.71257 55.8945, 37.70797 55.8945, 37.70567 55.89673, 37.70107 55.89673, 37.69877 55.89896, 37.69417 55.89896, 37.69187 55.9012, 37.68727 55.9012, 37.68497 55.89896, 37.68037 55.89896, 37.67807 55.9012, 37.67347 55.9012, 37.67117 55.90343, 37.66658 55.90343, 37.66428 55.90566, 37.65968 55.90566, 37.65738 55.9079, 37.65278 55.9079, 37.65048 55.90566, 37.64588 55.90566, 37.64358 55.9079, 37.63898 55.9079, 37.63668 55.91013, 37.63208 55.91013, 37.62978 55.91236, 37.62518 55.91236, 37.62288 55.91459, 37.61828 55.91459, 37.61598 55.91236, 37.61138 55.91236, 37.60908 55.91459, 37.60448 55.91459, 37.60218 55.91683, 37.59758 55.91683, 37.59529 55.91906, 37.59069 55.91906, 37.58839 55.92129, 37.58379 55.92129, 37.58149 55.92352, 37.57689 55.92352, 37.57459 55.92129, 37.56999 55.92129, 37.56769 55.91906, 37.56309 55.91906, 37.56079 55.91683, 37.55619 55.91683, 37.55389 55.91459, 37.54929 55.91459, 37.54699 55.91236, 37.54239 55.91236, 37.54009 55.91013, 37.53549 55.91013, 37.53319 55.9079, 37.52859 55.9079, 37.52629 55.90566, 37.5217 55.90566, 37.5194 55.90343, 37.5148 55.90343, 37.5125 55.9012, 37.5079 55.9012, 37.5056 55.89896, 37.501 55.89896, 37.4987 55.89673, 37.4941 55.89673, 37.4918 55.8945, 37.4872 55.8945, 37.4849 55.89673, 37.4803 55.89673, 37.478 55.8945, 37.4734 55.8945, 37.4711 55.89226, 37.4665 55.89226, 37.4642 55.89003, 37.4596 55.89003, 37.4573 55.8878, 37.4527 55.8878, 37.4504 55.88556, 37.44581 55.88556, 37.44351 55.88333, 37.43891 55.88333, 37.43661 55.88109, 37.43201 55.88109, 37.42971 55.87886, 37.42511 55.87886, 37.42281 55.87663, 37.41821 55.87663, 37.41591 55.87439, 37.41131 55.87439, 37.40901 55.87216, 37.40441 55.87216, 37.40211 55.86992, 37.39751 55.86992, 37.39521 55.86769, 37.39751 55.86545, 37.39521 55.86322, 37.39061 55.86322, 37.38831 55.86098, 37.39061 55.85875, 37.38831 55.85651, 37.39061 55.85427, 37.38831 55.85204, 37.38371 55.85204, 37.38141 55.8498, 37.38371 55.84757, 37.38141 55.84533, 37.38371 55.84309, 37.38141 55.84086, 37.37681 55.84086, 37.37452 55.83862, 37.37681 55.83638, 37.37452 55.83415, 37.37681 55.83191, 37.37452 55.82967, 37.36992 55.82967, 37.36762 55.82744, 37.36992 55.8252, 37.36762 55.82296, 37.36992 55.82072, 37.36762 55.81849, 37.36992 55.81625, 37.36762 55.81401, 37.36992 55.81177, 37.36762 55.80953, 37.36992 55.8073, 37.36762 55.80506, 37.36992 55.80282, 37.36762 55.80058, 37.36992 55.79834, 37.36762 55.7961, 37.36992 55.79386, 37.36762 55.79162, 37.36992 55.78938, 37.36762 55.78714, 37.36992 55.7849, 37.36762 55.78266, 37.36992 55.78042, 37.36762 55.77818, 37.36992 55.77594, 37.36762 55.7737, 37.36992 55.77146, 37.36762 55.76922, 37.36992 55.76698, 37.36762 55.76474, 37.36992 55.7625, 37.36762 55.76026, 37.36992 55.75802, 37.36762 55.75578, 37.36992 55.75354, 37.36762 55.75129, 37.36992 55.74905, 37.36762 55.74681, 37.36992 55.74457, 37.36762 55.74233, 37.36992 55.74008, 37.36762 55.73784, 37.36302 55.73784, 37.36072 55.7356, 37.36302 55.73336, 37.36762 55.73336, 37.36992 55.73111, 37.36762 55.72887, 37.36992 55.72663, 37.37452 55.72663, 37.37681 55.72438, 37.37452 55.72214, 37.37681 55.7199, 37.38141 55.7199, 37.38371 55.71765, 37.38141 55.71541, 37.38371 55.71317, 37.38141 55.71092, 37.38371 55.70868, 37.38831 55.70868, 37.39061 55.70643, 37.38831 55.70419, 37.39061 55.70195, 37.39521 55.70195, 37.39751 55.6997, 37.39521 55.69746, 37.39751 55.69521, 37.40211 55.69521, 37.40441 55.69297, 37.40211 55.69072, 37.40441 55.68848, 37.40901 55.68848, 37.41131 55.68623, 37.40901 55.68399, 37.41131 55.68174, 37.41591 55.68174, 37.41821 55.67949, 37.41591 55.67725, 37.41821 55.675, 37.41591 55.67276, 37.41131 55.67276, 37.40901 55.67051, 37.40441 55.67051, 37.40211 55.66826, 37.39751 55.66826, 37.39521 55.66602, 37.39061 55.66602, 37.38831 55.66377, 37.38371 55.66377, 37.38141 55.66152, 37.37681 55.66152, 37.37452 55.65928, 37.36992 55.65928, 37.36762 55.65703, 37.36302 55.65703, 37.36072 55.65478, 37.35612 55.65478, 37.35382 55.65254, 37.34922 55.65254, 37.34692 55.65029, 37.34232 55.65029, 37.34002 55.64804, 37.33542 55.64804, 37.33312 55.64579, 37.32852 55.64579, 37.32622 55.64355, 37.32162 55.64355, 37.31932 55.6413, 37.31472 55.6413, 37.31242 55.63905, 37.30782 55.63905, 37.30552 55.6368, 37.30093 55.6368, 37.29863 55.63455, 37.29403 55.63455, 37.29173 55.6323, 37.28713 55.6323, 37.28483 55.63006, 37.28023 55.63006, 37.27793 55.6323, 37.28023 55.63455, 37.27793 55.6368, 37.28023 55.63905, 37.27793 55.6413, 37.27333 55.6413, 37.27103 55.64355, 37.27333 55.64579, 37.27103 55.64804, 37.26643 55.64804, 37.26413 55.65029, 37.26643 55.65254, 37.26413 55.65478, 37.26643 55.65703, 37.26413 55.65928, 37.25953 55.65928, 37.25723 55.66152, 37.25953 55.66377, 37.25723 55.66602, 37.25953 55.66826, 37.25723 55.67051, 37.25263 55.67051, 37.25033 55.67276, 37.25263 55.675, 37.25033 55.67725, 37.25263 55.67949, 37.25033 55.68174, 37.24573 55.68174, 37.24343 55.68399, 37.24573 55.68623, 37.24343 55.68848, 37.24573 55.69072, 37.24343 55.69297, 37.2419964 55.69297))"));
        HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964 55.69297, 37.2419964 55.85427  ))"));
        HexGeometryFunctions.hex_cover(utf8Slice("POLYGON ((37.2419964 55.69297, 37.2419964 55.85427  ))"));
        HexGeometryFunctions.hex_cover(utf8Slice("polygon((37.2419964 55.69297, 37.2419964 55.85427  ))"));
        HexGeometryFunctions.hex_cover(utf8Slice("PolYgon((37.2419964 55.69297, 37.2419964 55.85427  ))"));
        HexGeometryFunctions.hex_cover(utf8Slice("POLYGON ( ( 37.2419964 55.69297 , 37.2419964 55.85427  )  )"));

        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964 55.69297 37.2419964 55.85427))")), null);
        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON (37.2419964 55.69297, 37.2419964 55.85427  )")), null);

        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("")), null);
        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON")), null);
        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON ((")), null);

        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON(( ))")), null);
        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964    ))")), null);

        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964 55.69297, 37.2419964   ))")), null);
        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964 55.69297   ))")), null);
        assertEquals(HexGeometryFunctions.hex_cover(utf8Slice("POLYGON((37.2419964    ))")), null);

    }
}