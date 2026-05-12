/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanelSection;
import main.Keyboardcontrols;
import object.OBJ_Flag;


/**
 *
 * @author emili
 */
public class Player_game extends Character{
    
    Keyboardcontrols keyH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    
    
    public Player_game(GamePanelSection gps, Keyboardcontrols keyH){
        super(gps);
        this.keyH = keyH;
        
        screenX = gps.screenWidth/2 -(gps.tileSize/2);
        screenY = gps.screenHeight/2 -(gps.tileSize/2);
        
        
        //define the parameters
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        

        
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gps.tileSize * 23;
        worldY = gps.tileSize * 22;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){

        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/player/up_img");
        up2 = setup("/player/up2_img");
        down = setup("/player/down_img");
        down2 = setup("/player/down2_img");
        left = setup("/player/left_img");
        left2 = setup("/player/left2_img");
        right = setup("/player/right_img");
        right2 = setup("/player/right2_img");
        
    }
    
    public void updateMovements(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true ){
        
            if(keyH.upPressed == true){
                direction = "up";
            }else if(keyH.downPressed == true){
                direction = "down";
            }else if(keyH.leftPressed == true){
                direction = "left";
            }else if(keyH.rightPressed == true){
                direction = "right";
            }
            
            // Test the collision
            collisionOn = false;
            gps.cTester.checkTiles(this); 
            
            // Test the  OBJ collision
            int objIndex = gps.cTester.testObject(this, true);
            pickUpObject(objIndex);
            
            //check NPC collision
            int npcIndex = gps.cTester.checkCharacter(this, gps.npc);
            interactNPC(npcIndex);
            
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
        }else{
                standCounter++;
                if(standCounter ==20){
                    spriteNum = 2;
                    standCounter = 0;
                }
        }
        
    }
    
    public void pickUpObject(int i){
        if(i != 999){
        if(gps.keyH.enterPressed){
            gps.obj[i].interact();  // abrir el cuestionario
        }
    }
        
    }
    
    public void  interactNPC(int i){
        if(i != 999){
            if(gps.keyH.enterPressed == true){
                gps.gameState = gps.dialogState;
                gps.npc[i].speak();
            }
        }
        gps.keyH.enterPressed = false;
    }
    
    
    public void draw(Graphics2D g2){
        // g2.setColor(Color. )  ;
         // g2.fillRect(x, y, gps.tileSize, gps.tileSize);
        BufferedImage image = null;
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
        g2.drawImage(image, screenX, screenY, null );
        
        //tosee the limits of the character´s collision
       /* BOX LIMITS --- g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x,screenY + solidArea.y,solidArea.width,solidArea.height);*/
        
        
    }
}
