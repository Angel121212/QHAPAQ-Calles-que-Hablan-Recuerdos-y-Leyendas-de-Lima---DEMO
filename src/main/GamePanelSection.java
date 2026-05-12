/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author emili
 */

import character.Player_game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import object.SuperObjects;
import tiles.TilesManager;

public class GamePanelSection extends JPanel implements Runnable{
    final int originalTileSize =16; //Default size
    final int scale = 3;
    
    boolean isMusicPlaying = false; // musica
    public final int tileSize = originalTileSize*scale; // total of the spriteframe 48 x 48
    public final int maxScreenCol = 20; //16
    public final int maxScreenRow = 12;  // 12 the size of the background of all the game _ 4x3
    //Screen size 768*576 pxls
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    
    //world Sttings - section
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    
    public final int worldWidth =  tileSize * maxWorldCol;
    public final int worldHeight =  tileSize * maxWorldRow;
    
    // FULL SCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    public boolean fullScreenOn = false;
    
    
    int fps = 60; //FPS 
    TilesManager tileM = new TilesManager(this);
    public Keyboardcontrols keyH = new Keyboardcontrols(this);
    
    Sound music = new Sound();
    Sound soundeffect = new Sound();
    
    public CollisionTester cTester = new CollisionTester(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI_Section ui = new UI_Section(this);
    Configuracion configuracion = new Configuracion(this);
    Thread gameThread;
    
    
    public Player_game player = new Player_game(this,keyH);
    public SuperObjects obj[] = new SuperObjects[25];
    public character.Character npc[] = new character.Character[30];
    /*public Character npc[] = new Character[10];*/
    

    //Game state 
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogState = 3;
    public final int optionsState = 5;
    
    
  
    
    public GamePanelSection(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }
    
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
       //playMusic(0);
        //stopMusic();
        gameState = titleState;
        tempScreen = new BufferedImage(screenWidth,screenHeight,BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)tempScreen.getGraphics();
       
        if(fullScreenOn == true){
            setFullScreen();
        }
    }
    
    public void setFullScreen(){
        //tomar la pantalla local
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);
        // get Full screen width and height
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    
    @Override
    
    public void run(){
        double drawIntervalGame = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawIntervalGame;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            
            if(delta >= 1){
                updateMovements();
                //repaint();
                drawToTempScreen(); // dibuja todo
                drawToScreen();  // dibuja el buffered de la image para la pantalla
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    
    public void updateMovements(){
       
        if(gameState == playState){
            //Music
            if(!isMusicPlaying){
                
                music.resume(); 
                isMusicPlaying = true;
            }
            
            //player
            player.updateMovements();
            
            //NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            
        }
        if(gameState == pauseState){
            //Stop
            //stopMusic();
            music.pause();
            isMusicPlaying = false;
        }
       
    }
    //full screen
    public void drawToTempScreen(){
         //Debuging
        long drawStart = 0;
        if(keyH.checkDrawTime == true){
            drawStart = System.nanoTime();
        }
        
        //TITLE SCREEN
        if(gameState == titleState){
           ui.draw(g2);
        }
       
       //others
       else{
           //title
            tileM.draw(g2);
        
            for (int i = 0; i < obj.length; i++) {
                if(obj[i] != null){
                    obj[i].draw(g2,this);
                }
            }
            //NPC
            for (int i = 0; i < npc.length; i++) {
                if(npc[i] != null){
                    npc[i].draw(g2);
                }
            }
                
            //player
            player.draw(g2);
        
            //UI_Section
            ui.draw(g2);
       } 
        
        //Debuging
        if(keyH.checkDrawTime == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: "+ passed, 10, 400);
            System.out.println("Draw Time: "+passed);
        }
    }
    
    
    public void drawToScreen(){
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
        g.dispose();
    }
    
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
        
    }
    
    public void stopMusic(){
        music.stop();
    }
    
    public void playSE(int i){
        soundeffect.setFile(i);
        soundeffect.play();
    }
}


