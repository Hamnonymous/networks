import java.io.*;
import java.net.*;
import java.lang.*;

public class Ham {

	public static void main(String q[]) throws IOException
	{
		System.out.println("Hello Welcome");
		ServerSocket ss=new ServerSocket(8000);
		System.out.println("\nServer Running...");
		System.out.println("\nServer Waiting For Client Request...");
		Socket cs=ss.accept();

		DataInputStream in=new DataInputStream(cs.getInputStream());

		String msg=in.readUTF();

		System.out.println(msg);

		DataOutputStream out=new DataOutputStream(cs.getOutputStream());

		out.writeUTF("Hi I'm Server..."+"\n");

	}
}
