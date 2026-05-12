/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanelSection;
import main.Utility_Tools;

/**
 *
 * @author emili
 */
public class TilesManager {
    GamePanelSection gps;
    public Tiles[] tiles;
    public int worldMapTilesNum[][];
    
    
    public TilesManager(GamePanelSection gps){
        this.gps = gps;
        tiles = new Tiles[10000];
        worldMapTilesNum = new int[gps.maxWorldCol][gps.maxWorldRow];
        
        
        getTilesImage();
        //loadWorldMap("/worldmap/Worldmap.txt");
        loadWorldMap("/worldmap/Worldmap.txt");
    }
    
    public void getTilesImage(){
           /* before
            tiles[1] = new Tiles();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tilesblocks/ground_block.png"));
            tiles[1].collision = true;
            */
            setup(0,"ground_green", false);
            setup(1,"ground_block", true);
            setup(2,"ground_water", true);
            setup(3,"ground_earth", false);
            setup(4,"ground_tree", true);
            setup(5,"ground_sand", false);
            
            
            setup(7,"ground_streetFloor", false);
            setup(8,"ground_secondaryStreetFloor", false);
            setup(9,"sprite_preside20", false);
            setup(10,"ground_churchWall", false);
            setup(11,"ground_pavedLV", false);
            setup(12,"ground_pavedRV", false);
            setup(13,"ground_pavedLH", false);
            setup(14,"ground_pavedRH", false);
            setup(15,"ground_zebraCrossingV", false);
            setup(16,"ground_zebraCrossingH", false);
            
            
            
            
            //president
            
            setup(31, "sprite_preside01", true);
            setup(32, "sprite_preside02", true);
            setup(33, "sprite_preside03", true);
            setup(34, "sprite_preside04", true);
            setup(35, "sprite_preside05", false);
            setup(36, "sprite_preside06", true);
            setup(37, "sprite_preside07", true);
            setup(38, "sprite_preside08", true);
            setup(39, "sprite_preside09", true);
            setup(40, "sprite_preside10", true);
            setup(41, "sprite_preside11", true);
            setup(42, "sprite_preside12", true);
            setup(43, "sprite_preside13", false);
            setup(44, "sprite_preside14", false);
            setup(45, "sprite_preside15", true);
            setup(46, "sprite_preside16", true);
            setup(47, "sprite_preside17", true);
            setup(48, "sprite_preside18", true);
            setup(49, "sprite_preside19", true);
            setup(50, "sprite_preside20", true);
            setup(51, "sprite_preside21", false);
            setup(52, "sprite_preside22", false);
            setup(53, "sprite_preside23", true);
            setup(54, "sprite_preside24", true);
            setup(55, "sprite_preside25", true);
            setup(56, "sprite_preside26", true);
            setup(57, "sprite_preside27", true);
            setup(58, "sprite_preside28", true);
            setup(59, "sprite_preside29", false);
            setup(60, "sprite_preside30", false);
            setup(61, "sprite_preside31", true);
            setup(62, "sprite_preside32", true);
            setup(63, "sprite_preside33", true);
            setup(64, "sprite_preside34", true);
            setup(65, "sprite_preside35", true);
            setup(66, "sprite_preside36", true);
            setup(67, "sprite_preside37", false);
            setup(68, "sprite_preside38", false);

            
            //Catedral
            setup(69, "sprite_catedral00", true);
            setup(70, "sprite_catedral01", true);
            setup(71, "sprite_catedral02", true);
            setup(72, "sprite_catedral03", true);
            setup(73, "sprite_catedral04", false);
            setup(74, "sprite_catedral05", true);
            setup(75, "sprite_catedral06", true);
            setup(76, "sprite_catedral07", true);
            setup(77, "sprite_catedral08", true);
            setup(78, "sprite_catedral09", false);
            setup(79, "sprite_catedral10", true);
            setup(80, "sprite_catedral11", true);
            setup(81, "sprite_catedral12", true);
            setup(82, "sprite_catedral13", true);
            setup(83, "sprite_catedral14", false);
            setup(84, "sprite_catedral15", true);
            setup(85, "sprite_catedral16", true);
            setup(86, "sprite_catedral17", true);
            setup(87, "sprite_catedral18", true);
            setup(88, "sprite_catedral19", false);
            setup(89, "sprite_catedral20", true);
            setup(90, "sprite_catedral21", true);
            setup(91, "sprite_catedral22", true);
            setup(92, "sprite_catedral23", true);
            setup(93, "sprite_catedral24", false);
            setup(94, "sprite_catedral25", true);
            setup(95, "sprite_catedral26", true);
            setup(96, "sprite_catedral27", true);
            setup(97, "sprite_catedral28", true);
            setup(98, "sprite_catedral29", false);
            setup(99, "sprite_catedral30", true);
            setup(100, "sprite_catedral31", true);
            setup(101, "sprite_catedral32", true);
            setup(102, "sprite_catedral33", true);
            setup(103, "sprite_catedral34", false);
            setup(104, "sprite_catedral35", true);
            setup(105, "sprite_catedral36", true);
            setup(106, "sprite_catedral37", true);
            setup(107, "sprite_catedral38", true);
            setup(108, "sprite_catedral39", false);
            setup(109, "sprite_catedral40", true);
            setup(110, "sprite_catedral41", true);
            setup(111, "sprite_catedral42", true);
            setup(112, "sprite_catedral43", true);
            setup(113, "sprite_catedral44", false);
 
            
            
            
            //extra
            
            setup(169,"simbol_pnp", true);
            setup(188,"wall_pnp", true);
            setup(6,"floor_pnp", false);
            setup(150,"ground_sand", false);
          
            
    }
    
