# presto-hex-geometry
Presto functions for geospatial hexagons

Copy jars to presto plugin folder and enjoy some useful gojuno hexgrid functions

Examples:

select hex_code(32.4,28.5, 512.0);
<BR>
25202343

select hex_neighbors(25202343,512.0);
<BR>
{25202342,25202348,25202341,25202349,25202352,25202354}

