import java.io.*;
import java.net.*;
import java.lang.*;

public class CLIENT_Date{
	public static void main(String q[]) throws IOException{
		System.out.println("Hello Welcome...");
			Socket sc = new Socket("localhost",8000);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			dout.writeUTF("Connection From Client...\n");
			
			DataInputStream in = new DataInputStream(sc.getInputStream());
			String msg = in.readUTF();
			
			System.out.println(msg);
		
	}
	}
