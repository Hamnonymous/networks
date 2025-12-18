import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class SERVER_IP{
	public static void main(String q[]) throws IOException{
		System.out.println("Hello Welcome...");
		
		ServerSocket ss = new ServerSocket(8000);
		
		InetAddress ipobj = InetAddress.getLocalHost();
		String Host_name = ipobj.getHostName();
		String ip_address = ipobj.getHostAddress();

		while(true){
		
			System.out.println("\n Server Running...");
			System.out.println("\n Server Waiting For Client Request...");
			Socket cs=ss.accept();
			System.out.println("\n Server Established Connection...");
			
			DataInputStream in = new DataInputStream(cs.getInputStream());
			String msg = in.readUTF();
			
			System.out.println("\n Message Received From Client: " + msg);
			
			DataOutputStream out = new DataOutputStream(cs.getOutputStream());
			
			out.writeUTF("Hi, I am Server...\nMy IP Address: "+ip_address+"\nHostname: "+Host_name+"\n");
		}
	}
	}
