package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import Controlador.Controlador;

/**
 * Ventana donde se inicia la sesion
 * 
 * @author Ismael y Paul
 */
public class VentanaLogin {
	private JFrame frame;
	private JTextField usuario;
	private JTextField contraseina;
	/**
	 * Boton para iniciar
	 */
	public JButton btnIniciar;
	/**
	 * Label de la contrasenya
	 */
	public JLabel lblContrasena;
	/**
	 * label del nombre de usuario
	 */
	public JLabel lblUsuario;
	private Controlador controlador;

	/*
	 * Se activa la inicializacion de la ventana
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Se crea un formulario donde se rellena con los datos solicitados
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 443);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// JLayeredPane para manejar capas
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 687, 443);
		frame.setContentPane(layeredPane);
		layeredPane.setLayout(null);

		// GIF en capa inferior
		ImageIcon gifIcon = new ImageIcon(getClass().getResource("/Imagenes/pacman.gif"));
		JLabel backgroundLabel = new JLabel(gifIcon);
		backgroundLabel.setBounds(0, 0, 645, 443);
		layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER); // capa base

		// Componentes en capa superior
		JLabel lblTitle = new JLabel("LOGIN");
		lblTitle.setForeground(new Color(255, 255, 0));
		lblTitle.setBackground(new Color(128, 0, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblTitle.setBounds(266, 51, 123, 31);
		layeredPane.add(lblTitle, JLayeredPane.PALETTE_LAYER);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(new Color(255, 255, 128));
		lblUsuario.setForeground(new Color(255, 255, 21));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblUsuario.setBounds(221, 132, 88, 13);
		layeredPane.add(lblUsuario, JLayeredPane.PALETTE_LAYER);

		usuario = new JTextField();
		usuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		usuario.setBounds(222, 149, 185, 31);
		layeredPane.add(usuario, JLayeredPane.PALETTE_LAYER);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBackground(new Color(255, 255, 128));
		lblContrasena.setForeground(new Color(255, 255, 21));
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblContrasena.setBounds(221, 213, 88, 13);
		layeredPane.add(lblContrasena, JLayeredPane.PALETTE_LAYER);

		contraseina = new JTextField();
		contraseina.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		contraseina.setBounds(222, 226, 185, 31);
		layeredPane.add(contraseina, JLayeredPane.PALETTE_LAYER);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.comprobarLogin(usuario.getText(), contraseina.getText());
			}
		});
		btnIniciar.setForeground(new Color(0, 0, 0));
		btnIniciar.setBackground(new Color(255, 255, 0));
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnIniciar.setBounds(222, 281, 91, 29);
		layeredPane.add(btnIniciar, JLayeredPane.PALETTE_LAYER);

		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.getRegistrar().MostrarVentana();
			}
		});

		btnCrear.setForeground(new Color(0, 0, 0));
		btnCrear.setBackground(new Color(255, 255, 0));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCrear.setBounds(323, 281, 97, 29);
		layeredPane.add(btnCrear, JLayeredPane.PALETTE_LAYER);
	}

	/**
	 * Se modifica el controlador
	 * 
	 * @param controlador Clase que une las ventanas con el modelo
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * Se recibe el controlador
	 * 
	 * @return controlador Clase que une las ventanas con el modelo
	 */
	public Controlador getControlador() {
		return controlador;
	}

	/**
	 * Se hace visible la ventana
	 */
	public void mostrarVentana() {
		frame.setVisible(true);
	}
}