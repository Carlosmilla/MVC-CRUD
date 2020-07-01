package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
private final String stringConexion = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//Metodo para acceder a la BD
	 public Connection  conectar(){
		Connection conexion = null;
		//Metodo para acceder a la BD

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(stringConexion, "tryData","12345");
			} catch (ClassNotFoundException e) {
				System.out.println("No se encuentra el driver"+e.getMessage());
			}
			catch(SQLException e){
				System.out.println("Error en la conexión");
			}
			return conexion;
		}

		public static void main(String[] args) {
			if(new conexion().conectar()!=null){
				System.out.println("Conexión exitosa");
			}
			else{
				System.out.println("Conexión fallida");
			}
		}

	
}
