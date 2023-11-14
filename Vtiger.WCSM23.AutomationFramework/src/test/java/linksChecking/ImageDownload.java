package linksChecking;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import vTiger_genericutility.JavaUtility;

public class ImageDownload {
	@Test	
	void captureAllImg() throws IOException
	{

		// Set the path to your ChromeDriver

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");

		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		int count=1;
		for(WebElement img:imgList)
		{
			String src = img.getAttribute("src");
			System.out.println(src);
			URL imgurl=new URL(src);
			BufferedImage savImg = ImageIO.read(imgurl);
			ImageIO.write(savImg, "jpg", new File(count+".jpg"));
			count++;

		}   
	}

	@Test
	void saveParticularImg() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");

		WebElement imgEl = driver.findElement(By.xpath("(//img[@style=\"width: 100%; margin: auto; display: block; object-fit: contain; opacity: 1; aspect-ratio: 1 / 1;\"])[4]"));
		String src = imgEl.getAttribute("src");
		System.out.println(src);
		URL imgurl=new URL(src);
		BufferedImage savImg = ImageIO.read(imgurl);
		
		JavaUtility jUtil=new JavaUtility();
		
		ImageIO.write(savImg, "jpg", new File(".\\Images\\"+jUtil.getSystemDateformat()+".jpg"));
	}
}

	
