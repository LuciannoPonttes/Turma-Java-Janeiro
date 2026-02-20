package repository;


import java.util.List;

import dao.DaoFuncionarioTerceirizado;
import model.FuncionarioTerceirizado;

public class RepositorioFuncionarioTerceirizadoImp implements RepositorioFuncionarioTerceirizado {

	@Override
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionario) {
		// TODO Auto-generated method stub
		return DaoFuncionarioTerceirizado.salvarFuncionarioTerceirizado(funcionario);
	}

	@Override
	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado() {
		// TODO Auto-generated method stub
		return DaoFuncionarioTerceirizado.listarFuncionarioTerceirizadoNoBanco();
	}

	@Override
	public FuncionarioTerceirizado buscarFuncionarioTerceirizadoCpf(String cpf) {
		// TODO Auto-generated method stub
		return DaoFuncionarioTerceirizado.buscarPorCpf(cpf);
	}

}
