import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TP_Fnac {
    WebDriver driver;

    @BeforeTest
    public void SetUp(){
        driver =  new ChromeDriver();
        driver.get("https://www.ebay.fr/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //String CookiesID= "#gdpr-banner-accept";
        //String EnSavoirPlus= "a.gdpr-banner-moreInfo[_sp='p2481888.m43527.l10184']";
        //driver.findElement(By.cssSelector(CookiesID)).click();
    }

    @Test
    public void test1(){

        String selectorCategories= "gh-shop-a";
        driver.findElement(By.id(selectorCategories)).click();


        String selectSport= "[_sp='m570.l3778']";
        driver.findElement(By.cssSelector(selectSport)).click();

        List<WebElement> listArticles = driver.findElements(By.cssSelector("[itemprop=\"image\"]"));
        listArticles.get(11).click();

        String ajoutPanier= "isCartBtn_btn";
        driver.findElement(By.id(ajoutPanier)).click();

        // Asserts
         String resultatAttendu="Buts de Foot 2pcs Mini Pop-Up Cages de Football Enfant Adulte + Sac de Transport";
        String resultat= "a span span.BOLD";
        driver.findElement(By.cssSelector(resultat)).click();

        String text= "#itemTitle";
        String textResult = driver.findElement(By.cssSelector(text)).getText();

        Assert.assertEquals(textResult, resultatAttendu);

        //Assert.assertTrue(resultatReel.contains(resultatAttendu), "Le panier est vide !!");



        //String xpathArticle2= "//*[@id=\"page-content\"]/section[2]/div/div[1]/article[1]/a/div/h2";
        //driver.findElement(By.xpath(xpathArticle2)).click();
        // a.card.card-lined.color-entertainment > figure.media > div.media-wrap > img.b-lazy.b-loaded

    }

    @Test
    public void test2(){

    }

    @AfterTest
    public void TearDown(){
        //driver.quit();
    }
}

