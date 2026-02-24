package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FuncionarioInterno;
import repository.RepositorioFuncionarioInternoImp;
import util.CripSenha;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	RepositorioFuncionarioInternoImp repoInterno = new RepositorioFuncionarioInternoImp();
	
	
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();

		}

		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(CripSenha.codificar("123"));
		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		FuncionarioInterno funcionarioInterno = repoInterno.buscarFuncionarioInternoCpf(cpf);
		

		
		
		if (funcionarioInterno != null) {
			String senhaDescrip = CripSenha.decodificar(funcionarioInterno.getSenha());
			if (cpf.equals(funcionarioInterno.getCpf()) && senha.equals(senhaDescrip)) {
				HttpSession session = request.getSession();// Vou criar uma sessão
				session.setAttribute("usuarioLogado", funcionarioInterno);
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/erro.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/erro.jsp");
		}
	}

}
