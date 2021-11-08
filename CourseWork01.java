import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
import static org.testng.Assert.assertEquals;

public class CourseWork01 {


    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().browserVersion("95.0.4638.69").setup();
        driver = new ChromeDriver();
    }


    @Test
    public void executeTest() {

        //Verify Homepage URL
        String givenUrl = "http://automationpractice.com/index.php";
        driver.get(givenUrl);
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Verify current URL and given URL in Homepage");
        assertEquals(currentUrl, givenUrl);
        System.out.println("Test Passed - Verify Homepage URL");

        //Click SignIn Button
        WebElement btnSignIn = driver.findElement(By.xpath("//div[@class=\"header_user_info\"]"));
        btnSignIn.click();
        System.out.println("Test Passed - Click SignIn Button");

        //Enter Username
        WebElement userName = driver.findElement(By.id("email"));
        userName.sendKeys("eximvx@gmail.com");
        System.out.println("Test Passed - Enter Username");

        //Enter Password
        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("8nzQJ64cjRHR7.Y");
        System.out.println("Test Passed - Enter Password");

        //Click on SignIn Button.
        WebElement btnSign = driver.findElement(By.id("SubmitLogin"));
        btnSign.click();
        System.out.println("Test Passed - Click on SignIn Button.");

        //Redirect to Homepage
        String givenUrl1 = "http://automationpractice.com/index.php";
        driver.get(givenUrl1);

        //Click on First Product
        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a"));
        firstProduct.click();
        System.out.println("Test Passed - Click on First Product");

        //Verify first product name
        String product1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText();
        assertEquals(product1, "Faded Short Sleeve T-shirts");
        System.out.println("Test Passed - Verify first product name");

        //Verify Product Price
        String product1Price = driver.findElement(By.id("our_price_display")).getText();
        assertEquals(product1Price, "$16.51");
        System.out.println("Test Passed - Verify Product Price");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Click on Add to Cart
        WebElement addToCart = driver.findElement(By.name("Submit"));
        addToCart.click();
        System.out.println("Test Passed - Click on Add to Cart");

        //Click on Continue Shopping
        WebElement continueShop = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span"));
        continueShop.click();
        System.out.println("Test Passed - Click on Continue Shopping");

        //Go to homepage for add another product
        WebElement goHomePage = driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img"));
        goHomePage.click();
        System.out.println("Test Passed - Go to homepage for add another product");


        //Add Second Product to the cart
        WebElement secondProduct = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]"));
        secondProduct.click();
        System.out.println("Test Passed - Add Second Product to the cart");

        //Go to shopping cart
        WebElement goToCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        goToCart.click();
        System.out.println("Test Passed - Go to shopping cart");

        //Refresh page
        driver.navigate().refresh();
        System.out.println("Test Passed - Refresh page");

        //Verify Total amount in Shopping Cart
        Double firstPPrice = 16.51;
        Double secondPPrice = 27.00;
        Double total = firstPPrice + secondPPrice;

        String verifyTotalStr = driver.findElement(By.id("total_product")).getText().replace("$", "");
        DecimalFormat df = new DecimalFormat("0.00");
        Assert.assertEquals(verifyTotalStr, (df.format(total)));
        System.out.println("Test Passed - Verify Total amount in Shopping Cart");

        //Remove one product from cart
        WebElement removeItem1 = driver.findElement(By.xpath("//*[@id=\"2_7_0_595663\"]/i"));
        removeItem1.click();
        System.out.println("Test Passed - Remove one product from cart");

        //Refresh page
        driver.navigate().refresh();
        System.out.println("Test Passed - Refresh page");

        //Verify total after remove product1
        String secondPrPrice = "16.51";
        String totalPriceTotal = driver.findElement(By.xpath("//*[@id=\"total_product\"]")).getText().replace("$", "");

        Assert.assertEquals(totalPriceTotal, secondPrPrice);
        System.out.println("Test Passed - Verify total after remove product1");

        //Click on Proceed to checkout
        WebElement clickCheckout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
        clickCheckout.click();
        System.out.println("Test Passed - Click on Proceed to checkout");

        //Verify Delivery Details - Name
        String deliveryName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
        assertEquals(deliveryName, "Naveen Chathuranga");
        System.out.println("Test Passed - Verify Details - Name");

        //Verify Delivery Details - Address
        String deliveryAddress = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[3]")).getText();
        assertEquals(deliveryAddress, "93/1 Karagaskada,");
        System.out.println("Test Passed - Verify Details - Address");

        //Verify Delivery Details - City,State,ZipCode
        String deliveryCity = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
        assertEquals(deliveryCity, "Deltota., Virginia 20430");
        System.out.println("Test Passed - Verify Details - City");

        //Verify Delivery Details - Country
        String deliveryCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
        assertEquals(deliveryCountry, "United States");
        System.out.println("Test Passed - Verify Details - Country");

        //Verify Delivery Details - Mobile Number
        String deliveryMobile = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
        assertEquals(deliveryMobile, "0775845653");
        System.out.println("Test Passed - Verify Details - Mobile Number");

        //Click on Proceed to Checkout
        WebElement clickProceed = driver.findElement(By.name("processAddress"));
        clickProceed.click();
        System.out.println("Test Passed - Click on Proceed to Checkout");

        //Click on Agree CheckBox
        WebElement clickAgree = driver.findElement(By.name("cgv"));
        clickAgree.click();
        System.out.println("Test Passed - Click on Agree CheckBox");

        //Click on Proceed to Checkout2
        WebElement clickProceed2 = driver.findElement(By.name("processCarrier"));
        clickProceed2.click();
        System.out.println("Test Passed - Click on Proceed to Checkout");

        //Click on pay by bank wire
        WebElement clickBankWire = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
        clickBankWire.click();
        System.out.println("Test Passed - Click on pay by bank wire");

        //Verify Payment Page URL
        String givenPayUrl = "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment";
        String currentPaymentUrl = driver.getCurrentUrl();
        assertEquals(givenPayUrl, currentPaymentUrl);
        System.out.println("Test Passed - Verify Payment Page URL");

        //Click on I confirm my order
        WebElement clickConfirm = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
        clickConfirm.click();
        System.out.println("Test Passed - Click on Confirm my Order");

        //Verify Order Complete Massage
        String orderComplete = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
        assertEquals(orderComplete, "Your order on My Store is complete.");
        System.out.println("Test Passed - Verify Order Complete Massage");

    }
}

