package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	

	public static void main(String[] args) {

		// Para Depurar(Debugar) linha por linha usamos a tecla F6
		// Para Depurar de um BreakPoint para o outro (sem ser linha por linha) usamos a
		// tecla F8

		// System.out.println("Digite F para Jogador de Futebol ou V para jogador de
		// Volei:");// Imprime uma String no console (Saida de Dados)
		// entradaDados.next();

		Scanner entradaDados = new Scanner(System.in); // Criando e inicializando o objeto entradaDeDados do tipo										// Scanner
		String opcaoNovoCadastro;// Criado e iniciado como NULL
		
		
		List<JogadorFutebol> jogadoresFutebol = new ArrayList<JogadorFutebol>();//Criação de uma lista de jogadores
		List<JogadorVolei> jogadoresVolei = new ArrayList<JogadorVolei>();
		
		System.out.println("###########Sistema de Cadastro de Atleta#############");
		
		do {
			System.out.println("Digite F para Jogador(a) de Futebol ou V para Jogador(a) de Volei:");// Imprime uma String
			String opcaoCadastro = entradaDados.next();
			
			
			if (opcaoCadastro.equals("F")) {
				JogadorFutebol jogadorFutebolObjeto = new JogadorFutebol();
				System.out.println("Qual o nome do Jogador(a) de Futebol: ");
				jogadorFutebolObjeto.setNomeAtleta(entradaDados.next());

				System.out.println("Qual a idade do Jogador(a) de Futebol:");
				jogadorFutebolObjeto.setIdade(entradaDados.nextInt()); // NextInt para receber inteiros do console

				System.out.println("Qual a perna mais forte: ");
				jogadorFutebolObjeto.setPernaMaisForte(entradaDados.next());

				System.out.println("Valor por gol marcado $: ");
				jogadorFutebolObjeto.setValorPorGol(entradaDados.nextDouble());

				System.out.println("Quantos gols o jogador marcou: ");
				jogadorFutebolObjeto.setQtdGol(entradaDados.nextInt());
				
				jogadorFutebolObjeto.setSalario(jogadorFutebolObjeto.calcularPagamento());
				
				jogadorFutebolObjeto.setPatrocinio(jogadorFutebolObjeto.calcularPatrocinio());
				
				
				jogadoresFutebol.add(jogadorFutebolObjeto);
				
				
				/*
					System.out.println("O nome do jogador é: " + jogadorFutebolObjeto.getNomeAtleta());
	
					System.out.println("A idade do jogador é: " + jogadorFutebolObjeto.getIdade());
	
					System.out.println("A perna mais forte é: " + jogadorFutebolObjeto.getPernaMaisForte());
	
					System.out.println("O valor por golt marcado é: " + jogadorFutebolObjeto.getvalorPorGol());
	
					System.out.println("O valor: " + jogadorFutebolObjeto.calcularPagamento());
				*/

			}

			if (opcaoCadastro.equals("V")) {
				JogadorVolei jogadorVoleiObjeto = new JogadorVolei();
				System.out.println("Qual o nome do Jogador(a) de Volei: ");
				jogadorVoleiObjeto.setNomeAtleta(entradaDados.next());

				System.out.println("Qual a idade do Jogador(a) de Volei:");
				jogadorVoleiObjeto.setIdade(entradaDados.nextInt()); // NextInt para receber inteiros do console

				System.out.println("Qual o braco mais forte: ");
				jogadorVoleiObjeto.setBracoMaisForte(entradaDados.next());

				System.out.println("Valor por pontos marcado $: ");
				jogadorVoleiObjeto.setValorPorPontos(entradaDados.nextDouble());

				System.out.println("Quantidade de pontos marcados $: ");
				jogadorVoleiObjeto.setQtdPonto(entradaDados.nextInt());
				
				jogadorVoleiObjeto.setSalario(jogadorVoleiObjeto.calcularPagamento());
				
				jogadorVoleiObjeto.setPatrocinio(jogadorVoleiObjeto.calcularPatrocinio());			
				
				jogadoresVolei.add(jogadorVoleiObjeto);
				/*
				System.out.println("O nome do jogador é: " + jogadorVoleiObjeto.getNomeAtleta());

				System.out.println("A idade do jogador é: " + jogadorVoleiObjeto.getIdade());

				System.out.println("A braco mais forte é: " + jogadorVoleiObjeto.getBracoMaisForte());

				System.out.println("O valor por ponto marcado é: " + jogadorVoleiObjeto.getValorPorPontos());

				System.out.println("O valor: " + jogadorVoleiObjeto.calcularPagamento());
				*/
			}
			System.out.println("Deseja Cadastrar mais um(S/N): ");
			opcaoNovoCadastro = entradaDados.next();
		}while(opcaoNovoCadastro.equals("S"));
		
		
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

}
