package codigoFonte;

public abstract class Atleta {
	
	private String nomeAtleta; // String é um tipo de variável que armazena uma cadeia de caracteres.
	private int idade; // int é um tipo de variável que armazena numeros inteiros
	
	//Polimorfismo
	protected abstract  Double calcularPagamento();// Apenas a assinatura, ou seja os filhos precisam implementar o comportamento.
	
	
	//Aqui a gente mantém a herança
	public void verificarNumeroNegativo(Double valor) {
		if(valor < 0) {
			
			throw new IllegalArgumentException("O valor não pode ser negativo!!!");
		}
	}
	
	
	public String getNomeAtleta() {
		return nomeAtleta;
	}
	
	public void setNomeAtleta(String nomeAtletaChegando) {
		this.nomeAtleta = nomeAtletaChegando;
		
	}
	public void setIdade(int idadeChegando) {
		if(idadeChegando < 0) {
			
			throw new IllegalArgumentException("A idade não pode ser negativa!!!");
		}
		this.idade = idadeChegando;
	}


	public int getIdade() {
		return idade;
	}
	

}
