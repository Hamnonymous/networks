import java.io.*;
import java.net.*;
import java.util.*;

public class SERVER_ENC{
	public static void main(String q[]) throws IOException{
		System.out.println("Hello Welcome...");
		
		ServerSocket ss = new ServerSocket(8000);

		while(true){
		
			System.out.println("\n Server Running...");
			System.out.println("\n Server Waiting For Client Request...");
			Socket cs=ss.accept();
			System.out.println("\n Server Established Connection...");
			
			final String alpha = "abcdefghijklmnopqrstuvwxyz";
			
			DataInputStream in = new DataInputStream(cs.getInputStream());
			String cipherText = in.readUTF();
			
			System.out.println("Message from Client: "+cipherText);
			cipherText = cipherText.toLowerCase();
			String message = "";
			int shiftKey = 6;
			
			for(int i=0;i<cipherText.length() - 1;i++){
			int charPos = alpha.indexOf(cipherText.charAt(i));
			int keyVal = (charPos + shiftKey)%26;
			
			if(keyVal<0){
			keyVal = alpha.length()+keyVal;
			}
			char replaceVal = alpha.charAt(keyVal);
			message+=replaceVal;
			
			}
			
			System.out.println("\nDecrypted Message: "+message+"\n");
		}
	}
	}
