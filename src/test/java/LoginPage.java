import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver){
	this.driver=driver;
	}
	
	public void loginInfo (String user , String password) {

		
		
		
		driver.findElement(By.className("btnSignIn")).click();
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		
		
		
		
		//LOGIN DOGRULUGU KONTROL ETME
		String actualTitle = driver.getTitle();

		if(actualTitle.equals("n11.com - Alışverişin Uğurlu Adresi"))
		{System.out.println("-----------------------LOGIN BASARILI---------------------");}
		
		else {
			System.out.println("-----------------------LOGIN BASARISIZ---------------------");
			driver.close(); }
		
		
	}
	
	
}
