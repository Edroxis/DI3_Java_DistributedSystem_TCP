package HelloWorld;

public class Main {

	public static void main(String[] args) {
		new Thread(new TCPServerHello()).start(); 
		new Thread(new TCPClientHello()).start();

	}

}
