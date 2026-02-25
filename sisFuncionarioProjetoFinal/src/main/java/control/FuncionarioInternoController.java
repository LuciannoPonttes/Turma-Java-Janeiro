package control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioInternoImp;
import repository.RepositorioFuncionarioTerceirizadoImp;
import util.CripSenha;

/**
 * Servlet implementation class FuncionarioInternoController
 */
@WebServlet("/FuncionarioInternoController")
public class FuncionarioInternoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioInternoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RepositorioFuncionarioInternoImp repo = new RepositorioFuncionarioInternoImp();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			repo.deletarInterno(cpf);
		}

		if ("editar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			FuncionarioInterno funcionarioEdit = repo.buscarFuncionarioInternoCpf(cpf);
			request.setAttribute("funcionarioEdit", funcionarioEdit);// o atendentEdit só vai existir no servidor se
																		// essa linha dor executada
		}

		request.setAttribute("listaFuncionarios", repo.listarFuncionarioInterno());
		request.getRequestDispatcher("/funcionarioInterno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Random random = new Random();

		RepositorioFuncionarioInternoImp repo = new RepositorioFuncionarioInternoImp();

		FuncionarioInterno funcionario = new FuncionarioInterno();
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setMatricula(request.getParameter("matricula"));
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setDatadataNascimento(request.getParameter("nascimento"));
		funcionario.setCargo(request.getParameter("cargo"));
		funcionario.setSalario(Double.parseDouble(request.getParameter("salario")));
		funcionario.setPlr(calcularPlr(funcionario.getSalario()));
		funcionario.setSenha(CripSenha.codificar(Integer.toString(random.nextInt(100, 999999))));

		if ("editar".equals(acao)) {
			repo.alterarInterno(funcionario);
		} else {
			repo.salvarFuncionarioInterno(funcionario);

		}

		response.sendRedirect(request.getContextPath() + "/FuncionarioInternoController");
	}
	
	public Double calcularPlr(Double salario) {
		return (salario * 0.8) + salario;
		
	}
}
