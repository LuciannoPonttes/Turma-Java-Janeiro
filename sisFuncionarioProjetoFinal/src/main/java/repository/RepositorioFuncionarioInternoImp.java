package repository;

import dao.DaoFuncionarioInterno;
import model.FuncionarioInterno;

public class RepositorioFuncionarioInternoImp implements RepositorioFuncionarioInterno {

	
	
	
	@Override
	public boolean salvarFuncionarioInterno(FuncionarioInterno fucnionarioInterno) {
		return DaoFuncionarioInterno.salvarFuncionarioInterno(fucnionarioInterno) ;
	}

}
