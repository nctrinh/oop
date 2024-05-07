package ChickenInvaders.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class UI {
    
    Panel panel;
    Font arial__40;
    Font arial_bold_10;
    BufferedImage bulletImage;
    Plane plane;
    Image avatar = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\avt.png").getImage();
    Image status = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\status.png").getImage();
    Image score = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\score.png").getImage();

    int widthScreen;
    int heightScreen;
    String Hp;
    String Bullet;
    String Score;

    UI(Panel panel, Plane plane){
        this.plane = plane;
        this.panel = panel;
        widthScreen = panel.widthScreen;
        heightScreen = panel.heightScreen;
        Hp = Integer.toString(plane.HP);
        Bullet = Integer.toString(plane.bullet);
        Score = Integer.toString(panel.score);
        arial__40 = new Font("Arial", Font.BOLD, 28);
        arial_bold_10 = new Font("Arial", Font.BOLD, 10);
    }

    public void draw(Graphics g2){

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
        g2.setFont(arial__40);
        g2.setColor(Color.white);
        g2.drawImage(score, widthScreen * 83/100, heightScreen / 35, 225, 115, null);
        g2.drawString(Integer.toString(panel.score), widthScreen * 9/10 - Integer.toString(panel.score).length() * 6, heightScreen / 8);
    }

}
