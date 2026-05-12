/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import javax.swing.JFrame;
/**
 *
 * @author emili
 */
public class Main {
    public static JFrame window;
    public static void main(String[] args) {
        javafx.application.Application.launch(VideoIntro.class);
    }
    
    public static void launchGameWindow() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("QHAPAQ | Calles que Hablan: Recuerdos y Leyendas de Lima");

        GamePanelSection gamepanelsection = new GamePanelSection();
        window.add(gamepanelsection);

        gamepanelsection.configuracion.cargarConfiguracion();
        if (gamepanelsection.fullScreenOn) {
            window.setUndecorated(true);
        }

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanelsection.setupGame();
        gamepanelsection.startGameThread();
    }
}
