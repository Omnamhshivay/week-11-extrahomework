package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void SetUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.name("username")).sendKeys("BahuBali");
        driver.findElement(By.name("password")).sendKeys("Devsena");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        //verify requirement
        String expectedMessage="Accounts Overview";
        String actualMessage=driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.name("username")).sendKeys("BahuBali");
        driver.findElement(By.name("password")).sendKeys("Devsena1");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        //verify requirement
        String expectedMessage="The username and password could not be verified.";
        String actualMessage=driver.findElement(By.xpath("//div[@id='bodyPanel']/div[2]/p")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void userShouldLogOutSuccessfully(){

        driver.findElement(By.name("username")).sendKeys("BahuBali");
        driver.findElement(By.name("password")).sendKeys("Devsena");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        driver.findElement(By.xpath("//div[@id='bodyPanel']/div/ul/li[8]/a")).click();
        //verify requirement
        String actualMsg = driver.findElement(By.xpath("//div[@id='leftPanel']/h2")).getText();
        String expectedMsg = "Customer Login";
        Assert.assertEquals("Customer Login Message", expectedMsg, actualMsg);
    }
    @After
    public void close(){
        driver.close();
    }
}
