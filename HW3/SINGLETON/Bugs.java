package SINGLETON;

import java.util.Random;

public class Bugs {

    private int[][] bugs;
    private char[][] board;
    private int width;
    private int height;
    private int numOfBugs;
    private char bugChar = '*';

    Bugs(int width, int height, int numOfBugs){
        this.width = width;
        this.height = height;
        this.numOfBugs = numOfBugs;
        
    }   


    public void init(){
        board = new char[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void drawPoint(int x, int y){
        board[x][y] = bugChar;
    }

    public void render(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void start(){

        Random random = new Random();
        bugs = new int[numOfBugs][2];
        board = new char[width][height];

        for(int i = 0; i < numOfBugs; i++){
            bugs[i][0] = random.nextInt(width);
            bugs[i][1] = random.nextInt(height);
        }

        while (true) {

            this.init();

            for(int i = 0; i < numOfBugs; i++){
                int x = bugs[i][0];
                int y = bugs[i][1];
                this.drawPoint(x, y);
            }

            this.render();

            for (int i = 0; i < numOfBugs; i++) {
                int direction = random.nextInt(4);

                switch (direction) {
                    case 0:
                        bugs[i][0] = (bugs[i][0] + 1) % width;
                        break;
                    case 1:
                        bugs[i][0] = (bugs[i][0] - 1 + width) % width;
                        break;
                    case 2:
                        bugs[i][1] = (bugs[i][1] + 1) % height;
                        break;
                    case 3:
                        bugs[i][1] = (bugs[i][1] - 1 + height) % height;
                        break;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    
    public static void main(String[] args) {
        Bugs bugGame = new Bugs(5, 5, 10);
        bugGame.init();
        bugGame.start();
    }

}
