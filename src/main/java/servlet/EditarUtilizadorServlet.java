package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilizador;
import service.UtilizadorService;
import util.DBConnection;

@WebServlet("/editarUtilizador")
public class EditarUtilizadorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String id = req.getParameter("id");
		if (id == null) {
			resp.sendRedirect(req.getContextPath() + "/utilizadores");
			return;
		}

		try (Connection conn = DBConnection.getConnection()) {

			UtilizadorService service = new UtilizadorService(conn);
			Utilizador u = service.buscarId(Integer.parseInt(id));
			
			if (u == null) {
				resp.sendRedirect(req.getContextPath() + "/utilizadores");
				return;
			}

			req.setAttribute("utilizador", u);
			req.getRequestDispatcher("/utilizadores/editar.jsp").forward(req, resp);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		try (Connection conn = DBConnection.getConnection()) {
			UtilizadorService service = new UtilizadorService(conn);
			Utilizador u = new Utilizador(
					req.getParameter("nome"),
					req.getParameter("username"),
					req.getParameter("email"),
					null,
					req.getParameter("nivel"));
			
			u.setIdUtilizador(Integer.parseInt(req.getParameter("id")));
			
			String senha = req.getParameter("senha");
			if (senha != null && !senha.isEmpty()) {
				u.setSenha(UtilizadorService.gerarHash(senha));
			} else {
				Utilizador ex = service.buscarId(u.getIdUtilizador());
				u.setSenha(ex.getSenha());
			}
			
			service.editarUtilizador(u);
			resp.sendRedirect(req.getContextPath() + "/utilizadores");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
