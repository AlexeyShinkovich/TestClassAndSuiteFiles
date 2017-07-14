package by.htp.citygameclient.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CollectCityList {
	protected static WebDriver driver;

		public static List<String> grabCityesFromSiteTest() {
	String driverPath = "c://driver//geckodriver.exe";
//	String url = "http://города-россия.рф/alphabet.php";
	String url = "https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population";
	System.setProperty("webdriver.gecko.driver", driverPath);
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);

	//List<WebElement> sityList = driver.findElements(By.xpath(".//*[@id='content']/div[3]/ul/li/a")); // for "http://города-россия.рф/alphabet.php"
	List<WebElement> sityList = driver.findElements(By.xpath(".//*[@id='mw-content-text']/div/table[4]/tbody/tr/td[2]/a"));
	List<String> cityNamesList = new ArrayList();
	for (WebElement element : sityList) {
		cityNamesList.add(element.getText());
	}
	driver.quit();
	return cityNamesList;
}

/*public static List<String> grabCityesFromSiteTest() {

	List<String> cityNamesList = new ArrayList();
	cityNamesList.add("Memphis");
	cityNamesList.add("Tulsa");
	cityNamesList.add("Corpus Christi");
	cityNamesList.add("Durham");
	cityNamesList.add("Reno");
	cityNamesList.add("Garland");
	cityNamesList.add("Oxnard");
	cityNamesList.add("Akron");
	cityNamesList.add("Overland Park");
	cityNamesList.add("Cape Coral");
	cityNamesList.add("Ontario");
	cityNamesList.add("Peoria");
	cityNamesList.add("Lakewood");
	cityNamesList.add("Escondido");
	cityNamesList.add("Mesquite");
	cityNamesList.add("Dayton");
	cityNamesList.add("Waco");
	cityNamesList.add("Cedar Rapids");
	cityNamesList.add("Lafayette");
	cityNamesList.add("Vallejo");
	cityNamesList.add("Odessa");
	cityNamesList.add("Peoria");
	cityNamesList.add("Miami Gardens");
	cityNamesList.add("Antioch");
	cityNamesList.add("Ventura");
	cityNamesList.add("Arrow");
	cityNamesList.add("Green Bay");
	return cityNamesList;
}
*/

	public static List<String> getEveryCity(int every, List<String> cityList) {
		List<String> shortCityList = new ArrayList();
		int count = 0;
		for (String element : cityList) {
			count++;
			if(count == every){
				shortCityList.add(element);
				count = 0;
			}
		}
		return shortCityList;
	}

}
