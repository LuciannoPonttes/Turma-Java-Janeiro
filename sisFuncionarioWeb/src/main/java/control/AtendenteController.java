package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Atendente;
import repository.RepositorioAtendente;
import repository.RepositorioAtendenteImplementacao;

/**
 * Servlet implementation class AtendenteController
 */
@WebServlet("/AtendenteController")
public class AtendenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtendenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Atendente atendente = new Atendente();
		atendente.setCpf(request.getParameter("cpf"));
		atendente.setNome(request.getParameter("nome"));
		atendente.setSetor(request.getParameter("setor"));
		
		RepositorioAtendenteImplementacao repositorioAtendente = new RepositorioAtendenteImplementacao();
		repositorioAtendente.salvarAtendente(atendente);
	}

}
