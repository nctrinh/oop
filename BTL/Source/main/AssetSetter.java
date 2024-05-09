package Source.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Source.Object.SuperOBJ;
import Source.Object.repairKit;
import Source.Object.supplyBullet;

public class AssetSetter {

    Sound sound;
    Panel panel;
    Plane plane;
    ArrayList<SuperOBJ> OBJs;
    Timer setter;
    List<String> string = List.of("kit", "bullet","bullet", "kit", "bullet");

    public AssetSetter(Panel panel, Sound sound){
        this.sound = sound;
        this.panel = panel;
        OBJs = new ArrayList<SuperOBJ>();   
    }

    public void setObject(){
        
        setter = new Timer(Math.min(10000, Math.max(25000, (int)(Math.random() * 10000))), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOBJ();
            }                
        });
        setter.start();
       
    }
    public void stop(){
        setter.stop();
    }
    private void addOBJ() {
        Random random = new Random();
        String obj_Name = string.get(random.nextInt(string.size()));
        if(obj_Name == "bullet"){
            supplyBullet bullet = new supplyBullet(Math.max(0, (int) (Math.random() * panel.widthScreen) - 40));
            OBJs.add(bullet);
        }
        if(obj_Name == "kit"){
            repairKit kit = new repairKit(Math.max(0, (int) (Math.random() * panel.widthScreen) - 40));
            OBJs.add(kit);
        }
    }    
    public void update1() {
        for(int i = 0; i < OBJs.size(); i++){
            SuperOBJ tmp = OBJs.get(i);
            if(tmp != null){
                tmp.posY +=  tmp.speed;
                if(!tmp.checkOutScreen(panel.heightScreen)){
                    OBJs.remove(tmp);
                }
            }else{
                OBJs.remove(tmp);
            }
        }
    }

    public void draw(Graphics2D g2){
        for(int i = 0; i < OBJs.size(); i++){
            SuperOBJ tmp = OBJs.get(i);
            if(tmp != null){
                tmp.draw(g2);
            }           
        }
    }
    public void update2(Plane plane, UI ui){
        for(int i = 0; i < OBJs.size(); i++){
            SuperOBJ tmp = OBJs.get(i);
            if(tmp == null){
                OBJs.remove(tmp);
            }else{
                if(tmp.checkCollision1(plane)){
                    OBJs.remove(tmp);
                    if(tmp.name == "Repair Kit"){
                        sound.playSE(3);
                        plane.HP = Math.min(100, plane.HP + 20);
                        ui.showMessage("You got an Repair Kit");
                    }
                    if(tmp.name == "Supply Bullet"){
                        sound.playSE(4);
                        plane.bullet = Math.min(50, plane.bullet + 20);
                        ui.showMessage("You got a Supply Bullet");
                    }
                }
            }
            
        }
    }

}
