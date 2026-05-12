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
public final class NPC_Citizen_2 extends Character{
     public NPC_Citizen_2(GamePanelSection gps){
        super(gps);
        
        direction = "right";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/citizen_2/sprite_NPC_Citizen_26");
        up2 = setup("/npc/citizen_2/sprite_NPC_Citizen_27");
        down = setup("/npc/citizen_2/sprite_NPC_Citizen_20");
        down2 = setup("/npc/citizen_2/sprite_NPC_Citizen_21");
        left = setup("/npc/citizen_2/sprite_NPC_Citizen_22");
        left2 = setup("/npc/citizen_2/sprite_NPC_Citizen_23");
        right = setup("/npc/citizen_2/sprite_NPC_Citizen_24");
        right2 = setup("/npc/citizen_2/sprite_NPC_Citizen_25");
        
    }
    
    public void setDialogue() {
    dialogues[0] = "Aquí, en esta plaza, Francisco Pizarro fundó Lima\nen 1535.";
    dialogues[1] = "La Catedral que ves fue reconstruida varias veces\ndespués de terremotos.";
    dialogues[2] = "En la época virreinal, la Plaza era usada para fiestas\ny castigos públicos.";
    dialogues[3] = "Ese edificio elegante es el Palacio de Gobierno, sede del\npresidente del Perú.";
    dialogues[4] = "¿Ves los balcones?\nSon coloniales. Lima tiene más de 1,600 de ellos.";
    dialogues[5] = "Toda esta zona fue declarada Patrimonio Cultural de la\nHumanidad por la UNESCO.";
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
