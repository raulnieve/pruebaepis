package formularios;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import usuario.Usuario;
import hilos.HiloBarra;
import mantenimientos.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	public static  JProgressBar pbCargar;
	private JLabel lblErrorClave;
	private JLabel lblErrorUsuario;
	public static String usuarioBienvenida;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setTitle("logueo boxman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/")));
		lblUsuario.setBounds(51, 46, 115, 35);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/")));
		lblContrasea.setBounds(51, 92, 115, 35);
		contentPane.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				lblErrorUsuario.setVisible(false);
				txtUsuario.setCaretColor(Color.black);
				
			}
		});
		txtUsuario.setBounds(164, 53, 131, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContraseña = new JPasswordField();
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblErrorClave.setVisible(false);
				txtContraseña.setCaretColor(Color.black);
			}
		});
		txtContraseña.setBounds(164, 99, 131, 20);
		contentPane.add(txtContraseña);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/cancel.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBounds(68, 201, 110, 35);
		contentPane.add(btnSalir);

		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/entrar.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(214, 201, 131, 35);
		contentPane.add(btnIngresar);
		
		pbCargar = new JProgressBar();
		pbCargar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cargar();
			}
		});
		pbCargar.setStringPainted(true);
		pbCargar.setBounds(51, 148, 294, 14);
		contentPane.add(pbCargar);
		
		lblErrorUsuario = new JLabel("");
		lblErrorUsuario.setVisible(false);
		lblErrorUsuario.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/exclamation-mark.png")));
		lblErrorUsuario.setBounds(305, 46, 46, 30);
		contentPane.add(lblErrorUsuario);
		
		lblErrorClave = new JLabel("");
		lblErrorClave.setVisible(false);
		lblErrorClave.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/exclamation-mark.png")));
		lblErrorClave.setBounds(305, 92, 46, 30);
		contentPane.add(lblErrorClave);
	}

	protected void cargar() {
		
		if(pbCargar.getValue() == 100){
			
			frmBienvenida bienvenida = new frmBienvenida();
			bienvenida.setVisible(true);
			bienvenida.setLocationRelativeTo(null);
		
			this.dispose();
			
			JOptionPane.showMessageDialog(rootPane, "Bienvenido");
		}
		
	}

	@SuppressWarnings("deprecation")
	protected void ingresar() {

		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtContraseña.getPassword());
		//String usuarioBienvenida="";

		GestionUsuario gestionUsuario = new GestionUsuario();

		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);

		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
	
		if (usu != null) {
			
			
			HiloBarra barra = new HiloBarra();
			barra.start();
			
			usuarioBienvenida = usu.getNombre() + " " + usu.getApellidos();
			

		} else if(txtUsuario.getText().equals("")){
			
			lblErrorUsuario.setVisible(true);
			txtUsuario.setCaretColor(Color.RED);
			txtUsuario.requestFocus();
			
		}else  if (txtContraseña.getText().equals("")){
			
			lblErrorClave.setVisible(true);
			txtContraseña.setCaretColor(Color.RED);
			txtContraseña.requestFocus();
			
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void salir() {
		System.exit(0);
	}
}
