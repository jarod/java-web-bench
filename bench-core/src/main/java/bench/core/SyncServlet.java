package bench.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SyncServlet extends HttpServlet {
	private static final long serialVersionUID = 3286410872696323844L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		resp.getWriter().write("hello " + name);
		resp.addCookie(new Cookie("name", name));
		resp.addHeader("name", name);
	}

	
}
