/*
    Group Number:
    Group Members: Hemil Patel, ....
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Class will handle welcoming/recognizing past patients
public class WelcomeDoctor {

	Scanner reader = new Scanner(System.in);
	String fullName;
	String previousDoctors;
	String currentDoctor;
	String address;
	String city;
	String state;
	String zipCode;
	String phoneNumber;
	String socialSecurity;
	String gender;
	String birthDate;
	String email;
	String rootDir;
	String emergencyContactName;
	String emergencyPhoneNumber;
	String insuranceCompanyName;
	String insuranceIDNumber;
	String insuranceGroupNumber;
	String insurancePhoneNumber;
	int allergyCount;
	int medCount;

    
    public void welcomeScreen()
    {
  
    	try
    	{
	    	ArrayList<String> allergyList = new ArrayList<String>();
	    	ArrayList<String> medList = new ArrayList<String>();
	    	String arlist;


	    	System.out.println("");
	    	System.out.println("We just need some basic patient information for our medical records");
	    	System.out.println("");
	    	System.out.print("What is your legal Full Name: ");
	    	fullName = reader.nextLine();

	    	File newPatient = new File(rootDir, (fullName + ".txt"));

	    	if(newPatient.exists())
	    		newPatient.delete();

	    	newPatient.createNewFile();

	    	System.out.println("");
	    	System.out.print("What are the previous doctor's you have visited (Use commas to separate names): ");
	    	previousDoctors = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your home address: ");
	    	address = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is the city you live in: ");
	    	city = reader.nextLine();

			System.out.println("");
	    	System.out.print("What is the state you live in: ");
	    	state = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your zipcode: ");
	    	zipCode = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your birthday: ");
	    	birthDate = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your email: ");
	    	email = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your phone number (i.e. ###-###-####): ");
	    	phoneNumber = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your social security (SSN#): ");
	    	socialSecurity = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your gender? (Choose one of the following): ");
	    	System.out.println("");
	    	System.out.print("A) Male");
	    	System.out.println("");
	    	System.out.print("B) Female");
	    	System.out.println("");
	    	System.out.print("C) Prefer not to say");
	    	System.out.println("");
	    	gender = reader.nextLine();
	    	gender = gender.toLowerCase();

	    	if(gender.equals("a"))
	    		gender = "Male";
	    	else if(gender.equals("b"))
	    		gender = "Female";
	    	else
	    		gender = "Prefer not to say";

	    	System.out.println("");
	    	System.out.print("What is your emergency contact's full name?: ");
	    	emergencyContactName = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your emergency contact's phone number? (i.e. ###-###-####): ");
	    	emergencyPhoneNumber = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your insurance company's name?: ");
	    	insuranceCompanyName = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is the ID number on your insurance card?: ");
	    	insuranceIDNumber = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is the group number on your insurance card?: ");
	    	insuranceGroupNumber = reader.nextLine();

			System.out.println("");
	    	System.out.print("What is the phone number on your insurance card?: ");
	    	insurancePhoneNumber = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("How many different types of allergies do you have? (Enter number): ");
	    	allergyCount = reader.nextInt();

	    	if(allergyCount != 0){

		    	for (int i = 1; i <= allergyCount; i++) {
		    		
		    		System.out.println("");
		    		System.out.print("List your allergy (" + i + "): ");
		    		arlist = reader.next();
		    		allergyList.add(arlist);

		    	}
	    	}
	    	if(allergyCount == 0){
	    		allergyList.add("None");
	    	}

	    	System.out.println("");
	    	arlist = "";
	    	System.out.print("How many different types of medications do you have? (Enter number): ");
	    	medCount = reader.nextInt();

	    	if(medCount != 0){

		    	for (int i = 1; i <= medCount; i++) {
		    		
		    		System.out.println("");
		    		System.out.print("List your medications (" + i + "): ");
		    		arlist = reader.next();
		    		medList.add(arlist);

		    	}
	    	}
	    	if(medCount == 0){
	    		medList.add("None");
	    	}

	    	FileWriter writer = new FileWriter(newPatient.getPath());
	    	String patientOutput = fullName + "'s Medical Information\n{\n";

	    	patientOutput += "Full Name:\n" + fullName + "\n" + "Doctor's Previously Seen:\n" + previousDoctors + "\n" + "Address:\n" + 
	    						address + ", " + city + " " + state + " " + zipCode + "\n" + 
	    						"Phone Number:\n" + phoneNumber + "\n" + "SSN:\n" + socialSecurity + "\n" + "Gender:\n" + gender + "\n" + 
	    							"Birthday:\n" + birthDate + "\n" + "Email:\n" + email + "\n" + "Emergency Contact:\n" + emergencyContactName + 
	    								"\n" + "Emergency Contact Number:\n" + emergencyPhoneNumber + "\n" + "Insurance Company Name:\n" + 
	    									insuranceCompanyName + "\n" + "Insurance ID:\n" + insuranceIDNumber + "\n" + "Insurance Group:\n" + 
	    										insuranceGroupNumber + "\n" + "Insurance Phone Number:\n" + insurancePhoneNumber;

			if(allergyCount != 0){
				patientOutput += "\nAllergies:\n";
		    	for(int i = 0; i < allergyList.size(); i++){

		    		if(i == 0)
		    			patientOutput += allergyList.get(i);
		    		else
		    			patientOutput += ", " + allergyList.get(i);
		    	}
	    	}

	    	if(medCount != 0){
				patientOutput += "\nMedications:\n";
		    	for(int i = 0; i < medList.size(); i++){

		    		if(i == 0)
		    			patientOutput += medList.get(i);
		    		else
		    			patientOutput += ", " + medList.get(i);
		    	}
	    	}

	    	patientOutput += "\n}";
            writer.write(patientOutput);
            writer.close();
	    }
	    catch(IOException e){
	    	e.printStackTrace();
	    }

    }

    public void homeDirectory(String dir)
    {
    	rootDir = dir;
    }
} 