package codigoFonte;

public class JogadorFutebol extends Atleta {
	
	private String pernaMaisForte;
	private Double valorPorGol; // Para armazenar dados do tipo decimal.
	private int qtdGol ; // Para armazenar dados do tipo decimal.

	public String getPernaMaisForte() {
		return pernaMaisForte;
	}
	
	public void setPernaMaisForte(String pernaMaisForteChegando) {
		this.pernaMaisForte = pernaMaisForteChegando;
	}
	
	public Double getvalorPorGol() {
		return valorPorGol;
	}
	
	public void setValorPorGol(Double valorPorGolChegando ) {
		verificarNumeroNegativo(valorPorGolChegando);
		this.valorPorGol = valorPorGolChegando;
	}

	// Metodo que a Classe (Pai) obriga a classe JogadorFutebol implementar
	@Override // Sobrepor - SobEscrever - Escreve por cima e etc..
	protected Double calcularPagamento() {
			
		return valorPorGol * qtdGol;
	}

	public int getQtdGol() {
		return qtdGol;
	}

	public void setQtdGol(int qtdGol) {
		verificarNumeroNegativo((double)qtdGol);
		this.qtdGol = qtdGol;
	}

	public Double getValorPorGol() {
		return valorPorGol;
	}

	@Override
	protected Double calcularPatrocinio() {
		Double vintePorCentoSalario = getSalario() * 0.2;
		Double vintePorCentoQtdPontosxTres = (qtdGol * 0.2) * 3; 		
		
		return vintePorCentoSalario + vintePorCentoQtdPontosxTres;
	}

}
