package bench.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
	private final Server server;

	public JettyServer() {
		server =  new Server();
		final ServerConnector connector = new ServerConnector(server);
		connector.setHost("0.0.0.0");
		connector.setPort(8080);
		connector.setReuseAddress(true);
		connector.setAcceptQueueSize(20480);
		server.setConnectors(new Connector[] { connector });

		final WebAppContext wac = new WebAppContext();
		wac.setContextPath("/");
		wac.setWar("webapp");
		server.setHandler(wac);
	}

	public void startup() {
		try {
			server.start();
			while (System.in.available() == 0) {
				Thread.sleep(10000L);
			}

			server.stop();
			server.join();
		} catch (final Exception exc) {
			throw new RuntimeException(exc);
		}
	}
	
	public static void main(String[] args) {
		new JettyServer().startup();
	}
}
