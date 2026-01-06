import java.util.Date; // Import da classe Date

//Imprimir a data atual no console
public class DataAtual{

	public static void main(String [] args){


		System.out.println("Rodou no JAVA - Receba Asp.net"); // Testar para verificar se está rodando

		Date data = new Date(); // Declarando que a classe Date vai existir na classe DataAtual

		int tempo = (int)data.getTime();
		System.out.println("Tempo:" + tempo );

	}
}