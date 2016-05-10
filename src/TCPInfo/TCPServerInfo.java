package TCPInfo;

import java.io.IOException;

public class TCPServerInfo extends TCPServerBuilder implements Runnable{

	public void run() {
		try {
			setServerSocket();
			
			socketInfo("Server", socket);
			serverSocketInfo("Server", serverSocket);
			
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
