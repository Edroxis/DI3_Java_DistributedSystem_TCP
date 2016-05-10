package Base;

import java.io.IOException;
import java.net.*;

public class TCPClient implements Runnable {

	private Socket s;
	private InetSocketAddress isA;

	TCPClient() {
		s = null;
		isA = new InetSocketAddress("localhost", 8080);
	}

	public void run() {
		try {
			s = new Socket();
			s.connect(isA);
			System.out.println("Hello, client connected");
			s.close();
		} catch (IOException e) {
			System.out.println("IOException TCPClient");
		}
	}
}
