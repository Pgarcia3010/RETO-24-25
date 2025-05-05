package Vista;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaLogin window = new VentanaLogin();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaLogin() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 660, 443);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear JLayeredPane para manejar capas
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 687, 443);
        frame.setContentPane(layeredPane);
        layeredPane.setLayout(null);

        // Fondo GIF en capa inferior
        ImageIcon gifIcon = new ImageIcon(getClass().getResource("/Imagenes/pacman.gif"));
        JLabel backgroundLabel = new JLabel(gifIcon);
        backgroundLabel.setBounds(0, 0, 687, 443);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER); // capa base

        // Componentes en capa superior
        JLabel lblTitle = new JLabel("Login");
        lblTitle.setForeground(new Color(250, 189, 5));
        lblTitle.setBackground(new Color(255, 128, 64));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
        lblTitle.setBounds(266, 51, 123, 31);
        layeredPane.add(lblTitle, JLayeredPane.PALETTE_LAYER);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBackground(new Color(255, 255, 0));
        lblUsuario.setForeground(new Color(250, 189, 5));
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblUsuario.setBounds(221, 132, 88, 13);
        layeredPane.add(lblUsuario, JLayeredPane.PALETTE_LAYER);

        textField = new JTextField();
        textField.setBounds(222, 149, 185, 31);
        layeredPane.add(textField, JLayeredPane.PALETTE_LAYER);

        JLabel lblContrasena = new JLabel("Contraseña");
        lblContrasena.setBackground(new Color(255, 255, 0));
        lblContrasena.setForeground(new Color(250, 189, 5));
        lblContrasena.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblContrasena.setBounds(221, 213, 88, 13);
        layeredPane.add(lblContrasena, JLayeredPane.PALETTE_LAYER);

        textField_1 = new JTextField();
        textField_1.setBounds(222, 226, 185, 31);
        layeredPane.add(textField_1, JLayeredPane.PALETTE_LAYER);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setForeground(new Color(0, 0, 0));
        btnIniciar.setBackground(new Color(250, 189, 5));
        btnIniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        btnIniciar.setBounds(222, 281, 91, 29);
        layeredPane.add(btnIniciar, JLayeredPane.PALETTE_LAYER);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaRegistrar ver = new VentanaRegistrar();
        		ver.MostrarVentana();
        	}
        });
        btnCrear.setForeground(new Color(0, 0, 0));
        btnCrear.setBackground(new Color(250, 189, 5));
        btnCrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        btnCrear.setBounds(323, 281, 97, 29);
        layeredPane.add(btnCrear, JLayeredPane.PALETTE_LAYER);
    }
}

