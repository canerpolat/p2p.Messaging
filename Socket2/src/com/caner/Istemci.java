package com.caner;
import java.net.*;
import java.util.Scanner;

import java.io.*;
public class Istemci {

	public static void main(String[] args) {
		
		Socket istemciSoket = null;
		BufferedReader input = null;
		PrintStream output	= null;
		
		Scanner scan = new Scanner(System.in);
		String inputLine = null;
		
		try {
			istemciSoket = new Socket("127.0.0.1",9091);
			input = new BufferedReader(new InputStreamReader(istemciSoket.getInputStream()));
			output = new PrintStream(istemciSoket.getOutputStream());
		}
		catch(Exception e)
		{
			System.err.println("Error : "+e);
		}
		if( istemciSoket != null && input != null && output !=null) {
			try { 
				while(true)
				{
					String ServerdanGelenMesaj = input.readLine();
					System.out.println(ServerdanGelenMesaj);
					System.out.print("Metin gir : ");
					inputLine = scan.nextLine();
					output.println(inputLine);
					String gelenData = input.readLine();
					System.out.println("Gelen data --> "+gelenData);
					}
			}
				catch(Exception e) {
					System.err.println("Error : "+e);
				}
				finally {
					try {
						input.close();
						output.close();
						istemciSoket.close();
					}
					catch(Exception e) {
						System.err.println("Error"+e);
					}
				}	
		}
	}
}
