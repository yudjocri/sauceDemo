package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtils;
import utility.PropertyUtils;

import java.util.List;
import java.util.Map;

public class steps {
    public  static org.slf4j.Logger logger = LoggerFactory.getLogger(steps.class.getName());
    private Scenario scenario;
    public static PropertyUtils propertyUtils;
    WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^user logs in to application with user \"([^\"]*)\"$")
    public void userLogsIn(String userName) throws Exception {
        logger.debug("user logs in");
        try {
            String url = propertyUtils.getProperty("URL");
            String passWord = propertyUtils.getProperty("password");
            driver = BrowserUtils.openBrowser("Chrome");
            driver.get(url);
            driver.findElement(By.id("user-name")).sendKeys(userName);
            driver.findElement(By.id("password")).sendKeys(passWord);
            driver.findElement(By.id("login-button")).click();
            scenario.write("Logged in as user: " + userName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error logging int to application " + e);
            Assert.fail("Exception occurred in logging in");
        }
    }

    @When("user adds to cart selected items")
    public void userAddsToCarItems(DataTable dataTable) throws Throwable {
        logger.debug("user adds items to cart");

        List<String> items = dataTable.asList(String.class);
        for (int i = 1; i < items.size(); i++) {
            String item = items.get(i).toString();
            String itemButton = "add-to-cart-" + item.toLowerCase().replace(" ","-");
            driver.findElement(By.id(itemButton)).click();
            scenario.write("Added item: " + item + " to cart");
        }
    }

    @And("user updates cart quantity")
    public void userUpdatesCart(DataTable dataTable) throws Throwable {
        logger.debug("user updates cart items");

        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);
        for (int i = 1; i < items.size(); i++) {
            String itemName = items.get(i).get("ItemName");
            String itemQty = items.get(i).get("Quantity");
            WebElement webElement = driver.findElement(By.xpath("//div[@text='" + itemName + "'//preceding::div[@class='cart_quantity'][0]"));
            String actQty = driver.findElement(By.xpath("//div[@text='" + itemName + "'//preceding::div[@class='cart_quantity'][0]")).getText();
            if (!actQty.equalsIgnoreCase(itemQty)) {
                webElement.sendKeys(itemQty);
            }
        }
    }

    @And("^user checks out items from cart with details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userChecksOutItems(String firstName, String lastName, String postalCode) throws Throwable {
        logger.debug("user updates cart items");

        //Click cart icon
        driver.findElement(By.className("shopping_cart_link")).click();

        //Click checkout button
        driver.findElement(By.id("checkout")).click();

        //Add checkout details
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);

        //Click continue button
        driver.findElement(By.id("continue")).click();
        scenario.write("Items checked-out");
    }

    @Then("user verifies item total and total value")
    public void userVerifiesTotal() throws Throwable {
        logger.debug("user verifies total items");
        Double expAmount = 0.00;
        int elSize = driver.findElements(By.className("inventory_item_price")).size();
        for (int i = 0; i < elSize; i++) {
            String price = driver.findElements(By.className("inventory_item_price")).get(i).getText().replace("$","");
            expAmount = expAmount + Double.parseDouble(price);
        }
        String itemTotal = driver.findElement(By.className("summary_subtotal_label")).getText().replace("Item total: $","");
        String tax = driver.findElement(By.className("summary_tax_label")).getText().replace("Tax: $","");
        String total = driver.findElement(By.className("summary_total_label")).getText().replace("Total: $","");

        scenario.write("Expected Amount: " + String.valueOf(expAmount) + " -- Actual Amount: " + itemTotal);

        if (!expAmount.equals(Double.parseDouble(itemTotal))) {
            Assert.fail("Expected Amount: " + String.valueOf(expAmount) + " -- Actual Amount: " + itemTotal);
        }
    }

    @And("user successfully finish check out")
    public void userSuccessfullyChecksOut() throws Throwable {
        logger.debug("user successfully checks out items");

        //Click Finish button
        driver.findElement(By.name("finish")).click();

        //Captures complete text
        String actualMessage = driver.findElement(By.className("complete-text")).getText();

        scenario.write("Expected message: Your order has been dispatched, and will arrive just as fast as the pony can get there! -- Actual message: " + actualMessage);

        if (!actualMessage.equalsIgnoreCase("Your order has been dispatched, and will arrive just as fast as the pony can get there!")) {
            Assert.fail("Expected message: Your order has been dispatched, and will arrive just as fast as the pony can get there! -- Actual message: " + actualMessage);
        }
    }

    @And("user removes selected items from product page")
    public void userRemovesFromProduct(DataTable dataTable) throws Throwable {
        logger.debug("user remove items from product page");

        //Click remove button for selected item
        List<String> items = dataTable.asList(String.class);
        for (int i = 1; i < items.size(); i++) {
            String item = items.get(i).toString();
            String itemButton = "remove-" + item.toLowerCase().replace(" ","-");
            driver.findElement(By.id(itemButton)).click();
            scenario.write("Item: " + item + " removed");
        }
    }

    @And("user removes selected items from checkout page")
    public void userRemovesFromCheckout(DataTable dataTable) throws Throwable {
        logger.debug("user remove items from checkout page");

        //Click cart icon
        driver.findElement(By.className("shopping_cart_link")).click();

        //Click remove button for selected item
        List<String> items = dataTable.asList(String.class);
        for (int i = 1; i < items.size(); i++) {
            String item = items.get(i).toString();
            String itemButton = "remove-" + item.toLowerCase().replace(" ","-");
            driver.findElement(By.id(itemButton)).click();
            scenario.write("Item: " + item + " removed");
        }
    }

    @Then("user verifies items removed successfully")
    public void userVerifiesItemsRemoved(DataTable dataTable) throws Throwable {
        logger.debug("user verifies items removed successfully from checkout page");
        int counter = 0;
        //Capture item names from inventory
        String inventoryItems = "";
        int z = driver.findElements(By.className("inventory_item_name")).size();
        for (int x = 0; x < z; x++) {
            String cart = driver.findElements(By.className("inventory_item_name")).get(x).getText();
            if (inventoryItems.isEmpty()) {
                inventoryItems = cart + ",";
            } else {
                inventoryItems = inventoryItems + cart;
            }
        }
        //Verification for removed items
        List<String> items = dataTable.asList(String.class);
        for (int i = 1; i < items.size(); i++) {
            String item = items.get(i).toString();
            if (inventoryItems.contains(item)) {
                counter++;
            }
        }

        if (counter != 0) {
            scenario.write("Items not successfully removed");
            Assert.fail("Items not successfully removed");
        } else {
            scenario.write("Items successfully removed");
        }
    }

    @Then("^user verifies login \"([^\"]*)\"$")
    public void userVerifiesLogin(String expected) throws Exception {
        logger.debug("user verifies log in");
        try {
            String errorMsg = "";


            switch (expected) {
                case "ERROR":
                    errorMsg = driver.findElement(By.xpath("//div[@class='error-message-container error']/h3")).getText();
                    scenario.write("Expected error message: " + errorMsg);
                    if (errorMsg.isEmpty()) {
                        Assert.fail("Error message: " + errorMsg + " not displayed");
                    }
                    break;
                case "SUCCESS":
                    Boolean appLogo = driver.findElement(By.className("app_logo")).isDisplayed();
                    if (appLogo == Boolean.FALSE) {
                        errorMsg = driver.findElement(By.xpath("//div[@class='error-message-container error']/h3")).getText();
                        scenario.write("Error logging in with message: " + errorMsg);
                        Assert.fail("Error logging in");
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error logging int to application " + e);
            Assert.fail("Exception occurred during logging in");
        }
    }

    @When("^user sort items in \"([^\"]*)\"$")
    public void userSortItems(String order) throws Exception {
        logger.debug("user sort items");
        try {
            WebElement selector = driver.findElement(By.className("product_sort_container"));
            Thread.sleep(5000);
            switch (order) {
                case "az":
                    selector.sendKeys("Name (A to Z)");
                    Thread.sleep(5000);
                    break;
                case "za":
                    selector.sendKeys("Name (Z to A)");
                    break;
                case "lohi":
                    selector.sendKeys("Price (low to high)");
                    break;
                case "hilo":
                    selector.sendKeys("Price (high to low)");
                    Thread.sleep(5000);
                    break;
            }
            scenario.write("Order selected: " + order);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error sorting " + e);
            Assert.fail("Exception occurred during sorting");
        }
    }

    @Then("^user verifies items sorted in \"([^\"]*)\"$")
    public void userVerifiesSort(String order) throws Exception {
        logger.debug("user verify sort items");
        String expectedSort = "";
        try {
            String actualSort = driver.findElement(By.className("active_option")).getText();
            switch (order) {
                case "az":
                    expectedSort = "Name (A to Z)";
                    break;
                case "za":
                    expectedSort = "Name (Z to A)";
                    break;
                case "lohi":
                    expectedSort = "Price (low to high)";
                    break;
                case "hilo":
                    expectedSort = "Price (high to low)";
                    break;
            }
            scenario.write("Expected order: " + expectedSort + " -- Actual order: " + actualSort);
            if (!expectedSort.equalsIgnoreCase(actualSort)) {
                Assert.fail("Failed in sorting products");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error sorting " + e);
            Assert.fail("Exception occurred during sorting");
        }
    }
}
