package hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Util {
	public static String sfileExt;
public static String getFileExtension(String dir) {
		


		File f = new File(dir);

		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {

				File f2 = new File(file.getAbsolutePath());

				String fileName = f2.getName();
				System.out.println("file name : " + fileName);
				if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)

					System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
				sfileExt = fileName.substring(fileName.lastIndexOf(".") + 1);

				count++;
			}
		}
		//System.out.println("Number of files: " + count);
		System.out.println("File extension : " + sfileExt);
		return sfileExt;

	}

public static int getFileCount(String dir) {
	


	File f = new File(dir);

	int count = 0;
	for (File file : f.listFiles()) {
		if (file.isFile()) {

			File f2 = new File(file.getAbsolutePath());

			String fileName = f2.getName();
			System.out.println("file name : " + fileName);
			if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)

				System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
			sfileExt = fileName.substring(fileName.lastIndexOf(".") + 1);

			count++;
		}
	}
	System.out.println("Number of files: " + count);
	//System.out.println("File extension : " + sfileExt);
	return count;

}

public static int  getValidTransactionCount() {

	String currentDir = System.getProperty("user.dir");
	//System.out.println("Current dir using System:" + currentDir + "\\out\\InputFile\\input.txt");
	String dir = currentDir + "\\out\\InputFile\\input.txt";
	int iValidFileCount = 0;
	try (BufferedReader br = new BufferedReader(new FileReader(new File(dir)))) {

		for (String line; (line = br.readLine()) != null;) {
			// process the line.
			String row[] = line.split(",");

			if (row[0].equals("110")) {
				System.out.println(line);
				iValidFileCount++;
			
			} else {
				System.out.println();
				// error
			}
		}
		System.out.println("Count of valid rows " + iValidFileCount);

		
	} catch (Exception e) {
		e.printStackTrace();
	}

	/*try (BufferedReader br2 = new BufferedReader(new FileReader(new File(dir)))) {
		int iCountTotalRows = br2.lines().toArray().length;
		System.out.println("iCountTotalRows " + iCountTotalRows);

		int iRejectedFileCount = iCountTotalRows - iValidFileCount;
		System.out.println("Rejected transaction count " + iRejectedFileCount);
	} catch (Exception e) {
		e.printStackTrace();
	}*/
	return iValidFileCount;

}

public static int  getInValidTransactionCount() throws FileNotFoundException, IOException {

	String currentDir = System.getProperty("user.dir");
	//System.out.println("Current dir using System:" + currentDir + "\\src\\test\\java\\hackathon\\input.txt");
	String dir = currentDir + "\\out\\InputFile\\input.txt";
	int iValidFileCount = 0;
	int iRejectedFileCount=0;
	
	try (BufferedReader br = new BufferedReader(new FileReader(new File(dir)))) {

		for (String line; (line = br.readLine()) != null;) {
			// process the line.
			String row[] = line.split(",");

			if (row[0].equals("110")) {
				System.out.println(line);
				iValidFileCount++;
			
			} else {
				System.out.println();
				// error
			}
		}
		System.out.println("Count of valid rows " + iValidFileCount);

		
	} 

	try (BufferedReader br2 = new BufferedReader(new FileReader(new File(dir)))) {
		int iCountTotalRows = br2.lines().toArray().length;
		System.out.println("iCountTotalRows " + iCountTotalRows);

		iRejectedFileCount = iCountTotalRows - iValidFileCount;
		System.out.println("Rejected transaction count " + iRejectedFileCount);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return iRejectedFileCount;

}

public static boolean validateXMLSchema(String xsdPath, String xmlPath){
    
    try {
        SchemaFactory factory = 
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdPath));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(xmlPath)));
    } catch (IOException | SAXException e) {
        System.out.println("Exception: "+e.getMessage());
        return false;
    }
    return true;
}
}

