package hu.krisz.foxandhounds.tests.serviceTests.validator;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.validator.MapValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapValidatorTest {
    private MapValidator underTest;
    private static final char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };

    private static final MapVO mapVO = new MapVO(4,map);
    private static final int[] winFox = {0,1};
    private static final int[] notWinFox = {1,0};
    private static final int[][] hounds = {{2, 1}, {0, 3}};
    private static final GState winGameState = new GState(mapVO, true, true, winFox, hounds);

    @Test
    public void testDidYouWinShouldGiveTrue() {
        //given
        underTest = new MapValidator(winGameState);

        //when
        boolean result = underTest.YouWin();

        //then
        assertEquals(true, result);
    }

    private static final GState notWinGameState = new GState(mapVO, true, true, notWinFox, hounds);
    @Test
    public void testDidYouWinShouldGiveFalse() {
        //given
        underTest = new MapValidator(notWinGameState);

        //when
        boolean result = underTest.YouWin();

        //then
        assertEquals(false, result);
    }

    private static final char[][] loseOneMap={
            {'X','_','X','H'},
            {'_','X','_','X'},
            {'X','H','X','_'},
            {'F','X','_','X'}
    };
    private static final MapVO loseOneMapVO = new MapVO(4,loseOneMap);
    private static final int[] loseOneFox = {3,0};
    private static final GState loseOneGameState = new GState(loseOneMapVO, true, true, loseOneFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueOne() {
        //given
        underTest = new MapValidator(loseOneGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(true, result);
    }

    private static final char[][] notLoseOneMap={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };
    private static final MapVO notLoseOneMapVO = new MapVO(4,notLoseOneMap);
    private static final GState notLoseOneGameState = new GState(notLoseOneMapVO, true, true, loseOneFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseOne() {
        //given
        underTest = new MapValidator(notLoseOneGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }

    private static final char[][] loseTwoMap={
            {'X','H','X','_'},
            {'F','X','_','X'},
            {'X','H','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO loseTwoMapVO = new MapVO(4,loseTwoMap);
    private static final int[] loseTwoFox = {1,0};
    private static final GState loseTwoGameState = new GState(loseTwoMapVO, true, true, loseTwoFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueTwo() {
        //given
        underTest = new MapValidator(loseTwoGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(true, result);
    }

    private static final char[][] notLoseTwoMap={
            {'X','_','X','H'},
            {'F','X','_','X'},
            {'X','H','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseTwoMapVO = new MapVO(4,notLoseTwoMap);
    private static final GState notLoseTwoGameState = new GState(notLoseTwoMapVO, true, true, loseTwoFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseTwo() {
        //given
        underTest = new MapValidator(notLoseTwoGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }

    private static final char[][] notLoseUpRightMap ={
            {'X','_','X','F'},
            {'_','X','H','X'},
            {'X','H','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseUpRightMapVO = new MapVO(4, notLoseUpRightMap);
    private static final int[] notLoseUpRightFox = {0,3};
    private static final GState notLoseUpRightGameState = new GState(notLoseUpRightMapVO, true, true, notLoseUpRightFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseUpRight() {
        //given
        underTest = new MapValidator(notLoseUpRightGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] notLoseUpMap={
            {'X','F','X','_'},
            {'H','X','H','X'},
            {'X','_','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseUpMapVO = new MapVO(4, notLoseUpMap);
    private static final int[] notLoseUpFox = {0,1};
    private static final GState notLoseUpGameState = new GState(notLoseUpMapVO, true, true, notLoseUpFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseUp() {
        //given
        underTest = new MapValidator(notLoseUpGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] loseThreeMap={
            {'X','_','X','_'},
            {'_','X','H','X'},
            {'X','_','X','F'},
            {'_','X','H','X'}
    };
    private static final MapVO loseThreeMapVO = new MapVO(4, loseThreeMap);
    private static final int[] loseThreeFox = {2,3};
    private static final GState loseThreeGameState = new GState(loseThreeMapVO, true, true, loseThreeFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueThree() {
        //given
        underTest = new MapValidator(loseThreeGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(true, result);
    }
    private static final char[][] notLoseThreeMap={
            {'X','H','X','_'},
            {'_','X','_','X'},
            {'X','_','X','F'},
            {'_','X','H','X'}
    };
    private static final MapVO notLoseThreeMapVO = new MapVO(4, notLoseThreeMap);
    private static final GState notLoseThreeGameState = new GState(notLoseThreeMapVO, true, true, loseThreeFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseThree() {
        //given
        underTest = new MapValidator(notLoseThreeGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] loseFourMap={
            {'X','_','X','_'},
            {'_','X','_','X'},
            {'X','H','X','H'},
            {'_','X','F','X'}
    };
    private static final MapVO loseFourMapVO = new MapVO(4, loseFourMap);
    private static final int[] loseFourFox = {3,2};
    private static final GState loseFourGameState = new GState(loseFourMapVO, true, true, loseFourFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueFour() {
        //given
        underTest = new MapValidator(loseFourGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(true, result);
    }
    private static final char[][] notLoseFourMap={
            {'X','_','X','_'},
            {'_','X','H','X'},
            {'X','_','X','H'},
            {'_','X','F','X'}
    };
    private static final MapVO notLoseFourMapVO = new MapVO(4, notLoseFourMap);
    private static final GState notLoseFourGameState = new GState(notLoseFourMapVO, true, true, loseFourFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseFour() {
        //given
        underTest = new MapValidator(notLoseFourGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] loseFiveMap={
            {'X','H','X','H'},
            {'_','X','F','X'},
            {'X','H','X','H'},
            {'_','X','_','X'}
    };
    private static final MapVO loseFiveMapVO = new MapVO(4, loseFiveMap);
    private static final int[] loseFiveFox = {1,2};
    private static final GState loseFiveGameState = new GState(loseFiveMapVO, true, true, loseFiveFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueFive() {
        //given
        underTest = new MapValidator(loseFiveGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(true, result);
    }
    private static final char[][] notLoseFiveMap={
            {'X','H','X','H'},
            {'_','X','F','X'},
            {'X','_','X','H'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseFiveMapVO = new MapVO(4, notLoseFiveMap);
    private static final GState notLoseFiveGameState = new GState(notLoseFiveMapVO, true, true, loseFiveFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseFive() {
        //given
        underTest = new MapValidator(notLoseFiveGameState);

        //when
        boolean result = underTest.YouLose();

        //then
        assertEquals(false, result);
    }
}
