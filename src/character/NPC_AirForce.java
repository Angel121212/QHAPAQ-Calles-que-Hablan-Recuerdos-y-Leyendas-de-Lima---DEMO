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
public final class NPC_AirForce extends Character {
    public NPC_AirForce(GamePanelSection gps){
        super(gps);
        
        direction = "down";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/airforce/sprite_NPC_Airforce6");
        up2 = setup("/npc/airforce/sprite_NPC_Airforce7");
        down = setup("/npc/airforce/sprite_NPC_Airforce0");
        down2 = setup("/npc/airforce/sprite_NPC_Airforce1");
        left = setup("/npc/airforce/sprite_NPC_Airforce2");
        left2 = setup("/npc/airforce/sprite_NPC_Airforce3");
        right = setup("/npc/airforce/sprite_NPC_Airforce4");
        right2 = setup("/npc/airforce/sprite_NPC_Airforce5");
        
    }
    
    public void setDialogue() {
    dialogues[0] = "Soy de la Fuerza Aérea. Y aunque volamos alto,\ntambién pisamos historia.";
    dialogues[1] = "¿Sabías que la aviación militar del Perú nació en\n1919?\nFuimos pioneros en América Latina.";
    dialogues[2] = "En Lima se fundó la primera escuela de aviación,\ngracias al presidente Leguía.";
    dialogues[3] = "Durante la Guerra con Ecuador, la FAP defendió\ncon honor los cielos del Perú.";
    dialogues[4] = "El Mariscal Cáceres está enterrado cerca, fue\nun héroe que también inspira a la\nFAP.";
    dialogues[5] = "Varios de nuestros aviones han sobrevolado esta\nplaza en fechas patrias. Es un honor.";
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
