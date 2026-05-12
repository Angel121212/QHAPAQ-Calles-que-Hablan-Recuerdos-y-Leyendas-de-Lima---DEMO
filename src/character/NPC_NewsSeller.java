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
public final class NPC_NewsSeller extends Character{
    public NPC_NewsSeller(GamePanelSection gps){
        super(gps);
        
        direction = "right";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/newsseller/sprite_NPC_Newsseller6");
        up2 = setup("/npc/newsseller/sprite_NPC_Newsseller7");
        down = setup("/npc/newsseller/sprite_NPC_Newsseller0");
        down2 = setup("/npc/newsseller/sprite_NPC_Newsseller1");
        left = setup("/npc/newsseller/sprite_NPC_Newsseller2");
        left2 = setup("/npc/newsseller/sprite_NPC_Newsseller3");
        right = setup("/npc/newsseller/sprite_NPC_Newsseller4");
        right2 = setup("/npc/newsseller/sprite_NPC_Newsseller5");
        
    }
    
    public void setDialogue(){
        dialogues[0] = "¡Periódico, periódico!\nNoticias frescas del Perú por solo una moneda.";
        dialogues[1] = "Hoy salió una nota sobre el presidente y la educación.\n¡Está buenaza!";
        dialogues[2] = "Oye, creo que perdí uno de mis periódicos por aquí...\n¡era una edición especial!";
        dialogues[3] = "Si lo encuentras, por favor tráemelo. ¡Te daré una\nsorpresa como recompensa!";
        dialogues[4] = "Mientras tanto, ¡lleva tu periódico del día con noticias\ny hasta una historieta!";
    }
    
    @Override
    public void setAction(){
        actionLockCounter ++;
        if(actionLockCounter ==20){
            Random random = new Random();
            int i = random.nextInt(30)+1;
            if(i<=15){
                direction = "up";
            }
            if(i>15 && i<=20){
                direction = "down";
            }
            if(i>20 && i <=25){
                direction = "left";
            }
            if(i>25 && i<=30){
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
