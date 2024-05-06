package ChickenInvaders.main;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    String soundURL[] = new String[10];

    public Sound(){
        soundURL[0] = "D:\\projects\\oop\\BTL\\Sound\\laser_gun.wav";
        // soundURL[1] = getClass().getResource();
        // soundURL[2] = getClass().getResource();
        // soundURL[3] = getClass().getResource();
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundURL[0]).getAbsoluteFile());
            clip = AudioSystem.getClip();
            // clip.open(ais);  
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

}
