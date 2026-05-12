/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import character.Character;
/**
 *
 * @author emili
 */
public class CollisionTester {

    GamePanelSection gps;
    
    public CollisionTester(GamePanelSection gps){
        this.gps = gps;
        
    }
    
    public void checkTiles(Character character){
        
        int characterLeftWorldX    = character.worldX + character.solidArea.x;
        int characterRightWorldX   = character.worldX + character.solidArea.x + character.solidArea.width;
        int characterTopWorldY     = character.worldY + character.solidArea.y;
        int characterBottomWorldY  = character.worldY + character.solidArea.y + character.solidArea.height;
        
        int characterLeftCol   = characterLeftWorldX/gps.tileSize;
        int characterRightCol  = characterRightWorldX/gps.tileSize;
        int characterTopRow    = characterTopWorldY/gps.tileSize;
        int characterBottomRow = characterBottomWorldY/gps.tileSize;
        
        int tileNum1,tileNum2;
        
        switch(character.direction){
            case "up":
                characterTopRow = (characterTopWorldY + character.speed)/gps.tileSize;
                tileNum1 = gps.tileM.worldMapTilesNum[characterLeftCol][characterTopRow];
                tileNum2 = gps.tileM. worldMapTilesNum[characterRightCol][characterTopRow];
                if(gps.tileM.tiles[tileNum1].collision == true || gps.tileM.tiles[tileNum2].collision == true){
                    character.collisionOn = true;
                }
                break;
            case "down":
                characterBottomRow = (characterBottomWorldY + character.speed)/gps.tileSize;
                tileNum1 = gps.tileM.worldMapTilesNum[characterLeftCol][characterBottomRow];
                tileNum2 = gps.tileM. worldMapTilesNum[characterRightCol][characterBottomRow];
                if(gps.tileM.tiles[tileNum1].collision == true || gps.tileM.tiles[tileNum2].collision == true){
                    character.collisionOn = true;
                }
                break;
            case "left":
                characterLeftCol = (characterLeftWorldX - character.speed)/gps.tileSize;
                tileNum1 = gps.tileM.worldMapTilesNum[characterLeftCol][characterTopRow];
                tileNum2 = gps.tileM. worldMapTilesNum[characterLeftCol][characterBottomRow];
                if(gps.tileM.tiles[tileNum1].collision == true || gps.tileM.tiles[tileNum2].collision == true){
                    character.collisionOn = true;
                }
                break;
             case "right":
                characterRightCol = (characterRightWorldX - character.speed)/gps.tileSize;
                tileNum1 = gps.tileM.worldMapTilesNum[characterRightCol][characterTopRow];
                tileNum2 = gps.tileM. worldMapTilesNum[characterRightCol][characterBottomRow];
                if(gps.tileM.tiles[tileNum1].collision == true || gps.tileM.tiles[tileNum2].collision == true){
                    character.collisionOn = true;
                }
                 break;
        }
    }  
    
    
    public int testObject(Character character, boolean player_game){
        
      int index = 999;
      for (int i = 0; i < gps.obj.length; i++) {
            if(gps.obj[i] != null){
                character.solidArea.x = character.worldX + character.solidArea.x;
                character.solidArea.y = character.worldY + character.solidArea.y;
                
                gps.obj[i].solidArea.x = gps.obj[i].worldX + gps.obj[i].solidArea.x;
                gps.obj[i].solidArea.y = gps.obj[i].worldY + gps.obj[i].solidArea.y;
                
                
                switch(character.direction){
                    case "up":
                        character.solidArea.y -= character.speed;
                        if(character.solidArea.intersects(gps.obj[i].solidArea)){
                            if(gps.obj[i].collision == true){
                                character.collisionOn = true;
                            }
                            if(player_game == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        character.solidArea.y += character.speed;
                        if(character.solidArea.intersects(gps.obj[i].solidArea)){
                            if(gps.obj[i].collision == true){
                                character.collisionOn = true;
                            }
                            if(player_game == true){
                                index = i;
                            }
                        }
                        break;  
                    case "left":
                        character.solidArea.x -= character.speed;
                        if(character.solidArea.intersects(gps.obj[i].solidArea)){
                           if(gps.obj[i].collision == true){
                                character.collisionOn = true;
                            }
                            if(player_game == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        character.solidArea.x += character.speed;
                        if(character.solidArea.intersects(gps.obj[i].solidArea)){
                           if(gps.obj[i].collision == true){
                                character.collisionOn = true;
                            }
                            if(player_game == true){
                                index = i;
                            }
                        break;  
                        }
                          
                    }
            
            
                    character.solidArea.x = character.solidAreaDefaultX;
                    character.solidArea.y = character.solidAreaDefaultY;
                    gps.obj[i].solidArea.x = gps.obj[i].solidAreaDefaultX;
                    gps.obj[i].solidArea.y = gps.obj[i].solidAreaDefaultY;

            }
      }
      
      
      return index;
    }
    public int checkCharacter(Character character, Character[] target){
        
        int index = 999;
      for (int i = 0; i < target.length; i++) {
            if(target[i] != null){
                character.solidArea.x = character.worldX + character.solidArea.x;
                character.solidArea.y = character.worldY + character.solidArea.y;
                
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
                
                
                switch(character.direction){
                    case "up":
                        character.solidArea.y -= character.speed;
                        if(character.solidArea.intersects(target[i].solidArea)){
                                character.collisionOn = true;
                                index = i;
                        }
                        break;
                    case "down":
                        character.solidArea.y += character.speed;
                        if(character.solidArea.intersects(target[i].solidArea)){
                                character.collisionOn = true;
                                index = i;
                        }
                        break;  
                    case "left":
                        character.solidArea.x -= character.speed;
                        if(character.solidArea.intersects(target[i].solidArea)){
                                character.collisionOn = true;
                                index = i;
                        }
                        break;
                    case "right":
                        character.solidArea.x += character.speed;
                        if(character.solidArea.intersects(target[i].solidArea)){
                                character.collisionOn = true;
                                index = i;
                        break;  
                        }
                    }
            
                    character.solidArea.x = character.solidAreaDefaultX;
                    character.solidArea.y = character.solidAreaDefaultY;
                    target[i].solidArea.x = target[i].solidAreaDefaultX;
                    target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
      }

      return index;
    }
    public void checkPlayer(Character character){
        character.solidArea.x = character.worldX + character.solidArea.x;
                character.solidArea.y = character.worldY + character.solidArea.y;
                
                gps.player.solidArea.x =  gps.player.worldX +  gps.player.solidArea.x;
                 gps.player.solidArea.y =  gps.player.worldY +  gps.player.solidArea.y;
                
                
                switch(character.direction){
                    case "up":
                        character.solidArea.y -= character.speed;
                        if(character.solidArea.intersects( gps.player.solidArea)){
                                character.collisionOn = true;
                        }
                        break;
                    case "down":
                        character.solidArea.y += character.speed;
                        if(character.solidArea.intersects( gps.player.solidArea)){
                                character.collisionOn = true;
                        }
                        break;  
                    case "left":
                        character.solidArea.x -= character.speed;
                        if(character.solidArea.intersects( gps.player.solidArea)){
                                character.collisionOn = true;
                        }
                        break;
                    case "right":
                        character.solidArea.x += character.speed;
                        if(character.solidArea.intersects( gps.player.solidArea)){
                                character.collisionOn = true;
                        break;  
                        }
                    }
            
                    character.solidArea.x = character.solidAreaDefaultX;
                    character.solidArea.y = character.solidAreaDefaultY;
                     gps.player.solidArea.x =  gps.player.solidAreaDefaultX;
                     gps.player.solidArea.y =  gps.player.solidAreaDefaultY;
    }
}
