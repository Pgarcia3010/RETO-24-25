package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaRegistrar {

	private JFrame frame;
	private JTextField Rnombre;
	private JTextField Rusuario;
	private JTextField Rcontraseina;
	private JTextField Rtelefono;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				VentanaRegistrar window = new VentanaRegistrar();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
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
		frame.setBounds(100, 100, 570, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Crear JLayeredPane para manejar capas
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 570, 550);
		frame.setContentPane(layeredPane);
		layeredPane.setLayout(null);

		// Fondo GIF en capa inferior
		ImageIcon gifIcon = new ImageIcon(getClass().getResource("/Imagenes/pacman.gif"));
		JLabel backgroundLabel = new JLabel(gifIcon);
		backgroundLabel.setBounds(0, 0, 570, 550); // Tamaño inicial de tu frame
		layeredPane.add(backgroundLabel, Integer.valueOf(0)); // Fondo en capa más baja

		// Ajustar tamaño del fondo automáticamente al cambiar el tamaño del frame
		frame.addComponentListener(new java.awt.event.ComponentAdapter() {
		    public void componentResized(java.awt.event.ComponentEvent evt) {
		        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		    }
		});


		// Componentes en capa superior
		JLabel lblTitle = new JLabel("LOGIN");
		lblTitle.setForeground(new Color(128, 0, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblTitle.setBounds(220, 40, 123, 31);
		layeredPane.add(lblTitle, JLayeredPane.PALETTE_LAYER);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(128, 0, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNombre.setBounds(198, 110, 88, 13);
		layeredPane.add(lblNombre, JLayeredPane.PALETTE_LAYER);

		Rnombre = new JTextField();
		Rnombre.setBounds(198, 125, 145, 27);
		layeredPane.add(Rnombre, JLayeredPane.PALETTE_LAYER);

		JLabel lblUsuario = DefaultComponentFactory.getInstance().createLabel("Usuario");
		lblUsuario.setForeground(new Color(128, 0, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblUsuario.setBounds(198, 160, 88, 13);
		layeredPane.add(lblUsuario, JLayeredPane.PALETTE_LAYER);

		Rusuario = new JTextField();
		Rusuario.setBounds(198, 175, 145, 27);
		layeredPane.add(Rusuario, JLayeredPane.PALETTE_LAYER);

		JLabel lblContrasenia = DefaultComponentFactory.getInstance().createLabel("Contraseña");
		lblContrasenia.setForeground(new Color(128, 0, 255));
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblContrasenia.setBounds(198, 210, 88, 13);
		layeredPane.add(lblContrasenia, JLayeredPane.PALETTE_LAYER);

		Rcontraseina = new JTextField();
		Rcontraseina.setBounds(198, 225, 145, 27);
		layeredPane.add(Rcontraseina, JLayeredPane.PALETTE_LAYER);

		JLabel lblTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono");
		lblTelefono.setForeground(new Color(128, 0, 255));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTelefono.setBounds(198, 260, 88, 13);
		layeredPane.add(lblTelefono, JLayeredPane.PALETTE_LAYER);

		Rtelefono = new JTextField();
		Rtelefono.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Rtelefono.setBounds(198, 275, 145, 27);
		layeredPane.add(Rtelefono, JLayeredPane.PALETTE_LAYER);

		JLabel lblDireccion = DefaultComponentFactory.getInstance().createLabel("Direccion");
		lblDireccion.setForeground(new Color(128, 0, 255));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDireccion.setBounds(198, 310, 88, 13);
		layeredPane.add(lblDireccion, JLayeredPane.PALETTE_LAYER);

		textField = new JTextField();
		textField.setBounds(198, 325, 145, 27);
		layeredPane.add(textField, JLayeredPane.PALETTE_LAYER);

		JButton BtnVolver = new JButton("Volver");
		BtnVolver.setBackground(new Color(128, 0, 255));
		BtnVolver.setForeground(new Color(255, 255, 255));
		BtnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		BtnVolver.setBounds(157, 395, 93, 29);
		BtnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		layeredPane.add(BtnVolver, JLayeredPane.PALETTE_LAYER);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBackground(new Color(128, 0, 255));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCrear.setBounds(294, 395, 99, 29);
		layeredPane.add(btnCrear, JLayeredPane.PALETTE_LAYER);
	}

	public void MostrarVentana() {
		frame.setVisible(true);
	}
}
