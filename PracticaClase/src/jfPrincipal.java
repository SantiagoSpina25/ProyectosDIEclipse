
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfPrincipal frame = new jfPrincipal();
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
	public jfPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JButton btnClickSecundario = new JButton("Haz click aquí");
		btnClickSecundario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				jfSecundario jfSecunadario = new jfSecundario();
//				jfSecunadario.setVisible(true);
//				dispose();
				JDSecundarioModal jDSecundarioModal = new JDSecundarioModal();
				jDSecundarioModal.setVisible(true);
			}
		});
		btnClickSecundario.setBounds(473, 385, 183, 23);
		contentPane.add(btnClickSecundario);
	}

}
