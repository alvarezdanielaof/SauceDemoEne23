package Edit.SauceDemo;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Asignacion4 {
	
	String url = "http://automationpractice.pl/";
	
	@Test
	public void SignIn() {
		
		// Paso 1. Configurar el navegador
		WebDriver navegador = new ChromeDriver();
		
		// Paso 2. Abrir el navegador en la URL requerida
		navegador.get(url);
		navegador.manage().window().maximize();
		
		// Paso 3. Hacer click en Sign In
		WebElement loguearse = navegador.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		loguearse.click();
		
		// Paso 4. Escribir el correo
		navegador.findElement(By.cssSelector("#email_create")).sendKeys("correo@gmail.com");
		
		// Paso 5. Hacer click en Create an Account
		navegador.findElement(By.id("SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		
		// Paso 6. Completar el formulario
		navegador.findElement(By.id("id_gender2")).click();
		navegador.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Daniela");
		navegador.findElement(By.cssSelector("#customer_lastname")).sendKeys("Alvarez");
		navegador.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Contraseña1");
		Select listadia = new Select(navegador.findElement(By.cssSelector("#days")));
		listadia.selectByValue("20");
		Select listames = new Select(navegador.findElement(By.cssSelector("#months")));
		listames.selectByIndex(9);
		Select listaaño = new Select(navegador.findElement(By.xpath("//select[@id='years']")));
		listaaño.selectByValue("1995");
		
		// Paso 7. Hacer click en Register
		navegador.findElement(By.id("submitAccount")).click();
		
		}
	
	
	
}
