package UiElemetTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TextBox {

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
    public void textBoxTest() throws InterruptedException {
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

        //3 saniye gözledek
        Thread.sleep(3000);

        //TextBox buttona click etmək
        String textBoxXpath = "//span[text()='Text Box']";
        WebElement textBox = driver.findElement(By.xpath(textBoxXpath));
        textBox.click();

        //3 saniye gözledek
        Thread.sleep(3000);

        //Full name daxil etmek
        String fullNameXpath = "//input[@placeholder='Full Name']";
        WebElement fullNameFIeld = driver.findElement(By.xpath(fullNameXpath));
        fullNameFIeld.click();

        //Full name fieldine ad soyad daxil edirik
        fullNameFIeld.sendKeys("Ilkin Salmanov");

        //EMAIL fieldine
        String emailXpath = "//input[@id='userEmail']";
        WebElement emailField = driver.findElement(By.xpath(emailXpath));

        //3 saniye gözledek
        Thread.sleep(3000);

        //Emaile data daxil etmek
        emailField.sendKeys("ilkinsalmanov@bda.edu.az");

        //CurrentAdress fieldine data daxil etmek
        String currentAdressXpath = "//textarea[@id='currentAddress']";
        WebElement currentAdress = driver.findElement(By.xpath(currentAdressXpath));
        currentAdress.click();

        //CurrentAdress fieldine data daxil etmek
        currentAdress.sendKeys("Baku");

        //3 saniye gözledek
        Thread.sleep(3000);

        //Aşağı doğru scroll etmek üçün işlədirik
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 300)");

        //Permanent Address firldine data daxil etmek
        String permanentAdressXpath = "//textarea[@id='permanentAddress']";
        WebElement permanentAdress = driver.findElement(By.xpath(permanentAdressXpath));
        permanentAdress.click();

        //data daxil etmek
        permanentAdress.sendKeys("Test");

        //Aşağı doğru scroll etmek üçün işlədirik
        js.executeScript("window.scrollBy(0, 300)");

        Thread.sleep(4000);

        //Submit button
        String submitXpath = "//button[@id='submit']";
        WebElement submit = driver.findElement(By.xpath(submitXpath));
        submit.click();

        Thread.sleep(3000);

        //Output check
        String outputXpath = "//div[@id='output']//p[@id='name']";
        WebElement output = driver.findElement(By.xpath(outputXpath));
        if (output.getText().contains("Ilkin Salmanov")){
            System.out.println("Test uğurludur");
        } else {
            System.out.println("test uğursuzdur");
        }
    }

    @AfterEach
    void finish (){
        if (driver != null){
            driver.quit();
        }
    }
}
