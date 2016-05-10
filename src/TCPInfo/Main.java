package TCPInfo;

public class Main {

	public static void main(String[] args) {
		new Thread(new TCPServerInfo()).start(); 
		new Thread(new TCPClientInfo()).start();

	}

}
