import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Produtos {
    WebDriver navegador;
    @Before
    public void logarSite(){
        Driver navegadory = new Driver();
        navegador = navegadory.WebDriver();
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.id("login-button")).click();
    }
    @Test
    public void adicionarCarrinho(){
        navegador.findElement(By.partialLinkText("Bike")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        navegador.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        String quantidade = navegador.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")).getText();
        Assert.assertEquals("1", quantidade);
        String nomedoproduto = navegador.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
        Assert.assertEquals("Sauce Labs Bike Light", nomedoproduto);
    }

    @Test
    public void adicionarAlgunsProdutosCarrinho(){
        navegador.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        navegador.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        navegador.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

    }

    @Test
    public void removerAlgunsProdutosCarrinho() {
        navegador.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        navegador.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        navegador.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        navegador.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        navegador.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
        navegador.findElement(By.id("continue-shopping")).click();
    }

    @Test
    public void finalizarCompra(){
        navegador.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        navegador.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        navegador.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        navegador.findElement(By.id("checkout")).click();
        navegador.findElement(By.name("firstName")).sendKeys("Ahasiduh");
        navegador.findElement(By.name("lastName")).sendKeys("asjdfoi");
        navegador.findElement(By.name("postalCode")).sendKeys("00000000");
        navegador.findElement(By.name("continue")).click();
        navegador.findElement(By.name("finish")).click();
        String mensagemcompra = navegador.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals("Thank you for your order!", mensagemcompra);
        navegador.findElement(By.id("back-to-products")).click();

    }
    @After
    public void fecharDriver(){
        navegador.close();
        navegador.quit();
    }

}
