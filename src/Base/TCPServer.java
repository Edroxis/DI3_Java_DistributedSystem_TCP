package Base;

import java.io.IOException;
import java.net.*;

public class TCPServer implements Runnable {

	private ServerSocket ss;
	private Socket s;
	private InetSocketAddress isA;

	TCPServer() {
		ss = null;
		s = null;
		isA = new InetSocketAddress("localhost", 8080);
	}

	public void run() {
		try {
			ss = new ServerSocket();
			ss.bind(isA);
			s = ss.accept();
			System.out.println("Hello, server accept");
			s.close();
			ss.close();
		} catch (IOException e) {
			System.out.println("IOException TCPServer");
		}
	}
}
