package ChickenInvaders.main;

import javax.swing.*;

import ChickenInvaders.Object.Bullet;
import ChickenInvaders.Object.SuperOBJ;
import ChickenInvaders.Object.UFO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Panel extends JPanel implements Runnable{
    //Get Screen size
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();

    //Size of screen
    public final int widthScreen = (int) screenSize.getWidth();
    public final int heightScreen = (int) screenSize.getHeight();
   
    //FPS and Score
    final int FPS = 80;
    int score = 0;

    //UI
    public UI ui;

    //gameOver
    public boolean gameOver = false;

    //Image
    Image backgroundImage;
    Image bulletPlaneImage;

    //Sound
    Sound sound = new Sound();
    
    //Key Handler
    KeyHandler keyH;

    //Plane
    public Plane plane;

    //Game Thread
    Thread gameThread;
    Timer UfoSetter;
    Timer UfoShoot;
    AssetSetter setter;

    //Object
    ArrayList<UFO> UFOs;
    ArrayList<Bullet> BulletUfo;
    ArrayList<Bullet> BulletPlane;
    ArrayList<SuperOBJ> OBJs;
    List<String> string = List.of("kit", "bullet","bullet", "kit", "bullet");


    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialougeState = 3;

    //Panel constructor
    Panel(){

        this.setPreferredSize(screenSize);
        this.setFocusable(true);
        this.setBackground(Color.black);

        keyH = new KeyHandler();
        this.addKeyListener(keyH);

        plane = new Plane(this);
        ui = new UI(this, plane);

        UFOs = new ArrayList<UFO>();
        BulletUfo = new ArrayList<Bullet>();
        BulletPlane = new ArrayList<Bullet>();
        setter = new AssetSetter(this, sound);
        
        //Images
        backgroundImage = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\backGround.jpg").getImage();
        bulletPlaneImage = new ImageIcon("D:\\projects\\oop\\BTL\\Images\\bulletPlane4.png").getImage();

    }

    // Start function
    public void gameThreadStart(){

        UfoSetter = new Timer(Math.min(1500, Math.max(4000, (int)(Math.random() * 5000))), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UFO_Setter();
            }     
        });

        UfoShoot = new Timer(Math.min(1000, Math.max(2500, (int)(Math.random() * 1000))), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UFO_Shoot();
            }     
        });

        setter.setObject();

        UfoShoot.start();
        UfoSetter.start();
        gameThread = new Thread(this);
        gameThread.start();
    }
    // UFO Setter
    public void UFO_Setter(){

        String UFO_file = "D:\\projects\\oop\\BTL\\Images\\UFO"+ (int)(Math.random() * 7) + ".png";
        Image UFO_image = new ImageIcon(UFO_file).getImage();
        UFO tmp = new UFO(UFO_image);
        tmp.posX = Math.max(0, (int) (Math.random() * widthScreen) - tmp.width);
        UFOs.add(tmp);

    }
    // Add bullet to List of Bullet_UFO
    public void UFO_Shoot(){       
        if(UFOs.size() > 0){
            int i = (int)(Math.random() * UFOs.size());
            String Bullet_file = "D:\\projects\\oop\\BTL\\Images\\bulletUfo"+ (int)(Math.random() * 3) + ".png";
            Image Bullet_image = new ImageIcon(Bullet_file).getImage();
            while(UFOs.get(i) == null){
                i = (int)(Math.random() * UFOs.size());
            }
            int posX = UFOs.get(i).posX + 34;
            int posY = UFOs.get(i).posY + 50;
            Bullet tmp = new Bullet(Bullet_image, posX, posY, 4);       
            BulletUfo.add(tmp);
            UFOs.get(i).posY -= 10;
        }
    } 

    

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; //0.01666666    
        double delta = 0;
        double currentTime = 0;
        double lastTime = System.nanoTime();
        if(gameThread != null){
            sound.playMusic(6);
        }
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            

            while (delta >= 1) {
                update();
                repaint();
                delta--;
                
            }
            if(gameOver){
                sound.playSE(2);
                gameThread = null;
            }
        }
    }

    // Update status and position
    public void update(){

        // Update position of plane
        if (keyH.upPressed) {
            plane.planeY -= plane.speed;
        }
        if (keyH.downPressed) {
            plane.planeY += plane.speed;
        }
        if (keyH.leftPressed) {
            plane.planeX -= plane.speed;
        }
        if (keyH.rightPressed) {
            plane.planeX += plane.speed;
        }
        if(keyH.shoot && plane.bullet != 0){
            int x = plane.planeX + plane.planeWidth/2 - 6;
            int y = plane.planeY - 10;
            Bullet tmp = new Bullet(bulletPlaneImage, x, y, -5);
            plane.bullet -= 1;
            BulletPlane.add(tmp);  
            plane.planeY += 10;     
            keyH.shoot = false; 
            sound.playSE(0);  
        }
        if(plane.planeY <= 0){
            plane.planeY = 0;
        }
        if(plane.planeY >= heightScreen - 100){
            plane.planeY = heightScreen - 100;
        }
        if(plane.planeX <= 0){
            plane.planeX = 0;
        }
        if(plane.planeX >= widthScreen - 80){
            plane.planeX = widthScreen - 80;
        }
        
        // Update UFO position and remove it when it disappear
        for(int i = 0; i < UFOs.size(); i++){
            UFO tmp = UFOs.get(i);
            if(tmp != null){
                tmp.posY +=  tmp.speed;
                if(!tmp.check()){
                    UFOs.remove(tmp);
                }
            }else{
                UFOs.remove(tmp);
            }
        }
        // Update Bullet_UFO position and remove it when it disappear
        for(int i = 0; i < BulletUfo.size(); i++){
            Bullet tmp = BulletUfo.get(i);
            if(tmp != null){
                tmp.posY +=  tmp.speed;
                if(!tmp.check()){
                    BulletUfo.remove(tmp);
                }
            }else{
                BulletUfo.remove(tmp);
            }
        }
        
        // Update Bullet_Plane position and remove it when it disappear
        for(int i = 0; i < BulletPlane.size(); i++){
            Bullet tmp = BulletPlane.get(i);
            if(tmp != null){
                tmp.posY +=  tmp.speed;
                if(!tmp.check()){
                    BulletUfo.remove(tmp);
                }
            }else{
                BulletUfo.remove(tmp);
            }
        }
        // Update OBJs's position
        setter.update1();

        // HP--
        if(collision1(plane)){
            sound.playSE(5);
            plane.HP -= 10;
        }
        // Remove Bullet_Plane and Score++ when Plane attack UFO
        for(int i = 0; i < BulletPlane.size(); i++){
            Bullet tmp = BulletPlane.get(i);
            if(tmp == null){
                BulletPlane.remove(tmp);
            }else{
                if(collision2(tmp)){
                    BulletPlane.remove(tmp);
                }
            }
            
        }
        // Update plane's status when it get OBJs
        setter.update2(plane);

        //Game over
        if(plane.HP <= 0){
            gameOver = true;
        }

    }

    // HP-- when plane is attacked by UFO and Bullet_UFO
    public boolean collision1(Plane plane){
        for(int i = 0; i < UFOs.size(); i++){
            UFO tmp = UFOs.get(i);
            if(tmp != null){
                if(tmp.checkCollision1(plane)){
                    UFOs.remove(tmp);
                    return true;                  
                }
            }else{
                UFOs.remove(tmp);
            }
        }
        for(int i = 0; i < BulletUfo.size(); i++){
            Bullet tmp = BulletUfo.get(i);
            if(tmp != null){
                if(tmp.checkCollision1(plane)){
                    BulletUfo.remove(tmp);
                    return true;
                }
            }else{
                BulletUfo.remove(tmp);
            }
        }
        return false;
    }

    //UFO and Bullet_UFO are attacked
    public boolean collision2(Bullet bullet){
        for(int i = 0; i < UFOs.size(); i++){
            UFO tmp = UFOs.get(i);
            if(tmp != null){
                if(tmp.checkCollision2(bullet)){
                    UFOs.remove(tmp);
                    sound.playSE(1);
                    score += 10;
                    return true;                  
                }
            }else{
                UFOs.remove(tmp);
            }
        }
        for(int i = 0; i < BulletUfo.size(); i++){
            Bullet tmp = BulletUfo.get(i);
            if(tmp != null){
                if(tmp.checkCollision2(bullet)){
                    BulletUfo.remove(tmp);
                    return true;
                }
            }else{
                BulletUfo.remove(tmp);
            }
        }
        return false;
    }


    // Draw function
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Draw backkground
        g2.drawImage(backgroundImage, 0, 0, widthScreen, heightScreen, null);
        // Draw plane
        plane.draw(g2);
        // Draw UFO
        for(int i = 0; i < UFOs.size(); i++){
            UFO tmp = UFOs.get(i);
            if(tmp != null){
                tmp.draw(g2);
            }         
        }
        // Draw Bullet_UFO
        for(int i = 0; i < BulletUfo.size(); i++){
            Bullet tmp = BulletUfo.get(i);
            if(tmp != null){
                tmp.draw(g2);
            }         
        }   
        // Draw Bullet_Plane
        for(int i = 0; i < BulletPlane.size(); i++){
            Bullet tmp = BulletPlane.get(i);
            if(tmp != null){
                tmp.draw(g2);
            }           
        }

        setter.draw(g2);

        // Draw UI
        ui.draw(g2);
    }


}
