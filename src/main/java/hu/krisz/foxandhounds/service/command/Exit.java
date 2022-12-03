package hu.krisz.foxandhounds.service.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.service.exception.ExitException;

public class Exit extends Throwable {
    private GState gameState;

    public Exit(GState gameState) {
        this.gameState = gameState;
    }

    public GState exitGame() throws ExitException {
        if (gameState.isMapExist()){
            gameState.setShouldExit(false);
            return gameState;
        }else{
            throw new ExitException("Exiting");
        }
    }
}
