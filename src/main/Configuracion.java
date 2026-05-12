/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Path; 

/**
 *
 * @author emili
 */
public class Configuracion {
    GamePanelSection gps;
    public Configuracion(GamePanelSection gps){
        this.gps = gps;
    }
    
    public void guardarConfiguracion(){
        Path saveData = Path.of("configuracion.txt"); 
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(saveData.toFile()));
            
            //Pantalla Completa -Full Screen
            if(gps.fullScreenOn == true){
                bw.write("On");
            }
            if(gps.fullScreenOn == false){
                bw.write("Off");
            }
            bw.newLine();
            
            // Volumen de musica - Music volume
            bw.write(String.valueOf(gps.music.volumeScale));
            bw.newLine();
            
            //SE music - Musica de Efectos de Sonidos
            bw.write(String.valueOf(gps.soundeffect.volumeScale));
            bw.newLine();
            bw.close();
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public void cargarConfiguracion(){
        
        try{
             BufferedReader br = new BufferedReader(new FileReader("configuracion.txt"));
             String s = br.readLine();
             
             
             //Full screen- Pantalla completa
             if(s.equals("On")){
                 gps.fullScreenOn = true;
             }
             if(s.equals("Off")){
                 gps.fullScreenOn = false;
             }
             
             // Music Volume - Volumen de musica
             s = br.readLine();
             gps.music.volumeScale = Integer.parseInt(s);
             
             // SE - Efecto de sonido
             s = br.readLine();
             gps.soundeffect.volumeScale = Integer.parseInt(s);
             br.close();
             
             
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}
