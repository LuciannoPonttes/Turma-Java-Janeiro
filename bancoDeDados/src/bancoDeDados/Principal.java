package bancoDeDados;

import java.sql.Connection;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main (String args[]) {
		
		DaoPessoa daoPessoa = new DaoPessoa();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("032");
		pessoa.setNome("Edu pelo java");
		
		pessoa.setEmail("edu@gmail.com");
		
		boolean resultado = daoPessoa.salvarPessoaNobanco(pessoa);
		
		if(resultado) {
			JOptionPane.showMessageDialog(null, "Deu certo");
		}else{
			JOptionPane.showMessageDialog(null, "Deu errado");
		}


	}

}
