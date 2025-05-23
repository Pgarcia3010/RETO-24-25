package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Controlador.Controlador;
import Modelo.lineaPedido;
import java.awt.GridLayout;

/**
 * Ventana de confirmacion de acciones
 * 
 * @author Ismael
 */
public class Confirmacion {

	private JFrame frame;
	private Controlador controlador;
	private int numLinea;

	/**
	 * Se inicializa la ventana
	 * 
	 */
	public Confirmacion() {
//		  @wbp.parser.constructor
		initialize();
	}

	/**
	 * Se ejecuta la ventana
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 445, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnAfirmar = new JButton("");
		btnAfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ImageIcon imaBtn = new ImageIcon(getClass().getResource("/Imagenes/img.png"));
		Image img = imaBtn.getImage().getScaledInstance(185, 190, Image.SCALE_SMOOTH);
		btnAfirmar.setIcon(new ImageIcon(img));

		btnAfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					lineaPedido linea = new lineaPedido();
					linea.setNumLinea(numLinea);
					controlador.eliminarLineaPedido(linea);
					frame.dispose();

				} catch (SQLException e1) {

					System.out.println("Error al intentar eliminar");
				}

			}
		});
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Confirmar eliminación");
		lblNewJgoodiesLabel.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		frame.getContentPane().add(lblNewJgoodiesLabel);

		JLabel label = new JLabel("");
		frame.getContentPane().add(label);
		frame.getContentPane().add(btnAfirmar);

		JButton Btnmal = new JButton("");

		ImageIcon imtbtn = new ImageIcon(getClass().getResource("/Imagenes/mal.png"));
		Image img1 = imtbtn.getImage().getScaledInstance(185, 190, Image.SCALE_SMOOTH);
		Btnmal.setIcon(new ImageIcon(img1));

		Btnmal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Btnmal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(Btnmal);
	}

	/**
	 * Se llama al controlador
	 * 
	 * @param controlador Clase que une las ventanas con el modelo
	 * @param numLinea    Indica la linea especifica del producto
	 */
	public Confirmacion(Controlador controlador, int numLinea) {

		this.controlador = controlador;
		this.numLinea = numLinea;
		initialize();

	}

	/**
	 * Recibe numLinea
	 * 
	 * @return numLinea Indica la linea especifica del producto
	 */
	public int getNumLinea() {
		return numLinea;
	}

	/**
	 * Modifica numLinea
	 * 
	 * @param numLinea Indica la linea especifica del producto
	 */
	public void setNumLinea(int numLinea) {
		this.numLinea = numLinea;
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

	/**
	 * se hace visible la venntana
	 */
	public void MostrarVentana() {
		frame.setVisible(true);
	}

}
