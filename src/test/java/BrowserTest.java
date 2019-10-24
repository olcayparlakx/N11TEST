import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserTest {

	
	public static void main(String[] args) {
		
		database db = new database();
		
		
		WebDriver driver = null;
		driver = Connect.startpage(driver,db.browser , db.url);
	
		String searchPrice;
		String basketPrice;
		String productCount;
		
		double Ibasketprice;
		double IdoubleBasketPrice;
		
		boolean basketStatus;

		 
		
	
		
		//GIRIS ISLEMERI
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.loginInfo(db.user, db.password);
	

		
		//ARAMA SAYFASI, RASTGELE URUN SECILMESI VE ACILAN URUNUN FIYATININ ALINMASI
	    
		SearchPage searchpage = PageFactory.initElements(driver, SearchPage.class);
		searchpage.SearchInfo(db.SearchObject,db.PageNumber);
		
		searchPrice=searchpage.searchPrice;

		

		//URUNUN SEPETE EKLENMESI VE URUN MIKTARININ ARTIRILMASI 
		
		BasketPage basketpage = PageFactory.initElements(driver, BasketPage.class);
		basketpage.BasketProcess();
	
		
		//URUNUN ARTTIRILMADAN ONCEKI FIYATININ VE URUN ADEDI ARTTIRILDIKTAN SONRAKI FIYATININ ALINMASI
		//URUNUN ADET MIKTARININ ALINMASI
		basketPrice=basketpage.basketPrice;
		Ibasketprice=basketpage.IbasketPrice;
		IdoubleBasketPrice=basketpage.IdoubleBasketPrice;
		productCount=basketpage.productCount;
		basketStatus=basketpage.basketStatus;

		

		
		//ARAMA SAYFASINDAKI URUN ILE SEPETTEKI URUNUN KARSILASTIRILMASI
		//SAYFADAN GELEN FIYATLARDA NOKTALAMA ISARETLERI DUZELTILDI
		searchPrice = searchPrice.replaceAll(",","");
		basketPrice = basketPrice.replaceAll(",","");
		String FbasketPrice=basketPrice.substring(0, basketPrice.length() - 1);
		
		if(searchPrice.equals(FbasketPrice)) {
			
			System.out.println("sepet fiyati ile arama fiyati ayni");	
		}
		
		else {	
			System.out.println("Fiyatlar esit degil");				
			}
		System.out.println("arama fiyati; "+searchPrice);		
		System.out.println("sepet fiyati; "+FbasketPrice);
	
		
		
		
		
		
		
			//SEPETTEKI URUN MIKTARI KONTROLU
		if(productCount.equals("2")) {
			
			System.out.println("Sepette 2 urun var");		
		}
		
		else { System.out.println("sepetteki urun sayisi 2'ye esit degil");	}
		

		
		
		
		
		//ELDEKI 2 URUNUN MANUEL OLARAK FIYAT TOPLAMININ SISTEMIN TOPLAM FIYATI ILE KARSILASTIRILMASI
		if(Ibasketprice==IdoubleBasketPrice) {
			System.out.println("Urun arttirildiktan Urunun iki kati fiyati ile sistemin iki kati fiyati ayni");		
		}
		else {
			System.out.println("Urunun arttirildiktan Urunun iki kati fiyati ile sistemin iki kati fiyati farkli");		
			}
	
		System.out.println("Sistemin hesapladigi;"+IdoubleBasketPrice+" tl");		
		System.out.println("Dogru hesaplanan;"+Ibasketprice+" tl");	
		
		
		
		
		
		
		
		//SEPETIN SON DURUMU
		
				if(basketStatus) { System.out.println("Sepet bosaltildi.Sepette suan urun bulunmuyor");	}
		
				else {
					System.out.println("Sepette suan urun bulumakta");	
					}
		
		
	    
	}	    

	
}


