import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	   public String searchPrice;
	
WebDriver driver;

	public SearchPage(WebDriver driver){
	this.driver=driver;
	}
	
	public void SearchInfo (String SearchObject , String PageNumber) {
		

		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("searchData")).sendKeys(SearchObject);
		driver.findElement(By.className("searchBtn")).click();
		driver.findElement(By.xpath(".//a[text()='"+PageNumber+"']")).click();
		driver.findElement(By.className("plink")).click();
		
		//driver.findElement(By.xpath(".//a[text()='+2']")).click();

		//URUNUN ANAEKRANDAKI FIYATININ ALINMASI
		 WebElement mainPrice1 = driver.findElement(By.id("productPrice"));
		 searchPrice = mainPrice1.getAttribute("value");
		


		driver.findElement(By.xpath("//*[@title='Sepete Ekle\']")).click();
		
		
		
		
		
	}
	
}

