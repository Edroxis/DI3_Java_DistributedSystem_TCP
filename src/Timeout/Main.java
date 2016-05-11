package Timeout;

public class Main {

	public static void main(String[] args) {
		new Thread(new TCPServerTimeout()).start(); 
		new Thread(new TCPClientTimeout()).start();
	}

}
