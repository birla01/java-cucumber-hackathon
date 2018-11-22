package stepDefinition;

import java.io.File;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hackathon.Util;

public class stepDefinition7 {
	public static String sfileExt;
	@When("^I open transformer folder$")
	public void i_open_transformer_folder() throws Throwable {
		String currentDir = System.getProperty("user.dir");
		//System.out.println("Current dir using System:" + currentDir + "\\out\\InputFile");
		String dir = currentDir + "\\out\\Transformer";

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

	@Then("^XML files should be present$")
	public void xml_files_should_be_present() throws Throwable {
		
		System.out.println("file extension "+ sfileExt);
		Assert.assertEquals(sfileExt, "xml");
	   
	}


}
