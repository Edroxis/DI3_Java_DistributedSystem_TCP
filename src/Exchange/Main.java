package Exchange;

public class Main {

	public static void main(String[] args) {
		new Thread(new TCPServerLMsg()).start(); 
		new Thread(new TCPClientLMsg()).start();
	}

}
