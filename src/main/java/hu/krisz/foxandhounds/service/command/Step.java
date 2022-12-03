package hu.krisz.foxandhounds.service.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;

public class Step {
    private GState gameState;
    private String upToDownFox;
    private String rightToLeftFox;

    public Step(GState gameState, String upToDownFox, String rightToLeftFox) {
        this.gameState = gameState;
        this.upToDownFox = upToDownFox;
        this.rightToLeftFox = rightToLeftFox;
    }

    /**
     * Checks and perform the Step.
     */
    public GState step(){
        char[][] map = gameState.getMapVO().getMap();
        MapVO mapVO = gameState.getMapVO();
        int[] fox = new int[2];
        fox[0] = gameState.getFox()[0];
        fox[1] = gameState.getFox()[1];
        switch (upToDownFox) {
            case "up":
                switch (rightToLeftFox) {
                    case "right":
                        if (gameState.getFox()[1] < gameState.getMapVO().getMapSize() - 1 && map[fox[0] - 1][fox[1] + 1] == '_') {
                            map[fox[0]][fox[1]] = '_';
                            fox[0] -= 1;
                            fox[1] += 1;
                            map[fox[0]][fox[1]] = 'F';
                            gameState.getMapVO().setMap(map);
                            gameState.setFox(fox);
                        }
                        return gameState;
                    case "left":
                        if (gameState.getFox()[1] > 0 && map[fox[0] - 1][fox[1] - 1] == '_') {
                            map[fox[0]][fox[1]] = '_';
                            fox[0] -= 1;
                            fox[1] -= 1;
                            map[fox[0]][fox[1]] = 'F';
                            gameState.getMapVO().setMap(map);
                            gameState.setFox(fox);
                        }
                        return gameState;
                    default:
                        return gameState;
                }
            case "down":
                if (gameState.getFox()[0] < gameState.getMapVO().getMapSize() - 1) {
                    switch (rightToLeftFox) {
                        case "right":
                            if (gameState.getFox()[1] < gameState.getMapVO().getMapSize() - 1 && map[fox[0] + 1][fox[1] + 1] == '_') {
                                map[fox[0]][fox[1]] = '_';
                                fox[0] += 1;
                                fox[1] += 1;
                                map[fox[0]][fox[1]] = 'F';
                                gameState.getMapVO().setMap(map);
                                gameState.setFox(fox);
                            }
                            return gameState;
                        case "left":
                            if (gameState.getFox()[1] > 0 && map[fox[0] + 1][fox[1] - 1] == '_') {
                                map[fox[0]][fox[1]] = '_';
                                fox[0] += 1;
                                fox[1] -= 1;
                                map[fox[0]][fox[1]] = 'F';
                                gameState.getMapVO().setMap(map);
                                gameState.setFox(fox);
                            }
                            return gameState;
                        default:
                            return gameState;
                    }
                }
                break;
            default:
                break;
        }
        return gameState;
    }
}
