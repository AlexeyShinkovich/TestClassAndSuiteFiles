package by.htp.citygameclient.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameLogic {
	List<String> cityList = new ArrayList<>();
	
	
	public GameLogic() {
		cityList.add("San-Diego");
		cityList.add("New-York");
	
	}

	public GameLogic(List<String> shortCityList) {
		//cityList = shortCityList;
	}

	public void eraseThisCityFromMyList(String input) {
		Iterator<String> iter = cityList.iterator();
		while (iter.hasNext()) {
			String cityTemp = (iter.next()).toLowerCase();
			if (cityTemp.equals(input.toLowerCase())) {
				iter.remove();
			}
		}
/*		for (String element : cityList) {
			System.out.println(element);
		}*/
	}

	public boolean imLoose(String input) {
		boolean imLooseFlag = true;
		char lastLetter = getLastLetter(input);
		for (String element : cityList) {
			String cityTemp = element.toLowerCase();
			if (cityTemp.charAt(0) == lastLetter) {
/*				System.out.println("First leter is " + cityTemp.charAt(0));
				System.out.println("Last leter is " + lastLetter);*/
				imLooseFlag = false;
				/*System.out.println(imLooseFlag);*/
				//break;
			}
		}
		return imLooseFlag;
	}

	public char getLastLetter(String input) {
		return input.charAt(input.length() - 1);
	}

	public String myAnswer(String input) {
		String myAnswer = null;
	

		char lastLetter = getLastLetter(input);
		Iterator<String> iter = cityList.iterator();
		while (iter.hasNext()) {
			String cityTemp = iter.next();
			if ((cityTemp.toLowerCase()).charAt(0) == lastLetter) {
				myAnswer = cityTemp;
			}
		}
		return myAnswer;

	}

	public String getRandomSity() {
		
		return cityList.get((int) (Math.random() * cityList.size()));
	}

}
