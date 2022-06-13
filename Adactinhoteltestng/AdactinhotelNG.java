package Adactinhoteltestng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinhotelNG {
	WebDriver driver;

	@Test(priority=0)
	void chrome() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/"); 
		System.out.println(driver.getTitle());

	}

	
	@Test(priority=1)
	void login() {
		driver.findElement(By.id("username")).sendKeys("vidhyasri17");
		driver.findElement(By.id("password")).sendKeys("anusri2417");
		driver.findElement(By.id("login")).click();
	}

	@Test(priority = 2)
	void dropDown() {
		WebElement location = driver.findElement(By.id("location"));
		Select selectLocation = new Select(location);
		selectLocation.selectByVisibleText("Melbourne");

		WebElement hotel = driver.findElement(By.id("hotels"));
		Select selectHotel = new Select(hotel);
		selectHotel.selectByIndex(2);

		WebElement roomType = driver.findElement(By.id("room_type"));
		Select selectRoomType = new Select(roomType);
		selectRoomType.selectByValue("Double");

		WebElement rooms = driver.findElement(By.id("room_nos"));
		Select roomsSelect = new Select(rooms);
		roomsSelect.selectByIndex(5);

	}

	@Test(priority = 3)
	void date() {
		driver.findElement(By.id("datepick_in")).sendKeys("23/05/2022");
		driver.findElement(By.id("datepick_out")).sendKeys("24/05/2022");

	}

	@Test(priority = 4)
	void room() {
		WebElement adultPerRoom = driver.findElement(By.id("adult_room"));
		Select selectAdultPerRoom = new Select(adultPerRoom);
		selectAdultPerRoom.selectByIndex(3);
		
		
		WebElement childrenRoom = driver.findElement(By.id("child_room"));
		Select selectchildrenRoom = new Select(childrenRoom);
		selectchildrenRoom.selectByIndex(2);
	}

	@Test(priority = 5)
	void email() {
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.name("continue")).click();
		
	}
}