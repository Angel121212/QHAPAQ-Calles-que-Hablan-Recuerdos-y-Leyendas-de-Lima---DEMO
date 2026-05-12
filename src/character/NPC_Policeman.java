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
public class NPC_Policeman extends Character{
        
    public NPC_Policeman(GamePanelSection gps){
        super(gps);
        
        direction = "down";
        speed = 1;  
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        /* BEFORE ----up = ImageIO.read(getClass().getResourceAsStream("/player/up_img.png"));*/
        
        up = setup("/npc/policeman/up_img");
        up2 = setup("/npc/policeman/up2_img");
        down = setup("/npc/policeman/down_img");
        down2 = setup("/npc/policeman/down2_img");
        left = setup("/npc/policeman/left_img");
        left2 = setup("/npc/policeman/left2_img");
        right = setup("/npc/policeman/right_img");
        right2 = setup("/npc/policeman/right2_img");
        
    }
    
    public void setDialogue(){
        dialogues[0] = "Hola niño, buenos días";
        dialogues[1] = "¿Donde estan tus padres?";
        dialogues[2] = "Entonces, ¿Estás perdido?";
        dialogues[3] = "Te llevaria a la comisaria, pero ahora estoy en un\noperativo";
        dialogues[4] = "Esta zona esta un poco peligrosa, ve mas adelante\nhasta que encuentres la bandera y ve a la derecha";
        dialogues[5] = "Suerte, avisale al comisario que vas por parte del cavo\n1° Perez Navarro";
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
    
    
    /*
    public BufferedImage setup(String imageName){
        Utility_Tools uTools = new Utility_Tools();
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/"+imageName+".png"));
            image = uTools.scaleImage(image, gps.tileSize, gps.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return image;
    }*/
}
