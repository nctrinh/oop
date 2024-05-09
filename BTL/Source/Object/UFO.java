package Source.Object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class UFO extends SuperOBJ{

    //Get Screen size
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    //Size of screen
    public final int heightScreen = (int) screenSize.getHeight();
    public boolean defeated;
    // Image dead1 = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion1.png").getImage();
    // Image dead2 = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion2.png").getImage();
    // Image dead3 = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion3.png").getImage();
    // Image dead4 = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion4.png").getImage();
    // Image dead5 = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion5.png").getImage();
    // Image dead6 = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion6.png").getImage();
    public Image[] deadImages = new Image[7];
     
    
    public UFO(Image image){
        name = "UFO";
        posY = 0;
        width = 80;
        height = 50;
        speed = 1;
        defeated = false;

        for(int i = 1; i <= 6; i++){
            deadImages[i] = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\explosion" + i + ".png").getImage();
        }
        
        this.image = image; 
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, posX, posY, width, height, null);       
    }

    public void drawDeadAnimation(Graphics2D g2){
        for(int i = 1; i <= 6; i++){
            g2.drawImage(deadImages[i], posX, posY, width, height, null);
        }
    }
    public boolean check(){
        if(posY > heightScreen || defeated){
            return false;
        }else{
            return true;
        }
    }
    
}
