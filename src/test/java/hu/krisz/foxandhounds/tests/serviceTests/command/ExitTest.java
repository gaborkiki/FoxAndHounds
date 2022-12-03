package hu.krisz.foxandhounds.tests.serviceTests.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.command.Exit;
import hu.krisz.foxandhounds.service.exception.ExitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExitTest {
    private Exit underTest;

    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };
    private static MapVO mapVO = new MapVO(4, map);
    private static int[] fox = {3,0};
    private static int[][] hounds = {{0, 1}, {0, 3}};
    private static GState inputGameState = new GState(mapVO, true, true, fox, hounds);
    private static GState inputTwoGameState = new GState(mapVO, false, true, fox, hounds);
    private static GState expectedGameState = new GState(mapVO, true, false, fox, hounds);

    @Test
    public void ExitTest() throws ExitException {
        //given
        underTest = new Exit(inputGameState);

        //when
        GState result = underTest.exitGame();

        //then
        assertEquals(expectedGameState.isShouldExit(), result.isShouldExit());
    }

    @Test
    public void MapNotExistTest() {
        //given
        underTest = new Exit(inputTwoGameState);

        //when - then
        assertThrows(ExitException.class, ()->{
            underTest.exitGame();
        });
    }
}
