package repository;

import java.util.List;

import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;

//Obriga todos as classe que implementam essa interface a usar esse metodos
public interface RepositorioFuncionarioInterno {
	
	public boolean salvarFuncionarioInterno(FuncionarioInterno fucnionarioInterno);
	public List<FuncionarioInterno> listarFuncionarioInterno();
	public FuncionarioInterno buscarFuncionarioInternoCpf (String cpf);
	public boolean deletarInterno(String cpf);
	public boolean alterarInterno(FuncionarioInterno funcionarioInterno);

}
