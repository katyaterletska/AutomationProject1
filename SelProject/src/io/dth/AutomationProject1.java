package io.dth;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationProject1 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread.sleep(2000);
		//1.Open the chrome browser		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//2. Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		
		//3. Login using username Tester and password test
		WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));// located element
		userName.sendKeys("Tester");
		WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));// located element
		password.sendKeys("test" + Keys.ENTER);
		
		//4. Click on Order link
		WebElement order = driver.findElement(By.linkText("Order"));
		order.click();
		
		//5. Enter a random quantity between 1 and 100
		int q = (int)(1+(Math.random()*100));
		WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
		quantity.sendKeys(String.valueOf(q));
		
		//6. Enter Customer Name:
		 //John <Middle Name > Doe.
		 //Instead of <Middle Name> your code should enter a random string of length 5 every time.
		WebElement customerName = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
		
		String rndm = " " +(int)(10000 + Math.random()* 66666);
		customerName.sendKeys("John " + rndm +" Doe");
		
		//7. Enter street: 8607 Westwood Center Dr
		WebElement street = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
		street.sendKeys("8607 Westwood Center Dr");
		
		//8. Enter City: Vienna
		WebElement city = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
		city.sendKeys("Vienna");
		
		//9. Enter State: Virginia
		WebElement state = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
		state.sendKeys("Virginia");
		
		//10. Enter a random 5 digit number to the zip code field
		WebElement zip = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
		int rndmzip = (int)(10000 + Math.random()* 99999);
		zip.sendKeys(String.valueOf(rndmzip));
		
		//11. Select any card type. Every time your code should select a different type.
		int n1 = (int)(Math.random()*4);
		           //System.out.print(n1);
		
		WebElement visa = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"));
		WebElement master = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]"));
		WebElement amex = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]"));
		
		if(n1==1) {
			visa.click();
			}else if(n1==2) {
				master.click();
				}else {
					amex.click();
				    }
		
		//12. Enter any card number: 
	    WebElement cardNo = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
	    
	    long number = (long)(100000000000000l + Math.random()* 999999999999999l);
        long number1 = (long)(10000000000000l + Math.random()* 99999999999999l);
	               //System.out.println(number);
	               //System.out.println(number1);
        String visaNumber = "4" + number;
        String masterNumber = "5" + number;
        String amexNumber = "3" + number1;
	           if(n1==1) {
		           cardNo.sendKeys(visaNumber);
	             }else if (n1==2) {
		           cardNo.sendKeys(masterNumber);
	               }else {
		           cardNo.sendKeys(amexNumber);
	                     }
	
	    //13. Enter a valid expiration date (newer than the current date)
	    WebElement expDate = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
	    expDate.sendKeys("12/25");
	    
	    //14. Click on Process
	    Thread.sleep(2000);
	    driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	    
        //15. Verify that the page contains text “New order has been successfully added”.
       String expectedResult = driver.findElement(By.tagName("strong")).getText();
       String actualResult ="New order has been successfully added.";
       
       if(actualResult.equals(expectedResult)) {
    	   System.out.println("PASS");
       }else {
    	   System.out.println("FAIL");
       }
        
	}

}
