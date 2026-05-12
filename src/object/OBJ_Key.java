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
public class OBJ_Key extends SuperObjects {
    
    GamePanelSection gps;
    
    public OBJ_Key(GamePanelSection gps){
        this.gps = gps;
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
            uTools.scaleImage(image, gps.tileSize, gps.tileSize);
        }catch(IOException e){
            e.printStackTrace();    
                }
    }
}
