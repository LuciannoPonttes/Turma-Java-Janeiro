package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidade.Atendente;
import entidade.Gerente;

public class ManipuladorArquivo {

	public boolean registrarGerente(Gerente gerente) {

		String enderecoArquivo = "C:\\Users\\luciano.pontes\\Desktop\\JavaProgrammer\\Turma-Java-Janeiro\\sisFuncionario\\registroGerente.txt";

		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));

			bufferedWriter.append("O nome do gerente é: " + gerente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do gerente é:" + gerente.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("A gerencia do gerente é: " + gerente.getGerencia());

			bufferedWriter.close();

			return true;

		} catch (IOException e) {
			System.out.println("Erro ao salvar o gerente");
			return false;
		}

	}

	public boolean registrarAtendente(Atendente atendente) {

		String enderecoArquivo = "C:\\Users\\luciano.pontes\\Desktop\\JavaProgrammer\\Turma-Java-Janeiro\\sisFuncionario\\registroAtendente.txt";

		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));

			bufferedWriter.append("O nome do atendente é: " + atendente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do atendente é:" + atendente.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("O setor do atendente é: " + atendente.getSetor());

			bufferedWriter.close();

			return true;

		} catch (IOException e) {
			System.out.println("Erro ao salvar o gerente");
			return false;
		}

	}

}
