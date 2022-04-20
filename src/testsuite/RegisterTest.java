package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //find element of register
        WebElement registerLinkElement= driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLinkElement.click();
        // verify the requirement
        String expectedMessage="Signing up is easy!";
        WebElement actualMessageElement=driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage="Signing up is easy!";
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println(actualMessage);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //find element of register
        WebElement registerLinkElement= driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLinkElement.click();
        // find element of firstname
        driver.findElement(By.id("customer.firstName")).sendKeys("Bahu");
        driver.findElement(By.id("customer.lastName")).sendKeys("Bali");
        driver.findElement(By.id("customer.address.street")).sendKeys("007 Bahubali");
        driver.findElement(By.id("customer.address.city")).sendKeys("Shivgamini");
        driver.findElement(By.id("customer.address.state")).sendKeys("Maheshmati");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("007007");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("00700700707");
        driver.findElement(By.id("customer.ssn")).sendKeys("7777777");
        driver.findElement(By.id("customer.username")).sendKeys("BahuBali");
        driver.findElement(By.id("customer.password")).sendKeys("Devsena");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Devsena");
        driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]")).click();
        //verify the requirement
        String expectedMessage= "Your account was created successfully. You are now logged in.";
        driver.findElement(By.xpath("//div[@id='mainPanel']/div[3]/div[2]/p"));
        String actualMessage="Your account was created successfully. You are now logged in.";
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void close(){
        //closeDriver();
    }
}
