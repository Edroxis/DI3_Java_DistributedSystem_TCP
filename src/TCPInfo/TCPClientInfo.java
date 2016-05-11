package TCPInfo;

import java.io.IOException;

public class TCPClientInfo extends TCPClientBuilder implements Runnable {

	public void run() {
		try {
			setSocket();
			
			socketInfo("Client", socket);
			
			socket.close();
		} catch (IOException e) {
			System.out.println("IOException TCPClient");
		}

	}

}
