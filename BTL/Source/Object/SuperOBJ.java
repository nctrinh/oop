package Source.Object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import Source.main.Player.Plane;


public class SuperOBJ {

    public String name;
    public Image image;
    public boolean collision = false;
    public int posX;
    public int posY;
    public int width;
    public int height;
    public boolean defeated = false;

    public double speed;

    //Get Screen size
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    //Size of screen
    public final int heightScreen = (int) screenSize.getHeight();

    public void draw(Graphics2D g2){
        g2.drawImage(image, posX, posY, width, height, null);
    }

    public boolean check(){
        if(posY > heightScreen || defeated){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkCollision1(Plane plane){
        return plane.planeX < posX + width &&
                plane.planeX + plane.planeWidth > posX &&
                plane.planeY < posY + height &&
                plane.planeY + plane.planeHeight > posY;
    }
    
    public boolean checkCollision2(SuperOBJ obj){
        return obj.posX < posX + width &&
                obj.posX + obj.width > posX &&
                obj.posY < posY + height &&
                obj.posY + obj.height > posY;
    }   
}
