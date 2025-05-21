package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.Producto;

public class AdministrarProductos {

	private JFrame frame;
	private JTextField Rid;
	private JTextField RNombre;
	private JTextField Rprecio;
	private JTextField Rstock;
	private Controlador controlador;

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

		JLabel lblNombre = new JLabel("Id");
		lblNombre.setForeground(new Color(128, 0, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNombre.setBounds(155, 142, 88, 13);
		layeredPane.add(lblNombre, JLayeredPane.PALETTE_LAYER);

		Rid = new JTextField();
		Rid.setBounds(155, 155, 145, 27);
		layeredPane.add(Rid, JLayeredPane.PALETTE_LAYER);

		JLabel lblUsuario = DefaultComponentFactory.getInstance().createLabel("Nombre");
		lblUsuario.setForeground(new Color(128, 0, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblUsuario.setBounds(155, 192, 88, 13);
		layeredPane.add(lblUsuario, JLayeredPane.PALETTE_LAYER);

		RNombre = new JTextField();
		RNombre.setBounds(155, 203, 145, 27);
		layeredPane.add(RNombre, JLayeredPane.PALETTE_LAYER);

		JLabel lblContrasenia = DefaultComponentFactory.getInstance().createLabel("Precio");
		lblContrasenia.setForeground(new Color(128, 0, 255));
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblContrasenia.setBounds(155, 240, 88, 13);
		layeredPane.add(lblContrasenia, JLayeredPane.PALETTE_LAYER);

		Rprecio = new JTextField();
		Rprecio.setBounds(155, 252, 145, 27);
		layeredPane.add(Rprecio, JLayeredPane.PALETTE_LAYER);

		JLabel lblTelefono = DefaultComponentFactory.getInstance().createLabel("Stock");
		lblTelefono.setForeground(new Color(128, 0, 255));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTelefono.setBounds(155, 285, 88, 13);
		layeredPane.add(lblTelefono, JLayeredPane.PALETTE_LAYER);

		Rstock = new JTextField();
		Rstock.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Rstock.setBounds(155, 298, 145, 27);
		layeredPane.add(Rstock, JLayeredPane.PALETTE_LAYER);

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
		ImageIcon imtbtn = new ImageIcon(getClass().getResource("/Imagenes/editar.png"));
		Image img1 = imtbtn.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		btnCrear.setIcon(new ImageIcon(img1));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto produViejo = controlador.getProduelegido();
				String id = Rid.getText();
				String nombre = RNombre.getText();
				int precio =Integer.parseInt( Rprecio.getText());
				int stock = Integer.parseInt(Rstock.getText());
				
				Producto produ = new Producto();
				produ.setIdProducto(id);
				produ.setNombreProducto(nombre);
				produ.setPrecio(precio);
				produ.setStock(stock);
				
				
				try {
					controlador.comprobarModificacion(produ,produViejo);
					frame.dispose();
				} catch (SQLException e1) {
					System.err.println("ERROR,al intentar modificar un producto");
				}
				
				
				
				
				
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

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	
}
