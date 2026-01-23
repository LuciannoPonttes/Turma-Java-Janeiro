package repositorio;

import bancoDados.dao.DaoAtendente;
import entidade.Atendente;

public class RepositorioAtendenteImplementacao implements RepositorioAtendente {

	
	
	@Override
	public boolean salvarAtendente(Atendente atendente) {
		DaoAtendente daoAtendente = new DaoAtendente();
		return daoAtendente.salvarAtendenteNobanco(atendente);
	}

}
