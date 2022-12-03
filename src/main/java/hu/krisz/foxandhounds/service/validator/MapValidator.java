package hu.krisz.foxandhounds.service.validator;

import hu.krisz.foxandhounds.model.GState;

public class MapValidator {
    private GState gameState;
    private boolean win;
    private boolean lose;
    private int[] fox;
    private int[][] hound;
    private int size;
    private char[][] map;
    private int randomHound;
    private int randomStep;

    public MapValidator(GState gameState) {
        this.gameState = gameState;
        this.fox = gameState.getFox();
        this.hound = gameState.getHounds();
        this.size = gameState.getMapVO().getMapSize();
        this.map = gameState.getMapVO().getMap();
    }

    public MapValidator(GState gameState, int randomHound, int randomStep) {
        this.gameState = gameState;
        this.fox = gameState.getFox();
        this.hound = gameState.getHounds();
        this.size = gameState.getMapVO().getMapSize();
        this.map = gameState.getMapVO().getMap();
        this.randomHound = randomHound;
        this.randomStep = randomStep;
    }

    public boolean YouWin(){
        if (fox[0]==0){
            win = true;
        }else{
            win = false;
        }
        return win;
    }

    public boolean YouLose(){
        if(fox[0] == size-1 && fox[1] == 0){
            if (map[fox[0] - 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[0] == 0 && fox[1] == size - 1) {
            lose = false;
        } else if (fox[0] == 0) {
            lose = false;
        } else if (fox[0] == size - 1) {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] - 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[1] == 0) {
            if (map[fox[0] - 1][fox[1] + 1] == 'H' && map[fox[0] + 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[1] == size - 1) {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] + 1][fox[1] - 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] + 1][fox[1] - 1] == 'H' &&
                    map[fox[0] - 1][fox[1] + 1] == 'H' && map[fox[0] + 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        }
        return lose;
    }

    public boolean StepRightOrLeft(){
        if (hound[randomHound][0] != size - 1) {
            if (hound[randomHound][1] != 0 && hound[randomHound][1] != size - 1) {
                if (randomStep == 0) {
                    if (map[hound[randomHound][0] + 1][hound[randomHound][1] - 1] == '_') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (map[hound[randomHound][0] + 1][hound[randomHound][1] + 1] == '_') {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean HoundStep(){
        if (StepRightOrLeft()){
            return true;
        } else {
            return false;
        }
    }
}
