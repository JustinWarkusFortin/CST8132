import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleClient {
	public static void main(String args[]) {

	try {
		Socket client = new Socket(InetAddress.getByName("LAPTOP-QPHRPPKI"), 1254);
		DataInputStream is = new DataInputStream(client.getInputStream());
		DataOutputStream os = new DataOutputStream(client.getOutputStream());
		String line = is.();
		os.writeBytes(line);
		client.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}

