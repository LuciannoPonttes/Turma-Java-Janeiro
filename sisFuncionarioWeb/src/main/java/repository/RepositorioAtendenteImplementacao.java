package repository;

import java.util.List;

import dao.DaoAtendente;
import model.Atendente;



public class RepositorioAtendenteImplementacao implements RepositorioAtendente {
	
	@Override
	public boolean deletarAtendente(String cpf) {
		return DaoAtendente.deletarAssistente(cpf);
	}

	@Override
	public Atendente buscarPorAtendente(String cpf) {
		return DaoAtendente.buscarPorCpf(cpf);
	}
	
	
	@Override
	public boolean salvarAtendente(Atendente atendente) {
		
		atendente.setNome(textoMaiusculo(atendente.getNome()));
		atendente.setSetor(textoMaiusculo(atendente.getSetor()));
		
		return DaoAtendente.salvarAtendenteNobanco(atendente);
	}

	@Override
	public List<Atendente> listarAtendente() {
		return DaoAtendente.listarAtendenteNoBanco();
	}

	@Override
	public boolean alterarAtendente(Atendente atendente) {
		atendente.setNome(textoMaiusculo(atendente.getNome()));
		atendente.setSetor(textoMaiusculo(atendente.getSetor()));
		return DaoAtendente.alterarAtendente(atendente);
	}
	
	public String textoMaiusculo (String texto) {
		return texto.toUpperCase();
	}



}
