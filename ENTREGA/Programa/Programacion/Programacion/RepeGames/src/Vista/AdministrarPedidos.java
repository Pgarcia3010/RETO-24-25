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
import Modelo.cabeceraPedido;

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

	/**
	* Se inicializa la ventana AdministrarPedidos
	*/
	public AdministrarPedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @author Ismael
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
		ImageIcon imtbtn = new ImageIcon(getClass().getResource("/Imagenes/editar.png"));
		Image img1 = imtbtn.getImage().getScaledInstance(130, 110, Image.SCALE_SMOOTH);
		btnseleccionar.setIcon(new ImageIcon(img1));
		btnseleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controlador.llenarLineaPedido();
					controlador.getPedidosempleados().mostrarVentana();

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnseleccionar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnseleccionar.setBounds(440, 361, 111, 83);
		frame.getContentPane().add(btnseleccionar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

		ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/basura.jpg"));

		Image img = iconoEliminar.getImage().getScaledInstance(117, 90, Image.SCALE_SMOOTH);
		btnEliminar.setIcon(new ImageIcon(img));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = ResultadoId.getText();

				cabeceraPedido cabe = new cabeceraPedido();
				cabe.setId(id);

				try {
					controlador.eliminarCabecera(cabe);
					System.out.println("Eliminado con exito");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error al intentar eliminar un producto");
				}

			}
		});
		btnEliminar.setBounds(590, 361, 101, 83);
		frame.getContentPane().add(btnEliminar);
	}
/**
 * Se rellena la tabla
 * 
 * @param cabeList ArrayList de tipo cabeceraPedido
 */
	public void SetTablaE1(ArrayList<cabeceraPedido> cabeList) {

		DefaultTableModel model = new DefaultTableModel(new String[] {

				"Numero Pedido", "Id", "Precio", "Fecha" }, 0);

		for (int i = 0; i < cabeList.size(); i++) {

			cabeceraPedido cabe = cabeList.get(i);

			model.addRow(new Object[] {

					cabe.getNumPedido(), cabe.getId(), cabe.getPrecioTotal(), cabe.getFechaPedido()

			});

		}

		/**
		 * El metodo mostrar ventana sirve para que podamos ver la ventana luego desde
		 * el llamado de nuestro controlador
		 * 
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

	/**
	 * Se hace que la ventana sea visible
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