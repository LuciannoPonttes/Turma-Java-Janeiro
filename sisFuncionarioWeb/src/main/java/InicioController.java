import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Inicio")
public class InicioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // GET → abre a página JSP
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Inicio.jsp")
               .forward(request, response);
    }

    // POST → recebe dados e devolve para o JSP
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String texto = request.getParameter("texto");
        request.setAttribute("texto", texto);
        request.getRequestDispatcher("/Inicio.jsp")
               .forward(request, response);
    }
}
