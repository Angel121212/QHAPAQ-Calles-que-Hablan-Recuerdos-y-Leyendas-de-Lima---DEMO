/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanelSection;

/**
 *
 * @author emili
 */
public class OBJ_Coffee extends  SuperObjects{
    GamePanelSection gps;
     public OBJ_Coffee(GamePanelSection gps){
        this.gps = gps;
        name = "Manzana";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/manzana.png"));
            uTools.scaleImage(image, gps.tileSize, gps.tileSize);
        }catch(IOException e){
            e.printStackTrace();    
                }
    }
}
