package hu.krisz.foxandhounds.service.map;

import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.exception.MapBuildException;

public class MapBuilder {
    private final int mapSize;

    public MapBuilder(int mapSize) {
        this.mapSize = mapSize;
    }

    public MapVO build() throws MapBuildException {
        checkSize(mapSize);
        char[][] map = getMap();
        return new MapVO(mapSize, map);
    }

    public void checkSize(int mapSize) throws MapBuildException {
        if (mapSize < 4) {
            throw new MapBuildException("The map size is too low.");
        }
        if (mapSize > 12) {
            throw new MapBuildException("The map size is too high");
        }
        if (mapSize % 2 != 0) {
            throw new MapBuildException("The map size has to be even");
        }
    }

    public char[][] getMap() {
        char[][] map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            if (i == 0) {
                for (int j = 0; j < mapSize; j++) {
                    if (j % 2 != 0) {
                        map[i][j] = 'H';
                    } else {
                        map[i][j] = 'X';
                    }
                }
            } else {
                for (int j = 0; j < mapSize; j++) {
                    if (i % 2 != 0) {
                        if (j % 2 == 0) {
                            map[i][j] = '_';
                        } else {
                            map[i][j] = 'X';
                        }
                    } else {
                        if (j % 2 != 0) {
                            map[i][j] = '_';
                        } else {
                            map[i][j] = 'X';
                        }
                    }
                }
            }
        }
        map[mapSize -1][0] = 'F';
        return map;
    }
}
