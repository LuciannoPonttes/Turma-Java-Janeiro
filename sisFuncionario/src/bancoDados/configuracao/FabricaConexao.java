package bancoDados.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static String USUARIO = "root"; // O usuario do banco
	private static String SENHA = "root"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/sis_funcionario?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	
	public Connection criarConexaoSisFuncionario() {
		
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Aponta o drive do banco
			
			conexao = DriverManager.getConnection(BANCO_URL,USUARIO,SENHA);// Tenta acessar o banco de dados e criar o objeto
			// Se algo ocorrer errado ele cai no cath
			System.out.println("Deu certo a conexão!!!!");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("Deu errado a conexão!!!!");
		
		}
		
		return conexao;
	}
	
	
	
	

}
