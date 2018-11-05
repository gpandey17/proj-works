package MyWork;

import java.io.*;
import java.net.*;
public class Requester1 extends MoveLabel{
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message;
        MoveNetwork1 move= new MoveNetwork1();
	Requester1(){}
                
	void run()  
	{
		try{
			//1. creating a socket to connect to the server
			requestSocket = new Socket("localhost", 2030);
			//System.out.println("Connected to localhost in port 2004");
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
                        move.moveMe(out.toString());  			
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			do{
					//key = (String)in.readObject();
					sendMessage(key);
				
			}while(!key.equals("e"));
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
                    if(key=="e")
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
      
}