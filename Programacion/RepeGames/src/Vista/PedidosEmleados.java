package Vista;

import java.awt.Color;
import java.awt.EventQueue;
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

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.lineaPedido;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PedidosEmleados {

	private JFrame frame;
	private JTable tablaPedi;
	private JTextField ResultadoNumPedido;
	private JTextField RnumeroLinea;
	private JTextField RIdproducto;
	private JTextField Rcantidad;
	private Controlador controlador;
	private Confirmacion confirmacion;

	public PedidosEmleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 852, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Titulo = DefaultComponentFactory.getInstance().createLabel("Administrar Productos");
		Titulo.setForeground(new Color(128, 0, 255));
		Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		Titulo.setBounds(10, 10, 278, 29);
		frame.getContentPane().add(Titulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 52, 745, 229);
		frame.getContentPane().add(scrollPane);

		tablaPedi = new JTable();
		tablaPedi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		tablaPedi.setBackground(new Color(128, 0, 255));
		tablaPedi.setForeground(new Color(255, 255, 0));
		tablaPedi.setModel(new DefaultTableModel(
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
//				"Numero Pedido", "Numero Linea", "Id Producto", "Cantidad"
//			}
		));
		scrollPane.setViewportView(tablaPedi);

		JButton btnFiltro = new JButton("Filtro ID");
		btnFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltro.setBackground(new Color(240, 240, 240));
		btnFiltro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnFiltro.setBounds(42, 313, 101, 21);
		frame.getContentPane().add(btnFiltro);

		JButton btnFiltro2 = new JButton("Filtro Stock");
		btnFiltro2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnFiltro2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltro2.setBounds(42, 344, 111, 21);
		frame.getContentPane().add(btnFiltro2);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(128, 0, 255));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnVolver.setBounds(10, 468, 85, 29);
		frame.getContentPane().add(btnVolver);

		ResultadoNumPedido = new JTextField();
		ResultadoNumPedido.setBounds(330, 319, 158, 19);
		frame.getContentPane().add(ResultadoNumPedido);
		ResultadoNumPedido.setColumns(10);

		JLabel titulo = DefaultComponentFactory.getInstance().createLabel("Nº Pedido:");
		titulo.setForeground(new Color(128, 0, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		titulo.setBounds(330, 306, 101, 13);
		frame.getContentPane().add(titulo);

		JButton btnseleccionar = new JButton("Selecionado");
		btnseleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controlador.llenarLineaPedido();
					controlador.getPedidosAdmin().MostrarVentana();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnseleccionar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnseleccionar.setBounds(640, 313, 101, 78);
		frame.getContentPane().add(btnseleccionar);

		JButton btnEliminar = new JButton("");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/basura.jpg"));

		Image img = iconoEliminar.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		btnEliminar.setIcon(new ImageIcon(img));

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int Nlineapedi = Integer.parseInt(RnumeroLinea.getText());

				lineaPedido linea = new lineaPedido();
				linea.setNumLinea(Nlineapedi);
				
				if(linea!=null) {
					
					confirmacion = new Confirmacion(controlador, Nlineapedi);
					confirmacion.MostrarVentana();
					
				}else {
					System.err.println("Campo vacio");
				}

//				try {
//
//					controlador.eliminarLineaPedido(linea);
//
//					System.out.println("Linea eliminada con exito");
//				} catch (SQLException e1) {
//
//					System.out.println("Error al intentar eliminar");
//				}
//
			}
		});
		btnEliminar.setBounds(640, 401, 101, 83);
		frame.getContentPane().add(btnEliminar);

		RnumeroLinea = new JTextField();
		RnumeroLinea.setBounds(330, 358, 158, 19);
		frame.getContentPane().add(RnumeroLinea);
		RnumeroLinea.setColumns(10);

		RIdproducto = new JTextField();
		RIdproducto.setBounds(330, 394, 158, 19);
		frame.getContentPane().add(RIdproducto);
		RIdproducto.setColumns(10);

		Rcantidad = new JTextField();
		Rcantidad.setBounds(330, 434, 158, 19);
		frame.getContentPane().add(Rcantidad);
		Rcantidad.setColumns(10);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nº Linea:");
		lblNewJgoodiesLabel.setForeground(new Color(128, 0, 255));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewJgoodiesLabel.setBounds(330, 344, 88, 13);
		frame.getContentPane().add(lblNewJgoodiesLabel);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Id Producto:");
		lblNewJgoodiesLabel_1.setForeground(new Color(128, 0, 255));
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewJgoodiesLabel_1.setBounds(330, 377, 88, 19);
		frame.getContentPane().add(lblNewJgoodiesLabel_1);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Cantidad:");
		lblNewJgoodiesLabel_2.setForeground(new Color(128, 0, 255));
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewJgoodiesLabel_2.setBounds(330, 417, 88, 19);
		frame.getContentPane().add(lblNewJgoodiesLabel_2);
	}

	public void tablaPedidos(ArrayList<lineaPedido> lineaList) {

		DefaultTableModel model = new DefaultTableModel(new String[] {

				"Numero Pedido", "Numero Linea", "Id Producto", "Cantidad"

		}, 0);

		for (int i = 0; i < lineaList.size(); i++) {

			lineaPedido linea = lineaList.get(i);

			model.addRow(new Object[] {

					linea.getNumPedido(), linea.getNumLinea(), linea.getIdProducto(), linea.getCantidadProducto()

			});

		}

		tablaPedi.setModel(model);

		JTableHeader diseñoTabla = tablaPedi.getTableHeader();
		diseñoTabla.setFont(new Font("Tahoma", Font.BOLD, 16));
		diseñoTabla.setBackground(Color.black);
		diseñoTabla.setForeground(new Color(128, 0, 255));

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