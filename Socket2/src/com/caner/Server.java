package com.caner;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		String line;
		BufferedReader input;
		PrintStream output;
		Socket istemciSoket =  null;
		String inputLine = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(9091);
		}
		catch(Exception e)
		{
			System.err.println("Sunucu açýlma hatasý : "+e);
		}
		
		try {
			istemciSoket = serverSocket.accept();
			input = new BufferedReader(new InputStreamReader(istemciSoket.getInputStream()));	//giriþ
			output = new PrintStream(istemciSoket.getOutputStream()); 	//çýkýþ
			
			while(true) {
			System.out.print("Sunucudan metni gir :");
			inputLine = scan.nextLine();
			output.println(inputLine);
			line = input.readLine();
			output.println(line);
			System.out.println("Ýstemciden gelen data : "+line);
			}
		}
		catch (IOException e) {
		System.out.println(e.toString());
		}
	}
}
