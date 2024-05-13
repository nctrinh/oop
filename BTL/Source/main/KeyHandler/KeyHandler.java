package Source.main.KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Source.main.Play.Panel;
import Source.main.Sound.Sound;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public boolean shoot = false;

    public boolean canShoot = true;
    public Panel panel;
    public Sound sound = new Sound();

    public KeyHandler(Panel panel){
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(panel.gameState == panel.titleState){
            if (code == KeyEvent.VK_W){
                panel.ui.cmd--;
                if(panel.ui.cmd < 0){
                    panel.ui.cmd = 1;
                }
            }
            if (code == KeyEvent.VK_S) {
                panel.ui.cmd++;
                if(panel.ui.cmd > 1){
                    panel.ui.cmd = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE){
                if(panel.ui.cmd == 0){
                    panel.gameState = panel.playState;
                    panel.sound.stopMusic();
                    sound.playMusic(6);
                    canShoot = false;
                }
                if(panel.ui.cmd == 1){
                    System.exit(0);
                }
            }
        }
        if(panel.gameState == panel.playState){
            if (code == KeyEvent.VK_W){
                upPressed = true;
            }
            if (code == KeyEvent.VK_S){
                downPressed = true;
            }
            if (code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_SPACE && canShoot){
                shoot = true;         
            }
            if(code == KeyEvent.VK_P){
                if(panel.gameState == panel.playState){
                    panel.gameState = panel.pauseState;
                }else if( panel.gameState == panel.pauseState){
                    panel.gameState = panel.playState;
                }
                
            }
        }
        if(panel.gameState == panel.pauseState){
            if(code == KeyEvent.VK_W){
                panel.ui.cmd_ofPause--;
                if(panel.ui.cmd_ofPause < 0){
                    panel.ui.cmd_ofPause = 1;
                }
            }
            if(code == KeyEvent.VK_S){
                panel.ui.cmd_ofPause++;
                if(panel.ui.cmd_ofPause > 1){
                    panel.ui.cmd_ofPause = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE){
                if(panel.ui.cmd_ofPause == 0){
                    panel.gameState = panel.playState;
                }
                if(panel.ui.cmd_ofPause == 1){
                    System.exit(0);
                }
            }
        }
        if(panel.gameState == panel.dieState){
            if(code == KeyEvent.VK_W){
                panel.ui.cmd--;
                if(panel.ui.cmd < 0){
                    panel.ui.cmd = 1;
                }
            }
            if(code == KeyEvent.VK_S){
                panel.ui.cmd++;
                if(panel.ui.cmd > 1){
                    panel.ui.cmd = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE){
                if(panel.ui.cmd == 0){
                    if(!panel.sound.clip.isRunning()){
                        panel.gameState = panel.playState;
                        panel.gameOver = false;  
                        sound.playMusic(6);
                        panel.score = 0;
                    }             
                }
                if(panel.ui.cmd == 1){
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upPressed = false;
        }
        if (code == KeyEvent.VK_S){
            downPressed = false;
        }
        if (code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_SPACE){
            shoot = false;
            canShoot = true;
        }
    }
    //Not use
    @Override
    public void keyTyped(KeyEvent e) {}
}
