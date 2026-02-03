package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atendente;
import repository.RepositorioAtendente;
import repository.RepositorioAtendenteImplementacao;
import util.CripSenha;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RepositorioAtendenteImplementacao atendenteImplementacao = new RepositorioAtendenteImplementacao();

		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		Atendente atendente = atendenteImplementacao.buscarPorAtendente(cpf);
		String senhaDescrip = CripSenha.decodificar(atendente.getSenha());

		if (atendente != null) {
			if (cpf.equals(atendente.getCpf()) && senha.equals(senhaDescrip)) {
				HttpSession session = request.getSession();// Vou criar uma sessão
				session.setAttribute("usuarioLogado", atendente);
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/erro.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/erro.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session != null) {
			session.invalidate();
		
		}
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}
	
	
	


	

}
