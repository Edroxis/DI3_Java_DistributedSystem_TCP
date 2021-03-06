package Exchange;

import java.io.IOException;
import java.net.*;

abstract class TCPClientBuilder extends TCPRW {
	protected Socket socket;
	protected InetSocketAddress inetsocketAddressTarget;

	TCPClientBuilder() {
		socket = null;
		inetsocketAddressTarget = new InetSocketAddress("localhost", 8080);
	}

	void setSocket() throws IOException {
		socket = new Socket();
		socket.setSoTimeout(5000);

		socket.connect(inetsocketAddressTarget);
	}
}
