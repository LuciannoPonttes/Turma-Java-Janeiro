package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.FuncionarioInterno;
import util.FabricaConexao;

public class DaoFuncionarioInterno {
	
	
	public static boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		boolean salvamento = false;

		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		String comandoSqlInsert = "INSERT INTO funcionario_interno(cpf, matricula, nome, data_nascimento, cargo, salario, plr) VALUES (?, ?, ?, ?, ?, ?, ?);"; // Base do comando SQL

		try {
			connection = FabricaConexao.criarConexaoSisFuncionario(); // Recebe o objeto de conexão da
																		// classe Fabrica de conexão

			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																				// comando SQL que vai ser
																				// preparado

			preparaOcomandoSQL.setString(1, funcionarioInterno.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, funcionarioInterno.getMatricula()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, funcionarioInterno.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(4, funcionarioInterno.getDatadataNascimento().toString()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(5, funcionarioInterno.getCargo());
			preparaOcomandoSQL.setString(6, funcionarioInterno.getSalario().toString());
			preparaOcomandoSQL.setString(7, funcionarioInterno.getPlr().toString());
			

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Foi registrado");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connection != null) {
					connection.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
										// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return salvamento;

	}

}
