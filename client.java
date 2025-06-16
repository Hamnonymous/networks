import java.io.*;
import java.net.*;

public class cliham {

	public static void main(String q[]) throws IOException
	{
		Socket sc=new Socket("localhost", 8000);
		DataOutputStream out=new DataOutputStream(sc.getOutputStream());
		out.writeUTF("Bhat Agniv Ghurche Videsh"+"\n");

		DataInputStream in=new DataInputStream(sc.getInputStream());

		String msg=in.readUTF();

		System.out.println(msg);

	}
}
