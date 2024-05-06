package ChickenInvaders.Object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class UFO extends SuperOBJ{

    //Get Screen size
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    //Size of screen
    public final int heightScreen = (int) screenSize.getHeight();
    public boolean defeated;
    
    public UFO(Image image){
        name = "UFO";
        posY = 0;
        width = 80;
        height = 50;
        speed = 1;
        defeated = false;
        
        this.image = image; 
    }

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
    
}
