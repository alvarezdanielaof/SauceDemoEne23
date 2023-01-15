package Edit.SauceDemo;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;
import Utilities.DatosExcel;



public class Asignacion6 {
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	File pantalla;
	String rutaEvidencia = "..\\SauceDemo\\Evidencias\\";
	String nombreDocumento = "Evidencia Saucedemo.docx";
	
	@BeforeSuite
	public void abrirNavegador () throws InvalidFormatException, IOException, InterruptedException {
		driver =  new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		CapturaEvidencia.escribirTituloEnDocumento(rutaEvidencia+nombreDocumento, "Documento de Evidencias Saucedemo",16);
	}
	
	//Iniciar sesión
	@Test(description="CP01 - Iniciar sesión",dataProvider="Datos Login")
	public void login(String usuario, String contraseña, String nombre, String apellido, String CP) throws InvalidFormatException, IOException, InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		driver.findElement(By.cssSelector("#password")).sendKeys(Keys.CONTROL,"A",Keys.DELETE);
		driver.findElement(By.id("user-name")).sendKeys(usuario);
		driver.findElement(By.cssSelector("#password")).sendKeys(contraseña);
		
		// Captura de Evidencia 1
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"Datos Login");
		
		driver.findElement(By.cssSelector("#login-button")).click();
	
	// Proceso de compra
		
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		
		// Captura de Evidencia 2
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"Se agregó al carrito");
		
		driver.findElement(By.id("shopping_cart_container")).click();
		
		// Captura de Evidencia 3
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"Dentro del carrito");
		
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		// Captura de Evidencia 4
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"En el Checkout");
		
		driver.findElement(By.id("first-name")).sendKeys(nombre);
		driver.findElement(By.name("lastName")).sendKeys(apellido);
		driver.findElement(By.cssSelector("#postal-code")).sendKeys(CP);
		
		// Captura de Evidencia 5
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"Formulario completado");
		
		driver.findElement(By.id("continue")).click();
		
		// Captura de Evidencia 6
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"último paso");
		
		driver.findElement(By.name("finish")).click();
		
		// Captura de Evidencia 7
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg",rutaEvidencia + nombreDocumento,"Compra finalizada");
			
		}
	
		@DataProvider (name="Datos Login")
		public Object [][] leerDatosLogin() throws Exception {
			return DatosExcel.leerExcel("..\\SauceDemo\\Datos\\Datos_Asignacion.xlsx", "Hoja1");
		
	}
		@AfterSuite
		public void cerrarNavegador() {
			driver.close();			
		}
}
		
		
	
