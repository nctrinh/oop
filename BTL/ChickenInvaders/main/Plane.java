package ChickenInvaders.main;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Plane {

    Panel panel;
    public final int planeHeight = 70;
    public final int planeWidth = 80;


    public int planeX;
    public int planeY;
    public int speed;
    public int HP;
    public int bullet;

    Image imagePlane;
    Image imageBullet;
    
    //Constructor
    Plane(Panel panel){
        this.panel = panel;
        planeX = panel.widthScreen / 2;
        planeY = panel.heightScreen * 7 / 8;
        speed = 4;
        HP = 100;
        bullet = 50;
        imagePlane = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\jetplane.png").getImage();
        imageBullet = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\bulletPlane4.png").getImage();
    }

    public void draw(Graphics2D g2){
        g2.drawImage(imagePlane, planeX, planeY, planeWidth, planeHeight, null);
    }
}
