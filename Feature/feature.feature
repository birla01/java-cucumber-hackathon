# Assumption: There will be only one input file file 


	Feature: File validation
	Scenario: Verification of Input file
		When I open the input folder
		Then text file should be present
		
		Scenario: Verification of  output
		When I open the output folder
		Then xml file should be present
		
		Scenario: Verification of number of output files in PAIN001 folder should equal to number of valid transactions
		When I open input file 
		And I count valid number of transactions
		When I open PAIN001 folder
		And I count valid files
		Then count of valid number of transactions should be equal to total number of valid output files
		
		Scenario: Verification of number of output files in Error folder should equal to number of Invalid transaction
		When I open input file 
		And I count Invalid number of transactions
		When I open error folder
		And I count Invalid files
		Then count of Invalid number of transactions should be equal to total number of invalid output files in error folder
		
		Scenario: Verification of account number in output xml file should be same account from input transaction.
		
		When I Open input file
		And I check account number in transaction
		When I open xml file
		And I check account number in transaction
		Then account number in both files should match
		
		Scenario: Verification of xsd file against xml
		When I Open XSD file
		And I check all tags
		When I Open XML file
		And I check all tags
		Then all tags should be present in xml as per xsd
		

         Scenario:  To verify the inpul xml file format should go to Transformer folder
         When I open transformer folder
         Then XML files should be present

         
         Scenario: To verify he lenth of xml values created in PAIN folder
         When I open pain folder
         And I open xml file
         Then value length should be correct

		