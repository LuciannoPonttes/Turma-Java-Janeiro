package codigoFonte;

public abstract class Atleta {
	
	private String nomeAtleta; // String é um tipo de variável que armazena uma cadeia de caracteres.
	private int idade; // int é um tipo de variável que armazena numeros inteiros
	private Double patrocinio;
	private Double salario;
	
	//Polimorfismo
	protected abstract  Double calcularPagamento();// Apenas a assinatura, ou seja os filhos precisam implementar o comportamento.
	protected abstract  Double calcularPatrocinio();
	
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

	public Double getPatrocinio() {
		return patrocinio;
	}

	public void setPatrocinio(Double patrocinio) {
		this.patrocinio = patrocinio;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
