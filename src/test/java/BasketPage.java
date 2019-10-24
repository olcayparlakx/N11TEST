import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {

	public String basketPrice;
	public String doubleBasketPrice;
	
	public String RbasketPrice;
	public String RdoubleBasketPrice;

	public double IbasketPrice;
	public double IdoubleBasketPrice=0;

	
	public String productCount;
	public boolean basketStatus;

	
WebDriver driver;

	public BasketPage(WebDriver driver){
	this.driver=driver;
	}

	
public void BasketProcess () {
		

		
	
		
	driver.navigate().to("https://www.n11.com/sepetim");
	
	
	     //URUNUN SEPET FIYATININ ALINMASI VE MANUEL OLARAK 2 URUN FIYATININ HESAPLANMASI
	WebElement basketPrice1 = driver.findElement(By.className("productPrice"));
	    basketPrice = basketPrice1.getAttribute("value");
	    

	    RbasketPrice = basketPrice.replaceAll(",","");
	    IbasketPrice=Double.parseDouble(RbasketPrice);
		  
		  IbasketPrice=IbasketPrice+IbasketPrice;
	    
	  
	

	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//URUN ADEDININ ARTTIRILMASI
	driver.findElement(By.xpath("//*[@class='spinnerUp spinnerArrow\']")).click();
	
	//URUN ADEDININ ALINMASI
	 WebElement productCount1 = driver.findElement(By.className("quantity"));
	 productCount = productCount1.getAttribute("value");
	    
	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 	//2 URUN ADEDININ SISTEMIN HESAPLADIGI TOPLAM FIYATININ ALINMASI
	    WebElement doubleBasketPrice1 = driver.findElement(By.className("productPrice"));
	    doubleBasketPrice = doubleBasketPrice1.getAttribute("value");
	  
	    RdoubleBasketPrice = doubleBasketPrice.replaceAll(",","");
	     IdoubleBasketPrice=Double.parseDouble(RdoubleBasketPrice);

	   
	    
		  
		  
		  
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	driver.findElement(By.xpath("//*[@title='Sil\']")).click();

	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 //SEPET DURUMU OGRENME
	 basketStatus = (driver.findElements(By.className("title")).size() > 0);
	
	
	
	}

}