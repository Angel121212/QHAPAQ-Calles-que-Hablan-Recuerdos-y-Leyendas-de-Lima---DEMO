/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import character.NPC_AirForce;
import character.NPC_Citizen1;
import character.NPC_Citizen_2;
import character.NPC_Citizen_3;
import character.NPC_Citizen_4;
import character.NPC_Policeman;
import character.NPC_UsarJunin;
import character.NPC_NewsSeller;
import character.NPC_TapadasLima;
import object.OBJ_Flag;
import object.OBJ_News1;
import object.OBJ_News2;
import object.OBJ_News3;
import object.OBJ_StreetLantern;
/**
 *
 * @author emili
 */
public class AssetSetter {
    GamePanelSection gps;
    
    public AssetSetter(GamePanelSection gps){
        this.gps = gps;
    }
    
    public void setObject(){
        gps.obj[0] = new OBJ_Flag();
        gps.obj[0].worldX = gps.tileSize*23;
        gps.obj[0].worldY = gps.tileSize*21;
        gps.obj[0].collision = true;
        
        
        gps.obj[1] = new OBJ_News1();
        gps.obj[1].worldX = gps.tileSize*25;
        gps.obj[1].worldY = gps.tileSize*18;
        gps.obj[1].collision = false;
        
        gps.obj[2] = new OBJ_News2();
        gps.obj[2].worldX = gps.tileSize*25;
        gps.obj[2].worldY = gps.tileSize*19;
        gps.obj[2].collision = false;
        
        gps.obj[3] = new OBJ_News3();
        gps.obj[3].worldX = gps.tileSize*26;
        gps.obj[3].worldY = gps.tileSize*19;
        gps.obj[3].collision = false;
        
        gps.obj[4] = new OBJ_StreetLantern();
        gps.obj[4].worldX = gps.tileSize*27;
        gps.obj[4].worldY = gps.tileSize*12;
        gps.obj[4].collision = true;
        
        gps.obj[5] = new OBJ_StreetLantern();
        gps.obj[5].worldX = gps.tileSize*19;
        gps.obj[5].worldY = gps.tileSize*12;
        gps.obj[5].collision = true;
        
        gps.obj[6] = new OBJ_StreetLantern();
        gps.obj[6].worldX = gps.tileSize*31;
        gps.obj[6].worldY = gps.tileSize*16;
        gps.obj[6].collision = true;
        
        gps.obj[7] = new OBJ_StreetLantern();
        gps.obj[7].worldX = gps.tileSize*31;
        gps.obj[7].worldY = gps.tileSize*26;
        gps.obj[7].collision = true;
        
        gps.obj[8] = new OBJ_News1();
        gps.obj[8].worldX = gps.tileSize*15;
        gps.obj[8].worldY = gps.tileSize*12;
        gps.obj[8].collision = true;
        
    }
    public void setNPC() {
       
        gps.npc[0] = new NPC_Policeman(gps);
        gps.npc[0].worldX = gps.tileSize*26;
        gps.npc[0].worldY = gps.tileSize*31;
        
        gps.npc[1] = new NPC_Policeman(gps);
        gps.npc[1].worldX = gps.tileSize*27;
        gps.npc[1].worldY = gps.tileSize*30;
        
        gps.npc[2] = new NPC_Citizen1(gps);
        gps.npc[2].worldX = gps.tileSize*24;
        gps.npc[2].worldY = gps.tileSize*25;
        
        gps.npc[3] = new NPC_UsarJunin(gps);
        gps.npc[3].worldX = gps.tileSize*21;
        gps.npc[3].worldY = gps.tileSize*12;
        
        gps.npc[4] = new NPC_NewsSeller(gps);
        gps.npc[4].worldX = gps.tileSize*26;
        gps.npc[4].worldY = gps.tileSize*18;
        
        gps.npc[5] = new NPC_Citizen_2(gps);
        gps.npc[5].worldX = gps.tileSize*21;
        gps.npc[5].worldY = gps.tileSize*22;
        
        gps.npc[6] = new NPC_Citizen_3(gps);
        gps.npc[6].worldX = gps.tileSize*21;
        gps.npc[6].worldY = gps.tileSize*22;
        
        gps.npc[7] = new NPC_Citizen_4(gps);
        gps.npc[7].worldX = gps.tileSize*21;
        gps.npc[7].worldY = gps.tileSize*22;
        
        gps.npc[8] = new NPC_TapadasLima(gps);
        gps.npc[8].worldX = gps.tileSize*32;
        gps.npc[8].worldY = gps.tileSize*22;
        
        gps.npc[9] = new NPC_Policeman(gps);
        gps.npc[9].worldX = gps.tileSize*28;
        gps.npc[9].worldY = gps.tileSize*30;
        
        gps.npc[10] = new NPC_Policeman(gps);
        gps.npc[10].worldX = gps.tileSize*26;
        gps.npc[10].worldY = gps.tileSize*29;
        
        
        gps.npc[11] = new NPC_TapadasLima(gps);
        gps.npc[11].worldX = gps.tileSize*32;
        gps.npc[11].worldY = gps.tileSize*22;
        
        
        gps.npc[12] = new NPC_TapadasLima(gps);
        gps.npc[12].worldX = gps.tileSize*32;
        gps.npc[12].worldY = gps.tileSize*22;
       
        
        gps.npc[13] = new NPC_TapadasLima(gps);
        gps.npc[13].worldX = gps.tileSize*32;
        gps.npc[13].worldY = gps.tileSize*22;
        
        gps.npc[14] = new NPC_AirForce(gps);
        gps.npc[14].worldX = gps.tileSize*37;
        gps.npc[14].worldY = gps.tileSize*27;
    }
    
}
