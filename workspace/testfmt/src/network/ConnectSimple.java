package network;

import java.net.InetAddress;
//BEGIN main
import java.net.Socket;

/* Client with NO error handling */
public class ConnectSimple {
	public static void main(String[] argv) throws Exception {
		try (Socket sock = new Socket("124.108.8.245", 13)) {
			/* If we get here, we can read and write on the socket "sock" */
			System.out.println(" *** Connected OK ***");
			//System.out.println(InetAddress.getByName("10.50.119.22").getHostName());
			/* Do some I/O here... */
			sock.close();
		} 
	}
}
// END main