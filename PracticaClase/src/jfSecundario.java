import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfSecundario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfSecundario frame = new jfSecundario();
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
	public jfSecundario() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Es una ventana secundaria");
		lblNewLabel.setBounds(135, 97, 157, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnVolverPrincipal = new JButton("Volver");
		btnVolverPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfPrincipal jfPrincipal = new jfPrincipal();
				jfPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVolverPrincipal.setBounds(157, 191, 89, 23);
		contentPane.add(btnVolverPrincipal);
	}
}
