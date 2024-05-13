package Source.main.Sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    public Clip clip;
    String soundURL[] = new String[11];

    public Sound(){
        soundURL[0] = "D:\\projects\\oop\\BTL\\Sound_src\\laser_gun.wav";
        soundURL[1] = "D:\\projects\\oop\\BTL\\Sound_src\\boom.wav";
        soundURL[2] = "D:\\projects\\oop\\BTL\\Sound_src\\game_over.wav";
        soundURL[3] = "D:\\projects\\oop\\BTL\\Sound_src\\HP++.wav";
        soundURL[4] = "D:\\projects\\oop\\BTL\\Sound_src\\supply_bullet.wav";
        soundURL[5] = "D:\\projects\\oop\\BTL\\Sound_src\\HP--.wav";
        soundURL[6] = "D:\\projects\\oop\\BTL\\Sound_src\\background_music1.wav";
        soundURL[7] = "D:\\projects\\oop\\BTL\\Sound_src\\tittle1.wav";
        soundURL[8] = "D:\\projects\\oop\\BTL\\Sound_src\\switch.wav";
        soundURL[9] = "D:\\projects\\oop\\BTL\\Sound_src\\levelUpUFO.wav";
        soundURL[10] = "D:\\projects\\oop\\BTL\\Sound_src\\levelUpPlayer.wav";
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundURL[i]).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(ais);  
        }catch(Exception e){

        }
        
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }

    public void playMusic(int i){
        setFile(i);
        play();
        loop();
    }

    public void stopMusic(){
        stop();
    }

    public void playSE(int i){
        setFile(i);
        play();
    }

}
