package SINGLETON;

public class TextGraphics {

    private static TextGraphics instance;
    private char[][] buffer;
    private int width;
    private int height;

    TextGraphics(){
        init(10, 10);
    }

    public static synchronized TextGraphics getInstance(){
        if(instance == null){
            instance = new TextGraphics();
        }
        return instance;
    }

    public void init(int width, int height){
        this.width = width;
        this.height = height;
        buffer = new char[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                buffer[i][j] = ' ';
            }
        }
    }

    public void drawPoint(char c, int x, int y){
        buffer[x][y] = c;
    }

    public void drawLine(char c, int x1, int y1, int x2, int y2){
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2 - y1);
        int deltaX = x1 < x2 ? 1 : -1;
        int deltaY = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while ((true)) {

            drawPoint(c, x1, y1);
            if(x1 == x2 && y1 == y2){
                break;
            }
            int e2 = 2 * err;
            if(e2 < dy){
                e2 += dy;
                x1 += deltaX;
            }
            if(e2 < dx){
                e2 += dx;
                y1 += deltaY;
            }

        }

    }

    public void fillRectPoint(char c, int x, int y, int width, int height){
        for(int i = x; i < x + width; i++){
            for(int j = y; j < y + height; j++){
                drawPoint(c, i, j);
            }
        }
    }
    
    public void render(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                System.out.print(buffer[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1,1);
        graphics.fillRectPoint('o', 5, 5, 3, 2);
        graphics.render();

    }

}
