package Timeout;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class TCPClientTimeout extends TCPClientBuilder implements Runnable {

	public void run() {
		try {
			setSocket();
			
			
			
			socket.close();
		} catch (SocketTimeoutException e) {
			System.out.println("Client - Timeout reached");
		} catch (IOException e) {
			System.out.println("IOException TCPClient");
		}

	}
}
