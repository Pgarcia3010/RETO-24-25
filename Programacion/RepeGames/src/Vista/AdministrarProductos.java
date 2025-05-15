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

public class AdministrarProductos {

	private JFrame frame;
	private JTextField Rnombre;
	private JTextField Rusuario;
	private JTextField Rcontraseina;
	private JTextField Rtelefono;

	public AdministrarProductos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 550);
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

		JLabel lblTitle = new JLabel("Administrar productos");
		lblTitle.setForeground(new Color(128, 0, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblTitle.setBounds(69, 25, 307, 110);
		layeredPane.add(lblTitle, JLayeredPane.PALETTE_LAYER);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(128, 0, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNombre.setBounds(155, 142, 88, 13);
		layeredPane.add(lblNombre, JLayeredPane.PALETTE_LAYER);

		Rnombre = new JTextField();
		Rnombre.setBounds(155, 155, 145, 27);
		layeredPane.add(Rnombre, JLayeredPane.PALETTE_LAYER);

		JLabel lblUsuario = DefaultComponentFactory.getInstance().createLabel("Usuario");
		lblUsuario.setForeground(new Color(128, 0, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblUsuario.setBounds(155, 192, 88, 13);
		layeredPane.add(lblUsuario, JLayeredPane.PALETTE_LAYER);

		Rusuario = new JTextField();
		Rusuario.setBounds(155, 203, 145, 27);
		layeredPane.add(Rusuario, JLayeredPane.PALETTE_LAYER);

		JLabel lblContrasenia = DefaultComponentFactory.getInstance().createLabel("Contraseña");
		lblContrasenia.setForeground(new Color(128, 0, 255));
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblContrasenia.setBounds(155, 240, 88, 13);
		layeredPane.add(lblContrasenia, JLayeredPane.PALETTE_LAYER);

		Rcontraseina = new JTextField();
		Rcontraseina.setBounds(155, 252, 145, 27);
		layeredPane.add(Rcontraseina, JLayeredPane.PALETTE_LAYER);

		JLabel lblTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono");
		lblTelefono.setForeground(new Color(128, 0, 255));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTelefono.setBounds(155, 285, 88, 13);
		layeredPane.add(lblTelefono, JLayeredPane.PALETTE_LAYER);

		Rtelefono = new JTextField();
		Rtelefono.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Rtelefono.setBounds(155, 298, 145, 27);
		layeredPane.add(Rtelefono, JLayeredPane.PALETTE_LAYER);

		JButton BtnVolver = new JButton("Volver");
		BtnVolver.setBackground(new Color(128, 0, 255));
		BtnVolver.setForeground(Color.WHITE);
		BtnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		BtnVolver.setBounds(29, 462, 93, 29);
		BtnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		layeredPane.add(BtnVolver, JLayeredPane.PALETTE_LAYER);

		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrear.setBackground(new Color(128, 0, 255));
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCrear.setBounds(178, 366, 99, 93);
		layeredPane.add(btnCrear, JLayeredPane.PALETTE_LAYER);
	}

	public void MostrarVentana() {
		frame.setVisible(true);
	}
}
