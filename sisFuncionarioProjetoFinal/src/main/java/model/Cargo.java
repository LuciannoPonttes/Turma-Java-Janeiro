package model;

public enum Cargo {

	
	GERENTE("Gerente do Setor"),
    COORDENADOR("Coordenador DO SETOR"),
    ASSISTENTE("Assistente Geral"),
	ASSISTENTE3("Assistente Geral 3");

	
    private final String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
	
	
	
}
