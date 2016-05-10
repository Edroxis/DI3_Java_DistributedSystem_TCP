package HelloWorld;

import java.io.IOException;

public class TCPServerHello extends TCPServerBuilder implements Runnable{

	@Override
	public void run() {
		setServerSocket();
		
		try {
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
