package CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CheckBox {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup(); // Driver avtomatik yüklənir
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications"); // Bildirişləri söndür
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        driver.get("https://demoqa.com/");

        // Banneri gizlət
        ((JavascriptExecutor) driver).executeScript("document.getElementById('fixedban').style.display='none';");

        // Scroll etmək üçün Actions
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Elements buttonunu tap və click et
        String elementsXpath = "//div[@class='card-body']//h5[text()='Elements']";
        WebElement elementsButton = driver.findElement(By.xpath(elementsXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsButton);
        elementsButton.click();

        // Check Box buttonuna click et
        WebElement checkBoxButton = driver.findElement(By.id("item-1")); // ID düzəldildi
        checkBoxButton.click();

        //3 saniye gözledek
        Thread.sleep(3000);

        //Button-a click edəndə checkbox-lar açılmasını yoxlamaq
        String openCheckboxesCss = ".rct-icon-expand-close";
        WebElement openCheckboxesButton = driver.findElement(By.cssSelector(openCheckboxesCss));
        openCheckboxesButton.click();

        //3 saniye gözledek
        Thread.sleep(3000);

        //Button-a click edəndə checkbox-lar baglanmasini yoxlamaq
        String closeCheckboxesCss = ".rct-collapse";
        WebElement closeCheckboxesButton = driver.findElement(By.cssSelector(closeCheckboxesCss));
        closeCheckboxesButton.click();

        //3 saniye gözledek
        Thread.sleep(3000);

        // Expended All buttonu test etmek
        String expededAllXpath = "//button[@title='Expand all']";
        WebElement expededAllButton = driver.findElement(By.xpath(expededAllXpath));
        expededAllButton.click();

        //2 saniye gözledek
        Thread.sleep(2000);

        //Selected buttonu test etmek

        String selectedButtonXpath = "//li[@class='rct-node rct-node-parent rct-node-expanded']/span[@class='rct-text']w]";
        WebElement selectedButton = driver.findElement(By.xpath(selectedButtonXpath));
        selectedButton.click();

        //2 saniye gözledek
        Thread.sleep(2000);

        //Collapse all
        String collapseAllXpath="//button[@title='Collapse all']";
        WebElement collapseAllButton = driver.findElement(By.xpath(collapseAllXpath));
        collapseAllButton.click();







        //driverden cixis
       //  driver.quit();








    }
}
