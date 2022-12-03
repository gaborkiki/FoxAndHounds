package hu.krisz.foxandhounds.tests.serviceTests.command;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.command.Start;
import hu.krisz.foxandhounds.service.exception.MapBuildException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartTest {
    private Start underTest;
    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };
    private static MapVO mapVO = new MapVO(4,map);
    private static int[] fox = {3,0};
    private static int[][] hounds = {{0, 1}, {0, 3}};
    private static GState expectedGameState = new GState(mapVO, true, true, fox, hounds);
    private static String input = "4";


    @Test
    public void testStartGameShouldGiveBackCorrectGameState() throws MapBuildException {
        //given
        underTest = new Start();
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        GState result = underTest.start();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}
