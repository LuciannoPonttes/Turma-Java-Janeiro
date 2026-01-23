package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bancoDados.configuracao.FabricaConexao;
import entidade.Gerente;

public class DaoGerente {

	public boolean salvarGerenteNobanco(Gerente gerente) {
		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into gerente (cpf, nome, gerencia) values (?, ?, ?)"; // Base do comando SQL

		try {
			connection = conexaoFabricaConexao.criarConexaoSisFuncionario(); // Recebe o objeto de conexão da
																						// classe Fabrica de conexão

			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// preparado

			preparaOcomandoSQL.setString(1, gerente.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, gerente.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, gerente.getGerencia()); // Colocar o valor no campo email

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

	public List<Gerente> listarGerenteDoBanco() {
		
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "select * from gerente"; // Base do comando SQL
		
		List<Gerente> listaGerente = new ArrayList<Gerente>();
		
		ResultSet resultadoDaTabelaDoBanco = null;// Armazenar todo o conteudo da consulta no banco
		
		try {
			
			connection = conexaoFabricaConexao.criarConexaoSisFuncionario();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
			
			
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();
			
			while(resultadoDaTabelaDoBanco.next()) {
				
				Gerente gerente = new Gerente();
				
				gerente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				
				gerente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				
				gerente.setGerencia(resultadoDaTabelaDoBanco.getString("gerencia"));
				
				listaGerente.add(gerente);
				
				
			}
			
			
		}catch (Exception e) {
			
		
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

		
		return listaGerente;
	}
	
	

}
