package Exchange;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class TCPClientLMsg extends TCPClientBuilder implements Runnable {

	public void run() {
		try {
			setSocket();
			
			System.out.println("Client, string read: " + lectureStream(socket));
			
			socket.close();
		} catch (SocketTimeoutException e) {
			System.out.println("Client - Timeout reached");
		} catch (IOException e) {
			System.out.println("IOException TCPClient");
		}

	}

}
