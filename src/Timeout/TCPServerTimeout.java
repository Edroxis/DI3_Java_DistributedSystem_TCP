package Timeout;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class TCPServerTimeout extends TCPServerBuilder implements Runnable {

	public void run() {
		try {
			setServerSocket();

			socket.close();
			serverSocket.close();
		} catch (SocketTimeoutException e) {
			System.out.println("Server - Timeout reached");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
