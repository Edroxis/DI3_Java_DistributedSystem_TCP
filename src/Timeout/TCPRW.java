package Timeout;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPRW extends TCPInfo{
	
	private OutputStream out;
	private InputStream in;

	String ecritureStream(String strParam, Socket socket){
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
	
	String lectureStream(Socket socket){
		String myStringIn = "";
		int count = 0;
		try {
			in = socket.getInputStream();

			byte[] buffer = new byte[8192];
			count = in.read(buffer);
			myStringIn = new String(buffer,0,count) ;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur Ecriture Flux");
		}
		return myStringIn;
	}
	
	void closeStreams(){
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
