package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioInterno;
import repository.RepositorioFuncionarioInternoImp;

/**
 * Servlet implementation class FuncionarioInternoApiController
 */
@WebServlet("/api/FuncionarioInternoApiController")
public class FuncionarioInternoApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioInternoApiController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	RepositorioFuncionarioInternoImp repo = new RepositorioFuncionarioInternoImp();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");

		FuncionarioInterno funcionarioInterno = jsonParaAtendente(request);

		if (isBlank(funcionarioInterno.getNome()) || isBlank(funcionarioInterno.getCpf())) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			response.getWriter().write("{\"status\":false,\"message\":\"Cpf e Nome são obrigadorios!!!\"}");
			return;
		}
		

		funcionarioInterno.setSenha("impacta");

		repo.salvarFuncionarioInterno(funcionarioInterno);
		response.getWriter().write("{\"ok\":true,\"message\":\"Funcionario Registrado!!\"}");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	
	
	
	
	
	
	
	
	//Metodos de suporte

	private String listaToJson(List<FuncionarioInterno> lista) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("{\"ok\":true,\"data\":[");
	    for (int i = 0; i < lista.size(); i++) {
	        sb.append(funcionarioToJson(lista.get(i)));
	        if (i < lista.size() - 1)
	            sb.append(",");
	    }
	    sb.append("]}");
	    return sb.toString();
	}

	private String funcionarioToJson(FuncionarioInterno a) {
	    return "{"
	        + "\"cpf\":\"" + esc(a.getCpf()) + "\","
	        + "\"nome\":\"" + esc(a.getNome()) + "\","
	        + "\"matricula\":\"" + esc(a.getMatricula()) + "\","
	        + "\"dataNascimento\":\"" + esc(a.getDatadataNascimento()) + "\","
	        + "\"cargo\":\"" + esc(a.getCargo()) + "\","
	        + "\"salario\":" + a.getSalario() + ","
	        + "\"plr\":" + a.getPlr()
	        + "}";
	}

	private String esc(String s) {
	    if (s == null)
	        return "";
	    return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	private FuncionarioInterno jsonParaAtendente(HttpServletRequest request) throws IOException {

	    String body = readBody(request);
	    if (!isBlank(body) && body.trim().startsWith("{")) {

	        String cpf = extractJsonValue(body, "cpf");
	        String nome = extractJsonValue(body, "nome");
	        String matricula = extractJsonValue(body, "matricula");
	        String dataNascimento = extractJsonValue(body, "dataNascimento");
	        String cargo = extractJsonValue(body, "cargo");

	        String salarioStr = extractJsonValue(body, "salario");
	        String plrStr = extractJsonValue(body, "plr");

	        FuncionarioInterno a = new FuncionarioInterno();
	        a.setCpf(cpf);
	        a.setNome(nome);
	        a.setMatricula(matricula);
	        a.setDatadataNascimento(dataNascimento);
	        a.setCargo(cargo);

	        if (salarioStr != null && !salarioStr.isEmpty())
	            a.setSalario(Double.parseDouble(salarioStr));

	        if (plrStr != null && !plrStr.isEmpty())
	            a.setPlr(Double.parseDouble(plrStr));

	        return a;
	    }

	    FuncionarioInterno a = new FuncionarioInterno();
	    a.setCpf(request.getParameter("cpf"));
	    a.setNome(request.getParameter("nome"));
	    a.setMatricula(request.getParameter("matricula"));
	    a.setDatadataNascimento(request.getParameter("dataNascimento"));
	    a.setCargo(request.getParameter("cargo"));

	    String salarioStr = request.getParameter("salario");
	    String plrStr = request.getParameter("plr");

	    if (salarioStr != null && !salarioStr.isEmpty())
	    	a.setSalario(Double.parseDouble(salarioStr));

	    if (plrStr != null && !plrStr.isEmpty())
	        a.setPlr(Double.parseDouble(plrStr));

	    return a;
	}

	private String extractJsonValue(String json, String key) {
	    String pattern = "\"" + key + "\"";
	    int i = json.indexOf(pattern);
	    if (i == -1)
	        return null;
	    int colon = json.indexOf(":", i);
	    if (colon == -1)
	        return null;

	    int firstQuote = json.indexOf("\"", colon + 1);
	    if (firstQuote == -1)
	        return null;
	    int secondQuote = json.indexOf("\"", firstQuote + 1);
	    if (secondQuote == -1)
	        return null;

	    return json.substring(firstQuote + 1, secondQuote);
	}

	private boolean isBlank(String s) {
	    return s == null || s.trim().isEmpty();
	}

	private String readBody(HttpServletRequest request) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    try (BufferedReader br = request.getReader()) {
	        String line;
	        while ((line = br.readLine()) != null)
	            sb.append(line);
	    }
	    return sb.toString();
	}

}
