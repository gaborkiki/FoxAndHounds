package hu.krisz.foxandhounds.service.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.service.exception.ExitException;
import hu.krisz.foxandhounds.service.exception.MapBuildException;
import hu.krisz.foxandhounds.service.hounds.RandomHoundStep;

public class GameCommands {
    private String command;
    private GState gameState;
    private String[] splitCommand;

    public GameCommands(String command, GState gameState) {
        this.command = command;
        this.gameState = gameState;
    }

    public String[] splitCommand() {
        splitCommand = command.split(" ");
        return splitCommand;
    }

    public GState checkCommand() throws MapBuildException, ExitException {
        String[] splitCommand = splitCommand();
        switch (splitCommand[0]) {
            case "start":
                return gameState = new Start().start();
            case "step":
                if (splitCommand.length == 3) {
                    int[] beforeStep = gameState.getFox();
                    gameState = new Step(gameState, splitCommand[1], splitCommand[2]).step();
                    if (beforeStep[0] != gameState.getFox()[0] && beforeStep[1] != gameState.getFox()[1]) {
                        gameState = new RandomHoundStep(gameState).randomHound();
                    }
                    return gameState;
                } else {
                    System.out.println("Wrong step command");
                    return gameState;
                }
            case "exit":
                return gameState = new Exit(gameState).exitGame();
            default:
                System.out.println("Unknown command " + splitCommand[0]);
                return gameState;
        }
    }
}
