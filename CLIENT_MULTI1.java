
import java.io.*;
import java.net.*;
public class CLIENT_MULTI1{
 // Runnable for Client-1
 static class Client1 implements Runnable {
 public void run() {
 Socket s = null;
 DataInputStream din = null;
 DataOutputStream dout = null;
 BufferedReader br = null;
 String msg = null, msg1 = null;
 try {
 s = new Socket("127.0.0.1", 9555);
 if (s.isConnected())
 System.out.println("Client-1 connected to Server...");
 } catch (IOException e) {
 System.err.println("Server or PORT NOT FOUND... " + e.getMessage());
 return;
 }
 try {
 br = new BufferedReader(new InputStreamReader(System.in));
 din = new DataInputStream(s.getInputStream());
 dout = new DataOutputStream(s.getOutputStream());
 while (true) {
 System.out.println("Enter message Client-1 (quit to end):");
 msg = br.readLine();
 if (msg.equalsIgnoreCase("quit")) {
 din.close();
 dout.close();
 s.close();
 System.out.println("Client-1 closed connection...");
 break;
 }
 dout.writeUTF(msg);
 dout.flush();
 msg1 = din.readUTF();
 System.out.println("Client-1 received: " + msg1);
 }
 } catch (Exception e) {
 System.out.println("Client-1 Socket Error: " + e.getMessage());
 }
 }
 }
// Runnable for Client-2
 static class Client2 implements Runnable {
 public void run() {
 Socket s = null;
 DataInputStream din = null;
 DataOutputStream dout = null;
 BufferedReader br = null;
 String msg = null, msg2 = null;
 try {
 s = new Socket("127.0.0.1", 9555);
 if (s.isConnected())
 System.out.println("Client-2 connected to Server...");
 } catch (IOException e) {
 System.err.println("Server or PORT NOT FOUND... " + e.getMessage());
 return;
 }
 try {
 br = new BufferedReader(new InputStreamReader(System.in));
 din = new DataInputStream(s.getInputStream());
 dout = new DataOutputStream(s.getOutputStream());
 while (true) {
 System.out.println("Enter message Client-2 (quit to end):");
 msg = br.readLine();
 if (msg.equalsIgnoreCase("quit")) {
 din.close();
 dout.close();
 s.close();
 System.out.println("Client-2 closed connection...");
 break;
 }
 dout.writeUTF(msg);
 dout.flush();
 msg2 = din.readUTF();
 System.out.println("Client-2 received: " + msg2);
 }
 } catch (Exception e) {
 System.out.println("Client-2 Socket Error: " + e.getMessage());
 }
 }
 }
 public static void main(String[] args) {
 Thread t1 = new Thread(new Client1());
 Thread t2 = new Thread(new Client2());
 t1.start();
 t2.start();
 }
}
