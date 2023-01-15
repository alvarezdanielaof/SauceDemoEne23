package Edit.SauceDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Asignacion5 {
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	File pantalla;
	String rutaEvidencia = "..\\SauceDemo\\Evidencias\\";

	@BeforeSuite
	public void abrirNavegador() {
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	
	}
	
	// Iniciar sesión
	@Test
	public void IniciarSesion() throws IOException{
		
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
	
	// Captura de evidencia 1
	pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(pantalla,new File(rutaEvidencia + "01_datosiniciosesión.jpg"));
	
	driver.findElement(By.cssSelector("#login-button")).click();
	
	}
	
	// Proceso de compra
	@Test
	public void RealizarCompra() throws IOException {
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		
		// Captura de evidencia 2
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla,new File(rutaEvidencia + "02_unproductoencarrito.jpg"));
		
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		driver.findElement(By.id("first-name")).sendKeys("Daniela");
		driver.findElement(By.name("lastName")).sendKeys("Alvarez");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("5000");
		
		// Captura de evidencia 3
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla,new File(rutaEvidencia + "03_camposcompletados.jpg"));
		
		driver.findElement(By.id("continue")).click();
		
		// Captura de evidencia 4
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla,new File(rutaEvidencia + "04_checkoutoverview.jpg"));
		
		driver.findElement(By.name("finish")).click();
		
		// Captura de evidencia 5
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla,new File(rutaEvidencia + "05_comprarealizada.jpg"));
		
		// Comprobar la nueva URL al confirmar la compra
		String urlEsperada ="https://www.saucedemo.com/checkout-complete.html";
		String urlActual = driver.getCurrentUrl();
		
		AssertJUnit.assertEquals(urlActual, urlEsperada);		
		
	}	
	
	// Cerrar el navegador
	@AfterSuite
	public void CerrarNavegador() {
		driver.close();	
	
	}
}
