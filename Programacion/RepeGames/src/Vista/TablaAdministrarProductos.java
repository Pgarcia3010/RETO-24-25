package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Modelo.Producto;

public class TablaAdministrarProductos {

	public JFrame frame;
	public JTable tablaProducEmple;
	public JTextField ResultadoId;
	public JComboBox filtroId;
	public JComboBox filtroStock;

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
		));

		scrollPane.setViewportView(tablaProducEmple);

		filtroId = new JComboBox();
		filtroId.setBackground(new Color(240, 240, 240));
		filtroId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		filtroId.setBounds(266, 302, 101, 21);
		frame.getContentPane().add(filtroId);
		

		filtroStock = new JComboBox();
		filtroStock.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		filtroStock.setBounds(401, 302, 111, 21);
		frame.getContentPane().add(filtroStock);

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

		JButton btnseleccionar = new JButton("Selecionado");
		btnseleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarProductos ver = new AdministrarProductos();
				ver.MostrarVentana();
			}
		});
		btnseleccionar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnseleccionar.setBounds(440, 361, 111, 83);
		frame.getContentPane().add(btnseleccionar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(590, 361, 101, 83);
		frame.getContentPane().add(btnEliminar);
	}

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

	public void MostrarVentana() {

		frame.setVisible(true);

	}

}
