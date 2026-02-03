package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
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
 * Servlet implementation class AtendenteApiController
 */
@WebServlet("/api/AtendenteApiController")
public class AtendenteApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Essa aqui é a boa pratica
	private final RepositorioAtendenteImplementacao repo = new RepositorioAtendenteImplementacao();
	Random random = new Random();

	// ListarTodos ou Buscar por CPF
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		String cpf = request.getParameter("cpf");
		String json;

		if (cpf != null) {
			Atendente atendente = repo.buscarPorAtendente(cpf);
			if (atendente == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.getWriter().write("{\"status\":false,\"message\":\"Atendente não encontrado\"}");
				return;
			} else {
				json = atendenteToJson(atendente);
				response.getWriter().write(json);

			}
		} else {

			List<Atendente> atendentes = repo.listarAtendente();
			json = listaToJson(atendentes);
			response.getWriter().write(json);
		}

	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		String cpf = request.getParameter("cpf");
		String json;

		if (cpf == null || repo.buscarPorAtendente(cpf) == null) {
			
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("{\"status\":false,\"message\":\"Atendente não encontrado!!\"}");
			return;
		}
		
		repo.deletarAtendente(cpf);
		response.getWriter().write("{\"ok\":true,\"message\":\"Atendente deletado!!\"}");
	
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setContentType("application/json; charset=UTF-8");
			
			Atendente atendente = jsonParaAtendente(request);
			
			if(isBlank(atendente.getNome()) || isBlank(atendente.getCpf()) || isBlank(atendente.getSetor() )) {
				response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
				response.getWriter().write("{\"status\":false,\"message\":\"Cpf, Nome e Setor são obrigadorios!!!\"}");
				return;
			}
			Integer senha = (random.nextInt(100, 999999));
			System.out.println(senha);
			
			atendente.setSenha(CripSenha.codificar(senha.toString()));
			
			repo.salvarAtendente(atendente);
			response.getWriter().write("{\"ok\":true,\"message\":\"Atendente Registrado!!\"}");
			
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		
		if(isBlank(cpf)) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			response.getWriter().write("{\"status\":false,\"message\":\"Informe o cpf!!!\"}");
			return;//Encerra o processo
			
		}
		
		Atendente atendenteExistente = repo.buscarPorAtendente(cpf);
		if(atendenteExistente == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("{\"status\":false,\"message\":\"Atendente não encontrado!!!\"}");
			return;
			
		}
		
		Atendente atendenteRequest = jsonParaAtendente(request);
		
		atendenteRequest.setCpf(cpf);
		
		if(isBlank(atendenteRequest.getSetor()) || isBlank(atendenteRequest.getNome())) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("{\"status\":false,\"message\":\"Nome e Setor são obrigatorios!!!\"}");
			
		}
		
		repo.alterarAtendente(atendenteRequest);
		response.getWriter().write("{\"ok\":true,\"message\":\"Atendente Alterado!!\"}");
		
		
	}
	

	// ------------------------------------Metodo de suporte

	// Pega uma lsita de atendente e retorna em formato de JSON
	//ISSO AQUI QUEM VAI FAZER O FRAMEWORK
	private String listaToJson(List<Atendente> lista) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"ok\":true,\"data\":[");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(atendenteToJson(lista.get(i)));
			if (i < lista.size() - 1)
				sb.append(",");
		}
		sb.append("]}");
		return sb.toString();
	}

	private String atendenteToJson(Atendente a) {
		// se quiser padronizar sempre com ok/data, mude aqui
		return "{" + "\"cpf\":\"" + esc(a.getCpf()) + "\"," + "\"nome\":\"" + esc(a.getNome()) + "\"," + "\"setor\":\""
				+ esc(a.getSetor()) + "\"" + "}";
	}

	private String esc(String s) {
		if (s == null)
			return "";
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}
	
	private Atendente jsonParaAtendente(HttpServletRequest request) throws IOException {
        
        String body = readBody(request);
        if (!isBlank(body) && body.trim().startsWith("{")) {
            
            String cpf = extractJsonValue(body, "cpf");
            String nome = extractJsonValue(body, "nome");
            String setor = extractJsonValue(body, "setor");

            Atendente a = new Atendente();
            a.setCpf(cpf);
            a.setNome(nome);
            a.setSetor(setor);
            return a;
        }

        
        Atendente a = new Atendente();
        a.setCpf(request.getParameter("cpf"));
        a.setNome(request.getParameter("nome"));
        a.setSetor(request.getParameter("setor"));
        return a;
    }

	private String extractJsonValue(String json, String key) {
	    // bem simples (pra aula/CRUD). Em produção use Jackson/Gson.
	    String pattern = "\"" + key + "\"";
	    int i = json.indexOf(pattern);
	    if (i == -1) return null;
	    int colon = json.indexOf(":", i);
	    if (colon == -1) return null;
	
	    int firstQuote = json.indexOf("\"", colon + 1);
	    if (firstQuote == -1) return null;
	    int secondQuote = json.indexOf("\"", firstQuote + 1);
	    if (secondQuote == -1) return null;
	
	    return json.substring(firstQuote + 1, secondQuote);
	}
	
	 private boolean isBlank(String s) {
	        return s == null || s.trim().isEmpty();
	 }
	 
	 private String readBody(HttpServletRequest request) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        try (BufferedReader br = request.getReader()) {
	            String line;
	            while ((line = br.readLine()) != null) sb.append(line);
	        }
	        return sb.toString();
	    }
	
	

}
