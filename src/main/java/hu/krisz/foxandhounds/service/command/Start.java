package hu.krisz.foxandhounds.service.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.exception.MapBuildException;
import hu.krisz.foxandhounds.service.map.MapBuilder;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Start {

    /**
     *Create the GameState and generate the Map
     */
    public GState start() throws MapBuildException{
        int size;
        size = 0;
        GState startMap;
        startMap = new GState(null, true, false,null, null);
        MapVO createdMap;
        createdMap = null;
        int[] fox;
        fox = new int[2];
        int[][] hounds;
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        size = Integer.parseInt(input.nextLine());
        hounds = new int[size / 2][2];
        for (int i = 1; i < size; i += 2) {
            hounds[i / 2][0] = 0;
            hounds[i / 2][1] = i;
        }
        fox[0] = size - 1;
        fox[1] = 0;
        createdMap = new MapBuilder(size).build();
        startMap.setFox(fox);
        startMap.setHounds(hounds);
        startMap.setMapVO(createdMap);
        return startMap;
    }
}
