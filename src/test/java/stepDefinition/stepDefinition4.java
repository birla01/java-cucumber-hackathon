package stepDefinition;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hackathon.Util;

public class stepDefinition4 {
	@When("^I count Invalid number of transactions$")
	public void i_count_Invalid_number_of_transactions() throws Throwable {
	
	}

	@When("^I open error folder$")
	public void i_open_error_folder() throws Throwable {
	   
	}

	@When("^I count Invalid files$")
	public void i_count_Invalid_files() throws Throwable {
	   
	}

	@Then("^count of Invalid number of transactions should be equal to total number of invalid output files in error folder$")
	public void count_of_Invalid_number_of_transactions_should_be_equal_to_total_number_of_invalid_output_files_in_error_folder() throws Throwable {
		String currentDir = System.getProperty("user.dir");
		String dir = currentDir + "\\out\\Error";
		
		Assert.assertEquals(Util.getInValidTransactionCount(), Util.getFileCount(dir));
	}
}
