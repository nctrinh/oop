package Source.main.LevelUP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Source.main.Play.Panel;

public class LevelUpUFO {
    public double speedBullet = 4;
    public int spawnTimer = 2000;
    public int speedShoot = 1500;
    public int speedUFO = 1;
    public boolean upgrade1;
    public boolean upgrade2;
    public int countUpgrade = 0;
    Timer levelUpSpeed;
    Timer levelUpSpawn;

    Panel panel;
    public LevelUpUFO(Panel panel){
        this.panel = panel;
        levelUpSpeed = new Timer(17500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speedBullet = Math.min(speedBullet + 0.5, 8);
                upgrade1 = true;
                panel.sound.playSE(9);
            }          
        });
        levelUpSpawn = new Timer(17500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnTimer = Math.max(800, spawnTimer - 200);
                speedShoot = Math.max(500, spawnTimer - 100);
                panel.UfoShoot.setDelay(speedShoot);
                panel.UfoSetter.setDelay(spawnTimer);
                panel.UfoShoot.start();
                panel.UfoSetter.start();
                upgrade2 = true;
            }           
        });
    }

    public void startLevelUp(){
        levelUpSpawn.start();
        levelUpSpeed.start();
    }

    public void stopLevelUp(){
        levelUpSpawn.stop();
        levelUpSpeed.stop();
    }

    public void restartLevelUp(){
        speedBullet = 4;
        spawnTimer = 2000;
        speedShoot = 1500;
        levelUpSpawn.stop();
        levelUpSpeed.stop();
    }

    public boolean getUpgrade(){
        return upgrade1 && upgrade2;
    }
    public void setDefault(){
        upgrade1 = false;
        upgrade2 = false;
    }
    
}
