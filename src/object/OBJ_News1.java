/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author emili
 */
public class OBJ_News1 extends SuperObjects{
   
    public OBJ_News1(){
        name = "News1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/news1.png"));
        }catch(IOException e){
            e.printStackTrace();    
                }
        
        collision = true;
        
    }
}
