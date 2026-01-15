package codigoFonte;

public abstract class Atleta {
	
	private String nomeAtleta; // String é um tipo de variável que armazena uma cadeia de caracteres.
	private int idade; // int é um tipo de variável que armazena numeros inteiros
	private long identificador; // Long é usado para armazenar numeros grandes
	
	
	
	private Double patrocinio;
	private Double salario;
	

	//Polimorfismo
	//Todas as classes filhas(subclasses) são obrigadas a implementar os metodos de acordo com a sua necessidade
	protected abstract  Double calcularPagamento();// Apenas a assinatura, ou seja os filhos precisam implementar o comportamento.
	protected abstract  Double calcularPatrocinio();
	
	
	//Construtor de Atleta inicializando o objeto com nome e idade
	public Atleta(String nomeAtletaConstrutor, int idadeAtletaConstrutor) {
		this.nomeAtleta = nomeAtletaConstrutor;
		this.idade = idadeAtletaConstrutor;
	}
	
	public Atleta(String nomeConstrutor) {
		this.nomeAtleta = nomeConstrutor;
	}
	
	//Construtor Vazio
	public Atleta() {
		
	}
	
	
	public Atleta(long identificador) {
		this.identificador = identificador;
	}
	
	//Aqui a gente mantém a herança
	// Todas as classes filhas(subclasse) herdam 100% o comportamento do metodo 
	//Regra de negocio
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
	public long getIdentificador() {
		return identificador;
	}
	
	
	
	
	
}
