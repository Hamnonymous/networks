import java.io.*;
import java.net.*;
import java.util.*;
public class CLIENT_ENC {
public static void main(String q[]) throws IOException {
Socket sc_object = new Socket("localhost", 8000);
final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
Scanner sc = new Scanner(System.in);
String cipherText = new String();
int key = 0;
System.out.print("Enter the String for Encryption:");
cipherText = sc.next();
cipherText = cipherText.toLowerCase();
System.out.println("\n\nEnter Shift Key:");
int shiftKey = sc.nextInt();
String message = "";
for (int i = 0; i < cipherText.length(); i++) {
int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
int keyVal = (charPosition - shiftKey) % 26;
if (keyVal < 0) {
keyVal = ALPHABET.length() + keyVal;
}
char replaceVal = ALPHABET.charAt(keyVal);
message += replaceVal;
}
DataOutputStream out = new DataOutputStream(sc_object.getOutputStream());
out.writeUTF(message + "\n");
System.out.println("Message From Server: " + message);
}
}
