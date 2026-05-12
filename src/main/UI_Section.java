/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author emili
 */
public class UI_Section {
    GamePanelSection gps;
    Graphics2D g2;
    Font arial_35, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean endGame = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    int subState = 0;
    

    public UI_Section(GamePanelSection gps){
        this.gps= gps;
        arial_35 = new Font("Dialog",Font.PLAIN, 35);
        arial_80B = new Font("Dialog",Font.BOLD, 80);
    }
    
    //metodo
    public void showMessage(String txt){
        message = txt;
        messageOn = true;
    }
    
    
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_35);
        g2.setColor(Color.white);
        
        
        //Title State
        if (gps.gameState == gps.titleState) {
            drawTitleScreen();
        }
        //PLAY STATE
        if(gps.gameState == gps.playState){
            //
        }
        //PAUSE STATE
        if(gps.gameState == gps.pauseState){
            drawPauseScreen();
        }
        //DIALOGUE STATE
        if(gps.gameState == gps.dialogState){
            drawDialogueScreen();
        }
        //OPTIONS STATE
        if(gps.gameState == gps.optionsState){
            drawOptionsScreen();
        }
        
        
    }
    
    public void drawTitleScreen(){
        //background
        /*g2.setColor(new Color(80,70,140));*/
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, gps.screenWidth, gps.screenHeight);
        
        
        //Title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
        String txt = "QHAPAQ";
        int x = getXforCenteredText(txt);
        int y = gps.tileSize*3; 
        
        //Shadow Color
        g2.setColor(Color.gray);
        g2.drawString(txt,x+5,y+5);
        
        //Principal Color
        g2.setColor(Color.white);
        g2.drawString(txt,x,y);
        
        //Principal Image(intro)
        x = gps.screenWidth/2-(1+gps.tileSize*2)/2;
        y += gps.tileSize*2;
        g2.drawImage(gps.player.down, x, y, gps.tileSize*2,gps.tileSize*2, null);
        
        //Menubar
        //1° Option
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        txt="NUEVO JUEGO";
        x = getXforCenteredText(txt);
        y += gps.tileSize*4;
        g2.drawString(txt, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gps.tileSize, y);
        }
        
        //2° Option
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        txt="CARGAR JUEGO";
        x = getXforCenteredText(txt);
        y += gps.tileSize;
        g2.drawString(txt, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gps.tileSize, y);
        }
        
        
        //3° Option
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        txt="SALIR";
        x = getXforCenteredText(txt);
        y += gps.tileSize;
        g2.drawString(txt, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gps.tileSize, y);
        }
    }
    
    
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String txt = "En Pausa";
        int x = getXforCenteredText(txt);
      
        int y = gps.screenHeight/2;
        
        g2.drawString(txt, x, y);
    }
    
    public void drawDialogueScreen(){
        //Dialogue Window
        int x = gps.tileSize*2;
        int y = gps.tileSize/2;
        int width = gps.screenWidth -(gps.tileSize*4);
        int height = gps.tileSize*4;
        drawSubWindow(x,y,width,height);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
        x += gps.tileSize;
        y += gps.tileSize;
        
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line,x,y);
            y += 40;
        }
    }
    
    
    public void drawOptionsScreen(){
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(27F));
        
        //sub window
        int frameX = gps.tileSize*6;
        int frameY = gps.tileSize;
        int frameWidth = gps.tileSize*9;
        int frameHeight = gps.tileSize*10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
        
        switch(subState){
            case 0:
                options_top(frameX,frameY);break;
            case 1:
                options_fullScreenNotification(frameX, frameY);
                break;
            case 2:
                options_control(frameX, frameY);
                break;  
            case 3:
                options_endGameConfiguration(frameX, frameY);
                break; 
        }    
        gps.keyH.enterPressed = false;
    }
    
    public void options_top(int frameX, int frameY){
        
        int txtX;
        int txtY;
        //title
        String text = "Ajustes";
        txtX = getXforCenteredText(text);
        txtY = frameY + gps.tileSize;
        g2.drawString(text,txtX, txtY);
        
        //FULL SCREEN ON/OFF
        txtX = frameX + gps.tileSize;
        txtY += frameY + gps.tileSize;
        g2.drawString("Pantalla Completa:",txtX, txtY);
        if(commandNum == 0){
            g2.drawString(">", txtX-25, txtY);
            if(gps.keyH.enterPressed == true){
                if(gps.fullScreenOn ==false){
                    gps.fullScreenOn = true;
                }
                else if(gps.fullScreenOn ==true){
                    gps.fullScreenOn = false;
                }
                subState = 1;
            }
        }
        
        //Music
        txtY += frameY + gps.tileSize/16;
        g2.drawString("Volumen Juego:",txtX, txtY);
        if(commandNum == 1){
            g2.drawString(">", txtX-25, txtY);
        }
        
        //SE(SOUND EFFECT)
        txtY += frameY + gps.tileSize/16;
        g2.drawString("Volumen Efectos:",txtX, txtY);
        if(commandNum == 2){
            g2.drawString(">", txtX-25, txtY);
        }
        
        //Control
        txtY += frameY + gps.tileSize/16;
        g2.drawString("Controles",txtX, txtY);
        if(commandNum == 3){
            g2.drawString(">", txtX-25, txtY);
            if (gps.keyH.enterPressed == true) {
                subState = 2;
                commandNum = 0;
            }
        }
        
        //END GAME
        txtY += frameY + gps.tileSize/16;
        g2.drawString("Salir",txtX, txtY);
        if(commandNum == 4){
            g2.drawString(">", txtX-25, txtY);
            if (gps.keyH.enterPressed == true) {
                subState = 3;
                commandNum = 0;
            }
        }
        
        //Atrás
        txtY += frameY + gps.tileSize;
        g2.drawString("Atrás",txtX, txtY);
        if(commandNum == 5){
            g2.drawString(">", txtX-25, txtY);
            if(gps.keyH.enterPressed == true){
                gps.gameState = gps.playState;
                commandNum = 0;
            }
        }
        
        //FULL SCREEN CHECK BOX
        txtX = frameX + gps.tileSize*6;
        txtY = frameY + gps.tileSize*2+24;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(txtX, txtY, 24, 24);
        if(gps.fullScreenOn == true){
            g2.fillRect(txtX, txtY, 24, 24);
        }
        
        
        //Music volume
        txtY += gps.tileSize;
        g2.drawRect(txtX, txtY, 120, 24);
        int volumeWidth = 24 * gps.music.volumeScale;
        g2.fillRect(txtX, txtY, volumeWidth, 24);
        
        //SE volume
        txtY += gps.tileSize;
        g2.drawRect(txtX, txtY, 120, 24);
        volumeWidth = 24 * gps.soundeffect.volumeScale;
        g2.fillRect(txtX, txtY, volumeWidth, 24);
        
        
        gps.configuracion.guardarConfiguracion();
    }
    
    
    public void options_fullScreenNotification(int frameX, int frameY){
        
        int txtX =frameX + gps.tileSize;
        int txtY =frameY + gps.tileSize*3;
        currentDialogue = "Es necesario reiniciar el \ndispositivo para que se hagan \nlos cambios";
        
        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,txtX,txtY);
            txtY += 40;
        }
        
        //back
        txtY = frameY +gps.tileSize*9;
        g2.drawString("Atrás", txtX, txtY);
        if(commandNum == 0){
            g2.drawString(">", txtX-25, txtY);
            if (gps.keyH.enterPressed == true) {
                subState = 0;
            }
        }
        
    }
    
    
    public void options_control(int frameX, int frameY){
        int txtX;
        int txtY;
        
        //title
        String txt = "Controles";
        txtX = frameX + gps.tileSize;
        txtY = frameY + gps.tileSize;
        g2.drawString("Mover", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("Hablar", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("Pausa", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("Render", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("Ajustes", txtX, txtY); txtY+= gps.tileSize;
        
        txtX = frameX + gps.tileSize*(int)(4.9);
        txtY = frameY + gps.tileSize;
        g2.drawString("WASD o ←↑↓→", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("T", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("P", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("F", txtX, txtY); txtY+= gps.tileSize;
        g2.drawString("ESC", txtX, txtY); txtY+= gps.tileSize;
        
        //BACK
        txtX = frameX + gps.tileSize;
        txtY = frameY + gps.tileSize*9;
        g2.drawString("Atrás", txtX, txtY);
        if(commandNum == 0){
            g2.drawString(">",txtX-25,txtY);
            if(gps.keyH.enterPressed == true){
                subState = 0;
                commandNum = 3;
            }
        }
    }
    
    
    public void options_endGameConfiguration(int frameX, int frameY){
        int txtX = frameX + gps.tileSize;
        int txtY = frameY + gps.tileSize*2;
        currentDialogue = "¿Estás seguro de que\nquieres salir del juego y \nvolver al menú principal?";
        
        for(String line: currentDialogue.split("\n")){
            g2.drawString(line, txtX, txtY);
            txtY += 40;
        }
        
        //si
        String txt = "Si";
        txtX = getXforCenteredText(txt)+20;
        txtY += gps.tileSize*3;
        g2.drawString(txt, txtX, txtY);
        if(commandNum == 0){
            g2.drawString(">", txtX-25, txtY);
            if(gps.keyH.enterPressed == true){
                subState = 0;
                gps.gameState = gps.titleState;
            }
        }
        
        //NO
        txt = "NO";
        txtX = getXforCenteredText(txt)+20;
        txtY += gps.tileSize;
        g2.drawString(txt, txtX, txtY);
        if(commandNum == 1){
            g2.drawString(">", txtX-25, txtY);
            if(gps.keyH.enterPressed == true){
                subState = 0;
                commandNum = 4;
            }
        }
        
    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255,255,255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c);
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    
    public int getXforCenteredText(String txt){
        int length = (int)g2.getFontMetrics().getStringBounds(txt, g2).getWidth();
        int x = gps.screenWidth/2 - length/2;
        return x;
        
    }
}