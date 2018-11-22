package stepDefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hackathon.Util;


public class stepDefinition3 {
	public static String sfileExt;
	@When("^I open input file$")
	public void i_open_input_file() throws Throwable {
	   
	}

	@When("^I count valid number of transactions$")
	public void i_count_valid_number_of_transactions() throws Throwable {
		
	    
	}

	@When("^I open PAIN(\\d+) folder$")
	public void i_open_PAIN_folder(int arg1) throws Throwable {
	    
	}

	@When("^I count valid files$")
	public void i_count_valid_files() throws Throwable {
	
		    
	  
	}

	@Then("^count of valid number of transactions should be equal to total number of valid output files$")
	public void count_of_valid_number_of_transactions_should_be_equal_to_total_number_of_valid_output_files() throws Throwable {
	  
		String currentDir = System.getProperty("user.dir");
		String dir = currentDir + "\\out\\pain001";
		Assert.assertEquals(Util.getValidTransactionCount(), Util.getFileCount(dir));
	}

}
