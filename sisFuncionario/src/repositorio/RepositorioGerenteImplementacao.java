package repositorio;

import java.util.List;

import bancoDados.dao.DaoGerente;
import entidade.Gerente;

public class RepositorioGerenteImplementacao implements RepositorioGerente {

	DaoGerente daoGerente = new DaoGerente();
	
	@Override
	public boolean salvarGerente(Gerente gerente) {
		return daoGerente.salvarGerenteNobanco(gerente);
	}

	@Override
	public List<Gerente> listarGerente() {
		
		return daoGerente.listarGerenteDoBanco();
	}

	
	

}
