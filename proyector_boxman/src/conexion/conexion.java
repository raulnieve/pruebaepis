package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class conexion {
	public static Connection getConexion() {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bd_datos";
			String usr = "root";
			String psw = "mysql";
			
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException e) {
			System.out.println("Error >> de conexi�n con la BD");
		}
		return con;
	}

}
