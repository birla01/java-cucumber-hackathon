package stepDefinition;

import java.io.File;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition2 {

	public static String sfileExt;
	@When("^I open the output folder$")
	public void i_open_the_output_folder() throws Throwable {
		String currentDir = System.getProperty("user.dir");
	System.out.println("Current dir using System:" + currentDir + "\\out\\pain001");
	String dir = currentDir + "\\out\\pain001";

	File f = new File(dir);

	int count = 0;
	for (File file : f.listFiles()) {
		if (file.isFile()) {

			File f2 = new File(file.getAbsolutePath());

			String fileName = f2.getName();
			System.out.println("file name : " + fileName);
			if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)

				System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
			sfileExt=fileName.substring(fileName.lastIndexOf(".") + 1);

			count++;
		}
	}
	System.out.println("Number of files: " + count);

	    
	}

	@Then("^xml file should be present$")
	public void xml_file_should_be_present() throws Throwable {
		System.out.println("file extension "+ sfileExt);
		Assert.assertEquals(sfileExt, "xml");
	}

}
