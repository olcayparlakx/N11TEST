import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Connect {

	
	
	
	
	public static WebDriver startpage(WebDriver driver , String browserName , String url  )
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Testing\\drivers\\geckodriver\\geckodriver.exe");

		if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("tarayici driver'i bulunamadi ");
	 }
		
		driver.get("https://n11.com");
		
		
		//SAYFANIN DOGRU ACILDIGINI KONTROL ETME
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("n11.com - Alışverişin Uğurlu Adresi"))
		{System.out.println("sayfa acildi ");}
		
		else {
			System.out.println("sayfa yuklenemedi ");
			driver.close(); }
		
		
		return driver;
		
	}
	
	
}
