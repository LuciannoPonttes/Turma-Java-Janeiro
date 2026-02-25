package repository;

import java.util.List;

import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;

public interface RepositorioFuncionarioTerceirizado {
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado);
	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado();
	public FuncionarioTerceirizado buscarFuncionarioTerceirizadoCpf (String cpf);
	public boolean deletarTerceirizado(String cpf);
	public boolean alterarTerceirizado(FuncionarioTerceirizado funcionario);
}
