package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class StepDefination extends TestBase {
	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	}

	@Given("^User is already in Login Page$")
	public void user_is_already_in_Login_Page() throws Throwable {
		String expectedTitle = "Login - TechFios Test Application - Billing"; // To store the actual title
		String actualTitle = driver.getTitle(); // To get and store the title
		System.out.println(actualTitle); // To print
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
	}

	@Then("^Dashboard page should display$")
	public void dashboard_page_should_display() {
		dashboardPage.waitForPage();
	}

	@Then("^Dashboard page should not display$")
	public void dashboard_page_should_not_display() {
		Assert.assertFalse(dashboardPage.isDashboardDisplayed(), "Invalid Customer was able to Login");
	}

	@After
	public void after_login_close_the_browser() {
		driver.close();
	}

}
