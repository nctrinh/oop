import java.util.Scanner;

public class charArea {

    class charGrid{

        int col;
        int row;
        char[][] grid;
        //Hàm input
        public void input(){

            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
            col = sc.nextInt();
            sc.nextLine();

            grid = new char[row][col];

            for(int i = 0; i < row; i++){
                String inp = sc.nextLine();
                for(int j = 0; j < inp.length(); j++){
                    grid[i][j] = inp.charAt(j);
                }
            }

        }
        //Hàm charArea
        public int charAreaFunction(char ch){
            
            int minRow = 100;
            int minCol = 100;
            int maxRow = 0;
            int maxCol = 0;

            boolean found = false;

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == ch){
                        found = true;

                        minRow = Math.min(minRow, i);
                        minCol = Math.min(minCol, j);
                        maxRow = Math.max(maxRow, i);
                        maxCol = Math.max(maxCol, j);

                    }
                }
            }
            if(!found){
                return 0;
            }
            return (maxCol - minCol + 1) * (maxRow - minRow + 1);
        }
    }
    

    public static void main(String[] args) {
               
        //Nhập bảng
        charArea tmpArea = new charArea();
        charArea.charGrid area = tmpArea.new charGrid();
        area.input();
        // Nhập ký tự
        Scanner sc = new Scanner(System.in);
        char ch = sc.nextLine().charAt(0);
        //In
        System.out.println(area.charAreaFunction(ch));
        sc.close();

    }
}
