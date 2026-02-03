package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gerente;
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

	//Apresenta a pagina do Crud de Gerente com a lista sempre atualizada
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RepositorioGerenteImplementacao gerenteImplementacao = new RepositorioGerenteImplementacao();
		
		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");
		
		if("deletar".equals(acao) && cpf != null && !cpf.isEmpty()  ) {
			gerenteImplementacao.deletarGerente(cpf);
			
		}
		
		
		
		request.setAttribute("listaGerentes", gerenteImplementacao.listarGerente());// Cria na request o objeto lista
		request.getRequestDispatcher("/GerenteCrud.jsp").forward(request, response);//Envia o usuario para a JSP
		
		
		
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
		response.sendRedirect(request.getContextPath()+"/GerenteController"); // Envia o usuario para a AtendenteController
	}

}
