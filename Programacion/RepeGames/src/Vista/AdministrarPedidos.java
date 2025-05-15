package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.Producto;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Se crea un objeto AdminstrasPedidos.
 * 
 * @author Ismael
 * @version 1.0
 */

public class AdministrarPedidos {
	/**
	 * Esta clase sirve para administrar los Productos en el menu de empleado
	 * 
	 * @author Ismael 
	 */

	private JFrame frame;
	private JTable tabla1;
	private JTextField ResultadoId;
	private Controlador controlador;

	public AdministrarPedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 852, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Titulo = DefaultComponentFactory.getInstance().createLabel("Administrar Pedidos");
		Titulo.setForeground(new Color(128, 0, 255));
		Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		Titulo.setBounds(22, 10, 302, 29);
		frame.getContentPane().add(Titulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 63, 745, 229);
		frame.getContentPane().add(scrollPane);

		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		tabla1.setBackground(new Color(128, 0, 255));
		tabla1.setForeground(new Color(255, 255, 0));
		tabla1.setModel(new DefaultTableModel(
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
//			},
//			new String[] {
//				"Id Producto", "Nombre Producto", "Precio", "Stock"
//			}
		));
		scrollPane.setViewportView(tabla1);

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
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnVolver.setBounds(22, 450, 85, 29);
		frame.getContentPane().add(btnVolver);

		ResultadoId = new JTextField();
		ResultadoId.setBounds(148, 380, 158, 19);
		frame.getContentPane().add(ResultadoId);
		ResultadoId.setColumns(10);

		JLabel titulo = DefaultComponentFactory.getInstance().createLabel("Id Producto:");
		titulo.setForeground(new Color(128, 0, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		titulo.setBounds(148, 367, 101, 13);
		frame.getContentPane().add(titulo);

		JButton btnseleccionar = new JButton("Selecionado");
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

	public void SetTablaE1(ArrayList<Producto> produList) {

		DefaultTableModel model = new DefaultTableModel(new String[] {

				"Id Producto", "Nombre Producto", "Precio", "Stock" }, 0);

		for (int i = 0; i < produList.size(); i++) {

			Producto produ = produList.get(i);

			model.addRow(new Object[] {

					produ.getIdProducto(), produ.getNombreProducto(), produ.getPrecio(), produ.getStock()

			});

		}

/**
 * El metodo mostrar ventana sirve para que podamos ver la ventana luego desde el llamado de nuestro controlador
 * @author Ismael
 * 		
 */

		tabla1.setModel(model);
		
	
		
/**
 * 
 * 
 * 
 */
		
		JTableHeader tablaDiseño = tabla1.getTableHeader();
		tablaDiseño.setFont(new Font("Tahoma", Font.BOLD, 18));
		tablaDiseño.setBackground(Color.black);
		tablaDiseño.setForeground(new Color(128, 0, 255));
/**
 * El get controlador lo necesitamos para pasar datos de clase a clase 
 * 
 * @author Ismael
 */
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
