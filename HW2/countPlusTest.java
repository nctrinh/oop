import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class countPlusTest {
    
    @Test
    public void Test1(){
        countPlus tmpCountPlus = new countPlus();
        countPlus.charGrid countPlus = tmpCountPlus.new charGrid();
        countPlus.row = 7;
        countPlus.col = 9;

        char[][] grid1 = {
            {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
            {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
            {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
            {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
            {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
            {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
        };
        countPlus.grid = grid1;
        assertEquals(2, countPlus.countPlusFunction());
    }

}
