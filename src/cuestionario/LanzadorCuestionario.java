/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuestionario;

/**
 *
 * @author Asus
 */
import javax.swing.SwingUtilities;

public class LanzadorCuestionario {
    public static void lanzar() {
        SwingUtilities.invokeLater(() -> {
            new Cuestionario().setVisible(true);
        });
    }
}
