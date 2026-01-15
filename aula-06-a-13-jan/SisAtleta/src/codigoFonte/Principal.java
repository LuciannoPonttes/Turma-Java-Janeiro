package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class Principal {

	

	public static void main(String[] args) {

		// Para Depurar(Debugar) linha por linha usamos a tecla F6
		// Para Depurar de um BreakPoint para o outro (sem ser linha por linha) usamos a
		// tecla F8

		// System.out.println("Digite F para Jogador de Futebol ou V para jogador de
		// Volei:");// Imprime uma String no console (Saida de Dados)
		// entradaDados.next();
								// Scanner
		String opcaoCadastrarMaisUm;// Criado e iniciado como NULL
		
		
		List<JogadorFutebol> jogadoresFutebol = new ArrayList<JogadorFutebol>();//Criação de uma lista de jogadores
		List<JogadorVolei> jogadoresVolei = new ArrayList<JogadorVolei>();
		
		
		
		do { // Primeira possivel repetição(loop 0 da imagem)
			// JOptionPane é uma classe do java Swing(pacote de interface gratica nativa do java)
			//showInputDialog Ele recebe uma String(via interface grafica) e retorna a String recebido pelo usuario
			//equalsIgnoreCase -> Para ignorar se é caixa alta ou baixa
			//   || OR/ OU
			
			String opcaoCadastroAtleta;
			
			boolean letraOuNao;
			
			do {
				opcaoCadastroAtleta = JOptionPane.showInputDialog("Digite F para Jogador(a) de Futebol ou V para Jogador(a) de Volei: ");
				
				
				letraOuNao = somenteLetras(opcaoCadastroAtleta);
				
				if(!(opcaoCadastroAtleta.equalsIgnoreCase("F") || opcaoCadastroAtleta.equalsIgnoreCase("V"))) {
					JOptionPane.showMessageDialog(null, "Somente V ou F");
					letraOuNao = false;
				}
				
			}while(!letraOuNao);
			
			
			if (opcaoCadastroAtleta.equalsIgnoreCase("F")) {
				
				
				
				// APENAS PARA APRENDER
				//JogadorFutebol jogadorFutebolObjetoCompleto = new JogadorFutebol("Luciano", 23, "Esquerda", 10.0, 10 );
				
				//JogadorFutebol jogadorFutebolObjetoSomenteNome = new JogadorFutebol("ELAINE");
				
				
				
				long identificador = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);// Gera um numero aleatorio
				
				JogadorFutebol jogadorFutebolObjeto = new JogadorFutebol(identificador);
				
				
			
				do {
					
					String nome = JOptionPane.showInputDialog("Qual o nome do Jogador(a) de Futebol: ");
					
					letraOuNao = somenteLetras(nome);
					
					if(letraOuNao) {
						jogadorFutebolObjeto.setNomeAtleta(nome);
					}
				
				}while(!letraOuNao);
				
				int idadeTemporaria; // Variavel para receber o resultado do metodo validaInteiroEretornaInt
				
				do {
					idadeTemporaria = validaInteiroEretornaInt(JOptionPane.showInputDialog("Qual a idade do Jogador(a) de Futebol:")); // NextInt para receber inteiros do console
					if(idadeTemporaria != 0) {
						jogadorFutebolObjeto.setIdade(idadeTemporaria);
						
					}
					
					
				}while(idadeTemporaria == 0);
				
				do{
					String pernaMaisForte = JOptionPane.showInputDialog("Qual a perna mais forte: ");
					
					
					letraOuNao = somenteLetras(pernaMaisForte);
					
					if(letraOuNao) {
						jogadorFutebolObjeto.setPernaMaisForte(pernaMaisForte);
					}
				
				}while(!letraOuNao);
				
				double valorPorGolTemp;
				do {
					
					valorPorGolTemp =  validaDoubleEretornaDouble(JOptionPane.showInputDialog("Valor por gol marcado $: "));
					
					if(valorPorGolTemp != 0.0) {
						jogadorFutebolObjeto.setValorPorGol(valorPorGolTemp);
					}
					
				}while(valorPorGolTemp == 0.0);
				
				int qtdGolTemporaria;
				
				do {
					qtdGolTemporaria = validaInteiroEretornaInt(JOptionPane.showInputDialog("Quantos gols o jogador marcou:")); // NextInt para receber inteiros do console
					if(qtdGolTemporaria != 0) {
						jogadorFutebolObjeto.setQtdGol(qtdGolTemporaria);
						
					}
				}while(qtdGolTemporaria == 0);
				
				
				jogadorFutebolObjeto.setSalario(jogadorFutebolObjeto.calcularPagamento());
				
				jogadorFutebolObjeto.setPatrocinio(jogadorFutebolObjeto.calcularPatrocinio());
				
				jogadoresFutebol.add(jogadorFutebolObjeto);
				
				
			

			}

			if (opcaoCadastroAtleta.equalsIgnoreCase("V")) {
				//JogadorVolei jogadorVoleiObjeto = new JogadorVolei("JOENIO", 10, "Direito", 10.0, 20);
				
				long identificador = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);// Gera um numero aleatorio
				
				JogadorVolei jogadorVoleiObjeto = new JogadorVolei(identificador);
				
				
				jogadorVoleiObjeto.setNomeAtleta(JOptionPane.showInputDialog("Qual o nome do Jogador(a) de Volei: "));

				
				
				
				int idadeTemporaria;
				
				do {
					idadeTemporaria = validaInteiroEretornaInt(JOptionPane.showInputDialog("Qual a idade do Jogador(a) de Volei: ")); // NextInt para receber inteiros do console
					if(idadeTemporaria != 0) {
						jogadorVoleiObjeto.setIdade(idadeTemporaria);
						
					}
					
					
				}while(idadeTemporaria == 0);
				
				
				jogadorVoleiObjeto.setBracoMaisForte(JOptionPane.showInputDialog("Qual o braco mais forte: "));

				double valorPorPontoTemp;
				do {
					
					valorPorPontoTemp =  validaDoubleEretornaDouble(JOptionPane.showInputDialog("Valor por pontos marcado $: "));
					
					if(valorPorPontoTemp != 0.0) {
						jogadorVoleiObjeto.setValorPorPontos(valorPorPontoTemp);
					}
					
				}while(valorPorPontoTemp == 0.0);
				
				int qtdPontoTemporaria;
				
				do {
					qtdPontoTemporaria = validaInteiroEretornaInt(JOptionPane.showInputDialog(("Quantidade de pontos marcados $: "))); // NextInt para receber inteiros do console
					if(qtdPontoTemporaria != 0) {
						jogadorVoleiObjeto.setIdade(qtdPontoTemporaria);
						
					}
					
					
				}while(qtdPontoTemporaria == 0);
				
				jogadorVoleiObjeto.setSalario(jogadorVoleiObjeto.calcularPagamento());
				
				jogadorVoleiObjeto.setPatrocinio(jogadorVoleiObjeto.calcularPatrocinio());			
				
				jogadoresVolei.add(jogadorVoleiObjeto);
				
			}
			
			opcaoCadastrarMaisUm  = JOptionPane.showInputDialog("Deseja Cadastrar mais um(S/N): ");
			
		}while(opcaoCadastrarMaisUm.equals("S"));
		
		
		
		StringBuilder mensagem = new StringBuilder();
		
		mensagem.append("################Lista de Jogadores de futebol Cadastrados################\n");
		
		for (JogadorFutebol jogadorFutebolLista: jogadoresFutebol) {
			
			mensagem.append("Identificador: ")
			.append(jogadorFutebolLista.getIdentificador())
			.append("\n");
			
			
			
			mensagem.append("Nome do Jogador de Futebol: ")
					.append(jogadorFutebolLista.getNomeAtleta())
					.append("\n");
			
			mensagem.append("Idade do Jogador de Futebol: ")
			.append(jogadorFutebolLista.getIdade())
			.append("\n");
			
			mensagem.append("Perna Mais forte do Jogador de Futebol: ")
			.append(jogadorFutebolLista.getPernaMaisForte())
			.append("\n");
			
			mensagem.append("Valor recebido por gol: ")
			.append(jogadorFutebolLista.getvalorPorGol())
			.append("\n");
			
			mensagem.append("Quantidade de gol: ")
			.append(jogadorFutebolLista.getQtdGol())
			.append("\n");
			
			mensagem.append("Valor Salario: ")
			.append(jogadorFutebolLista.getSalario())
			.append("\n");
			
			mensagem.append("O valor do patrocinio é: ")
			.append(jogadorFutebolLista.getPatrocinio())
			.append("\n");
			
			
			
			
		
			mensagem.append("----------------------- \n ");
		}
		
		mensagem.append("################Lista de Jogadores de Volei Cadastrados################\n");
		
		for (JogadorVolei jogadorVoleiLista: jogadoresVolei) {
			
			mensagem.append("Identificador: ")
			.append(jogadorVoleiLista.getIdentificador())
			.append("\n");
			
			mensagem.append("Nome do Jogador de Volei: ")
			.append(jogadorVoleiLista.getNomeAtleta())
			.append("\n");
			
			mensagem.append("Idade do Jogador de Volei: ")
			.append(jogadorVoleiLista.getIdade())
			.append("\n");
			
			mensagem.append("Braço Mais forte do Jogador de Volei: ")
			.append(jogadorVoleiLista.getBracoMaisForte())
			.append("\n");
			
			mensagem.append("Valor recebido por pontos: ")
			.append(jogadorVoleiLista.getQtdPonto())
			.append("\n");
			

			mensagem.append("Valor Salario: ")
			.append(jogadorVoleiLista.getSalario())
			.append("\n");
			
			mensagem.append("O valor do patrocinio é: ")
			.append(jogadorVoleiLista.getPatrocinio())
			.append("\n");
			
			mensagem.append("----------------------- \n ");
			
		}
		
		JOptionPane.showMessageDialog(null, mensagem.toString(),"Lista De Atletas", JOptionPane.INFORMATION_MESSAGE);
		
		
		
	}
	//Recebe a string, valida e retornar o numero inteiro
	public static int validaInteiroEretornaInt(String numeroString) {
		int numeroInteiro = 0;
		
		if(numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null,"Valor inválido");
		}else {
		try {
			
			
			numeroInteiro = Integer.parseInt(numeroString);// Transforma em Inteiro
			
			
			
			//Só vai cair no Catch se não conseguir converter o numeroString em inteiro
		}catch (Exception e) {
			
			
			JOptionPane.showMessageDialog(null,"Apenas Numeros.");// Comunica para o usuario
			System.out.println("O valor: " + e.getMessage() + "Não pode ser convertido para inteiro."); // Comunica para o DEV
		}	
			
			
		}
		return numeroInteiro;
	}
	
	public static Double validaDoubleEretornaDouble(String numeroString) {
		Double numeroDecimal = 0.0;
		
		if(numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null,"Valor inválido");
		}else {
			
			try {
				numeroDecimal = Double.parseDouble(numeroString);
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Apenas Numeros.");// Comunica para o usuario
				System.out.println("O valor: " + e.getMessage() + "Não pode ser convertido para inteiro."); // Comunica para o DEV
			}
		}
		
		return numeroDecimal;
	}
	
	//Esse metodo retorna verdadeiro se a String tiver apenas letras
	public static boolean somenteLetras(String texto) {
		
		if(texto == null || texto.isBlank()) {
			JOptionPane.showMessageDialog(null,"Inválido!");
			return false;
		}
		//for(tradicional)
		//texto.length() -> Conta quantos caracteres tem na String
		//int indice = 0 -> Indica que o indice começa na posição 0
		//indice++ -> Vai incrementar mais uma posição no valor de indice
		// Character.isLetter Retorna verdadeiro se o Char for uma letra e falso se não for
		//charAt recebe um inteiro e retona o Char de acordo com a posição enviada.
		//! -> O is isLetter retorna verdadeiro, ele inverte a logica do IF para que o metodo não retorne falso
		
		int qtdCaracterString = texto.length();
		
		for(int indice = 0; indice < qtdCaracterString; indice++) {
			
			char caracterAtual = texto.charAt(indice);
			
			if(!Character.isLetter(caracterAtual)) {
				JOptionPane.showMessageDialog(null, "Somente Letras;");
				return false;
			}
			
		}
		return true;
		
	}
	



}
