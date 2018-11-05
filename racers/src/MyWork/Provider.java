package MyWork;

import java.io.*;
import java.net.*;

public class Provider{
	ServerSocket providerSocket1;
        ServerSocket providerSocket2;
	Socket connection1 = null;
        Socket connection2 = null;
	ObjectOutputStream out1,out2;
	ObjectInputStream in1,in2;
	Provider(){}
	void run1() throws Exception
	{
	           	//1. creating a server socket
			providerSocket1 = new ServerSocket(2020);
			connection1 = providerSocket1.accept();
			
                        providerSocket1 = new ServerSocket(2030);
			connection2 = providerSocket2.accept();
                        
                        out1 = new ObjectOutputStream(connection1.getOutputStream()); 
                       // passing outstream from one client to others instream                           
			in2 = new ObjectInputStream((InputStream)(Object)out1);        
                         
                        out2 = new ObjectOutputStream(connection2.getOutputStream());
                      // passing outstream from one client to others instream                             
			in1 = new ObjectInputStream((InputStream)(Object)out2);   
                       		
}
        void run() throws Exception{ // runs continuously
            while(true)
            {run1();}
        } 
        
}