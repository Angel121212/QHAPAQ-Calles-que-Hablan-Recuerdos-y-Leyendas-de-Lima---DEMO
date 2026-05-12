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
public final class NPC_Citizen_4 extends Character {
     public NPC_Citizen_4(GamePanelSection gps){
        super(gps);
        
        direction = "down";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/citizen_4/sprite_NPC_Citizen_46");
        up2 = setup("/npc/citizen_4/sprite_NPC_Citizen_47");
        down = setup("/npc/citizen_4/sprite_NPC_Citizen_40");
        down2 = setup("/npc/citizen_4/sprite_NPC_Citizen_41");
        left = setup("/npc/citizen_4/sprite_NPC_Citizen_42");
        left2 = setup("/npc/citizen_4/sprite_NPC_Citizen_43");
        right = setup("/npc/citizen_4/sprite_NPC_Citizen_44");
        right2 = setup("/npc/citizen_4/sprite_NPC_Citizen_45");
        
    }
    
    public void setDialogue(){
        dialogues[0] = "Ten cuidado por algunas zonas más adelante, mejor\nsigue por este camino seguro.";
        dialogues[1] = "Ah, y si ves al vendedor de periódicos, ¡devuélvele su\nedición especial!";
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
