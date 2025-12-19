//Multi client server Socket
import java.io.*;
import java.util.*;
import java.net.*;
public class SERVER_MULTI
{
public static void main(String []args) throws Exception
{
ServerSocket ss=null;
Socket s=null;
int count=0;
System.out.println("Server Running.....");
try
{
ss=new ServerSocket(9555);
}
catch(Exception e)
{
System.out.println("Server PORT Connection Error.....");
System.exit(1);
}
while(true)
{
try
{
System.out.println("Server waiting/Listening.....");
s=ss.accept();
count++;
System.out.println("\nConnection established by CLIENT: " + count);
ThreadServer ts=new ThreadServer(s,count); //user defined constructor
ts.start();
}
catch(Exception e)
{
System.out.println("Connection error.....");
}
}
}
}
class ThreadServer extends Thread
{
String msg=null;
DataInputStream din=null;
DataOutputStream dout=null;
Socket socketobj=null;
int n;
public ThreadServer (Socket s,int count) //constructor
{
 socketobj=s;
 n=count;
}


public void run()
{
try
{
 while(true)
 {
 din=new DataInputStream(socketobj.getInputStream());
 dout=new DataOutputStream(socketobj.getOutputStream());

 msg=din.readUTF(); //read
System.out.println("Receiving Server " + msg + "message from CLIENT " + n);
 dout.writeUTF(msg.toUpperCase()+"\n");
 dout.flush();
 }
}
catch(Exception e)
{
System.out.println("Socket closed by Client" + n );
}
}
}
