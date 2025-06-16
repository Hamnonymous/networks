import java.io.*;
import java.net.*;
public class Client2
{

	public static void main(String args[]) throws IOException
	{
		Socket sc = new Socket("localhost",5000);
		DataOutputStream out = new DataOutputStream(sc.getOutputStream());
		out.writeUTF("Hi I am Client.." + "\n");
		
		DataInputStream in = new DataInputStream(sc.getInputStream());
		String msg = in.readUTF();
		System.out.println(msg);
		
		String message = "Hello World";
		out.writeUTF(message);
		sc.close();
	}
}
