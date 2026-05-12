/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuestionario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class Cuestionario extends JFrame {

    private JLabel lblPregunta;
    private JRadioButton[] opciones;
    private ButtonGroup grupoOpciones;
    private JButton btnResponder;
    private JLabel lblResultado;

    private List<Pregunta> preguntas;
    private int indicePregunta = 0;
    private int puntaje = 0;

    public Cuestionario(){
        setTitle("Formulario Interactiv - Historia de la FAP");
    setSize(1200, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    JPanel panelPrincipal = new PanelConFondo("/cuestionario/Peruanos.png");
    panelPrincipal.setLayout(new BorderLayout(10, 10));
    setContentPane(panelPrincipal);
    
    preguntas = new ArrayList<>();
    cargarPreguntas();

    lblPregunta = new JLabel("", SwingConstants.CENTER);
    lblPregunta.setFont(new Font("SansSerif", Font.BOLD, 28));
    add(lblPregunta, BorderLayout.NORTH);

    // Panel de opciones
    JPanel panelOpciones = new JPanel(new GridLayout(4, 1, 10, 10));
    panelOpciones.setOpaque(false); // fondo transparente
    opciones = new JRadioButton[4];
    grupoOpciones = new ButtonGroup();
    
     JPanel contenedorCentro = new JPanel(new FlowLayout(FlowLayout.CENTER));
    contenedorCentro.setOpaque(false);
    panelOpciones.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 200));
    contenedorCentro.add(panelOpciones);
    add(contenedorCentro, BorderLayout.CENTER);

    for (int i = 0; i < opciones.length; i++) {
    opciones[i] = new JRadioButton();
    opciones[i].setFont(new Font("SansSerif", Font.PLAIN, 40));
    opciones[i].setOpaque(false); // ✅ fondo transparente
    opciones[i].setForeground(Color.BLACK); // ✅ texto visible si el fondo es oscuro
    opciones[i].addActionListener(e -> btnResponder.setEnabled(true));
    grupoOpciones.add(opciones[i]);
    panelOpciones.add(opciones[i]);
}

    add(panelOpciones, BorderLayout.CENTER);

    // Panel inferior
    JPanel panelSur = new JPanel(new GridLayout(2, 1, 5, 5));
    btnResponder = new JButton("Siguiente");
    btnResponder.setFont(new Font("SansSerif", Font.BOLD, 20)); // 🔸 Tamaño grande y negrita
    btnResponder.setEnabled(false);
    lblResultado = new JLabel(" ", SwingConstants.CENTER);
    lblResultado.setFont(new Font("SansSerif", Font.ITALIC, 14));

    btnResponder.addActionListener(e -> {
    // Si aún no se ha validado la respuesta
    if (btnResponder.getText().equals("Responder")) {
        validarRespuesta();
        btnResponder.setText("Siguiente");
    } 
    // Si ya se validó y ahora debe pasar a la siguiente
    else if (btnResponder.getText().equals("Siguiente")) {
        indicePregunta++;
        mostrarPregunta();
        btnResponder.setText("Responder");
    }
});

    panelSur.add(btnResponder);
    panelSur.add(lblResultado);

    add(panelSur, BorderLayout.SOUTH);

    mostrarPregunta();
    }
    
    class PanelConFondo extends JPanel {
    private Image imagen;

    public PanelConFondo(String ruta) {
        try {
            imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
        } catch (Exception e) {
            System.err.println(" No se pudo cargar la imagen: " + ruta);
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


    
    private void cargarPreguntas() {
        preguntas.add(new Pregunta("¿En qué año nació la aviación militar del Perú?",
                new String[]{"1921", "1919", "1940", "1905"}, "1919"));
        preguntas.add(new Pregunta("¿Qué presidente fundó la primera escuela de aviación en Lima?",
                new String[]{"Sánchez Cerro", "Leguía", "Prado", "Belaúnde"}, "Leguía"));
        preguntas.add(new Pregunta("¿Durante qué conflicto la FAP defendió los cielos con honor?",
                new String[]{"Guerra con Chile", "Conflicto del Cenepa", "Guerra con Ecuador", "Revolución del 50"}, "Guerra con Ecuador"));
        preguntas.add(new Pregunta("¿Qué héroe nacional está enterrado cerca y también inspira a la FAP?",
                new String[]{"Miguel Grau", "Túpac Amaru", "Mariscal Cáceres", "Ramón Castilla"}, "Mariscal Cáceres"));
        preguntas.add(new Pregunta("¿En qué ocasión los aviones de la FAP sobrevolaron la plaza?",
                new String[]{"Elecciones", "Fiestas Patrias", "Simulacro Nacional", "Aniversario del Callao"}, "Fiestas Patrias"));
        preguntas.add(new Pregunta("Completa: 'Soy de la Fuerza Aérea, y aunque volamos alto...'",
                new String[]{"siempre regresamos", "miramos abajo", "también pisamos historia", "somos eternos"}, "también pisamos historia"));
        preguntas.add(new Pregunta("¿Qué edificio importante se menciona en el diálogo del Palacio de Gobierno?",
        new String[]{"Congreso", "Palacio de Justicia", "Palacio de Gobierno", "Municipalidad de Lima"}, "Palacio de Gobierno"));
        preguntas.add(new Pregunta("¿Qué héroe nacional fue mencionado por inspirar a la FAP?",
            new String[]{"Ramón Castilla", "Miguel Grau", "Mariscal Cáceres", "Bolognesi"}, "Mariscal Cáceres"));
        preguntas.add(new Pregunta("¿Qué acción se recomienda si ves al vendedor de periódicos?",
            new String[]{"Ignorarlo", "Llamar al policía", "Darle su edición especial", "Comprar un chocolate"}, "Darle su edición especial"));
        preguntas.add(new Pregunta("¿Cómo se llama la plaza mencionada como corazón del centro histórico?",
            new String[]{"Plaza San Martín", "Plaza Grau", "Plaza de Armas", "Plaza Bolognesi"}, "Plaza de Armas"));
        preguntas.add(new Pregunta("¿Qué calle conecta con la Plaza San Martín según el NPC?",
            new String[]{"Jirón de la Unión", "Avenida Brasil", "Jirón Callao", "Jirón Quilca"}, "Jirón de la Unión"));
        preguntas.add(new Pregunta("¿Qué título se le da al centro histórico de Lima según la UNESCO?",
            new String[]{"Reserva Patrimonial", "Zona arqueológica", "Patrimonio Cultural de la Humanidad", "Monumento Nacional"}, "Patrimonio Cultural de la Humanidad"));
        preguntas.add(new Pregunta("¿Qué recomienda el NPC si te interesa la arquitectura?",
            new String[]{"Mirar las iglesias modernas", "Visitar museos", "Fijarse en los balcones coloniales", "Tomar fotos a los semáforos"}, "Fijarse en los balcones coloniales"));
        preguntas.add(new Pregunta("¿Qué ciudad fundó Francisco Pizarro según el NPC?",
            new String[]{"Cusco", "Arequipa", "Trujillo", "Lima"}, "Lima"));

    }

    private void mostrarPregunta() {
    if (indicePregunta >= preguntas.size()) {
        mostrarResultadoFinal();
        return;
    }

    Pregunta p = preguntas.get(indicePregunta);
    lblPregunta.setText(p.getTexto());

    String[] alternativas = p.getAlternativas();
    for (int i = 0; i < opciones.length; i++) {
        opciones[i].setText(alternativas[i]);
        opciones[i].setSelected(false);
        opciones[i].setVisible(true);
    }

    grupoOpciones.clearSelection();
    lblResultado.setText(" ");
    
    // 🔄 Reiniciar botón correctamente
    btnResponder.setText("Responder");
    btnResponder.setEnabled(false); // deshabilitado hasta que selecciones
}



    private void validarRespuesta() {
    String seleccion = null;
    for (JRadioButton opcion : opciones) {
        if (opcion.isSelected()) {
            seleccion = opcion.getText();
            break;
        }
    }

    if (seleccion == null) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una opción.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Pregunta p = preguntas.get(indicePregunta);

    if (p.validarRespuesta(seleccion)) {
        puntaje++;
        lblResultado.setText("✅ ¡Correcto!");
        lblResultado.setForeground(new Color(0, 128, 0));
    } else {
        lblResultado.setText("❌ Incorrecto. Era: " + p.getRespuestaCorrecta());
        lblResultado.setForeground(Color.RED);
    }

    btnResponder.setText("Continuar");
    btnResponder.setEnabled(true); // mantener habilitado para continuar

    
}


    private void mostrarResultadoFinal() {
        lblPregunta.setText("<html><center>Formulario finalizado<br>Puntaje: " + puntaje + "/" + preguntas.size() + "</center></html>");
        for (JRadioButton opcion : opciones) {
            opcion.setVisible(false);
        }
        btnResponder.setEnabled(false);
        lblResultado.setText(puntaje == preguntas.size() ?
                "🎖️ ¡Conoces bien la historia de la FAP!" :
                "📚 Sigue aprendiendo sobre nuestra aviación.");
    }

    // Clase interna para Pregunta
    static class Pregunta {
        private String texto;
        private String[] alternativas;
        private String respuestaCorrecta;

        public Pregunta(String texto, String[] alternativas, String respuestaCorrecta) {
            this.texto = texto;
            this.alternativas = alternativas;
            this.respuestaCorrecta = respuestaCorrecta;
        }

        public String getTexto() {
            return texto;
        }

        public String[] getAlternativas() {
            return alternativas;
        }

        public String getRespuestaCorrecta() {
            return respuestaCorrecta;
        }

        public boolean validarRespuesta(String r) {
            return r.equalsIgnoreCase(respuestaCorrecta);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cuestionario().setVisible(true));
    }
    
    
}
