package repository;

import java.util.List;

import model.Atendente;


public interface RepositorioAtendente {
	
	public  boolean salvarAtendente(Atendente atendente); // Assinatura
	public List<Atendente> listarAtendente ();
	public boolean alterarAtendente(Atendente atendente);
	public boolean deletarAtendente(String cpf);
	public Atendente buscarPorAtendente(String cpf);

}
