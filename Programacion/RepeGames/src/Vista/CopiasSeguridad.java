package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class CopiasSeguridad {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopiasSeguridad window = new CopiasSeguridad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopiasSeguridad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Copias de seguridad");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewJgoodiesTitle.setBounds(265, 22, 221, 35);
		frame.getContentPane().add(lblNewJgoodiesTitle);

		JPanel panel = new JPanel();
		panel.setBounds(40, 250, 697, 187);
		frame.getContentPane().add(panel);

		table = new JTable();
		panel.add(table);

		JButton btnRealizarcopias = new JButton("Realizar copia de seguridad\r\n");
		btnRealizarcopias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRealizarcopias.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnRealizarcopias.setBounds(233, 98, 264, 29);
		frame.getContentPane().add(btnRealizarcopias);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnVolver.setBounds(321, 151, 85, 40);
		frame.getContentPane().add(btnVolver);
	}

	public void MostrarVentana() {

		frame.setVisible(true);
	}
}
