package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		HttpSession session = req.getSession(false);

		if (session != null)
			session.invalidate();

		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
		resp.setHeader("Pragma", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.sendRedirect(req.getContextPath() + "/utilizadores/login.jsp");
	}
}
