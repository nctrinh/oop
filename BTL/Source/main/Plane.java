package Source.main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Source.Object.Bullet;

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
    // Update position of plane
    public void update(Sound sound, KeyHandler keyH, ArrayList<Bullet> BulletPlane){
        
        if (keyH.upPressed) {
            planeY -= speed;
        }
        if (keyH.downPressed) {
            planeY += speed;
        }
        if (keyH.leftPressed) {
            planeX -= speed;
        }
        if (keyH.rightPressed) {
            planeX += speed;
        }
        if(keyH.shoot && bullet != 0){
            int x = planeX + planeWidth/2 - 6;
            int y = planeY - 10;
            Bullet tmp = new Bullet(imageBullet, x, y, -5);
            bullet -= 1;
            BulletPlane.add(tmp);  
            planeY += 10;     
            keyH.shoot = false; 
            sound.playSE(0);  
        }
        if(planeY <= 0){
            planeY = 0;
        }
        if(planeY >= panel.heightScreen - 100){
            planeY = panel.heightScreen - 100;
        }
        if(planeX <= 0){
            planeX = 0;
        }
        if(planeX >= panel.widthScreen - 80){
            planeX = panel.widthScreen - 80;
        }
    }
}
