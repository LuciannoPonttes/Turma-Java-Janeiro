package repositorio;

import java.util.List;

import entidade.Atendente;


public interface RepositorioAtendente {
	
	public  boolean salvarAtendente(Atendente atendente); // Assinatura
	public List<Atendente> listarAtendente ();

}
