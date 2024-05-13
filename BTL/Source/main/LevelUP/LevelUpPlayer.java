package Source.main.LevelUP;

import Source.main.Play.Panel;


public class LevelUpPlayer {
    public double speedBullet = -4;
    Panel panel;
    public int countUpgrade = 0;
    public final int scoreForUpgrade = 100;
    public int score;
    public LevelUpPlayer(Panel panel){
        this.panel = panel;
        if(getUpgrade()){
            panel.sound.playSE(10);
        }
    }

    public void restartLevelUp(){
        speedBullet = -4;
        score = 0;
    }

    public boolean getUpgrade(){
        return score == scoreForUpgrade;
    }
}
