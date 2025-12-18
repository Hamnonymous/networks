import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class SERVER_SUM{
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
			String msg1 = in.readUTF();
			int num1 = Integer.parseInt(msg1);
			System.out.println("\n First number Received From Client: " + msg1);
			
			String msg2 = in.readUTF();
			int num2 = Integer.parseInt(msg2);
			System.out.println("\n Second number Received From Client: " + msg2);
			int num3 = num1+num2;
			DataOutputStream out = new DataOutputStream(cs.getOutputStream());
			
			out.writeUTF("The Sum of "+msg1+" and " +msg2+" is "+num3+"\n");
		}
	}
	}
