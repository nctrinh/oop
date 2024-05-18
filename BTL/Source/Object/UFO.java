package Source.Object;

import java.awt.Image;


public class UFO extends SuperOBJ{
     
    public UFO(Image image, int speed){
        name = "UFO";
        posY = 0;
        width = 80;
        height = 50;
        this.speed = speed;
        defeated = false;
        this.image = image;
    }
    
}
