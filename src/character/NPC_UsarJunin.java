/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.util.Random;
import main.GamePanelSection;

/**
 *
 * @author emili
 */
public final class NPC_UsarJunin extends Character {
    public NPC_UsarJunin(GamePanelSection gps){
        super(gps);
        
        direction = "right";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/usarjunin/sprite_NPC_UsarJunin6");
        up2 = setup("/npc/usarjunin/sprite_NPC_UsarJunin7");
        down = setup("/npc/usarjunin/sprite_NPC_UsarJunin0");
        down2 = setup("/npc/usarjunin/sprite_NPC_UsarJunin1");
        left = setup("/npc/usarjunin/sprite_NPC_UsarJunin2");
        left2 = setup("/npc/usarjunin/sprite_NPC_UsarJunin3");
        right = setup("/npc/usarjunin/sprite_NPC_UsarJunin4");
        right2 = setup("/npc/usarjunin/sprite_NPC_UsarJunin5");
        
    }
    
    public void setDialogue(){
        
        dialogues[0] = "Hola, soy parte de la Escolta Presidencial. Mi uniforme\nestá inspirado en los Húsares de Junín.";
        dialogues[1] = "Nuestra vestimenta de gala rinde homenaje a ese\nvaliente regimiento clave en la independencia\ndel Perú.";
        dialogues[2] = "Este es el Palacio de Gobierno del Perú, también\nllamado la Casa de Pizarro.";
        dialogues[3] = "Aquí vive el Presidente del Perú y también funciona\ncomo sede principal del Poder Ejecutivo.";
        dialogues[4] = "Está ubicado en el Centro Histórico de Lima, justo frente\na la Plaza Mayor.";
        dialogues[5] = "Su historia comienza en 1535, cuando Francisco Pizarro\nfundó la ciudad de Lima.";
        dialogues[6] = "Pizarro ordenó construir aquí la primera sede del\ngobierno colonial.";
        dialogues[7] = "A lo largo del tiempo, el palacio ha sido reconstruido\nvarias veces, manteniendo su función principal.";
        dialogues[8] = "Su fachada actual es de estilo neobarroco francés y fue\ninaugurada en 1938.";
        dialogues[9] = "Cada día, muchos turistas vienen a ver el Cambio\nde Guardia, un acto ceremonial muy vistoso.";
        dialogues[10] = "Además de ser símbolo político, es parte importante del\npatrimonio cultural del país.";
        dialogues[11] = "Recuerda que este lugar es protegido por la Guardia\nPresidencial del Perú.";
        dialogues[12] = "Y no lo olvides, aquí se han escrito muchas páginas\nde la historia republicana peruana.";

    }
    
    @Override
    public void setAction(){
        actionLockCounter ++;
        if(actionLockCounter ==120){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            /*if(i<=25){
                direction = "up";
            }
            if(i>25 && i<=50){
                direction = "down";
            }*/
            if(i>50 && i <=75){
                direction = "left";
            }
            if(i>75 && i<=100){
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }
    
    @Override
    public void speak(){
        super.speak();
    }
}
