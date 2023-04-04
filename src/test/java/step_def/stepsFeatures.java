package step_def;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class stepsFeatures {

    String url = ConfigReader.getProperty("url");
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("User open URL")
    public void user_open_url() {
        driver.get(url);
    }

    @Given("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @Given("Click on Login")
    public void click_on_login() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(2000);
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful")) {
            driver.close();
            Assert.assertTrue(false);
        } else
            Assert.assertEquals(title, driver.getTitle());
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        loginPage.clickLogout();
    }

    @Then("close browser")
    public void close_browser() {
        Driver.closeDriver();
    }
}
