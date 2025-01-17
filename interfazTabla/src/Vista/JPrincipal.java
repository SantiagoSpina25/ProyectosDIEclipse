package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Contenedor.ConectorBd;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable table;
	private JTextField txtNuevoNombre;
	private JTextField txtNuevoApellido;
	ConectorBd conexion = new ConectorBd();
	Connection cn = null;
	Statement stm = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 25, 243, 32);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.conectar();
				String nombreActor = txtBuscar.getText();
				conexion.buscarActor(nombreActor);
				table.setModel(conexion.cargarTabla(nombreActor));
			}
		});
		btnBuscar.setBounds(329, 26, 116, 30);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setBounds(24, 120, 436, 138);
		contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(24, 120, 436, 138);
		contentPane.add(scroll);
		
		
		txtNuevoNombre = new JTextField();
		txtNuevoNombre.setToolTipText("Nuevo nombre");
		txtNuevoNombre.setBounds(10, 363, 178, 32);
		contentPane.add(txtNuevoNombre);
		txtNuevoNombre.setColumns(10);
		
		txtNuevoApellido = new JTextField();
		txtNuevoApellido.setToolTipText("Nuevo apellido");
		txtNuevoApellido.setBounds(10, 406, 178, 32);
		contentPane.add(txtNuevoApellido);
		txtNuevoApellido.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.insertarNuevo(txtNuevoNombre,txtNuevoApellido);
				
				
				
				
			}
		});
		btnInsertar.setBounds(329, 384, 116, 32);
		contentPane.add(btnInsertar);
	}
}
