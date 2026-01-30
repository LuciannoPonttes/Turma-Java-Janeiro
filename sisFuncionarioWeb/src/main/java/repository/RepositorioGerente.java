package repository;

import java.util.List;

import model.Gerente;



public  interface RepositorioGerente {

	public  boolean salvarGerente(Gerente gerente); // Assinatura
	public List<Gerente> listarGerente();
	public boolean deletarGerente(String cpf);
	
}
