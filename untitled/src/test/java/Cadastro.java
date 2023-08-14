import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cadastro {
    WebDriver navegador;

    @Before
    public void acessarSiteDois() {
        Driverdois navegadorx = new Driverdois();
        navegador = navegadorx.WebDriver();
    }
    @Test
    public void fazerCadastro(){
        navegador.findElement(By.linkText("Login or register")).click();
        navegador.findElement(By.xpath("//*[@id=\"accountFrm\"]/fieldset/button")).click();
        navegador.findElement(By.id("AccountFrm_firstname")).sendKeys("Pessoa");
        navegador.findElement(By.name("lastname")).sendKeys("Pessoa");
        navegador.findElement(By.id("AccountFrm_email")).sendKeys("pessoapessoas@gmail.com");
        navegador.findElement(By.name("country_id")).sendKeys("Brazil");
        navegador.findElement(By.id("AccountFrm_zone_id")).click();
        navegador.findElement(By.id("AccountFrm_zone_id")).sendKeys("Sao Paulo");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_city\"]")).sendKeys("Sao Paulo");
        navegador.findElement(By.name("postcode")).sendKeys("00000000");
        navegador.findElement(By.id("AccountFrm_loginname")).sendKeys("pessoapessoas");
        navegador.findElement(By.name("password")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_confirm")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_address_1")).sendKeys("Rua Brasil 123");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_agree\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button")).click();
        String mensagemsucesso = navegador.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/h1/span[1]")).getText().toLowerCase();
        Assert.assertEquals("your account has been created!", mensagemsucesso);
    }
    @Test
    public void testandoLogin(){
        navegador.findElement(By.linkText("Login or register")).click();
        navegador.findElement(By.id("loginFrm_loginname")).sendKeys("pessoapessoas");
        navegador.findElement(By.id("loginFrm_password")).sendKeys("pessoapessoa");
        navegador.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button")).click();
        String validacaohome = navegador.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/h1/span[2]")).getText();
        Assert.assertEquals("Pessoa", validacaohome);
    }

    @Test
    public void errorCadastroEmailJaEmUso() {
        navegador.findElement(By.linkText("Login or register")).click();
        navegador.findElement(By.xpath("//*[@id=\"accountFrm\"]/fieldset/button")).click();
        navegador.findElement(By.id("AccountFrm_firstname")).sendKeys("Pessoa");
        navegador.findElement(By.name("lastname")).sendKeys("Pessoa");
        navegador.findElement(By.id("AccountFrm_email")).sendKeys("pessoapessoas@gmail.com");
        navegador.findElement(By.name("country_id")).sendKeys("Brazil");
        navegador.findElement(By.id("AccountFrm_zone_id")).click();
        navegador.findElement(By.id("AccountFrm_zone_id")).sendKeys("Sao Paulo");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_city\"]")).sendKeys("Sao Paulo");
        navegador.findElement(By.name("postcode")).sendKeys("00000000");
        navegador.findElement(By.id("AccountFrm_loginname")).sendKeys("pessoapessoasx");
        navegador.findElement(By.name("password")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_confirm")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_address_1")).sendKeys("Rua Brasil 123");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_agree\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button")).click();
        String emailemuso = navegador.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]")).getText();
        System.out.println(emailemuso);
        Assert.assertEquals("×\n" +
                "Error: E-Mail Address is already registered!", emailemuso);
    }

    @Test
        public void errorPasswordDiferente() {
        navegador.findElement(By.linkText("Login or register")).click();
        navegador.findElement(By.xpath("//*[@id=\"accountFrm\"]/fieldset/button")).click();
        navegador.findElement(By.id("AccountFrm_firstname")).sendKeys("Pessoa");
        navegador.findElement(By.name("lastname")).sendKeys("Pessoa");
        navegador.findElement(By.id("AccountFrm_email")).sendKeys("pessoapessoass@gmail.com");
        navegador.findElement(By.name("country_id")).sendKeys("Brazil");
        navegador.findElement(By.id("AccountFrm_zone_id")).click();
        navegador.findElement(By.id("AccountFrm_zone_id")).sendKeys("Sao Paulo");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_city\"]")).sendKeys("Sao Paulo");
        navegador.findElement(By.name("postcode")).sendKeys("00000000");
        navegador.findElement(By.id("AccountFrm_loginname")).sendKeys("pessoapessoasxx");
        navegador.findElement(By.name("password")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_confirm")).sendKeys("pessoapessoas");
        navegador.findElement(By.id("AccountFrm_address_1")).sendKeys("Rua Brasil 123");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_agree\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button")).click();
        String passworddiferente = navegador.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]")).getText();
        System.out.println(passworddiferente);
        Assert.assertEquals("×\n" +
                "Password confirmation does not match password!", passworddiferente);
    }


    @Test
    public void errorUsernameEmUso() {
        navegador.findElement(By.linkText("Login or register")).click();
        navegador.findElement(By.xpath("//*[@id=\"accountFrm\"]/fieldset/button")).click();
        navegador.findElement(By.id("AccountFrm_firstname")).sendKeys("Pessoa");
        navegador.findElement(By.name("lastname")).sendKeys("Pessoa");
        navegador.findElement(By.id("AccountFrm_email")).sendKeys("pessoapessoasss@gmail.com");
        navegador.findElement(By.name("country_id")).sendKeys("Brazil");
        navegador.findElement(By.id("AccountFrm_zone_id")).click();
        navegador.findElement(By.id("AccountFrm_zone_id")).sendKeys("Sao Paulo");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_city\"]")).sendKeys("Sao Paulo");
        navegador.findElement(By.name("postcode")).sendKeys("00000000");
        navegador.findElement(By.id("AccountFrm_loginname")).sendKeys("pessoapessoas");
        navegador.findElement(By.name("password")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_confirm")).sendKeys("pessoapessoa");
        navegador.findElement(By.id("AccountFrm_address_1")).sendKeys("Rua Brasil 123");
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm_agree\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button")).click();
        String usernameemuso = navegador.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]")).getText();
        System.out.println(usernameemuso);
        Assert.assertEquals("×\n" +
                "This login name is not available. Try different login name!", usernameemuso);

    }
    @After
    public void fecharDriver(){
        navegador.close();
        navegador.quit();
    }
}