    public void setup(int index, String imageName, boolean collision){
        
        Utility_Tools uTools = new Utility_Tools();
        try{
            tiles[index] = new Tiles();
            tiles[index].image = ImageIO.read(getClass().getResourceAsStream("/tilesblocks/"+ imageName +".png"));
            tiles[index].image = uTools.scaleImage(tiles[index].image, gps.tileSize, gps.tileSize);
            tiles[index].collision = collision;
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    public void loadWorldMap(String filePath){
        try{
           InputStream is = getClass().getResourceAsStream(filePath);
           BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
           int col = 0;
           int row = 0;
           
           while(col < gps.maxWorldCol && row < gps.maxWorldRow){
               String line = br.readLine(); //will read each single line
               
               while(col < gps.maxWorldCol){
                   String numbers[] = line.split(" ");
                   int num = Integer.parseInt(numbers[col]);
                   
                   worldMapTilesNum[col][row] = num;
                   col++;
                }if(col == gps.maxWorldCol){
                    col = 0;
                    row++;

               }
            }
           br.close();
           
        }catch (Exception e){
            
        }
    }
    
    
    public void draw(Graphics2D g2){
        
       // g2.drawImage(tiles[0].image, 0, 0, gps.tileSize, gps.tileSize,null);
       // g2.drawImage(tiles[1].image, 48, 0, gps.tileSize, gps.tileSize,null);
       // g2.drawImage(tiles[2].image, 96, 0, gps.tileSize, gps.tileSize,null);
       // the code above is not efficient
       
       int worldCol = 0;
       int worldRow= 0;
       
       
       while(worldCol < gps.maxWorldCol && worldRow < gps.maxWorldRow){
           
           int tilesNum = worldMapTilesNum[worldCol][worldRow];

           int worldX = worldCol * gps.tileSize;
           int worldY = worldRow * gps.tileSize;
           int screenX = worldX - gps.player.worldX + gps.player.screenX;
           int screenY = worldY - gps.player.worldY + gps.player.screenY;
           
           // To be able to see just the map u have to play- more efficient
            if(worldX + gps.tileSize > gps.player.worldX - gps.player.screenX && 
               worldX - gps.tileSize < gps.player.worldX + gps.player.screenX && 
               worldY + gps.tileSize > gps.player.worldY - gps.player.screenY &&
               worldY - gps.tileSize < gps.player.worldY + gps.player.screenY){
                
            g2.drawImage( tiles[tilesNum].image, screenX, screenY, null);
       }
            worldCol++;
            
            if(worldCol == gps.maxWorldCol){
                worldCol = 0;
                worldRow++;
                
            }
       }
              
    
    }
}
