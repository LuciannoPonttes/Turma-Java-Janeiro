package codigoFonte;

public class JogadorVolei extends Atleta {
	

	private String bracoMaisForte;
	private Double valorPorPontos;
	private int qtdPonto;
	/*
	public JogadorVolei(String nomeAtletaConstrutor, int idadeAtletaConstrutor, String bracoMaisForteConstrutor, Double valorPorPontosConstrutor, int qtdPontoConstrutor) {
		super(nomeAtletaConstrutor, idadeAtletaConstrutor);
		this.bracoMaisForte = bracoMaisForteConstrutor;
		this.valorPorPontos = valorPorPontosConstrutor;
		this.qtdPonto = qtdPontoConstrutor;
		
	}

	public JogadorVolei() {
		super();// Indicando que vai usar a superClasse
	}
	
	
	*/
	
	
	public JogadorVolei(long identificadorConstrutor) {
		super(identificadorConstrutor);
	}
	
	
	
	
	public String getBracoMaisForte() {
		return bracoMaisForte;
	}
	public void setBracoMaisForte(String bracoMaisForte) {
		this.bracoMaisForte = bracoMaisForte;
	}
	public Double getValorPorPontos() {
		return valorPorPontos;
	}
	public void setValorPorPontos(Double valorPorPontos) {
		verificarNumeroNegativo(valorPorPontos);
		this.valorPorPontos = valorPorPontos;
		
	}
	//Metodo que a classe pai obriga a implementar
	@Override
	protected Double calcularPagamento() {
		return valorPorPontos * qtdPonto;
	}
	public int getQtdPonto() {
		return qtdPonto;
	}
	public void setQtdPonto(int qtdPonto) {
		verificarNumeroNegativo( (double)qtdPonto);
		this.qtdPonto = qtdPonto;
	}
	
	
	@Override
	protected Double calcularPatrocinio() {
		Double trintaPorCentoSalario = getSalario() * 0.3;
		Double trintaPorCentoQtdPontosxTres = (qtdPonto * 0.3) * 4; 
		return trintaPorCentoSalario + trintaPorCentoQtdPontosxTres;
	}

	
	
}
