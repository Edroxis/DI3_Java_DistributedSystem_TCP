package Exchange;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class TCPServerLMsg extends TCPServerBuilder implements Runnable {

	public void run() {
		try {
			setServerSocket();
			
			ecritureStream(duplicateMessage(4), socket);
			
			socket.close();
			serverSocket.close();
		} catch (SocketTimeoutException e) {
			System.out.println("Server - Timeout reached");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
