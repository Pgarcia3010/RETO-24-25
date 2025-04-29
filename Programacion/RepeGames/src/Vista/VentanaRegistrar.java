package Login;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaRegistrar {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaRegistrar window = new VentanaRegistrar();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public VentanaRegistrar() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 570, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // --- Agregar fondo de imagen con el logo y estrellas ---
        // Asegúrate de que la ruta sea correcta (relativa o absoluta)
        ImageIcon fondo = new ImageIcon("C:\\Users\\1AW3-22\\eclipse-workspace\\RepeGames\\src\\Fondo.png");

        // Crear JLabel con la imagen y colocarlo ocupando toda la ventana
        JLabel fondoLabel = new JLabel(fondo);
        fondoLabel.setBounds(0, 0, 556, 384); // mismo tamaño que la ventana

        // Agregar el JLabel al frame
        frame.getContentPane().add(fondoLabel);
        // --- Fin del fondo ---
    }
    
    public void MostrarVentana() {
    	
    	frame.setVisible(true);
    }
    
}

