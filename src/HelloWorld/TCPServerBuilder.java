package HelloWorld;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBuilder extends TCPRW {

	protected ServerSocket serverSocket;
	protected Socket socket;
	protected InetSocketAddress isA;
	
	TCPServerBuilder(){
		serverSocket = null;
		socket = null;
		isA = new InetSocketAddress("localhost", 8080);
	}
	
	public void setServerSocket(){
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(isA);
			
			socket = serverSocket.accept();
			
			System.out.println("Hello, server accepted");
			
		} catch (IOException e) {
			System.out.println("IOException TCPServer");
		}
	}
}
