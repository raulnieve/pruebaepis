package formularios;

import hilos.HiloReloj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class frmBienvenida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JLabel lblFechaactual;
	public static JLabel lblHoraActual;
	private JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBienvenida frame = new frmBienvenida();
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
	public frmBienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHora = new JLabel("HORA:");
		lblHora.setBounds(208, 11, 46, 14);
		contentPane.add(lblHora);
		
		lblHoraActual = new JLabel("hora");
		lblHoraActual.setBounds(264, 11, 98, 14);
		contentPane.add(lblHoraActual);
		
		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setBounds(63, 11, 46, 14);
		contentPane.add(lblFecha);
		
		lblFechaactual = new JLabel("fechaactual");
		lblFechaactual.setBounds(107, 11, 91, 14);
		contentPane.add(lblFechaactual);
		
		JLabel lblBienvenido = new JLabel("Bienvenido usuario:");
		lblBienvenido.setBounds(25, 236, 132, 14);
		contentPane.add(lblBienvenido);
		
		lblUsuario = new JLabel("usuario");
		lblUsuario.setBounds(135, 236, 185, 14);
		contentPane.add(lblUsuario);
		
		HiloReloj hiloReloj = new  HiloReloj();
		hiloReloj.start();
		
		lblUsuario.setText(" " + frmLogin.usuarioBienvenida);
	
	}

}
