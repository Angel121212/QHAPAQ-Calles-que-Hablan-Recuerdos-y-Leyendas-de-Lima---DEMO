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
public final class NPC_TapadasLima extends Character{
     public NPC_TapadasLima(GamePanelSection gps){
        super(gps);
        
        direction = "left";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/tapada/sprite_NPC_TapadasLima6");
        up2 = setup("/npc/tapada/sprite_NPC_TapadasLima7");
        down = setup("/npc/tapada/sprite_NPC_TapadasLima0");
        down2 = setup("/npc/tapada/sprite_NPC_TapadasLima1");
        left = setup("/npc/tapada/sprite_NPC_TapadasLima2");
        left2 = setup("/npc/tapada/sprite_NPC_TapadasLima3");
        right = setup("/npc/tapada/sprite_NPC_TapadasLima4");
        right2 = setup("/npc/tapada/sprite_NPC_TapadasLima5");
        
    }
    
    public void setDialogue(){
        dialogues[0] = "Hola, soy una Tapada de Lima, una tradición muy\nespecial de nuestra historia.";
        dialogues[1] = "Vestimos mantos largos y una saya para cubrirnos, solo\nmostrando un ojo.";
        dialogues[2] = "En el siglo XIX, usábamos esta vestimenta para salir a la\ncalle con libertad y misterio.";
        dialogues[3] = "Hoy ya no se usa como antes, pero seguimos\nrepresentando parte del alma limeña.";
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
