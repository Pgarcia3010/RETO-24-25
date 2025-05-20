package Vista;

import java.awt.EventQueue;
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

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.Cliente;
import Modelo.Producto;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;

public class TablaPedidos {
	private JFrame frame;
	private JTable tablaClien;
	private Controlador controlador;

	public TablaPedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 791, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 36, 564, 250);
		frame.getContentPane().add(scrollPane);

		tablaClien = new JTable();
		tablaClien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		tablaClien.setBackground(new Color(0, 0, 0));
		tablaClien.setForeground(new Color(255, 255, 0));
		tablaClien.setModel(new DefaultTableModel(
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
//				{null, null, null, null},
//			},
//			new String[] {
//				"IdProducto", "NombreProdcuto", "Precio", "Stock"
//			}
		));
		scrollPane.setViewportView(tablaClien);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Creacion de pedido\r\n");
		lblNewJgoodiesLabel.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewJgoodiesLabel.setBounds(24, 321, 171, 20);
		frame.getContentPane().add(lblNewJgoodiesLabel);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance()
				.createLabel("Nombre del producto a comprar:\r\n");
		lblNewJgoodiesLabel_1.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewJgoodiesLabel_1.setBounds(24, 360, 279, 20);
		frame.getContentPane().add(lblNewJgoodiesLabel_1);

		JComboBox Resultadocombo = new JComboBox();
		Resultadocombo.setBounds(319, 362, 98, 21);
		frame.getContentPane().add(Resultadocombo);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Cantidad:");
		lblNewJgoodiesLabel_2.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewJgoodiesLabel_2.setBounds(24, 400, 88, 21);
		frame.getContentPane().add(lblNewJgoodiesLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 402, 29, 21);
		frame.getContentPane().add(comboBox);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(128, 0, 255));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnVolver.setBounds(10, 460, 102, 21);
		frame.getContentPane().add(btnVolver);

		JButton btnanadir = new JButton("Añadir linea");
		btnanadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnanadir.setBounds(639, 400, 128, 25);
		frame.getContentPane().add(btnanadir);

		JButton btnFinalizar = new JButton("Finalizar pedido");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnFinalizar.setBounds(609, 435, 158, 30);
		frame.getContentPane().add(btnFinalizar);

		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("R");
		lblNewJgoodiesLabel_3.setBackground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_3.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewJgoodiesLabel_3.setBounds(626, 10, 88, 69);
		frame.getContentPane().add(lblNewJgoodiesLabel_3);

		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("E");
		lblNewJgoodiesLabel_4.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewJgoodiesLabel_4.setBounds(639, 66, 88, 69);
		frame.getContentPane().add(lblNewJgoodiesLabel_4);

		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("P");
		lblNewJgoodiesLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewJgoodiesLabel_5.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel_5.setBounds(654, 126, 88, 61);
		frame.getContentPane().add(lblNewJgoodiesLabel_5);

		JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("E");
		lblNewJgoodiesLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewJgoodiesLabel_6.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel_6.setBounds(664, 177, 88, 69);
		frame.getContentPane().add(lblNewJgoodiesLabel_6);

		JLabel lblNewJgoodiesLabel_7 = DefaultComponentFactory.getInstance().createLabel("S");
		lblNewJgoodiesLabel_7.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewJgoodiesLabel_7.setBounds(679, 242, 88, 44);
		frame.getContentPane().add(lblNewJgoodiesLabel_7);
	}

	public void setLlenartabla(ArrayList<Producto> produList) {

		DefaultTableModel model = new DefaultTableModel(

				new String[] { "IdProducto", "NombreProducto", "Precio", "Stock" }, 0

		);

		for (int i = 0; i < produList.size(); i++) {

			Producto produc = produList.get(i);

			model.addRow(new Object[] {

					produc.getIdProducto(), produc.getNombreProducto(), produc.getPrecio(), produc.getStock()

			});

		}

		tablaClien.setModel(model);

		JTableHeader tabla = tablaClien.getTableHeader();
		tabla.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabla.setBackground(Color.black);
		tabla.setForeground(new Color(128, 0, 255));

	}

	public void mostrarVentana() {
		frame.setVisible(true);
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}