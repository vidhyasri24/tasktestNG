package amazontestng;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	WebDriver driver;
	Scanner scan = new Scanner(System.in);

	@Test(enabled = true)
	void amazonWebsite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Scanner scan = new Scanner(System.in);
		

		driver.get("http://www.amazon.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("water bottles" + Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='brandsRefinements']/ul/li[8]/span/div/a/i")).click();

	}

	@Test(dependsOnMethods = "amazonWebsite")
	void brandList() {

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='brandsRefinements']/ul"));
		WebElement brands;
		for (WebElement webElement : list) {
			System.out.println("===WaterBottle Brand List=== ");
			String waterBottle = webElement.getText();
			System.out.println(waterBottle);
			System.out.println();
			System.out.println("=====================");
			System.out.println("Enter The WaterBottle Brand Name: ");
			String bottleBrandName = scan.next();

			if (waterBottle.contains(bottleBrandName)) {

				System.out.println("Given brand is present");
				System.out.println("=====================");

				break;
			} else {
				System.out.println("Given Brand is not present");
				System.out.println("=====================");

			}
		}
	}
}
