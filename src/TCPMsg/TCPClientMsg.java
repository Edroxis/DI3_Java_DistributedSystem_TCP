package TCPMsg;

import java.io.IOException;

public class TCPClientMsg extends TCPClientBuilder implements Runnable {

	public void run() {
		try {
			setSocket();
			
			System.out.println("Client - data Sent : " + ecritureStream("test", socket));
			
			System.out.println("Client - data Received : " + lectureStream(socket));
			
			closeStreams();
			socket.close();
		} catch (IOException e) {
			System.out.println("IOException TCPClient");
		}

	}
}
