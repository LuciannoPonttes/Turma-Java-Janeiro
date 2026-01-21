package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoPessoa {
	
	public boolean salvarPessoaNoBanco(Pessoa pessoa) {
		
		boolean salvamento = false;
		
		String comandoSqlInsert = "insert into pessoa (cpf, nome, email) values (?, ?, ?)";
		
		FabricaConexao fabricaConexaoSisPessoa = new FabricaConexao();
		
		Connection conexaoSisPessoa= null;

		PreparedStatement preparaComando = null;
		
		try {
			conexaoSisPessoa = fabricaConexaoSisPessoa.criarConexaoBancoSisPessoa();

			preparaComando = conexaoSisPessoa.prepareStatement(comandoSqlInsert);
			preparaComando.setString(1, pessoa.getCpf());
			preparaComando.setString(2, pessoa.getNome());
			preparaComando.setString(3, pessoa.getEmail());
			preparaComando.execute();
		
			salvamento = true;
		
		} catch (SQLException e) {
			System.out.println("Erro ao executar o salvamento de Pessoa no Banco");
			e.printStackTrace();
		}finally { // Obrigatoriamente esse trecho é executado
			
				try {
					if(conexaoSisPessoa != null) {
						conexaoSisPessoa.close(); // Fechar conexão com o banco
					}
					if(preparaComando != null) {
						preparaComando.close(); // Fechar conexão com o banco
					}
					
				} catch (SQLException e) {
					System.out.println("Não foi possivel fechar a conexão");
					e.printStackTrace();
				}
				
			
		}
		
		return salvamento;
	}

}
