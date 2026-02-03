package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Atendente;
import util.FabricaConexao;


public class DaoAtendente {

	public static boolean salvarAtendenteNobanco(Atendente atendente) {
		boolean salvamento = false;

		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		String comandoSqlInsert = "insert into atendente (cpf, nome, setor,senha) values (?, ?, ?,?)"; // Base do comando SQL

		try {
			connection = FabricaConexao.criarConexaoSisFuncionario(); // Recebe o objeto de conexão da
																		// classe Fabrica de conexão

			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																				// comando SQL que vai ser
																				// preparado

			preparaOcomandoSQL.setString(1, atendente.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, atendente.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, atendente.getSetor()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(4, atendente.getSenha());

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

	public static List<Atendente> listarAtendenteNoBanco() {

		String comandoSqlInsert = "select * from atendente"; // Comando que será executado
		Connection connection = null; // Objeto de conexão
		PreparedStatement prepararOcomandoSql = null;// Preparação comando
		List<Atendente> listaAtendente = new ArrayList<Atendente>();// a lista que será retornada
		ResultSet resultadoDaTabelaDoBanco = null;// Objeto que recebe a tabela do banco

		try {

			connection = FabricaConexao.criarConexaoSisFuncionario();// Realiza a conexão
			prepararOcomandoSql = connection.prepareStatement(comandoSqlInsert);// Objeto que possui a conexão e o
																				// comando
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();// Executa a query no banco

			while (resultadoDaTabelaDoBanco.next()) {

				Atendente atendente = new Atendente();

				atendente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				atendente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				atendente.setSetor(resultadoDaTabelaDoBanco.getString("setor"));

				listaAtendente.add(atendente);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // Esse é obrigatorio
			try {
				if (connection != null) {
					connection.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
										// encerrar
				}
				if (prepararOcomandoSql != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					prepararOcomandoSql.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return listaAtendente;
	}

	public static boolean alterarAtendente(Atendente atendente) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE atendente SET nome = ?,  setor = ? WHERE cpf = ?";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.criarConexaoSisFuncionario();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, atendente.getNome());
			preparedStatement.setString(2, atendente.getSetor());
			preparedStatement.setString(3, atendente.getCpf());

			preparedStatement.execute();

			resultadoBoolean = true;

		} catch (Exception e) {

		} finally {
			try {
				if (connectar != null) {
					connectar.close();

				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return resultadoBoolean;
	}

	public static boolean deletarAssistente(String cpf) {

		Boolean deletar = false;
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from atendente where cpf = ? ";

		try {
			conectar = FabricaConexao.criarConexaoSisFuncionario();
			preparedStatement = conectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, cpf);
			preparedStatement.execute();

			deletar = true;

		} catch (Exception e) {

		} finally {
			try {
				if (conectar != null) {
					conectar.close();

				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return deletar;
	}
	
	public static Atendente buscarPorCpf(String cpf) {

	    Atendente atendente = null;
	    Connection conectar = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    String sql = "SELECT cpf, nome, setor, senha FROM atendente WHERE cpf = ?";

	    try {
	        conectar = FabricaConexao.criarConexaoSisFuncionario();
	        ps = conectar.prepareStatement(sql);
	        ps.setString(1, cpf);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            atendente = new Atendente();
	            atendente.setCpf(rs.getString("cpf"));
	            atendente.setNome(rs.getString("nome"));
	            atendente.setSetor(rs.getString("setor"));
	            atendente.setSenha(rs.getString("senha"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conectar != null) conectar.close();
	        } catch (Exception e2) {
	            System.out.println("Não foi possível fechar a conexão!");
	        }
	    }

	    return atendente; // retorna null se não encontrar
	}

}
