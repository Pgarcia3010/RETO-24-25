package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.Producto;

/**
 * Ventana para la administracion de productos
 */
public class TablaAdministrarProductos {

	private JFrame frame;
	private JTable tablaProducEmple;
	private JTextField ResultadoId;
	private Controlador controlador;

	/**
	 * Se activa la inicializacion
	 */
	public TablaAdministrarProductos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(128, 0, 255));
		frame.setBounds(100, 100, 852, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Titulo = DefaultComponentFactory.getInstance().createLabel("Administrar Productos");
		Titulo.setBackground(new Color(255, 255, 255));
		Titulo.setForeground(new Color(128, 0, 255));
		Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		Titulo.setBounds(10, 10, 278, 29);
		frame.getContentPane().add(Titulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 63, 745, 229);
		frame.getContentPane().add(scrollPane);

		tablaProducEmple = new JTable();
		tablaProducEmple.setForeground(new Color(255, 255, 0));
		tablaProducEmple.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		tablaProducEmple.setBackground(new Color(128, 0, 255));
		tablaProducEmple.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//			},
//			new String[] {
//				"IdProducto", "NombreProducto", "Precio", "Stock"
//			}
		));

		scrollPane.setViewportView(tablaProducEmple);

		JButton btnFiltro = new JButton("Filtro ID");
		btnFiltro.setBackground(new Color(240, 240, 240));
		btnFiltro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnFiltro.setBounds(266, 302, 101, 21);
		frame.getContentPane().add(btnFiltro);

		JButton btnFiltro2 = new JButton("Filtro Stock");
		btnFiltro2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnFiltro2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnFiltro2.setBounds(401, 302, 111, 21);
		frame.getContentPane().add(btnFiltro2);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setBackground(new Color(128, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnVolver.setBounds(22, 458, 85, 21);
		frame.getContentPane().add(btnVolver);

		ResultadoId = new JTextField();
		ResultadoId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		ResultadoId.setBounds(148, 380, 158, 19);
		frame.getContentPane().add(ResultadoId);
		ResultadoId.setColumns(10);

		JLabel titulo = DefaultComponentFactory.getInstance().createLabel("Id Producto:");
		titulo.setForeground(new Color(128, 0, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		titulo.setBounds(148, 367, 101, 13);
		frame.getContentPane().add(titulo);

		JButton btnseleccionar = new JButton("");

		ImageIcon imtbtn = new ImageIcon(getClass().getResource("/Imagenes/editar.png"));
		btnseleccionar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		Image img1 = imtbtn.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		btnseleccionar.setIcon(new ImageIcon(img1));

		btnseleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = ResultadoId.getText();

				if (id != null) {

					Producto produElegido = new Producto();
					produElegido.setIdProducto(id);

					controlador.setProduelegido(produElegido);
					controlador.getAdministrarProductos().MostrarVentana();

				} else {

				}

			}
		});
		btnseleccionar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnseleccionar.setBounds(440, 361, 111, 83);
		frame.getContentPane().add(btnseleccionar);

		JButton btnEliminar = new JButton("");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/basura.jpg"));

		Image img = iconoEliminar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		btnEliminar.setIcon(new ImageIcon(img));

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = ResultadoId.getText();

				Producto produ = new Producto();
				produ.setIdProducto(id);

				try {
					controlador.eliminarProdu(produ);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnEliminar.setBounds(590, 361, 101, 83);
		frame.getContentPane().add(btnEliminar);
	}

	/**
	 * se rellena la tabla de la ventan
	 * 
	 * @param producList array de tipo Producto
	 */
	public void setTabla(ArrayList<Producto> producList) {

		DefaultTableModel model = new DefaultTableModel(
				new String[] { "IdProducto", "NombreProducto", "Precio", "Stock" }, 0

		);

		for (int i = 0; i < producList.size(); i++) {

			Producto produ = producList.get(i);

			model.addRow(new Object[] {

					produ.getIdProducto(), produ.getNombreProducto(), produ.getPrecio(), produ.getStock()

			});

		}

		tablaProducEmple.setModel(model);

		JTableHeader tituloTabla = tablaProducEmple.getTableHeader();
		tituloTabla.setFont(new Font("Tahoma", Font.BOLD, 14));
		tituloTabla.setBackground(Color.BLACK);
		tituloTabla.setForeground(new Color(128, 0, 255));

	}

	/**
	 * Se hace visible la ventana
	 */
	public void MostrarVentana() {

		frame.setVisible(true);

	}

	/**
	 * recibe controlador
	 * 
	 * @return controlador Clase que une las ventanas con el modelo
	 */
	public Controlador getControlador() {
		return controlador;
	}

	/**
	 * modifica controlador
	 * 
	 * @param controlador Clase que une las ventanas con el modelo
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
