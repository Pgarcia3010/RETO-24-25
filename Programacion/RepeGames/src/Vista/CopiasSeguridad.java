package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.Copia;
import Modelo.Usuarios;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JTree;

public class CopiasSeguridad {

	private JFrame frame;
	private JTable tablaCopiasSegu;
	private Controlador controlador;

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
