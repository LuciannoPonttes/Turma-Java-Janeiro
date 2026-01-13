package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			
			String opcaoCadastroAtleta = JOptionPane.showInputDialog("Digite F para Jogador(a) de Futebol ou V para Jogador(a) de Volei: ");
			
			
			if (opcaoCadastroAtleta.equals("F")) {
				JogadorFutebol jogadorFutebolObjeto = new JogadorFutebol();
			
				jogadorFutebolObjeto.setNomeAtleta(JOptionPane.showInputDialog("Qual o nome do Jogador(a) de Futebol: "));
				
				int idadeTemporaria; // Variavel para receber o resultado do metodo validaInteiroEretornaInt
				
				do {
					idadeTemporaria = validaInteiroEretornaInt(JOptionPane.showInputDialog("Qual a idade do Jogador(a) de Futebol:")); // NextInt para receber inteiros do console
					if(idadeTemporaria != 0) {
						jogadorFutebolObjeto.setIdade(idadeTemporaria);
						
					}
					
					
				}while(idadeTemporaria == 0);
				
				
				jogadorFutebolObjeto.setPernaMaisForte(JOptionPane.showInputDialog("Qual a perna mais forte: "));
			
				
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

			if (opcaoCadastroAtleta.equals("V")) {
				JogadorVolei jogadorVoleiObjeto = new JogadorVolei();
				
				
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
		
		
		System.out.println("################Lista de Jogadores de futebol Cadastrados################");
		for (JogadorFutebol jogadorFutebolLista: jogadoresFutebol) {
			System.out.println("Nome do Jogador de Futebol: " + jogadorFutebolLista.getNomeAtleta());
			System.out.println("Idade do Jogador de Futebol: " + jogadorFutebolLista.getIdade());
			System.out.println("Perna Mais forte do Jogador de Futebol: " + jogadorFutebolLista.getPernaMaisForte());
			System.out.println("Valor recebido por gol: " + jogadorFutebolLista.getvalorPorGol());
			System.out.println("Quantidade de gol: " + jogadorFutebolLista.getQtdGol());
			System.out.println("Valor Salario: " + jogadorFutebolLista.getSalario());
			System.out.println("O valor do patrocinio é: " + jogadorFutebolLista.getPatrocinio());
			
			System.out.println("----------------------------------------------------------------");
			
			
		}
		
		System.out.println("############Lista de Jogadores de Volei Cadastrados##############");
		for (JogadorVolei jogadorVoleiLista: jogadoresVolei) {
			System.out.println("Nome do Jogador de Volei: " + jogadorVoleiLista.getNomeAtleta());
			System.out.println("Idade do Jogador de Volei: " + jogadorVoleiLista.getIdade());
			System.out.println("Braço Mais forte do Jogador de Volei: " + jogadorVoleiLista.getBracoMaisForte());
			System.out.println("Valor recebido por pontos: " + jogadorVoleiLista.getValorPorPontos());
			System.out.println("Quantidade de pontos: " + jogadorVoleiLista.getQtdPonto());
			System.out.println("Valor Salario: " + jogadorVoleiLista.getSalario());
			System.out.println("O valor do patrocinio é: " + jogadorVoleiLista.getPatrocinio());
			
			System.out.println("----------------------------------------------------------------");
			
			
		}
		
		
		System.out.println("##########Encerrado########");
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

}
