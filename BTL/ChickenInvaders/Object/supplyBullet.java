package ChickenInvaders.Object;

import javax.swing.ImageIcon;

public class supplyBullet extends SuperOBJ{
    public supplyBullet(int posX){
        name = "Supply Bullet";
        posY = 0;
        image = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\supplyBullet.png").getImage();
        speed = 2;
        width = 45;
        height = 45;
        this.posX = posX;
    }  
}
