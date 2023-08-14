import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver navegador;
    @Before
    public void criarDriver(){
        Driver navegadorx = new Driver();
        navegador = navegadorx.WebDriver();
    }

    @Test
    public void fazerLogin(){
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.id("login-button")).click();
        String logado = navegador.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals("Products", logado);
    }

    @Test
    public void fazerLoginLocket(){
        navegador.findElement(By.id("user-name")).sendKeys("locked_out_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.id("login-button")).click();
        String locket = navegador.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", locket);

    }


    @Test
    public void fazerLoginUsernameInvalido() {
        navegador.findElement(By.id("user-name")).sendKeys("lasd");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.id("login-button")).click();
        String erroruser = navegador.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", erroruser);

    }

    @Test
    public void fazerLoginPasswordInvalido() {
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        navegador.findElement(By.id("password")).sendKeys("asdf");
        navegador.findElement(By.id("login-button")).click();
        String errorpass = navegador.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorpass);
    }

    @After
    public void fecharDriver(){
        navegador.close();
        navegador.quit();
    }
}
