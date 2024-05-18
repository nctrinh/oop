package Source.Object;

import javax.swing.ImageIcon;

public class repairKit extends SuperOBJ{
    public repairKit(int posX){
        name = "Repair Kit";
        posY = 0;
        this.posX = posX;
        speed = 2;
        width = 45; 
        height = 45;
        image = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\Objects\\repairKit.png").getImage();
    }
}
