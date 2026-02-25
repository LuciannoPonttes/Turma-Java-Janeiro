package repository;


import java.util.List;

import dao.DaoFuncionarioTerceirizado;
import model.FuncionarioTerceirizado;

public class RepositorioFuncionarioTerceirizadoImp implements RepositorioFuncionarioTerceirizado {

	@Override
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionario) {
		return DaoFuncionarioTerceirizado.salvarFuncionarioTerceirizado(funcionario);
	}

	@Override
	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado() {
		return DaoFuncionarioTerceirizado.listarFuncionarioTerceirizadoNoBanco();
	}

	@Override
	public FuncionarioTerceirizado buscarFuncionarioTerceirizadoCpf(String cpf) {
		return DaoFuncionarioTerceirizado.buscarPorCpf(cpf);
	}

	@Override
	public boolean deletarTerceirizado(String cpf) {
		return DaoFuncionarioTerceirizado.deletarTerceirizado(cpf);
	}

	@Override
	public boolean alterarTerceirizado(FuncionarioTerceirizado funcionario) {
		return DaoFuncionarioTerceirizado.alterarTerceirizado(funcionario) ;
	}

}
