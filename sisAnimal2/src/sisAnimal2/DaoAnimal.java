package sisAnimal2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoAnimal {

	public boolean salvarAnimalBanco(Animal animal) {
		boolean salvamento = false;

		String comandoInsert = "insert into animal(matricula, nome, nomeTutor) values (?, ?, ?)"; // Comando SQL que
																									// será executado (o
																									// ponto de
																									// interrogação
																									// representa os
																									// valores ainda não
																									// definidos)

		FabricaConexao fabricaConexao = new FabricaConexao();// Instancia a fabrica de conexao

		Connection conexao = null;

		PreparedStatement preracaoComando = null;

		try {

			conexao = fabricaConexao.criarConexaoAnimal(); // Busca a conexao com o banco de dados

			preracaoComando = conexao.prepareStatement(comandoInsert);// Cria o objeto que gerencia a execucao e ajustes
																		// no comando SQL

			preracaoComando.setString(1, animal.getMatricula());// Adiciona a matricula na posição do primeiro ponto de
																// ?
			preracaoComando.setString(2, animal.getNome());// Adiciona o nome na posição do segundo ponto de ?
			preracaoComando.setString(3, animal.getNomeTutor());// Adiciona o nomeTutor na posição do terceriro ponto de
																// ?

			preracaoComando.execute();

			salvamento = true;

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} finally {

			try {

				if (conexao != null) {
					conexao.close();
				}

				if (preracaoComando != null) {
					preracaoComando.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão");
			}
		}
		return salvamento;
	}
}
