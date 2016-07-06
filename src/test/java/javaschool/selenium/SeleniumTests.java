package javaschool.selenium;


import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTests {

    @Test
    public void testSeleniumLoadMainPage() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/");
        WebElement element;
        element = driver.findElement(By.id("menu_left"));
        driver.quit();
    }

    @Test
    public void testSeleniumLoginCorrect() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/login");
        WebElement element;
        element = driver.findElement(By.id("login-form"));
        driver.quit();
    }

    @Test(expected = Exception.class)
    public void testSeleniumLoginInCorrect() throws Exception {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/login");
        WebElement element;
        element = driver.findElement(By.id("login2-form"));
        driver.quit();
    }

    @Test
    public void testSeleniumLoginUser() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/login");
        WebElement elementEmail, elementPassword, elementCheck;
        elementEmail = driver.findElement(By.id("email"));
        elementPassword = driver.findElement(By.id("password"));
        elementEmail.sendKeys("Lev.Simonov@icloud.com");
        elementPassword.sendKeys("12345");
        driver.findElement(By.id("submit")).click();
        driver.get("http://localhost:8080/site/cabinet");
        elementCheck = driver.findElement(By.id("cabinetpage"));
        driver.quit();
    }

    @Test(expected = Exception.class)
    public void testSeleniumLoginUserEx() throws Exception {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/login");
        WebElement elementEmail, elementPassword, elementCheck;
        elementEmail = driver.findElement(By.id("email"));
        elementPassword = driver.findElement(By.id("password"));
        elementEmail.sendKeys("Lev.Simonov@icloud.com");
        elementPassword.sendKeys("1234");
        driver.findElement(By.id("submit")).click();
        driver.get("http://localhost:8080/site/cabinet");
        elementCheck = driver.findElement(By.id("cabinetpage"));
        driver.quit();
    }

    @Test(expected = Exception.class)
    public void testSeleniumLoginUserNoPermision() throws Exception {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/login");
        WebElement elementEmail, elementPassword, elementCheck;
        elementEmail = driver.findElement(By.id("email"));
        elementPassword = driver.findElement(By.id("password"));
        elementEmail.sendKeys("Lev.Simonov@icloud.com");
        elementPassword.sendKeys("12345");
        driver.findElement(By.id("submit")).click();
        driver.get("http://localhost:8080/site/admin");
        elementCheck = driver.findElement(By.id("adminclients"));
        driver.quit();
    }

    @Test
    public void testSeleniumLoginUserPermision() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/login");
        WebElement elementEmail, elementPassword, elementCheck;
        elementEmail = driver.findElement(By.id("email"));
        elementPassword = driver.findElement(By.id("password"));
        elementEmail.sendKeys("pow@pow.pow");
        elementPassword.sendKeys("pow");
        driver.findElement(By.id("submit")).click();
        driver.get("http://localhost:8080/site/adminclients");
        elementCheck = driver.findElement(By.id("adminclients"));
        driver.quit();
    }


    @Ignore("Create a new user")
    @Test
    public void testSeleniumRegistration() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/site/reg");
        WebElement elementEmail, elementPassword, elementCheckPass,
                elementName, elementSurname, elementCheck;

        elementEmail = driver.findElement(By.id("email"));
        elementPassword = driver.findElement(By.id("password"));
        elementName = driver.findElement(By.id("first_name"));
        elementSurname = driver.findElement(By.id("last_name"));
        elementCheckPass = driver.findElement(By.id("password_confirmation"));

        elementEmail.sendKeys("how@how.how");
        elementPassword.sendKeys("how");
        elementCheckPass.sendKeys("how");
        elementName.sendKeys("how");
        elementSurname.sendKeys("how");

        driver.findElement(By.id("submit")).click();

        driver.quit();
    }
}