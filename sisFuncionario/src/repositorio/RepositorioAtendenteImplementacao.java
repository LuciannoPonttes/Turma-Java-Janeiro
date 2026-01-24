package repositorio;

import java.util.List;

import bancoDados.dao.DaoAtendente;
import entidade.Atendente;


public class RepositorioAtendenteImplementacao implements RepositorioAtendente {

	
	
	@Override
	public boolean salvarAtendente(Atendente atendente) {
		return DaoAtendente.salvarAtendenteNobanco(atendente);
	}

	@Override
	public List<Atendente> listarAtendente() {
		
		return DaoAtendente.listarAtendenteNoBanco();
	}

}
