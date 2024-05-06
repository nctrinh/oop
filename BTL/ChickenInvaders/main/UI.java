package ChickenInvaders.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UI {
    
    Panel panel;
    Font arial__40;
    BufferedImage bulletImage;

    UI(Panel panel){
        this.panel = panel;
        arial__40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw(Graphics g2){
        g2.setFont(arial__40);
        g2.setColor(Color.WHITE);
        g2.drawString("Bullet = " + panel.plane.bullet, 50, 50);

        g2.setFont(arial__40);
        g2.setColor(Color.WHITE);
        g2.drawString("HP = " + panel.plane.HP, 50, 100);

    }

}
