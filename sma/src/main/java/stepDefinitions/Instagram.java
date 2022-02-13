package stepDefinitions;


import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Instagram extends CommonUtils{

	  @Given("^I enter below (.+)$")
    public void i_enter_url(String url) throws Throwable {
    	openBrowser(url, "instagram");
    }

    @When("^I enter my username as (.+) and password as (.+)$")
    public void i_enter_my_and(String username, String password) throws Throwable {
    	instagramEnterCredentials(username, password);
    }

    @Then("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
        throw new PendingException();
    }
}
