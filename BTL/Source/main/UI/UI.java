package Source.main.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import Source.main.Play.Panel;
import Source.main.Player.Plane;

public class UI {
    
    Panel panel;
    Font arial_40;
    Font arial_28;
    Font arial_bold_10;
    Font arial_plain_18;
    Font ofCMD;
    BufferedImage bulletImage;
    Plane plane;
    Image avatar = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\avt.png").getImage();
    Image status = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\status.png").getImage();
    Image score = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\score.png").getImage();
    Image tittleImage = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\tittle_background.png").getImage();
    Image pauseImage = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\pauseTittle.png").getImage();
    Image dieImage = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\dieState.png").getImage();
    Image UFO_levelUp = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\UFO_levelUp.png").getImage();
    Image Player_levelUP = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\levelUP_Player.png").getImage();
    int widthScreen;
    int heightScreen;
    public boolean messageOn = false;
    public String message = "";
    public int cmd = 0;
    public int cmd_ofPause = 0;
    private int messageCountTime = 0;
    private int messageCountTime1 = 0;

    public UI(Panel panel, Plane plane){

        this.plane = plane;
        this.panel = panel;
        widthScreen = panel.widthScreen;
        heightScreen = panel.heightScreen;
        
        // Set font
        arial_28 = new Font("Arial", Font.BOLD, 28);
        arial_40 = new Font("Arial", Font.BOLD, 40);
        arial_bold_10 = new Font("Arial", Font.BOLD, 10);
        arial_plain_18 = new Font("Arial", Font.PLAIN, 18);
        ofCMD = new Font("Arial", Font.BOLD, 40);
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        if(panel.gameState == panel.playState){
            drawPlayState(g2);
        }
        if(panel.gameState == panel.titleState){
            drawTittleState(g2);
        }
        if(panel.gameState == panel.pauseState){
            drawPlayState(g2);
            drawPauseState(g2);
        }
        if(panel.gameState == panel.dieState){
            drawDieState(g2);
        }

    }

    public void drawPlayState(Graphics2D g2){
        // Draw status
        g2.drawImage(status, widthScreen / 11 , heightScreen / 14, widthScreen * 2/13, heightScreen / 12, null);       
        g2.setColor(new Color(255, 106, 106));
        g2.fillRect(widthScreen * 98/1000, heightScreen *  98 / 1100, plane.HP * 193 /100, 12);
        g2.setColor(new Color(144, 238, 144));
        g2.fillRect(widthScreen * 98/1000, heightScreen * 133/1100, plane.bullet * 193 /50, 12);
        g2.setFont(arial_bold_10);
        g2.setColor(Color.black);
        g2.drawString(Integer.toString(plane.HP) + "/100", widthScreen * 105/ 700, heightScreen / 10);
        g2.drawString(Integer.toString(plane.bullet) + "/50", widthScreen * 108/ 700, heightScreen * 133/1000);
        g2.drawImage(avatar, widthScreen / 26, heightScreen / 19, 100, 100, null);

        // Draw score
        g2.setFont(arial_28);
        g2.setColor(Color.white);
        g2.drawImage(score, widthScreen * 83/100, heightScreen / 35, 225, 115, null);
        g2.drawString(Integer.toString(panel.score), widthScreen * 9/10 - Integer.toString(panel.score).length() * 6, heightScreen / 8);
        
        // Draw when plane get HP, bullet
        if(messageOn){
            g2.setColor(Color.white);
            g2.setFont(arial_plain_18);
            g2.drawString(message, widthScreen * 9/ 90 , heightScreen * 9/ 50);

            messageCountTime++;
            if(messageCountTime > 100){
                messageCountTime = 0;
                messageOn = false;
            }
        }
        // Draw when UFO upgrade
        if(panel.levelUp_UFO.getUpgrade()){
            if(panel.levelUp_UFO.countUpgrade <= 8){
                g2.drawImage(UFO_levelUp, widthScreen * 405/1000, heightScreen / 35, widthScreen * 2/10, heightScreen * 9/100, null);
                messageCountTime++;
                if(messageCountTime > 150){
                    messageCountTime = 0;
                    panel.levelUp_UFO.setDefault();
                    panel.levelUp_UFO.countUpgrade++;
                }               
            }
        }
        //Draw when Player upgrade
        if(panel.plane.levelUp_Player.getUpgrade()){
            if(panel.plane.levelUp_Player.countUpgrade < 8){
                if(messageCountTime1 == 0){
                    panel.sound.playSE(10);
                    panel.plane.levelUp_Player.speedBullet = Math.max(panel.plane.levelUp_Player.speedBullet - 0.5, -8);
                }
                g2.drawImage(Player_levelUP, widthScreen * 123/1000, heightScreen * 1/ 100, widthScreen * 8/100, heightScreen * 8/100, null);
                messageCountTime1++;
                if(messageCountTime1 > 150){
                    messageCountTime1 = 0;
                    panel.plane.levelUp_Player.score = 0;
                    panel.plane.levelUp_Player.countUpgrade++;
                }
            }
        }
    }
    // Draw titleState
    public void drawTittleState(Graphics2D g2){
        g2.drawImage(tittleImage, 0, 0, widthScreen, heightScreen,  null);
        if(cmd == 0){
            g2.setColor(Color.white);
            g2.setFont(ofCMD);
            g2.drawString(">", widthScreen * 41 / 100, heightScreen * 69 / 100);
        }else if(cmd == 1){
            g2.setColor(Color.white);
            g2.setFont(ofCMD);
            g2.drawString(">", widthScreen * 42 / 100, heightScreen * 76 / 100);
        }     
    }
    // Draw pauseState
    public void drawPauseState(Graphics2D g2){
        g2.drawImage(pauseImage, widthScreen * 38/100, heightScreen * 2/10, widthScreen/4, heightScreen * 6/10, null);
        if(cmd_ofPause == 0){
            g2.setColor(Color.white);
            g2.setFont(ofCMD);
            g2.drawString(">", widthScreen * 42 / 100, heightScreen * 565 / 1000);
        }else if(cmd_ofPause == 1){
            g2.setColor(Color.white);
            g2.setFont(ofCMD);
            g2.drawString(">", widthScreen * 445 / 1000, heightScreen * 645 / 1000);
        }   
    }
    // Draw dieState
    public void drawDieState(Graphics2D g2){
        g2.drawImage(dieImage, widthScreen * 38/100, heightScreen * 2/10, widthScreen/4, heightScreen * 6/10, null);
        g2.setColor(Color.white);
        g2.setFont(arial_40);
        g2.drawString(Integer.toString(panel.score), widthScreen * 5/10 - Integer.toString(panel.score).length() * 10, heightScreen / 2);
        if(cmd == 0){
            g2.setColor(Color.white);
            g2.setFont(ofCMD);
            g2.drawString(">", widthScreen * 42 / 100, heightScreen * 62 / 100);
        }else if(cmd == 1){
            g2.setColor(Color.white);
            g2.setFont(ofCMD);
            g2.drawString(">", widthScreen * 45 / 100, heightScreen * 70 / 100);
        }   
    }

}
