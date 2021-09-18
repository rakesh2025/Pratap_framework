package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lenskart {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.lenskart.com/");
		
		driver.findElement(By.name("q")).click();
		List<WebElement> suggest = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']"));
		for(WebElement ele:suggest)
		{
			System.out.println(ele.getText());
		}
		
		driver.close();

	}

}
