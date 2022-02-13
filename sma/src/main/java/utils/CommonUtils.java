package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtils {

	public Properties dataProp = null;
	protected WebDriver driver = null;

	public void openBrowser(String url, String propFileName)
			throws IOException {
		dataProp = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/locators/" + propFileName + ".properties");
		dataProp.load(fs);
		DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions op = new ChromeOptions();
		//op.addArguments("--headless");
		op.addArguments("disable-infobars");
		// op.setAcceptInsecureCerts(true);
		// op.addArguments("window-size=1400,1200");
		op.addArguments("--window-size=1920x1080");
		// op.addArguments("--window-size=1920x1080");
		op.merge(cap);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String getUrl = dataProp.getProperty(url);
		driver.navigate().to(getUrl);
	}
	
	public void instagramEnterCredentials(String username, String password) {
		driver.findElement(By.xpath("//h1[contains(@class," + dataProp.getProperty("instagramLogoIsDisplayed") + ")]"));
		driver.findElement(By.name(dataProp.getProperty("username"))).sendKeys(username);
		driver.findElement(By.name(dataProp.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='" + dataProp.getProperty("login") + "']")).click();
	}
}
