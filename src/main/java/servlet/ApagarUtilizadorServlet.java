package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilizador;
import service.UtilizadorService;
import util.DBConnection;

@WebServlet("/apagarUtilizador")
public class ApagarUtilizadorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		try {
		UtilizadorService service = new UtilizadorService(DBConnection.getConnection());
		service.apagarUtilizador(Integer.parseInt(req.getParameter("id")));
		
		resp.sendRedirect(req.getContextPath() + "/utilizadores");
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
