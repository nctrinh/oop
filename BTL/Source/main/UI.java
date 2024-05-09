package Source.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class UI {
    
    Panel panel;
    Font arial_40;
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
    int widthScreen;
    int heightScreen;
    public boolean messageOn = false;
    public String message = "";
    public int cmd = 0;
    public int cmd_ofPause = 0;
    private int messageCountTime = 0;

    UI(Panel panel, Plane plane){

        this.plane = plane;
        this.panel = panel;
        widthScreen = panel.widthScreen;
        heightScreen = panel.heightScreen;
        
        // Set font
        arial_40 = new Font("Arial", Font.BOLD, 28);
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
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawImage(score, widthScreen * 83/100, heightScreen / 35, 225, 115, null);
        g2.drawString(Integer.toString(panel.score), widthScreen * 9/10 - Integer.toString(panel.score).length() * 6, heightScreen / 8);
        
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
    }

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

}
