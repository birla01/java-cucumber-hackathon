package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hackathon.Util;

public class stepDefinition6 {
	@When("^I Open XSD file$")
	public void i_Open_XSD_file() throws Throwable {
	   
	}

	@When("^I check all tags$")
	public void i_check_all_tags() throws Throwable {
	  
	}

	@When("^I Open XML file$")
	public void i_Open_XML_file() throws Throwable {
	
	}

	@Then("^all tags should be present in xml as per xsd$")
	public void all_tags_should_be_present_in_xml_as_per_xsd() throws Throwable {
		
		String currentDir = System.getProperty("user.dir");
		String xsdDir = currentDir + "\\out\\xsd\\pain.001.001.06.xsd";
		
		String xmlDir = currentDir + "\\out\\pain001\\1542692066104.xml";
		 System.out.println("Input xsd validate against output xml "+Util.validateXMLSchema(xsdDir, xmlDir));
	}


}
