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

    
    public void welcomeScreen()
    {
  
    	try
    	{
	    	ArrayList<String> allergyList = new ArrayList<String>();
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

	    	FileWriter writer = new FileWriter(newPatient.getPath());
	    	String patientOutput = "Information\n{\n";

	    	patientOutput += fullName + "\n" + address + ", " + city + " " + state + " " + zipCode + "\n" + 
	    						phoneNumber + "\n" + socialSecurity + "\n" + gender + "\n" + birthDate + "\n" + 
	    							email + "\n" + emergencyContactName + "\n" + emergencyPhoneNumber + "\n" + 
	    								insuranceCompanyName + "\n" + insuranceIDNumber + "\n" + insuranceGroupNumber + "\n" + 
	    									insurancePhoneNumber;

			if(allergyCount != 0){
				patientOutput += "\nAllergies: ";
		    	for(int i = 0; i < allergyList.size(); i++){

		    		if(i == (allergyList.size() - 1))
		    			patientOutput += allergyList.get(i) + ".";
		    		else
		    			patientOutput += allergyList.get(i) + ", ";
		    	}
	    	}

	    	patientOutput += "\n}\n";
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