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
public class OBJ_Door extends  SuperObjects{
    GamePanelSection gps;
     public OBJ_Door(GamePanelSection gps){
        this.gps = gps;
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/sprite_palace1.png"));
        }catch(IOException e){
            e.printStackTrace();    
                }
        
        collision = true;
        
    }
}
