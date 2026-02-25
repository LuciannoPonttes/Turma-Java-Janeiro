package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;
import util.FabricaConexao;

public class DaoFuncionarioInterno {

	public static boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		boolean salvamento = false;

		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		String comandoSqlInsert = "INSERT INTO funcionario_interno(cpf, matricula, nome, data_nascimento, cargo, salario, plr,senha) VALUES (?, ?, ?, ?, ?, ?, ?,?);"; // Base
																																								// do
																																								// comando
																																								// SQL

		try {
			connection = FabricaConexao.criarConexaoSisFuncionario(); // Recebe o objeto de conexão da
																		// classe Fabrica de conexão

			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																				// comando SQL que vai ser
																				// preparado

			preparaOcomandoSQL.setString(1, funcionarioInterno.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, funcionarioInterno.getMatricula()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, funcionarioInterno.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(4, funcionarioInterno.getDatadataNascimento().toString()); // Colocar o valor
																									// no campo email
			preparaOcomandoSQL.setString(5, funcionarioInterno.getCargo());
			preparaOcomandoSQL.setString(6, funcionarioInterno.getSalario().toString());
			preparaOcomandoSQL.setString(7, funcionarioInterno.getPlr().toString());
			preparaOcomandoSQL.setString(8, funcionarioInterno.getSenha().toString());

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

	public static List<FuncionarioInterno> listar() {

		String comandoSqlInsert = "select * from funcionario_interno "; // Comando que será executado
		Connection connection = null; // Objeto de conexão
		PreparedStatement prepararOcomandoSql = null;// Preparação comando
		List<FuncionarioInterno> lista = new ArrayList<>();// a lista que será retornada
		ResultSet resultadoDaTabelaDoBanco = null;// Objeto que recebe a tabela do banco

		try {

			connection = FabricaConexao.criarConexaoSisFuncionario();// Realiza a conexão
			prepararOcomandoSql = connection.prepareStatement(comandoSqlInsert);// Objeto que possui a conexão e o
																				// comando
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();// Executa a query no banco

			while (resultadoDaTabelaDoBanco.next()) {

				FuncionarioInterno funcionario = new FuncionarioInterno();

				funcionario.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				funcionario.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				funcionario.setMatricula(resultadoDaTabelaDoBanco.getString("matricula"));
				funcionario.setDataNascimento(resultadoDaTabelaDoBanco.getString("data_nascimento"));
				funcionario.setSalario(Double.parseDouble(resultadoDaTabelaDoBanco.getString("salario")));
				funcionario.setCargo(resultadoDaTabelaDoBanco.getString("cargo"));
				funcionario.setPlr(Double.parseDouble(resultadoDaTabelaDoBanco.getString("plr")));

				lista.add(funcionario);
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

		return lista;
	}

	public static boolean deletarInterno(String cpf) {

		Boolean deletar = false;
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from funcionario_interno where cpf = ? ";

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

	public static FuncionarioInterno buscarPorCpf(String cpf) {

		FuncionarioInterno funcionarioInterno = null;
		Connection conectar = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT cpf, matricula, nome, data_nascimento, cargo, salario, plr,senha FROM funcionario_interno WHERE  cpf = ?";

		try {
			conectar = FabricaConexao.criarConexaoSisFuncionario();
			ps = conectar.prepareStatement(sql);
			ps.setString(1, cpf);

			rs = ps.executeQuery();

			if (rs.next()) {
				funcionarioInterno = new FuncionarioInterno();
				funcionarioInterno.setCpf(rs.getString("cpf"));
				funcionarioInterno.setNome(rs.getString("nome"));
				funcionarioInterno.setMatricula(rs.getString("matricula"));
				funcionarioInterno.setDataNascimento(rs.getString("data_nascimento"));
				funcionarioInterno.setCargo(rs.getString("cargo"));
				funcionarioInterno.setSalario(Double.parseDouble(rs.getString("salario")));
				funcionarioInterno.setPlr(Double.parseDouble(rs.getString("plr")));
				funcionarioInterno.setSenha(rs.getString("senha"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conectar != null)
					conectar.close();
			} catch (Exception e2) {
				System.out.println("Não foi possível fechar a conexão!");
			}
		}

		return funcionarioInterno; // retorna null se não encontrar
	}
	
	
	public static boolean alterarInterno(FuncionarioInterno funcionario) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE funcionario_interno SET matricula = ?, nome = ?, data_nascimento = ?, cargo = ?, salario = ?, plr = ? WHERE cpf = ?;";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.criarConexaoSisFuncionario();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, funcionario.getMatricula());
			preparedStatement.setString(2, funcionario.getNome());
			preparedStatement.setString(3, funcionario.getDatadataNascimento());
			preparedStatement.setString(4, funcionario.getCargo());
			preparedStatement.setString(5, funcionario.getSalario().toString());
			preparedStatement.setString(6, funcionario.getPlr().toString());
			
			preparedStatement.setString(7, funcionario.getCpf());

			preparedStatement.execute();

			resultadoBoolean = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
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

}
