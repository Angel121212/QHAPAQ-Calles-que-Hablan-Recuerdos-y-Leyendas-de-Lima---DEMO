/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanelSection;
import main.Utility_Tools;

/**
 *
 * @author emili
 */
public class SuperObjects {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    Utility_Tools uTools = new Utility_Tools();
    
    
    public void draw(Graphics2D g2, GamePanelSection gps){
        int screenX = worldX - gps.player.worldX + gps.player.screenX;
        int screenY = worldY - gps.player.worldY + gps.player.screenY;
           
        // To be able to see just the map u have to play- more efficient
        if(worldX + gps.tileSize > gps.player.worldX - gps.player.screenX && 
            worldX - gps.tileSize < gps.player.worldX + gps.player.screenX && 
            worldY + gps.tileSize > gps.player.worldY - gps.player.screenY &&
            worldY - gps.tileSize < gps.player.worldY + gps.player.screenY){
                
            g2.drawImage( image, screenX, screenY, gps.tileSize, gps.tileSize,null);
       }
    }
    
    public void interact() {
    System.out.println("Interactuaste con la bandera.");
    cuestionario.Cuestionario.main(null); // Abre el formulario (si tienes que ajustar el paquete, hazlo)
}
}
