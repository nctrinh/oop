package Source.main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    String soundURL[] = new String[10];

    public Sound(){
        soundURL[0] = "D:\\projects\\oop\\BTL\\Sound\\laser_gun.wav";
        soundURL[1] = "D:\\projects\\oop\\BTL\\Sound\\boom.wav";
        soundURL[2] = "D:\\projects\\oop\\BTL\\Sound\\game_over.wav";
        soundURL[3] = "D:\\projects\\oop\\BTL\\Sound\\HP++.wav";
        soundURL[4] = "D:\\projects\\oop\\BTL\\Sound\\supply_bullet.wav";
        soundURL[5] = "D:\\projects\\oop\\BTL\\Sound\\HP--.wav";
        soundURL[6] = "D:\\projects\\oop\\BTL\\Sound\\background_music1.wav";
        soundURL[7] = "D:\\projects\\oop\\BTL\\Sound\\tittle1.wav";
        soundURL[8] = "D:\\projects\\oop\\BTL\\Sound\\switch.wav";
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
