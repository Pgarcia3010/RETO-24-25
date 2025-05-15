package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

//import Controlador.Controlador;

public class VentanaRegistrar {

	public JFrame frame;
	public JTextField Rnombre;
	public JTextField Rusuario;
	public JTextField Rcontraseina;
	public JTextField Rtelefono;
	public JTextField Rdireccion;
	public JButton btnCrear2;
//	public Controlador controlador;

	public VentanaRegistrar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 570, 550);
		frame.setContentPane(layeredPane);
		layeredPane.setLayout(null);

		// Fondo GIF redimensionado
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Imagenes/pacman.gif"));
		Image image = originalIcon.getImage().getScaledInstance(570, 550, Image.SCALE_DEFAULT);
		ImageIcon resizedIcon = new ImageIcon(image);
		JLabel backgroundLabel = new JLabel(resizedIcon);
		backgroundLabel.setBounds(0, 0, 570, 550);
		layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

		JLabel lblTitle = new JLabel("REGISTRO");
		lblTitle.setForeground(new Color(128, 0, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblTitle.setBounds(220, 40, 173, 31);
		layeredPane.add(lblTitle, JLayeredPane.PALETTE_LAYER);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 128));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNombre.setBounds(198, 110, 88, 13);
		layeredPane.add(lblNombre, JLayeredPane.PALETTE_LAYER);

		Rnombre = new JTextField();
		Rnombre.setBounds(198, 125, 145, 27);
		layeredPane.add(Rnombre, JLayeredPane.PALETTE_LAYER);

		JLabel lblTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 255, 128));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTelefono.setBounds(198, 162, 88, 13);
		layeredPane.add(lblTelefono, JLayeredPane.PALETTE_LAYER);

		Rtelefono = new JTextField();
		Rtelefono.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Rtelefono.setBounds(198, 177, 145, 27);
		layeredPane.add(Rtelefono, JLayeredPane.PALETTE_LAYER);

		JLabel lblDireccion = DefaultComponentFactory.getInstance().createLabel("Direccion");
		lblDireccion.setForeground(new Color(255, 255, 128));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDireccion.setBounds(198, 212, 88, 13);
		layeredPane.add(lblDireccion, JLayeredPane.PALETTE_LAYER);

		Rdireccion = new JTextField();
		Rdireccion.setBounds(198, 227, 145, 27);
		layeredPane.add(Rdireccion, JLayeredPane.PALETTE_LAYER);

		JLabel lblUsuario = DefaultComponentFactory.getInstance().createLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 128));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblUsuario.setBounds(198, 264, 88, 13);
		layeredPane.add(lblUsuario, JLayeredPane.PALETTE_LAYER);

		Rusuario = new JTextField();
		Rusuario.setBounds(198, 279, 145, 27);
		layeredPane.add(Rusuario, JLayeredPane.PALETTE_LAYER);

		JLabel lblContrasenia = DefaultComponentFactory.getInstance().createLabel("Contraseña");
		lblContrasenia.setForeground(new Color(255, 255, 128));
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblContrasenia.setBounds(198, 314, 88, 13);
		layeredPane.add(lblContrasenia, JLayeredPane.PALETTE_LAYER);

		Rcontraseina = new JTextField();
		Rcontraseina.setBounds(198, 329, 145, 27);
		layeredPane.add(Rcontraseina, JLayeredPane.PALETTE_LAYER);

		JButton BtnVolver = new JButton("Volver");
		BtnVolver.setBackground(new Color(255, 255, 53));
		BtnVolver.setForeground(Color.BLACK);
		BtnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		BtnVolver.setBounds(157, 395, 93, 29);
		BtnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		layeredPane.add(BtnVolver, JLayeredPane.PALETTE_LAYER);

		btnCrear2 = new JButton("Crear");
		btnCrear2.setBackground(new Color(255, 255, 53));
		btnCrear2.setForeground(Color.BLACK);
		btnCrear2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCrear2.setBounds(294, 395, 99, 29);
		layeredPane.add(btnCrear2, JLayeredPane.PALETTE_LAYER);
	}

	/*public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}*/

	public void MostrarVentana() {
		frame.setVisible(true);
	}
}
