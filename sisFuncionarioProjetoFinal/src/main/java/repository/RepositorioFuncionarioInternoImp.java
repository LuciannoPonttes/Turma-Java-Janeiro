package repository;

import java.util.List;

import dao.DaoFuncionarioInterno;
import dao.DaoFuncionarioTerceirizado;
import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;

public class RepositorioFuncionarioInternoImp implements RepositorioFuncionarioInterno {

	
	@Override
	public boolean salvarFuncionarioInterno(FuncionarioInterno fucnionarioInterno) {
		return DaoFuncionarioInterno.salvarFuncionarioInterno(fucnionarioInterno) ;
	}

	@Override
	public List<FuncionarioInterno> listarFuncionarioInterno() {
		return DaoFuncionarioInterno.listar() ;
	}
	
	@Override
	public FuncionarioInterno buscarFuncionarioInternoCpf(String cpf) {
		return DaoFuncionarioInterno.buscarPorCpf(cpf);
	}

	@Override
	public boolean deletarInterno(String cpf) {
		return DaoFuncionarioInterno.deletarInterno(cpf);
	}

	@Override
	public boolean alterarInterno(FuncionarioInterno funcionarioInterno) {
		return DaoFuncionarioInterno.alterarInterno(funcionarioInterno);
	}

}
