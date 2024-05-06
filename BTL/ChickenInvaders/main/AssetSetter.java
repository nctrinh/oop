package ChickenInvaders.main;

import java.util.List;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import ChickenInvaders.Object.SuperOBJ;
import ChickenInvaders.Object.repairKit;
import ChickenInvaders.Object.supplyBullet;

public class AssetSetter {

    Panel panel;
    public SuperOBJ[] OBJs ;   
    final int size = 10;
    public int index = 0;
    Timer setter;
    private List<String> string = List.of("kit", "bullet","bullet", "kit", "bullet");

    public AssetSetter(Panel panel){
        this.panel = panel;
        OBJs = new SuperOBJ[size];      
    }

    public void setObject(){
        
        setter = new Timer(15000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOBJ();
            }                
        });
        setter.start();
       
    }
    private void addOBJ() {
        Random random = new Random();
        String obj_Name = string.get(random.nextInt(string.size()));
        index = (index + 1) % 10;
        if(obj_Name == "bullet"){
            supplyBullet bullet = new supplyBullet(Math.max(0, (int) (Math.random() * panel.widthScreen) - 40));
            OBJs[index] = bullet;
        }
        if(obj_Name == "kit"){
            repairKit kit = new repairKit(Math.max(0, (int) (Math.random() * panel.widthScreen) - 40));
            OBJs[index] = kit;
        }

    }    
    public void update() {
        OBJs[0].posX += OBJs[0].speed;
    }

    public void draw(Graphics2D g2){
        SuperOBJ tmp = OBJs[0];
        g2.drawImage(tmp.image, tmp.posX, tmp.posY, tmp.width, tmp.height, null);
    }

}
