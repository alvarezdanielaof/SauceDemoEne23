package Edit.SauceDemo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asignacion2 {
	
	// Seccion 1 : Atributos o Variables de uso común
		String url = "https://www.saucedemo.com/";
		
	// Seccion 2: Métodos de prueba
		@Test
		public void IniciarSesionEnChrome()
		{
			
			// Acciones para poder iniciar sesión
			// Paso 1. Configurar el navegador
			WebDriver navegador = new ChromeDriver();
			
			// Paso 2. Abrir el navegador en la URL requerida
			navegador.get(url);
			navegador.manage().window().maximize();
			
			// Paso 3. Escribir el usuario y contraseña
			WebElement txtUsuario = navegador.findElement(By.id("user-name"));
			txtUsuario.sendKeys("standard_user");
			WebElement txtContraseña = navegador.findElement(By.id("password"));
			txtContraseña.sendKeys("secret_sauce");
			
			// Paso 4. Hacer click en LOGIN
			WebElement loguearse = navegador.findElement(By.id("login-button"));
			loguearse.click();
			
}}
