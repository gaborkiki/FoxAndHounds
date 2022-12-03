package hu.krisz.foxandhounds.tests.serviceTests.map;

import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.exception.MapBuildException;
import hu.krisz.foxandhounds.service.map.MapBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapBuilderTest {
    private MapBuilder underTest;

    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };

    private static MapVO exeptedMapVO = new MapVO(4,map);

    @Test
    public void testBuildShouldReturnNewParse() throws MapBuildException {
        //given
        underTest = new MapBuilder(4);

        //then
        MapVO result = underTest.build();

        //when
        assertEquals(exeptedMapVO, result);
    }

    @Test
    public void NumberLessThen4Test() {
        //given
        underTest = new MapBuilder(2);

        //when-then
        assertThrows(MapBuildException.class, ()->{
            underTest.build();
        });
    }

    @Test
    public void NumberMoreThan12Test() {
        //given
        underTest =new MapBuilder(14);

        //when-then
        assertThrows(MapBuildException.class, ()->{
            underTest.build();
        });
    }

    @Test
    public void EvenNumberTest() {
        //given
        underTest =new MapBuilder(7);

        //when-then
        assertThrows(MapBuildException.class, ()->{
            underTest.build();
        });
    }
}
