package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controlador.Controlador;

public class MenuEmpleados {

	private JFrame frame;
	public JButton BtncopiasSegu;
	public JButton Btnpedidos;
	public JButton Btnproductos;
	private Controlador controlador;

	public MenuEmpleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 373, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		JButton Btnproductos = new JButton("Producto");
		Btnproductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controlador.tablaEmpleadoproduc();
					controlador.getTablaProdu().MostrarVentana();

				} catch (SQLException e1) {

					System.out.println("ERROR");
				}

			}
		});
		Btnproductos.setForeground(new Color(128, 0, 255));
		Btnproductos.setBackground(new Color(0, 0, 0));
		Btnproductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(Btnproductos);

		Btnpedidos = new JButton("Pedidos");
		Btnpedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controlador.llenarCabecera();
					controlador.getPedidosAdmin().MostrarVentana();
				} catch (SQLException e1) {
					System.out.println("ERROR");

				}

			}
		});
		Btnpedidos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Btnpedidos.setBackground(new Color(0, 0, 0));
		Btnpedidos.setForeground(new Color(128, 0, 255));
		Btnpedidos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(Btnpedidos);

		BtncopiasSegu = new JButton("Copias de seguridad");
		BtncopiasSegu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.usuariosCopiasTabla();
					controlador.getCopiasdeseguri().MostrarVentana();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		BtncopiasSegu.setForeground(new Color(128, 0, 255));
		BtncopiasSegu.setBackground(new Color(0, 0, 0));
		BtncopiasSegu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(BtncopiasSegu);

		JButton Btnvolver = new JButton("Volver");
		Btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Btnvolver.setForeground(new Color(128, 0, 255));
		Btnvolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Btnvolver.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(Btnvolver);
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


