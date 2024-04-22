import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class tetrisGridTest {
    
    @SuppressWarnings("deprecation")
    @Test
    public void Test1(){

        tetrisGrid tmpGrid = new tetrisGrid();
        tetrisGrid.TetrisGrid grid = tmpGrid.new TetrisGrid();

        grid.row = 7;
        grid.col = 3;

        boolean[][] grid1 = {
            {false, false, false},
            {false, false, false},
            {true, false, false},
            {false, true, true},
            {true, true, true},
            {true, true, false},
            {true, true, true}

        };

        grid.grid = grid1;

        grid.clearGrid();

        boolean[][] grid2 = {
            {false, false, false},
            {false, false, false},
            {false, false, false},
            {false, false, false},
            {true, false, false},
            {false, true, true},
            {true, true, false},          
        };

        assertEquals(grid2, grid.getGrid());

    }

}
