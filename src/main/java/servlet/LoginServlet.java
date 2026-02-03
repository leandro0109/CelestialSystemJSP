package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utilizador;
import service.UtilizadorService;
import util.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String username = req.getParameter("username");
		String senha = req.getParameter("senha");
		
		try(Connection conn = DBConnection.getConnection()){
			UtilizadorService service = new UtilizadorService(conn);
			Utilizador u = service.login(username, senha);
			
			if(u == null) {
				req.setAttribute("erro", "Utilizador ou senha incorretos");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("utilizador", u);
			
			resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
