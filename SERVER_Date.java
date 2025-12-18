import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SERVER_Date{
	public static void main(String q[]) throws IOException{
		System.out.println("Hello Welcome...");
		ServerSocket ss = new ServerSocket(8000);
		while(true){
			System.out.println("\n Server Running...");
			System.out.println("\n Server Waiting For Client Request...");
			Socket cs=ss.accept();
			System.out.println("\n Server Established Connection...");
			DataInputStream in = new DataInputStream(cs.getInputStream());
			String msg = in.readUTF();
			System.out.println("\n Message Received From Client: " + msg);
			DataOutputStream out = new DataOutputStream(cs.getOutputStream());
			LocalDateTime dat = LocalDateTime.now();
			DateTimeFormatter cus = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
			String formatt = dat.format(cus);
			out.writeUTF(formatt);
		}
	}
	}
