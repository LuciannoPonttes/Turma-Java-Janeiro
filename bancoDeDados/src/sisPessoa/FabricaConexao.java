package sisPessoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	
	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/sisPessoa";
	
	public Connection criarConexaoBancoSisPessoa() {
		
		Connection conexaoBaseDadosSisPessoa = null; 
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexaoBaseDadosSisPessoa = DriverManager.getConnection(BANCO_URL,USUARIO, SENHA);
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro da linha do Classe.forName.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Erro da linha do DriverManager.getConnection");
		}
		
		return conexaoBaseDadosSisPessoa;
	}

}
