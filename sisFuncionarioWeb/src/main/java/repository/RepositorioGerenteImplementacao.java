package repository;

import java.util.List;

import dao.DaoGerente;
import model.Gerente;


public class RepositorioGerenteImplementacao implements RepositorioGerente {

	 
	
	@Override
	public boolean salvarGerente(Gerente gerente) {
		return DaoGerente.salvarGerenteNobanco(gerente);
	}

	@Override
	public List<Gerente> listarGerente() {
		return DaoGerente.listarGerenteDoBanco();
	}

	@Override
	public boolean deletarGerente(String cpf) {
		return DaoGerente.deletarDeletar(cpf);
	}

	

	
	

}
