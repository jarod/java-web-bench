package bench.core;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 3286410872696323844L;
	private final ExecutorService executor = Executors.newCachedThreadPool();

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
			IOException {
		final AsyncContext async = req.startAsync();
		executor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					resp.setContentType("text/html;charset=utf-8");
					String name = req.getParameter("name");
					resp.getWriter().write("hello " + name);
					resp.addCookie(new Cookie("name", name));
					resp.addHeader("name", name);
				} catch (Exception ex) {
					System.err.println(ex);

				} finally {
					async.complete();
				}
			}
		});
	}

}
