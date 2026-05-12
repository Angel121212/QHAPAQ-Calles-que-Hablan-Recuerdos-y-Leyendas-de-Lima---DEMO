/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import cuestionario.LanzadorCuestionario;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author emili
 */
public class OBJ_Flag extends SuperObjects{
    public OBJ_Flag(){
        name = "Flag";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/flag.png"));
            
        }catch(IOException e){
            e.printStackTrace();    
                }
    }
    public void interact() {
        System.out.println("¡Interacción con la bandera!");
        LanzadorCuestionario.lanzar();
    }
}
