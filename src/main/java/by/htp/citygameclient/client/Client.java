package by.htp.citygameclient.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import by.htp.citygameclient.util.GameLogic;

public class Client {
	
	GameLogic gameLogic;
	Socket fromServer;
	BufferedReader in;
	PrintWriter out;
	String from_client;
	String from_server;
	Boolean imLooseFlag = false;
	String youWinExit = "I'm sad: You win! exit";
	String clientSad = "I'm sad: ";
	String serverSad = "Server sad: ";
	String firstCity = " exit";
	String myAnswer;

	public Client() {
		
	}

	public Client(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}

	public String run(String ip, int port) {

		
	
		
		System.out.println("I'm client! Hi!!!");
		System.out.println("Connecting to " + ip + " " + port);
		try {
			fromServer = new Socket(ip, port);
			System.out.println("Connected.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		try {
		in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
		out = new PrintWriter(fromServer.getOutputStream(), true);
		

		from_server = in.readLine();
		
		
		}
		
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		return from_server;
		}
	

	
		public String getAnswer(String nameCity) {
		
//		System.out.println(from_server);
//		firstCity = gameLogic.getRandomSity();
//		out.println(firstCity);
//		gameLogic.eraseThisCityFromMyList(firstCity);
//		System.out.println(clientSad + firstCity);
		while (true) {
			from_server = nameCity;
			System.out.println(from_server);
			if(from_server.contains(" exit")) break;
			gameLogic.eraseThisCityFromMyList(from_server);
			imLooseFlag = gameLogic.imLoose(from_server);
			if (imLooseFlag == true) {
				System.out.println(youWinExit);
				out.println(youWinExit);
			}
			if (imLooseFlag == true) break;
			myAnswer = gameLogic.myAnswer(from_server);
//			out.println(myAnswer);
			System.out.println(myAnswer);
		
//			if (myAnswer != null)
//				gameLogic.eraseThisCityFromMyList(myAnswer);
			break;
		}	
//		
//
		return myAnswer;
			
//		 finally {
//			out.close();
//			try {
//				in.close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			try {
//				fromServer.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
				
	}
	}