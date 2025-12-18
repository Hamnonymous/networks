import java.io.*;
import java.net.*;
import java.lang.*;

public class CLIENT_SUM{
	public static void main(String q[]) throws IOException{
		System.out.println("Hello Welcome...");
			Socket sc = new Socket("localhost",8000);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			System.out.println("Enter first number: ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg=br.readLine();
			
			System.out.println("First Number Entered...");
			dout.writeUTF(msg);
			
			System.out.println("Enter Second number: ");
			String msg2=br.readLine();
			
			System.out.println("Second Number Entered...");
			dout.writeUTF(msg2);
			
			DataInputStream in = new DataInputStream(sc.getInputStream());
			String msg3 = in.readUTF();
			
			System.out.println(msg3);
		
	}
	}
