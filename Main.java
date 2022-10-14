import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\aliyazicioglus\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://techcrunch.com/");

        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl);

        WebElement i = driver.findElement(By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article[1]/footer/figure/picture/img"));

        Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

        if (p) {
            System.out.println("News has an image");
        }
        else {
            System.out.println("News has not an image");
        }

        WebElement author = driver.findElement(By.cssSelector("#tc-main-content > div:nth-child(3) > div > div > div > article:nth-child(1) > header > div > div > span > span > a"));

        if(author.isDisplayed()) {
            System.out.println("News has an author");
        }
        else {
            System.out.println("News has not an author");
        }

        driver.findElement(By.cssSelector("#tc-main-content > div:nth-child(3) > div > div > div > article:nth-child(1) > div")).click();

        List<WebElement> allLinks = driver.findElements(By.cssSelector("#tc-main-content > div:nth-child(3) > div > div > div > article.article-container.article--post > div.article__content-outer > div:nth-child(2) > div:nth-child(2)"));

        for(WebElement link:allLinks){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }

        driver.quit();
    }
}