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
import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioTerceirizadoImp;

/**
 * Servlet implementation class FuncionarioTerceirizadoApiController
 */
@WebServlet("/api/FuncionarioTerceirizadoApiController")
public class FuncionarioTerceirizadoApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioTerceirizadoApiController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	RepositorioFuncionarioTerceirizadoImp repo = new RepositorioFuncionarioTerceirizadoImp();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");

		FuncionarioTerceirizado funcionario = jsonParaFuncionario(request);

		if (isBlank(funcionario.getNome()) || isBlank(funcionario.getCpf())) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			response.getWriter().write("{\"status\":false,\"message\":\"Cpf e Nome são obrigadorios!!!\"}");
			return;
		}
		

		funcionario.setSenha("impacta");

		repo.salvarFuncionarioTerceirizado(funcionario);
		response.getWriter().write("{\"ok\":true,\"message\":\"Funcionario Registrado!!\"}");

	}
	
	
	// ListarTodos ou Buscar por CPF
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.setContentType("application/json; charset=UTF-8");
			String cpf = request.getParameter("cpf");
			String json;

			if (cpf != null) {
				FuncionarioTerceirizado funcionarioTerceirizado = repo.buscarFuncionarioTerceirizadoCpf(cpf);
				if (funcionarioTerceirizado == null) {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					response.getWriter().write("{\"status\":false,\"message\":\"Funcionario não encontrado\"}");
					return;
				} else {
					json = funcionarioToJson(funcionarioTerceirizado);
					response.getWriter().write(json);

				}
			} else {

				List<FuncionarioTerceirizado > funcionarios = repo.listarFuncionarioTerceirizado();
				json = listaToJson(funcionarios);
				response.getWriter().write(json);
			}

		}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

	// Metodos de suporte

	private String listaToJson(List<FuncionarioTerceirizado> lista) {
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

	private String funcionarioToJson(FuncionarioTerceirizado a) {
		return "{" + "\"cpf\":\"" + esc(a.getCpf()) + "\"," + "\"nome\":\"" + esc(a.getNome()) + "\","
				+ "\"matricula\":\"" + esc(a.getMatricula()) + "\"," + "\"dataNascimento\":\""
				+ esc(a.getDatadataNascimento()) + "\"," + "\"funcao\":\"" + esc(a.getFuncao()) + "\"," + "\"empresa\":"
				+ a.getEmpresa() + "," + "\"curso\":" + a.getCusto() + "}";
	}

	private String esc(String s) {
		if (s == null)
			return "";
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	private FuncionarioTerceirizado jsonParaFuncionario(HttpServletRequest request) throws IOException {

		String body = readBody(request);
		if (!isBlank(body) && body.trim().startsWith("{")) {

			String cpf = extractJsonValue(body, "cpf");
			String nome = extractJsonValue(body, "nome");
			String matricula = extractJsonValue(body, "matricula");
			String dataNascimento = extractJsonValue(body, "dataNascimento");
			String funcao = extractJsonValue(body, "funcao");

			String empresa = extractJsonValue(body, "empresa");
			String custo = extractJsonValue(body, "custo");

			FuncionarioTerceirizado a = new FuncionarioTerceirizado();
			a.setCpf(cpf);
			a.setNome(nome);
			a.setMatricula(matricula);
			a.setDatadataNascimento(dataNascimento);
			a.setFuncao(funcao);
			a.setEmpresa(empresa);

			if (custo != null && !custo.isEmpty())
				a.setCusto(Double.parseDouble(custo));

			return a;
		}

		FuncionarioTerceirizado a = new FuncionarioTerceirizado();
		a.setCpf(request.getParameter("cpf"));
		a.setNome(request.getParameter("nome"));
		a.setMatricula(request.getParameter("matricula"));
		a.setDatadataNascimento(request.getParameter("dataNascimento"));
		a.setFuncao(request.getParameter("funcao"));
		a.setEmpresa(request.getParameter("empresa"));
		String custo = request.getParameter("custo");

		if (custo != null && !custo.isEmpty())
			a.setCusto(Double.parseDouble(custo));

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
