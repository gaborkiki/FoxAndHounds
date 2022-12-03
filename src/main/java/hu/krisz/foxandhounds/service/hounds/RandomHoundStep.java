package hu.krisz.foxandhounds.service.hounds;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.service.validator.MapValidator;

import java.util.Random;

public class RandomHoundStep {
    private GState gameState;
    private int randomHound;
    private int randomStep;
    private int max;
    private int size;

    public RandomHoundStep(GState gameState) {
        this.gameState = gameState;
        this.randomHound = randomHound;
        this.randomStep = randomStep;
        this.max = max;
        this.size = size;
    }

    public GState randomHound(){
        int size = gameState.getMapVO().getMapSize();
        int[][] hound = gameState.getHounds();
        char [][] map = gameState.getMapVO().getMap();
        randomNumber();

        if (max < 30) {
            switch (randomStep) {
                case 0:
                    map[hound[randomHound][0]][hound[randomHound][1]] = '_';
                    hound[randomHound][0] += 1;
                    hound[randomHound][1] -= 1;
                    map[hound[randomHound][0]][hound[randomHound][1]] = 'H';
                    gameState.getMapVO().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                case 1:
                    map[hound[randomHound][0]][hound[randomHound][1]] = '_';
                    hound[randomHound][0] += 1;
                    hound[randomHound][1] += 1;
                    map[hound[randomHound][0]][hound[randomHound][1]] = 'H';
                    gameState.getMapVO().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                default:
                    return gameState;
            }
        } else {
            return gameState;
        }
    }

    private void randomNumber() {
        Random random =new Random();
        max = 0;
        do {
            randomHound = random.nextInt(size/2);
            randomStep = random.nextInt(2);
            max++;
        }while(!new MapValidator(gameState,randomHound,randomStep).HoundStep() && max<30);
        if (max == 30) System.out.println("The hounds cant step.");
    }
}
