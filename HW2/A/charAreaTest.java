import static org.junit.Assert.assertEquals;

import org.junit.*;

public class charAreaTest {
    
    @Test
    public void test1(){

        charArea tmpArea = new charArea();
        charArea.charGrid area = tmpArea.new charGrid();
        area.row = 3;
        area.col = 4;

        char[][] grid1 = {
            {' ', 'b', 'a', 'd'},
            {'a', 'b', 'c', 'd'},
            {'b', 'c','d', 'a'}
        };
        area.grid = grid1;
        assertEquals(12, area.charAreaFunction('a'));

    }

}
