package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.Copia;

/**
 * Ventana donde se gestionan las copias de seguridad
 * 
 * @author Ismael
 */
public class CopiasSeguridad {

	private JFrame frame;
	private JTable tablaCopiasSegu;
	private Controlador controlador;

	/**
	 * Se empieza la inicializacion
	 */
	public CopiasSeguridad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 790, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Copias de seguridad");
		lblNewJgoodiesTitle.setForeground(new Color(128, 0, 255));
		lblNewJgoodiesTitle.setBackground(new Color(128, 0, 255));
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewJgoodiesTitle.setBounds(265, 22, 221, 35);
		frame.getContentPane().add(lblNewJgoodiesTitle);

		JButton btnRealizarcopias = new JButton("Realizar copia de seguridad\r\n");
		btnRealizarcopias.setForeground(new Color(255, 255, 255));
		btnRealizarcopias.setBackground(new Color(128, 0, 255));
		btnRealizarcopias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRealizarcopias.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnRealizarcopias.setBounds(233, 92, 264, 35);
		frame.getContentPane().add(btnRealizarcopias);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 0, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnVolver.setBounds(321, 151, 85, 40);
		frame.getContentPane().add(btnVolver);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 232, 655, 197);
		frame.getContentPane().add(scrollPane);

		tablaCopiasSegu = new JTable();
		tablaCopiasSegu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		tablaCopiasSegu.setBackground(new Color(128, 0, 255));
		tablaCopiasSegu.setForeground(new Color(255, 255, 0));
		tablaCopiasSegu.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//				{null, null, null},
//			},
//			new String[] {
//				"Id", "Nombre", "Contrase\u00F1a"
//			}
		));
		scrollPane.setViewportView(tablaCopiasSegu);
	}

	/**
	 * Se rellena la tabla con usuarios
	 * 
	 * @param usuarioList Objeto de tipo Usuario
	 */
	public void tablaCS(ArrayList<Copia> usuarioList) {

		DefaultTableModel model = new DefaultTableModel(new String[] {

				"Id Copia", "Nombre", "Fecha", "Ubicacion"

		}, 0);

		for (int i = 0; i < usuarioList.size(); i++) {

			Copia user = usuarioList.get(i);

			model.addRow(new Object[] {

					user.getIdCopia(), user.getNombre(), user.getFecha(), user.getUbicacion()

			});

		}

		tablaCopiasSegu.setModel(model);

		JTableHeader tablaCDS = tablaCopiasSegu.getTableHeader();
		tablaCDS.setFont(new Font("tahoma", Font.BOLD, 16));
		tablaCDS.setBackground(Color.black);
		tablaCDS.setForeground(new Color(128, 0, 255));
	}

	/**
	 * Se visualiza la ventana
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
