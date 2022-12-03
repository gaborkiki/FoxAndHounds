package hu.krisz.foxandhounds.model;


import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/**
 *Contains the Map and its Size
 */

public class MapVO {
    private final int mapSize;
    private char[][] map;
    public void setMap(char[][] map){
        this.map = map;
    }

    public MapVO(int mapSize, char[][] map) {
        this.mapSize = mapSize;
        this.map = map;
    }

    public int getMapSize() {
        return mapSize;
    }

    public char[][] getMap() {
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapVO mapVO = (MapVO) o;
        return mapSize == mapVO.mapSize && Arrays.equals(map, mapVO.map);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mapSize);
        result = 31 * result + Arrays.hashCode(map);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MapVO.class.getSimpleName() + "[", "]")
                .add("mapSize=" + mapSize)
                .add("map=" + Arrays.toString(map))
                .toString();
    }

    /**
     * Returns the Map as String
     */

    public String getMapAsString(){
        String mapString = new String();
        for (int i = 0; i < mapSize; i++){
            for (int j = 0; j < mapSize; j++){
                mapString += map[i][j] + " ";
            }
        }
        return mapString;
    }
}
