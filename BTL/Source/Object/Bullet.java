package Source.Object;

import java.awt.Image;

public class Bullet extends SuperOBJ{

    public Bullet(Image image, int posX, int posY, double speed){
        name = "Bullet";
        width = 13;
        height = 45;
        this.speed = speed;  
        this.image = image;
        this.posX = posX;
        this.posY = posY;
    }

    public void update(){
        posY += speed;
    }
}
