package Source.main.Play;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame screen = new JFrame();
        final ImageIcon iconGame = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\BackGround\\iconGame.jpg");
        //Get Screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
    

        screen.setIconImage(iconGame.getImage());
        screen.setTitle("UFO Invaders");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(screenSize);
        screen.setResizable(false);
        screen.setLocationRelativeTo(null);
        screen.setUndecorated(true);

        Panel myPanel = new Panel();
        screen.add(myPanel);
        screen.pack();
        screen.setVisible(true);
        
        myPanel.gameThreadStart();

    }
}
