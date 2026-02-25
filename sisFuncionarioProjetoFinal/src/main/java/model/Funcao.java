package model;



public enum Funcao {
    
	AUXILIAR_SERVICOS_GERAIS("Auxiliar de serviços gerais"),
    ENCARREGADO("Encarregado"),
    AJUDANTE("Ajudante");

	
    private final String descricao;

    Funcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}