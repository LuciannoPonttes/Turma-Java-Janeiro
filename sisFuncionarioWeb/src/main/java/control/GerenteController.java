package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gerente;
import repository.RepositorioGerente;
import repository.RepositorioGerenteImplementacao;

/**
 * Servlet implementation class GerenteController
 */
@WebServlet("/GerenteController")
public class GerenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		Gerente gerente = new Gerente();
		gerente.setCpf(request.getParameter("cpf"));
		gerente.setNome(request.getParameter("nome"));
		gerente.setGerencia(request.getParameter("gerencia"));
		RepositorioGerenteImplementacao repositorioGerente = new RepositorioGerenteImplementacao();
		repositorioGerente.salvarGerente(gerente);
	}

}
