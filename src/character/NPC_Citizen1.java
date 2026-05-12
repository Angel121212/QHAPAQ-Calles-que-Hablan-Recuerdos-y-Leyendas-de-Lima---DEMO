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
public final class NPC_Citizen1 extends Character {
     public NPC_Citizen1(GamePanelSection gps){
        super(gps);
        
        direction = "up";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/citizen_1/sprite_NPC_Citizen16");
        up2 = setup("/npc/citizen_1/sprite_NPC_Citizen17");
        down = setup("/npc/citizen_1/sprite_NPC_Citizen10");
        down2 = setup("/npc/citizen_1/sprite_NPC_Citizen11");
        left = setup("/npc/citizen_1/sprite_NPC_Citizen12");
        left2 = setup("/npc/citizen_1/sprite_NPC_Citizen13");
        right = setup("/npc/citizen_1/sprite_NPC_Citizen14");
        right2 = setup("/npc/citizen_1/sprite_NPC_Citizen15");
        
    }
    
    public void setDialogue(){
       dialogues[0] = "Hola, joven. ¿Estás bien?\nParece que estás un poco perdido por aquí.";
       dialogues[1] = "Este lugar es el Palacio de Gobierno. Aquí trabaja el\nPresidente del Perú.";
       dialogues[2] = "No deberías andar solo por estos lugares, hay bastante\nmovimiento policial.";
       dialogues[3] = "Si buscas ayuda, por allá está un oficial. Él te puede\norientar mejor que yo.";
       dialogues[4] = "Antes, yo solía venir de niño a ver el Cambio de Guardia.\nEs todo un espectáculo.";
       dialogues[5] = "Ahora vengo con mis hijos a ver la Plaza Mayor y\ncontarles un poco de nuestra historia.";
       dialogues[6] = "¿Sabías que este palacio existe desde la época de\nPizarro?\nEs parte de Lima desde 1535.";
       dialogues[7] = "Si caminas hacia la derecha, hay una bandera. A partir\nde ahí, todo es más turístico.";
       dialogues[8] = "Y si te da hambre, a la vuelta hay unas ricas empanadas.\n¡Muy recomendadas!";
       dialogues[9] = "Cuídate mucho, y no olvides avisarle a algún policía si\nnecesitas más ayuda.";
       dialogues[10] = "¡Que tengas buen día! Y recuerda que esta zona\nes parte de nuestra historia.";
    }
    
    @Override
    public void setAction(){
        actionLockCounter ++;
        if(actionLockCounter ==120){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i<=25){
                direction = "up";
            }
            if(i>25 && i<=50){
                direction = "down";
            }
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
