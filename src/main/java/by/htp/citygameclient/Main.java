package by.htp.citygameclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.citygameclient.util.CollectCityList;
import by.htp.citygameclient.util.GameLogic;
import by.htp.citygameclient.client.Client;

public class Main {

	public static void main(String[] args) {
	
		String ip = "127.0.0.1";
		List<String> cityList = new ArrayList();
		List<String> shortCityList = new ArrayList();
		int every = 3;
		int port = 8080;
		
		cityList = CollectCityList.grabCityesFromSiteTest();
		shortCityList = CollectCityList.getEveryCity(every, cityList);
		
		GameLogic gameLogic = new GameLogic(shortCityList);
		Client client = new Client(gameLogic);
		client.run(ip, port);

	}

}
