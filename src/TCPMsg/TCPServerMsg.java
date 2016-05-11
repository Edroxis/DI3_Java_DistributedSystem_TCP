package TCPMsg;

import java.io.IOException;

public class TCPServerMsg extends TCPServerBuilder implements Runnable{

	public void run() {
		try {
			setServerSocket();
			
			System.out.println("Server - data Received : " + lectureStream(socket));
			
			System.out.println("Server - data Sent : " + ecritureStream("test2", socket));
			
			closeStreams();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
