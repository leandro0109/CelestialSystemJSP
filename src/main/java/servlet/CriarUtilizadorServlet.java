package servlet;

import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilizador;
import service.UtilizadorService;
import util.DBConnection;

@WebServlet("/criarUtilizador")
public class CriarUtilizadorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		try {
			Utilizador u = new Utilizador(
					req.getParameter("nome"),
					req.getParameter("username"),
					req.getParameter("email"),
					UtilizadorService.gerarHash(req.getParameter("senha")),
					req.getParameter("nivel"));
			
			UtilizadorService service = new UtilizadorService(DBConnection.getConnection());
			service.criarUtilizador(u);
		} catch (Exception e) {
			throw new ServletException(e);
		}	
	}
}
