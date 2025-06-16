import java.io.*;
import java.net.*;
import java.lang.*;
public class Server2
{
	public static void main(String args[]) throws IOException
	{
		System.out.println( "Hello welcome..");
		ServerSocket ss = new ServerSocket (5000);
		System.out.println("\nServer Running...");
		
		while (true) {
			System.out.println( "Server wait for Client Request...");
			Socket cs = ss.accept();
			System.out.println("Connection Established...");
			
			DataInputStream in = new DataInputStream(cs.getInputStream());
			String msg = in.readUTF();
			System.out.println(msg);

			DataOutputStream out = new DataOutputStream(cs.getOutputStream());
			out.writeUTF("Hi I am Server.." + msg.length() + "\n");
			String message = in.readUTF();
			System.out.println(message.toUpperCase());
		}
	}
}
