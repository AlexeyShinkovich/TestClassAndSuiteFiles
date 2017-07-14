package by.htp.citygameclient;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.citygameclient.client.Client;
import by.htp.citygameclient.util.GameLogic;

public class TestClient {
	
	public static final String IP = "127.0.0.1";
	public static final int PORT = 8080;
	public static Client client;
	public static GameLogic logic;
	
	
	@BeforeClass
	public static void init() {
		logic = new GameLogic();
		System.out.println("Init GameLogic");
		client = new Client(logic);
	}
	
	@Test
	public void testServer(){
		String a =  client.run(IP, PORT);
		assertEquals("I connected You", a);
		System.out.println("Client connect");
	}
	
	
	@Test
	public void testLastSymbol() {
		char a = logic.getLastLetter("New-York");
		assertEquals('k', a);
		System.out.println("test method getLastLetter OK");

	}

	@Test
	public void testLAnswer() {
		String answer = logic.myAnswer("Washington");
		assertEquals("New-York", answer);
		System.out.println("test method getAnswer OK");
	}
}