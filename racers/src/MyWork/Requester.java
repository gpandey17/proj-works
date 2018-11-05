package MyWork;

///////////////// this code will create connection with server from client1///////////////////////////////
//////////////// keys that is pressed from client2 will be send to client1 from client 2 through server///
/////////////// cars will be moved in client1 according to key pressed in client 2 and displayed//////////

import java.io.*;
import java.net.*;

public class Requester extends MoveLabel{
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message;
        MoveNetwork move= new MoveNetwork();
	Requester(){}
                
	void run()  
	{
		try{
			//creating a socket to connect to the server
			requestSocket = new Socket("localhost", 2020);
			// get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream()); // puts key value from client 2 to client 1 through server
                        move.moveMe(out.toString());  	// this will move car in client1 according to key pressed in client 2
                        
			in = new ObjectInputStream(requestSocket.getInputStream());
			// Communicating with the server
			do{
					sendMessage(key); // send key to server
				
			}while(!key.equals("e"));
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//Closing connection
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