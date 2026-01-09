package codigoFonte;

import java.util.Scanner;

public class Principal {
	
	
	public static void main(String [] args) {
		
		
		// Para Depurar(Debugar) linha por linha usamos a tecla F6
		// Para Depurar de um BreakPoint para o outro (sem ser linha por linha) usamos a tecla F8 
		
		//System.out.println("Digite F para Jogador de Futebol ou V para jogador de Volei:");// Imprime uma String no console (Saida de Dados)
		//entradaDados.next();
		
		Scanner entradaDados = new Scanner(System.in); // Criando e inicializando o objeto entradaDeDados do tipo Scanner
		JogadorFutebol jogadorFutebolObjeto = new JogadorFutebol();
		JogadorVolei jogadorVoleiObjeto = new JogadorVolei();
		
		System.out.println("###########Sistema de Cadastro de Atleta#############");
		
		System.out.println("Digite F para Jogador(a) de Futebol ou V para Jogador(a) de Volei:");// Imprime uma String no console (Saida de Dados)
		String opcao = entradaDados.next();
		
		if(opcao.equals("F")) {
			
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
		
			
			System.out.println("O nome do jogador é: " + jogadorFutebolObjeto.getNomeAtleta());
			
			System.out.println("A idade do jogador é: " + jogadorFutebolObjeto.getIdade());
			
			System.out.println("A perna mais forte é: " + jogadorFutebolObjeto.getPernaMaisForte());
			
			System.out.println("O valor por golt marcado é: " + jogadorFutebolObjeto.getvalorPorGol());
			
			System.out.println("O valor: " + jogadorFutebolObjeto.calcularPagamento());
			
			
		}
		
		if(opcao.equals("V")) {
			
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
			
			System.out.println("O nome do jogador é: " + jogadorVoleiObjeto.getNomeAtleta());
			
			System.out.println("A idade do jogador é: " + jogadorVoleiObjeto.getIdade());
			
			System.out.println("A braco mais forte é: " + jogadorVoleiObjeto.getBracoMaisForte());
			
			System.out.println("O valor por ponto marcado é: " + jogadorVoleiObjeto.getValorPorPontos());
			
			System.out.println("O valor: " + jogadorVoleiObjeto.calcularPagamento());
			
			
			
		}
		
	
		System.out.println("##########Encerrado########");
		

		
	}
		

}
