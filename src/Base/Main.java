package Base;

public class Main {

	public static void main(String[] args) {
		new Thread(new TCPServer()).start(); 
		new Thread(new TCPClient()).start();
	}

}
