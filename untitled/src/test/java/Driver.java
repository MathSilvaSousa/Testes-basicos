import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public WebDriver WebDriver(){
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://www.saucedemo.com/");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return navegador;
    }
}
