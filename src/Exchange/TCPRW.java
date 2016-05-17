package Exchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPRW extends TCPInfo {

	private OutputStream out;
	private InputStream in;
	private StringBuffer msT;
	private int time;
	private final String ms = "Java TCP";

	String ecritureStream(String strParam, Socket socket) {
		try {
			out = socket.getOutputStream();
			out.write(strParam.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur Lecture Flux");
		}
		return strParam;
	}

	String lectureStream(Socket socket) {
		String myStringIn = "";
		int count = 0;
		msT = new StringBuffer();
		try {
			in = socket.getInputStream();

			byte[] buffer = new byte[8192];

			while (count != -1) {
				count = in.read(buffer);
				if (count != -1) {
					myStringIn = new String(buffer, 0, count);
					msT.append(myStringIn);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur Ecriture Flux");
		}
		return msT.toString();
	}

	void closeStreams() {
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String duplicateMessage(int size) {
		/** The size is in kbyte. */
		msT = new StringBuffer();
		time = (size * 1024) / 8;
		for (int i = 0; i < time; i++)
			msT.append(ms);
		return msT.toString();
	}
}
