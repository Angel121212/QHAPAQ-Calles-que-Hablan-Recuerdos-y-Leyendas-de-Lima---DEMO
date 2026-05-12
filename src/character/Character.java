 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanelSection;
import main.Utility_Tools;

/**
 *
 * @author emili
 */
public class Character {
    
    GamePanelSection gps;
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up, down, left, right,up2, down2, left2, right2;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;
    
    
    public Character(GamePanelSection gps){
        this.gps = gps;
    }
    
    public void setAction(){
        
    }
    
    public void speak(){
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gps.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
        
        switch(gps.player.direction){
            case"up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }
    
    public void update(){
        setAction();
        collisionOn = false;
        gps.cTester.checkTiles(this);
        gps.cTester.testObject(this,false);
        gps.cTester.checkPlayer(this);
        
        //if la collision  es falso, se puede mover(el player)
            if(collisionOn == false){
                switch(direction){
                    case "up":
                           worldY -= speed; // the same to playerY = playerY - playerSpeed; 
                        break;
                    case "down":
                            worldY += speed; // the same to playerY = playerY + playerSpeed; 
                        break;
                    case "left":
                            worldX -= speed; // the same to playerX = playerX - playerSpeed; 
                        break;
                    case "right":
                            worldX += speed; // the same to playerX = playerX + playerSpeed; 
                        break;
                }
            }
            
            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;    
                }
                spriteCounter = 0;
            
            }
    }
    
    public void draw(Graphics2D g2){
         BufferedImage image = null;
        
        int screenX = worldX - gps.player.worldX + gps.player.screenX;
        int screenY = worldY - gps.player.worldY + gps.player.screenY;
           
        // To be able to see just the map u have to play- more efficient
        if(worldX + gps.tileSize > gps.player.worldX - gps.player.screenX && 
            worldX - gps.tileSize < gps.player.worldX + gps.player.screenX && 
            worldY + gps.tileSize > gps.player.worldY - gps.player.screenY &&
            worldY - gps.tileSize < gps.player.worldY + gps.player.screenY){
                
            
             switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up;
                }
               if(spriteNum == 2){
                    image = up2;
               } //second image for the movement
                break;
            case "down":
                if(spriteNum == 1){
                    image = down;
                }
                if(spriteNum == 2){
                    image = down2;
                } //second image for the movement
                break;
            case "left":
                if(spriteNum == 1){
                    image = left;
                }
                if(spriteNum == 2){
                    image = left2;
                } //second image for the movement
                break;
            case "right":
                
                if(spriteNum == 1){
                    image = right;
                }
                 if(spriteNum == 2){
                    image = right2;
                } //second image for the movement
                break;
        }
            
            g2.drawImage( image, screenX, screenY, gps.tileSize, gps.tileSize,null);
       }
    }
    
    //----------------------------
    public BufferedImage setup(String imagePath){
        Utility_Tools uTools = new Utility_Tools();
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTools.scaleImage(image, gps.tileSize, gps.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return image;
    }
}
