package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import entidade.Gerente;

public class ManipuladorArquivo {
	
	public boolean registrarGerente(Gerente gerente) {
		
		String enderecoArquivo = "D:\\workSpace\\workSpaceJavaJaneiro\\sisFuncionario\\registroGerente.txt";
		
		try {
		
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do gerente é: "+ gerente.getNome() );
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

}
