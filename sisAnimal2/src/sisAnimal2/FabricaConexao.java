package sisAnimal2;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/sisAnimal";
	
	
	
	public Connection criarConexaoAnimal() {
		
		Connection conexao = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexao = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Não conectou!");
		}
		
		return conexao;
		
		
		
		
	}

}
