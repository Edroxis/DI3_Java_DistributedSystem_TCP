package Exchange;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPServerBuilder extends TCPRW {

	protected ServerSocket serverSocket;
	protected Socket socket;
	protected InetSocketAddress isA;
	
	TCPServerBuilder(){
		serverSocket = null;
		socket = null;
		isA = new InetSocketAddress("localhost", 8080);
	}
	
	public void setServerSocket() throws IOException {
		serverSocket = new ServerSocket();
		serverSocket.setSoTimeout(5000);
		
		serverSocket.bind(isA);
		
		socket = serverSocket.accept();
	}
}
