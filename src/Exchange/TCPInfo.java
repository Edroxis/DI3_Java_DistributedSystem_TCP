package Exchange;

import java.io.IOException;
import java.net.*;

public class TCPInfo {
	//Structure
	class SocketInfo {
		//Attribute
		String localAdress, remoteAddress;
		int localPort, remotePort, sendBufferSize, readBufferSize, timeout, soLinger;
		boolean bounded, closed, isIPV6, noDelay;

		//Constructor
		SocketInfo() {
			localAdress = remoteAddress = null;
			localPort = remotePort = sendBufferSize = readBufferSize = timeout = soLinger = -1;
			bounded = closed = isIPV6 = noDelay = false;
		}
	}

	//Attribute
	private SocketInfo socketInfo;
	private SocketInfo serverSocketInfo;

	//Method
	/** To print the sever socket's parameters. */
	void serverSocketInfo(String event, ServerSocket serverSocket) throws SocketException,
			IOException {
		serverSocketInfo = new SocketInfo();
		serverSocketInfo.isIPV6 = isIPV6(serverSocket.getInetAddress());
		serverSocketInfo.localAdress = getAdressName(serverSocket.getInetAddress());
		serverSocketInfo.localPort = serverSocket.getLocalPort();
		serverSocketInfo.closed = serverSocket.isClosed();
		serverSocketInfo.bounded = serverSocket.isBound();
		serverSocketInfo.timeout = serverSocket.getSoTimeout();
		serverSocketInfo.readBufferSize = serverSocket.getReceiveBufferSize();
		print(event, serverSocketInfo);
	}

	/** To print the socket's parameters. */
	void socketInfo(String event, Socket socket) throws SocketException, IOException {
		socketInfo = new SocketInfo();
		socketInfo.isIPV6 = isIPV6(socket.getInetAddress());
		socketInfo.localAdress = getAdressName(socket.getLocalAddress());
		socketInfo.localPort = socket.getLocalPort();
		socketInfo.remoteAddress = getAdressName(socket.getInetAddress());
		socketInfo.remotePort = socket.getPort();
		socketInfo.bounded = socket.isBound();
		socketInfo.closed = socket.isClosed();
		if (!socketInfo.closed) {
			socketInfo.timeout = socket.getSoTimeout();
			socketInfo.soLinger = socket.getSoLinger();
			socketInfo.sendBufferSize = socket.getSendBufferSize();
			socketInfo.readBufferSize = socket.getReceiveBufferSize();
		}
		print(event, socketInfo);
	}

	private static String getAdressName(InetAddress iA) {
		if (iA != null)
			return iA.toString();
		return null;
	}

	private static boolean isIPV6(InetAddress iA) {
		if (iA instanceof Inet6Address)
			return true;
		return false;
	}

	private void print(String event, SocketInfo socketInfo) {
		System.out.println(event + ":\n" + "IPV6: " + socketInfo.isIPV6 + "\n"
				+ "local \tadress:" + socketInfo.localAdress + "\t port:" + socketInfo.localPort + "\n"
				+ "remote \tadress:" + socketInfo.remoteAddress + "\t port:" + socketInfo.remotePort + "\n"
				+ "bounded: " + socketInfo.bounded + "\n" + "closed: " + socketInfo.closed
				+ "\n" + "timeout: " + socketInfo.timeout + "\tso linger: " + socketInfo.soLinger
				+ "\n" + "buffer \tsend:" + socketInfo.sendBufferSize + "\treceive:" + socketInfo.readBufferSize
				+ "\n");
	}
}
