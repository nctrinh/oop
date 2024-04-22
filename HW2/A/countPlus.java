import java.util.Scanner;

public class countPlus {
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
                for(int j = 0; j < col; j++){
                    grid[i][j] = inp.charAt(j);
                }
            }

            sc.close();
        }

        //Hàm charArea
        public int countPlusFunction(){
            
            int cnt = 0;

            for(int i = 1; i < row - 1; i++){
                for(int j = 1; j < col - 1; j++){
                    char center = grid[i][j];
                    if(center != ' '){                       
                        int top = 0;
                        int bottom = 0; 
                        int left = 0; 
                        int right = 0;
                        // Kiểm tra hình chữ thập theo hướng lên
                        for (int r = i - 1; r >= 0; r--) {
                            if (grid[r][j] != center) {
                                break;
                            }
                            top++;
                        }

                        // Kiểm tra hình chữ thập theo hướng xuống
                        for (int r = i + 1; r < row; r++) {
                            if (grid[r][j] != center) {
                                break;
                            }
                            bottom++;
                        }

                        // Kiểm tra hình chữ thập theo hướng trái
                        for (int c = j - 1; c >= 0; c--) {
                            if (grid[i][c] != center) {
                                break;
                            }
                            left++;
                        }

                        // Kiểm tra hình chữ thập theo hướng phải
                        for (int c = j + 1; c < col; c++) {
                            if (grid[i][c] != center) {
                                break;
                            }
                            right++;
                        }

                        if(left != 0 && left == right && left == top && left == bottom){
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        
        countPlus tmpCountPlus = new countPlus();
        countPlus.charGrid countPlus = tmpCountPlus.new charGrid();
        countPlus.input();
        System.out.println(countPlus.countPlusFunction());

    }
}
