package HelloWorld;

import java.io.IOException;

public class TCPClientHello extends TCPClientBuilder implements Runnable {

	public void run() {
		try {
			setSocket();
			
			socket.close();
		} catch (IOException e) {
			System.out.println("IOException TCPClient");
		}
	}

}
