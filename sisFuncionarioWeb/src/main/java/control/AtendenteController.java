package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Atendente;
import repository.RepositorioAtendenteImplementacao;
import util.CripSenha;

/**
 * Servlet implementation class AtendenteController
 */
@WebServlet("/AtendenteController")
public class AtendenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AtendenteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RepositorioAtendenteImplementacao atendenteImplementacao = new RepositorioAtendenteImplementacao();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			atendenteImplementacao.deletarAtendente(cpf);
		}
		
		if ("editar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			Atendente atendenteEdit = atendenteImplementacao.buscarPorAtendente(cpf);
			request.setAttribute("atendentEdit", atendenteEdit );// o atendentEdit só vai existir no servidor se essa linha dor executada
		}
		

		request.setAttribute("listaAtendentes", atendenteImplementacao.listarAtendente());
		request.getRequestDispatcher("/AtendenteCrud.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Random random = new Random();
	
		RepositorioAtendenteImplementacao repositorioAtendente = new RepositorioAtendenteImplementacao();

		Atendente atendente = new Atendente();
		atendente.setCpf(request.getParameter("cpf"));
		atendente.setNome(request.getParameter("nome"));
		atendente.setSetor(request.getParameter("setor"));
		atendente.setSenha(CripSenha.codificar(Integer.toString(random.nextInt(100, 999999))));
		
		

		if("editar".equals(acao)) {
			repositorioAtendente.alterarAtendente(atendente);
		}else {
			repositorioAtendente.salvarAtendente(atendente);
			
		}
		

		response.sendRedirect(request.getContextPath() + "/AtendenteController");
	}
	

}
