package TCPMsg;

public class Main {

	public static void main(String[] args) {
		new Thread(new TCPServerMsg()).start(); 
		new Thread(new TCPClientMsg()).start();
	}

}
