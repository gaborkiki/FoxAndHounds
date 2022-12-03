package hu.krisz.foxandhounds.tests.serviceTests.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.command.GameCommands;
import hu.krisz.foxandhounds.service.exception.ExitException;
import hu.krisz.foxandhounds.service.exception.MapBuildException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameCommandsTest {
    private GameCommands underTest;

    private GState inputGameState = new GState(null, false, true, null, null);
    private String startCommand = "start";
    private String wrongStepCommand = "step";
    private String badStepCommand = "step up felt";
    private String goodStepCommand = "step up right";
    private String exitCommand = "exit";
    private String wrongCommand = "asd";
    private char[][] map = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'F', 'X', '_', 'X'}
    };
    private char[][] randomHoundMap = {
            {'X', '_', 'X', 'H'},
            {'_', 'X', 'H', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'}
    };
    private MapVO mapVO = new MapVO(4, map);
    private MapVO randomHoundMapVO = new MapVO(4, randomHoundMap);
    private int[] fox = {3, 0};
    private int[] randomHoundFox = {2, 1};
    private int[][] hounds = {{0, 1}, {0, 3}};
    private int[][] randomHoundHounds = {{1, 2}, {0, 3}};
    private GState expectedGameState = new GState(mapVO, true, true, fox, hounds);
    private GState randomHoundGameState = new GState(randomHoundMapVO, true, true, randomHoundFox, randomHoundHounds);


    @Test
    public void StartCommandTest() throws MapBuildException, ExitException {
        //given
        underTest = new GameCommands(startCommand, inputGameState);
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        GState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    @Test
    public void CommandNotThreeWordTest() throws MapBuildException, ExitException {
        //given
        underTest = new GameCommands(wrongStepCommand, expectedGameState);

        //when
        GState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    @Test
    public void ExitCommandTest() throws MapBuildException, ExitException {
        //given
        underTest = new GameCommands(exitCommand, expectedGameState);

        //when
        GState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.isShouldExit(), false);
    }

    @Test
    public void WrongCommandTest() throws MapBuildException, ExitException {
        //given
        underTest = new GameCommands(wrongCommand, expectedGameState);

        //when
        GState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.toString(), result.toString());
    }

    @Test
    public void StepCommandIsWrongTest() throws MapBuildException, ExitException {
        //given
        underTest = new GameCommands(badStepCommand, expectedGameState);

        //when
        GState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.toString(), result.toString());
    }
}
