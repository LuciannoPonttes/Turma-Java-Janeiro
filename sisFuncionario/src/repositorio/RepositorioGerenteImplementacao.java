package repositorio;

import java.util.List;

import bancoDados.dao.DaoGerente;
import entidade.Gerente;

public class RepositorioGerenteImplementacao implements RepositorioGerente {

	 
	
	@Override
	public boolean salvarGerente(Gerente gerente) {
		return DaoGerente.salvarGerenteNobanco(gerente);
	}

	@Override
	public List<Gerente> listarGerente() {
		return DaoGerente.listarGerenteDoBanco();
	}

	

	
	

}
