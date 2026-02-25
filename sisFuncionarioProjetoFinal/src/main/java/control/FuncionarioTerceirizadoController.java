package control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioTerceirizadoImp;
import util.CripSenha;

/**
 * Servlet implementation class FuncionarioTerceirizadoController
 */
@WebServlet("/FuncionarioTerceirizadoController")
public class FuncionarioTerceirizadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionarioTerceirizadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RepositorioFuncionarioTerceirizadoImp repo = new RepositorioFuncionarioTerceirizadoImp();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			repo.deletarTerceirizado(cpf);
		}
		
		if ("editar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			FuncionarioTerceirizado funcionarioEdit = repo.buscarFuncionarioTerceirizadoCpf(cpf);
			request.setAttribute("funcionarioEdit", funcionarioEdit );// o atendentEdit só vai existir no servidor se essa linha dor executada
		}
		

		request.setAttribute("listaFuncionarios", repo.listarFuncionarioTerceirizado());
		request.getRequestDispatcher("/funcionarioTerceirizado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Random random = new Random();
	
		RepositorioFuncionarioTerceirizadoImp repo = new RepositorioFuncionarioTerceirizadoImp();

		FuncionarioTerceirizado funcionario = new FuncionarioTerceirizado();
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setMatricula(request.getParameter("matricula"));
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setDatadataNascimento(request.getParameter("nascimento"));
		funcionario.setEmpresa(request.getParameter("empresa"));
		funcionario.setFuncao(request.getParameter("funcao"));
		funcionario.setCusto(Double.parseDouble( request.getParameter("custo")));
		funcionario.setSenha(CripSenha.codificar(Integer.toString(random.nextInt(100, 999999))));
		
		

		if("editar".equals(acao)) {
			repo.alterarTerceirizado(funcionario);
		}else {
			repo.salvarFuncionarioTerceirizado(funcionario);
			
		}
		

		response.sendRedirect(request.getContextPath() + "/FuncionarioTerceirizadoController");
	}
}
