import java.util.Scanner;

// Sistema de cadastro de Atleta
public class Principal{ // A abertura da Chave indica o inicio da classe

	

	public static void main( String [] args){       // A abertura da Chave indica o inicio do método main
		
		System.out.println("#################CADASTRO DE ATLETA####################### ");
		
		Scanner entradaDeDados = new Scanner(System.in); // Criando e inicializando o objeto entradaDeDados do tipo Scanner
		JogadorFutebol jogadorFutebol = new JogadorFutebol(); 
		JogadorVolei jogadorVolei = new JogadorVolei();




		System.out.println("Digite F para Jogador de futebol e V para Jogador de Volei: ");// Imprime uma String no console (Saida de Dados)
		String opcao =  entradaDeDados.next();

		if( opcao.equals("F")){
			System.out.println("Digite o Nome do Jogador De Futebol: ");// Imprime uma String no console (Saida de Dados)
			jogadorFutebol.nomeAtleta = entradaDeDados.next();

			System.out.println("Digite a idade do jogador: ");// Imprime uma String no console (Saida de Dados)
			jogadorFutebol.idade = entradaDeDados.nextInt();

			System.out.println("Digite a perna mais forte do jogador: ");// Imprime uma String no console (Saida de Dados)
			jogadorFutebol.pernaMaisForte = entradaDeDados.next();

			System.out.println("Digite o valor por gol do jogador: ");// Imprime uma String no console (Saida de Dados)
			jogadorFutebol.valorPorGol = entradaDeDados.nextDouble();

			System.out.println("O nome do jogador: " + jogadorFutebol.nomeAtleta );// Imprime uma String no console (Saida de Dados)
			System.out.println("A idade do jogador: " + jogadorFutebol.idade );// Imprime uma String no console (Saida de Dados)
			System.out.println("A perna mais forte: " + jogadorFutebol.pernaMaisForte );// Imprime uma String no console (Saida de Dados)
			System.out.println("O valor por gols: " + jogadorFutebol.valorPorGol );// Imprime uma String no console (Saida de Dados)


		}

		if(opcao.equals("V")){

			System.out.println("Digite o Nome do Jogador De Volei: ");// Imprime uma String no console (Saida de Dados)
			jogadorVolei.nomeAtleta = entradaDeDados.next();

			System.out.println("Digite a Idade do Jogador De Volei: ");// Imprime uma String no console (Saida de Dados)
			jogadorVolei.idade = entradaDeDados.nextInt();

			System.out.println("Digite o Braco mais forte do Jogador De Volei: ");// Imprime uma String no console (Saida de Dados)
			jogadorVolei.bracoMaisForte = entradaDeDados.next();

			System.out.println("Digite o valor por ponto do Jogador De Volei: ");// Imprime uma String no console (Saida de Dados)
			jogadorVolei.valorPorPontos = entradaDeDados.nextDouble();


			System.out.println("O nome do jogador de volei: " + jogadorVolei.nomeAtleta );// Imprime uma String no console (Saida de Dados)
			System.out.println("A idade do jogador de Volei: " + jogadorVolei.idade );// Imprime uma String no console (Saida de Dados)
			System.out.println("O braco mais forte: " + jogadorVolei.bracoMaisForte );// Imprime uma String no console (Saida de Dados)
			System.out.println("O valor por pontos: " + jogadorVolei.valorPorPontos );// Imprime uma String no console (Saida de Dados)

		
			

		}



		


		System.out.println("#################Fim####################### ");

	}    //O fechamento da chave indica o final do metodo






}          //O fechamento da chave indica o final da classe(Essa deve precisar ficar alinhada com o texto que inicia classe)