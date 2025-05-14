//package Vista;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.awt.BorderLayout;
//import javax.swing.JScrollPane;
//import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
//
//import Controlador.Controlador;
//
//import java.awt.Font;
//import javax.swing.JComboBox;
//import javax.swing.JButton;
//import javax.swing.JTable;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class TablaPedidos {
//
//	private JFrame frame;
//	private JTable table;
//	private Controlador controlador;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TablaPedidos window = new TablaPedidos();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public TablaPedidos() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 791, 528);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(24, 36, 564, 250);
//		frame.getContentPane().add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		
//		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Creacion de pedido:\r\n");
//		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
//		lblNewJgoodiesLabel.setBounds(24, 321, 171, 20);
//		frame.getContentPane().add(lblNewJgoodiesLabel);
//		
//		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nombre del producto a comprar:\r\n");
//		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
//		lblNewJgoodiesLabel_1.setBounds(24, 360, 279, 20);
//		frame.getContentPane().add(lblNewJgoodiesLabel_1);
//		
//		JComboBox Resultadocombo = new JComboBox();
//		Resultadocombo.setBounds(319, 362, 98, 21);
//		frame.getContentPane().add(Resultadocombo);
//		
//		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Cantidad:");
//		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
//		lblNewJgoodiesLabel_2.setBounds(24, 400, 88, 21);
//		frame.getContentPane().add(lblNewJgoodiesLabel_2);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(141, 402, 29, 21);
//		frame.getContentPane().add(comboBox);
//		
//		JButton btnVolver = new JButton("Volver");
//		btnVolver.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//			}
//		});
//		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
//		btnVolver.setBounds(10, 460, 102, 21);
//		frame.getContentPane().add(btnVolver);
//		
//		JButton btnanadir = new JButton("Añadir linea");
//		btnanadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		btnanadir.setBounds(639, 400, 128, 25);
//		frame.getContentPane().add(btnanadir);
//		
//		JButton btnFinalizar = new JButton("Finalizar pedido");
//		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
//		btnFinalizar.setBounds(609, 435, 158, 30);
//		frame.getContentPane().add(btnFinalizar);
//	}
//	public void mostrarVentana() {
//		frame.setVisible(true);
//	}
//
//	public Controlador getControlador() {
//		return controlador;
//	}
//
//	public void setControlador(Controlador controlador) {
//		this.controlador = controlador;
//	}
//	
//}

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

public class TablaPedidos {

    private JFrame frame;
    private JTable tablaClien;
    private Controlador controlador;

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TablaPedidos window = new TablaPedidos();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public TablaPedidos() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 791, 528);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 36, 564, 250);
        frame.getContentPane().add(scrollPane);

        tablaClien = new JTable();
        tablaClien.setModel(new DefaultTableModel(
//            new Object[][] {
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//            },
//            new String[] {
//                "IdProducto", "NombreProdcuto", "Precio", "Stock"
//            }
        ));
        scrollPane.setViewportView(tablaClien);

        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Creacion de pedido:\r\n");
        lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewJgoodiesLabel.setBounds(24, 321, 171, 20);
        frame.getContentPane().add(lblNewJgoodiesLabel);

        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance()
                .createLabel("Nombre del producto a comprar:\r\n");
        lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewJgoodiesLabel_1.setBounds(24, 360, 279, 20);
        frame.getContentPane().add(lblNewJgoodiesLabel_1);

        JComboBox Resultadocombo = new JComboBox();
        Resultadocombo.setBounds(319, 362, 98, 21);
        frame.getContentPane().add(Resultadocombo);

        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Cantidad:");
        lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewJgoodiesLabel_2.setBounds(24, 400, 88, 21);
        frame.getContentPane().add(lblNewJgoodiesLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(141, 402, 29, 21);
        frame.getContentPane().add(comboBox);

        JButton btnVolver = new JButton("Volver");
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
    }

    public void setLlenartabla(ArrayList<Producto> produList) {

        DefaultTableModel model = new DefaultTableModel(

                new String[] { "IdProducto", "NombreProdcuto", "Precio", "Stock" }, 0

        );
        
        
        for (int i=0; i<produList.size(); i++) {
            
            Producto produc = produList.get(i);
            
            model.addRow(new Object [] {
                    
                    produc.getIdProducto(),produc.getNombreProducto(),produc.getPrecio(),produc.getStock()
                    
            });
            
        }
        
        tablaClien.setModel(model);

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
