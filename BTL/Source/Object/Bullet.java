package Source.Object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class Bullet extends SuperOBJ{

    //Get Screen size
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    //Size of screen
    public final int heightScreen = (int) screenSize.getHeight();
    
    public boolean defeated = false;

    public Bullet(Image image, int posX, int posY, int speed){
        name = "Bullet";
        width = 13;
        height = 45;
        this.speed = speed;  
        this.image = image;
        this.posX = posX;
        this.posY = posY;
    }

    public boolean check(){
        if(posY < 0 || posY > heightScreen || defeated){
            return false;
        }else{
            return true;
        }
    }

    public void draw(Graphics2D g2){

        g2.drawImage(image, posX, posY, width, height, null);

    }

    public void update(){
        posY += speed;
    }
}
