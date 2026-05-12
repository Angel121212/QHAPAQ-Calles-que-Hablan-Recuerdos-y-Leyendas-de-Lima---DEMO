/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author emili
 */
public class Keyboardcontrols implements KeyListener{

    GamePanelSection gps;
    public boolean upPressed, downPressed, leftPressed,rightPressed, enterPressed;
    //Debuging
    boolean checkDrawTime = false;
    
    Keyboardcontrols(GamePanelSection gps){
        this.gps = gps;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        //TITLE STATE
            if (gps.gameState == gps.titleState) {
               
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                    gps.playSE(3);
                    gps.ui.commandNum--;
                    if(gps.ui.commandNum < 0){
                        gps.ui.commandNum = 2;
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                    gps.playSE(3);
                    gps.ui.commandNum++;
                    if(gps.ui.commandNum > 2){
                        gps.ui.commandNum = 0;
                    }
                }   
                if(code == KeyEvent.VK_ENTER){
                    gps.playSE(3);
                    if(gps.ui.commandNum == 0){
                        gps.gameState = gps.playState;
                        gps.playMusic(0);
                    }
                    if(gps.ui.commandNum == 1){
                        //add later
                    }
                    if(gps.ui.commandNum == 2){
                        System.exit(0);
                    }
                }   
        }
        
        
        
        
        //PLAY STATE
        
        if(gps.gameState == gps.playState){ 
            
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P){
                gps.gameState = gps.pauseState;
            }
            if(code == KeyEvent.VK_T){
                enterPressed = true;
            }
            if(code == KeyEvent.VK_ESCAPE){
                gps.gameState = gps.optionsState;
            }
           

            //Debuging
            if(code == KeyEvent.VK_F){
                if (checkDrawTime ==  false) {
                    checkDrawTime = true;
                }
                else if(checkDrawTime == true){
                    checkDrawTime = false;
                }
            } 
        } 
        //PAUSE STATE
        else if(gps.gameState == gps.pauseState){
            if(code == KeyEvent.VK_P){
                gps.gameState = gps.playState;
            }
        }
        //DIALOGUE STATE
        else if(gps.gameState == gps.dialogState){
            if(code == KeyEvent.VK_T){
                gps.gameState = gps.playState;
            }
        }
        else if(gps.gameState == gps.optionsState){
            optionsState(code);
            
        }
        
    }

    public void optionsState(int code){
        if (code == KeyEvent.VK_ESCAPE) {
            gps.gameState = gps.playState;
        }
        if (code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        
        int maxCommandNum = 0;
        switch(gps.ui.subState){
            case 0: maxCommandNum = 5; break;
            case 3: maxCommandNum = 1; break;
        }
        if (code == KeyEvent.VK_W || code ==KeyEvent.VK_UP){
            gps.ui.commandNum--;
            gps.playSE(3);
            if(gps.ui.commandNum < 0){
                gps.ui.commandNum = maxCommandNum;
            }
        }
        if (code == KeyEvent.VK_S || code ==KeyEvent.VK_DOWN){
            gps.ui.commandNum++;
            gps.playSE(3);
            if(gps.ui.commandNum > maxCommandNum){
                gps.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_A|| code ==KeyEvent.VK_LEFT){
            if (gps.ui.subState == 0) {
                if (gps.ui.commandNum == 1 && gps.music.volumeScale > 0) {
                    gps.music.volumeScale--;
                    gps.music.checkVolume();
                    gps.playSE(3);
                }
                if (gps.ui.commandNum == 2 && gps.music.volumeScale > 0) {
                    gps.soundeffect.volumeScale--;
                    gps.playSE(3);
                    
                }
            }
        }
        if (code == KeyEvent.VK_D|| code ==KeyEvent.VK_RIGHT){
            if (gps.ui.subState == 0) {
                if (gps.ui.commandNum == 1 && gps.music.volumeScale < 5) {
                    gps.music.volumeScale++;
                    gps.music.checkVolume();
                    gps.playSE(3);
                }
                if (gps.ui.commandNum == 2 && gps.soundeffect.volumeScale < 5) {
                    gps.soundeffect.volumeScale++;
                    gps.playSE(3);
                }
            }
        }
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
         if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
         if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }
    
}
