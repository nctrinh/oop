import java.util.Scanner;

public class tetrisGrid {
    class TetrisGrid{
        int col;
        int row;
        boolean[][] grid;
        //Hàm input
        public void input(){
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
            col = sc.nextInt();
            sc.nextLine();
            grid = new boolean[row][col];
            for(int i = 0; i < row; i++){                
                for(int j = 0; j < col; j++){
                    boolean inp = sc.nextBoolean();
                    grid[i][j] = inp;
                }
            }
            sc.close();
        }
        public boolean[][] getGrid(){
            return grid;
        }
        public void clearGrid(){
            int i = row - 1;
            while(i >= 0){                
                if(grid[i][0] == true && grid[i][1] == true && grid[i][2] == true){
                    for(int j = i; j > 0; j--){
                        grid[j][0] = grid[j-1][0];
                        grid[j][1] = grid[j-1][1];
                        grid[j][2] = grid[j-1][2];
                    }
                    grid[0][0] = false;
                    grid[0][1] = false;
                    grid[0][2] = false;
                }else{
                    i--;
                }               
            }
        }        
    }
    public static void main(String[] args) {

        tetrisGrid tmpGrid = new tetrisGrid();
        tetrisGrid.TetrisGrid grid = tmpGrid.new TetrisGrid();

        grid.input();
        grid.clearGrid();
    }
}
