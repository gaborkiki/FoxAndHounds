package hu.krisz.foxandhounds.tests.serviceTests.randomhound;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.hounds.RandomHoundStep;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoundTest {
    private RandomHoundStep underTest;

    private char[][] inOneRightMap = {
            {'X', '_', 'X', 'H'},
            {'H', 'X', '_', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private char[][] expectedRightOneMap = {
            {'X', '_', 'X', '_'},
            {'H', 'X', 'H', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'}
    };
    private MapVO inOneRightMapVO = new MapVO(4, inOneRightMap);
    private MapVO expectedOneRightMapVO = new MapVO(4, expectedRightOneMap);
    private int[] oneRightFox = {2, 1};
    private int[][] inOneRightHounds = {{1, 0}, {0, 3}};
    private int[][] expectedOneRightHounds = {{1, 0}, {1, 2}};
    private GState inOneRightGameState = new GState(inOneRightMapVO, true, true, oneRightFox, inOneRightHounds);
    private GState expectedOneRightGameState = new GState(expectedOneRightMapVO, true, true, oneRightFox, expectedOneRightHounds);

    @Test
    public void testRandomHoundShouldReturnCorrectGameStateWhenHoundLeftSideButCantStepRight() {
        //given
        underTest = new RandomHoundStep(inOneRightGameState);

        //when
        GState result = underTest.randomHound();

        //then
        assertEquals(expectedOneRightGameState.getMapVO().toString(), result.getMapVO().toString());
    }
    private char[][] inOneLeftMap = {
            {'X', '_', 'X', 'H'},
            {'H', 'X', 'F', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private char[][] expectedLeftOneMap = {
            {'X', '_', 'X', 'H'},
            {'_', 'X', 'F', 'X'},
            {'X', 'H', 'X', '_'},
            {'_', 'X', '_', 'X'}
    };
    private MapVO inOneLeftMapVO = new MapVO(4, inOneLeftMap);
    private MapVO expectedOneLeftMapVO = new MapVO(4, expectedLeftOneMap);
    private int[] oneLeftFox = {1, 2};
    private int[][] inOneLeftHounds = {{1, 0}, {0, 3}};
    private int[][] expectedOneLeftHounds = {{2, 1}, {0, 3}};
    private GState inOneLeftGameState = new GState(inOneLeftMapVO, true, true, oneLeftFox, inOneLeftHounds);
    private GState expectedOneLeftGameState = new GState(expectedOneLeftMapVO, true, true, oneLeftFox, expectedOneLeftHounds);

    @Test
    public void testRandomHoundShouldReturnCorrectGameStateWhenHoundRightSideButCantStepLeft() {
        //given
        underTest = new RandomHoundStep(inOneLeftGameState);

        //when
        GState result = underTest.randomHound();

        //then
        assertEquals(expectedOneLeftGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}
