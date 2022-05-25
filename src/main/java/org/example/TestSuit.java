package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import sun.font.EAttribute;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit {

    protected static WebDriver driver;

//======================================================================================================================
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
//======================================================================================================================
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

//======================================================================================================================
     @Test
     public static void userShouldBeAbleToSelectTheCurrencyInEuro(){

       // Click currency bar
      clickElement(By.id("customerCurrency"));

       //Select currency
       Select currency = new Select(driver.findElement(By.id("customerCurrency")));
       currency.selectByVisibleText("Euro");

       //Build your own computer price in Euro
       String expectedCurrency="€1032.00";
       String actualCurrency=driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
       Assert.assertEquals(expectedCurrency,actualCurrency,"Price is not in Euro ");

}

//======================================================================================================================
    @Test
    public static void userShouldBeAbleToSendEmailToFriend(){

        // click on register button
        clickElement(By.className("ico-register"));

        // enter firstname
        TextType(By.xpath("//input[@name='FirstName']"),"abcd");

        //enter lastname
        TextType(By.id("LastName"), "abhdfjg");

        // select gender
        driver.findElement(By.xpath("//label[@for='gender-male']")).click();

        // select birthday
        Select birthday = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        birthday.selectByValue("19");

        //select month
        Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        birthmonth.selectByValue("1");

        // select year
        Select birthyear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        birthyear.selectByVisibleText("2014");

        // enter Email address
        driver.findElement(By.id("Email")).sendKeys(" abndgshkg"+RandomDate()+"@gmail.com");

        // enter password
        TextType(By.id("Password"), "123456");

        // Confirm password
        TextType(By.id("ConfirmPassword"),"123456");

        // click register button
        clickElement(By.id("register-button"));

        //Click on computer
        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //Click on desktop
        clickElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //click on Build your own computer
        clickElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

        //click on Email a friend
        clickElement(By.xpath("//button[normalize-space()='Email a friend']"));

        //enter Friend's email
        driver.findElement(By.xpath("//input[@id='FriendEmail']")).sendKeys("12345678@gmail.com");

        //click on send email button
        driver.findElement(By.xpath("//button[contains(text(),'Send email')]")).click();

        // message display after send email
        String expectedMessage="Your message has been sent.";
        String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"Message has not been sent successfully");

    }
 //=====================================================================================================================
    @Test
    public static void userShouldBeAbleToAddProductInShoppingCardSuccessfully(){

        //click on computers
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")).click();

        //click on desktops
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']")).click();

        //click on build your own computer
        driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();

        //select 2.2Ghz from processor
        Select processor = new Select(driver.findElement(By.xpath("//select[@id=\"product_attribute_1\"]")));
        processor.selectByValue("1");

        //click on Ram and select 2gb
        driver.findElement(By.xpath("//label[contains(text(),'RAM')]"));
        Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
        ram.selectByVisibleText("2 GB");

        //select320gb
        driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();


        //select vista home from OS
        driver.findElement(By.xpath("//input[@id='product_attribute_4_8']")).click();

        //select software microSoftOffice
        driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));

        //select software Acrobat reader
        driver.findElement(By.xpath("//input[@id='product_attribute_5_11']")).click();

        //select Total commander
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();

        //click on add to cart button
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();

        //to verify the product is in shopping cart
        driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();

        assertEquals("Shopping cart",By.xpath("//div[@class='page-title']"),"could not locate shopping cart" );

        assertEquals("Build your own computer", By.xpath("//a[@class='product-name']"),"Wrong product");

    }

//======================================================================================================================
    @Test
    public void userShouldBeBaleToRegisterSuccessfully(){

        // click on register button
        clickElement(By.className("ico-register"));
        //  driver.findElement(By.className("ico-register")).click();

        // enter firstname
        TextType(By.xpath("//input[@name='FirstName']"),"abcd");
        // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Aayan");

        //enter lastname
        TextType(By.id("LastName"), "abhdfjg");
        // driver.findElement(By.id("LastName")).sendKeys("Chovatia");

        // select gender
        driver.findElement(By.xpath("//label[@for='gender-male']")).click();

        // select birthday
        Select birthday = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        birthday.selectByValue("19");

        //select month
        Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        birthmonth.selectByValue("1");

        // select year
        Select birthyear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        birthyear.selectByVisibleText("2014");



        // enter Email address

        // driver.findElement(By.xpath("//input[@id=\"Email\"]") ).sendKeys(" aaabndgshkgj@gmail.com");
        driver.findElement(By.id("Email")).sendKeys(" abndgshkg"+RandomDate()+"@gmail.com");

        // enter password
        TextType(By.id("Password"), "123456");
        //  driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("Saturday07");
        // driver.findElement(By.id("Password")).sendKeys("Saturday07");

        // Confirm password
        TextType(By.id("ConfirmPassword"),"123456");
        // driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("Saturday07");
        //  driver.findElement(By.id("ConfirmPassword")).sendKeys("Saturday07");

        // click register button
        clickElement(By.id("register-button"));
        // driver.findElement(By.id("register-button")).click();

        String expectedMessage="Your registration completed";
        String actualMessage=driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualMessage,expectedMessage, "Registration is not successful");


    }
//======================================================================================================================

    public static void clickElement(By by) {

        driver.findElement(by).click();
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void TextType(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void assertEquals(String expectedMessage,By by, String errormessage){
        String expectedmessage="expectedMessage";
        String actualMessage=driver.findElement(by).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"errormessage");
    }
//----------------------------------------------------------------------------------------------------------------------
    public static String GetTextFromElement(By by) {

        return driver.findElement(by).getText();
    }
//---------------------------------------------------------------------------------------------------------------------
    public static String RandomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }
//======================================================================================================================
   public static void DriverWaitUnitURL(int time, String url) {
        WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.urlToBe(url));
    }

    public static void WaitForClickAble(By by, int time) {
        WebDriverWait wait02 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait02.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void InvisibilityOfWebElements(int time, WebElement element) {
        WebDriverWait wait03 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait03.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void driverWaitTitle(int time, String xyz){
        WebDriverWait wait04 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait04.until(ExpectedConditions.titleIs(xyz));
    }
    public static void ElementLocated(int time, By by, String located){
        WebDriverWait wait05 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait05.until(ExpectedConditions.textToBePresentInElementLocated(by,located));

    }
    public static void PresenceOfElements( int time,WebElement element, String text ){
        WebDriverWait wait06 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait06.until(ExpectedConditions.textToBePresentInElement(element, text));

    }
    public static void AttributionTobe(int time,By by, String attribute, String text){
        WebDriverWait wait07 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait07.until(ExpectedConditions.attributeContains(by,attribute,text));
    }
    public static void UrlFraction(int time, String fraction){
        WebDriverWait wait08 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait08.until(ExpectedConditions.urlContains(fraction));
    }
    public static void AlertIsPresent(int time){
        WebDriverWait wait09 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait09.until(ExpectedConditions.alertIsPresent());
    }
    public static void AttributeToBeNotEmpty(int time, WebElement element, String attribute){
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait10.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }
    public static void TextToBe(int time, By by, String text){
        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait11.until(ExpectedConditions.textToBe(by, text));
    }
    public static void DomAttribute(int time, WebElement element, String attribute, String text){
        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait12.until(ExpectedConditions.domAttributeToBe(element, attribute, text));
    }
    public static void ElementsToBeSelected(int time, WebElement element){
        WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait13.until(ExpectedConditions.elementToBeSelected(element));
    }
    public static void method(int time, By by, String name){
        WebDriverWait wait14 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait14.until(ExpectedConditions.textToBe(by, name));
    }


}

