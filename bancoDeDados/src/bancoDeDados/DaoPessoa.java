package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoPessoa {
	
	public boolean salvarPessoaNobanco(Pessoa pessoa) {
		boolean salvamento = false;
		
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection  connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		
		String comandoSqlInsert = "insert into pessoa (cpf, nome, email) values (?, ?, ?)"; // Base do comando SQL
		
		try {
			 connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseExemplo(); // Recebe o objeto de conexão da classe Fabrica de conexão
			 
			 preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o comando SQL que vai ser preparado
			 
			 preparaOcomandoSQL.setString(1, pessoa.getCpf());// Coloca o valor no campo cpf
			 preparaOcomandoSQL.setString(2, pessoa.getNome()); // Colocar o valor no campo nome
			 preparaOcomandoSQL.setString(3, pessoa.getEmail()); // Colocar o valor no campo email
			 
			 preparaOcomandoSQL.execute(); // Executa o comando no banco de dados
			 
			 System.out.println("A pessoa foi registrada");//Log
			 
			 salvamento = true; // Se tudo funcionar certo
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar a pessoa!!!");
			
		}finally { // Esse é obrigatorio
			try {
				if(connectionBaseExemplo != null) {
					connectionBaseExemplo.close();//Se objeto connectionBaseExemplo estiver aberto essa linha vai encerrar
				}
				if(preparaOcomandoSQL != null) {//Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}
				
			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}
			
		}
		
		return salvamento;
		
	}

}
