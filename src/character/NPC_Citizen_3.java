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
public final class NPC_Citizen_3 extends Character{
     public NPC_Citizen_3(GamePanelSection gps){
        super(gps);
        
        direction = "up";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/citizen_3/sprite_NPC_Citizen_36");
        up2 = setup("/npc/citizen_3/sprite_NPC_Citizen_37");
        down = setup("/npc/citizen_3/sprite_NPC_Citizen_30");
        down2 = setup("/npc/citizen_3/sprite_NPC_Citizen_31");
        left = setup("/npc/citizen_3/sprite_NPC_Citizen_32");
        left2 = setup("/npc/citizen_3/sprite_NPC_Citizen_33");
        right = setup("/npc/citizen_3/sprite_NPC_Citizen_34");
        right2 = setup("/npc/citizen_3/sprite_NPC_Citizen_35");
        
    }
    
    public void setDialogue() {
    dialogues[0] = "¡Buenos días! ¿Primera vez en Lima? Esta ciudad tiene\nmucha historia.";
    dialogues[1] = "Estás en la Plaza de Armas, el corazón del Centro\nHistórico de Lima, fundada en 1535.";
    dialogues[2] = "Aquí fue donde Francisco Pizarro proclamó la fundación\nde la ciudad como 'La Ciudad de los Reyes'.";
    dialogues[3] = "A tu alrededor verás edificios históricos como el Palacio\nde Gobierno,la Catedral de Lima y el Palacio Municipal.";
    dialogues[4] = "Si te interesa la arquitectura, fíjate en los balcones\ncoloniales, muchos tienen más de 200 años.";
    dialogues[5] = "Si buscas lugares bonitos, ve por la Plaza Mayor y luego\ncruza hacia el Jirón de la Unión.";
    dialogues[6] = "Ese jirón conecta con otros puntos importantes como la\nPlaza San Martín, llena de historia.";
    dialogues[7] = "¿Sabías que todo este centro histórico fue declarado\nPatrimonio Cultural de la Humanidad por la UNESCO?";
    dialogues[8] = "Tómate tu tiempo, recorre con calma, cada rincón tiene\n algo que contar";
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
