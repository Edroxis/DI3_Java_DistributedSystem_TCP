package TCPMsg;

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
	void serverSocketInfo(String event, ServerSocket ss) throws SocketException,
			IOException {
		serverSocketInfo = new SocketInfo();
		serverSocketInfo.isIPV6 = isIPV6(ss.getInetAddress());
		serverSocketInfo.localAdress = getAdressName(ss.getInetAddress());
		serverSocketInfo.localPort = ss.getLocalPort();
		serverSocketInfo.closed = ss.isClosed();
		serverSocketInfo.bounded = ss.isBound();
		serverSocketInfo.timeout = ss.getSoTimeout();
		serverSocketInfo.readBufferSize = ss.getReceiveBufferSize();
		print(event, serverSocketInfo);
	}

	/** To print the socket's parameters. */
	void socketInfo(String event, Socket s) throws SocketException, IOException {
		socketInfo = new SocketInfo();
		socketInfo.isIPV6 = isIPV6(s.getInetAddress());
		socketInfo.localAdress = getAdressName(s.getLocalAddress());
		socketInfo.localPort = s.getLocalPort();
		socketInfo.remoteAddress = getAdressName(s.getInetAddress());
		socketInfo.remotePort = s.getPort();
		socketInfo.bounded = s.isBound();
		socketInfo.closed = s.isClosed();
		if (!socketInfo.closed) {
			socketInfo.timeout = s.getSoTimeout();
			socketInfo.soLinger = s.getSoLinger();
			socketInfo.sendBufferSize = s.getSendBufferSize();
			socketInfo.readBufferSize = s.getReceiveBufferSize();
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

	private void print(String event, SocketInfo sI) {
		System.out.println(event + ":\n" + "IPV6: " + sI.isIPV6 + "\n"
				+ "local \tadress:" + sI.localAdress + "\t port:" + sI.localPort + "\n"
				+ "remote \tadress:" + sI.remoteAddress + "\t port:" + sI.remotePort + "\n"
				+ "bounded: " + sI.bounded + "\n" + "closed: " + sI.closed
				+ "\n" + "timeout: " + sI.timeout + "\tso linger: " + sI.soLinger
				+ "\n" + "buffer \tsend:" + sI.sendBufferSize + "\treceive:" + sI.readBufferSize
				+ "\n");
	}
}
