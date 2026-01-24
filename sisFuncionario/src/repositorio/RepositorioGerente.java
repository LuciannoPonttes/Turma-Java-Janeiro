package repositorio;

import java.util.List;

import entidade.Gerente;

public  interface RepositorioGerente {

	public  boolean salvarGerente(Gerente gerente); // Assinatura
	public List<Gerente> listarGerente();
	
	
}
