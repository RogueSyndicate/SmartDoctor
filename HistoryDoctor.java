/*
    Group Number: 10
    Group Members: Robert Reilly, Hemil Patel, Dharmendra Sindha, Kiran Patel
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Class will handle doctor information such as which doctors the patient has seen before or what medication was prescribed to them previously and by which doctor.
public class HistoryDoctor {
	
	//Initialize objects and declare variables
	Scanner reader = new Scanner(System.in);
	ArrayList<String> list = new ArrayList<String>();
	String fullName;
	String phoneNumber;
	String gender;
	String email;
	String rootDir;
	String university;
	String study;
	String years;
	String languages;
	String specialties;
	String statement;

	//this method is called when a new doctor is accessing the system, this requires them to make a profile
    public void buildProfile()
    {
  
    	try
    	{
    		//This try will gather all personal information from the doctor for patients to view
	    	System.out.println("");
	    	System.out.println("Hello Doctor, here we will build your personal profile for patients/doctors to view");
	    	System.out.println("");
	    	System.out.print("What is your legal Full Name: ");
	    	fullName = reader.nextLine();

	    	File newDoctor = new File(rootDir, (fullName + ".txt"));

	    	if(newDoctor.exists())//if file exists then delete otherwise create
	    		newDoctor.delete();

	    	newDoctor.createNewFile();

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
	    	System.out.print("What is your work email: ");
	    	email = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is your work phone number (i.e. ###-###-####): ");
	    	phoneNumber = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is the most recent place of education you attended: ");
	    	university = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What is field of study you specialized or studied in at this location: ");
	    	study = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What years did you attend this higher education location: ");
	    	years = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What other languages do you speak besides English (Use commas to separate entries): ");
	    	languages = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("What field/skills do you specialize in (Use commas to separate entries): ");
	    	specialties = reader.nextLine();

	    	System.out.println("");
	    	System.out.print("Write a short professional statement (Use periods and hit enter when finished): ");
	    	statement = reader.nextLine();

	    	
	    	FileWriter writer = new FileWriter(newDoctor.getPath());
	    	String patientOutput = "Dr. " + fullName + "'s Doctoral Profile\n{\n";

	    	//Add all the personal info asked from doctor into a string with the correct format
	    	patientOutput += "Full Name:\n" + fullName + "\n" + "Gender:\n" + gender + "\n" + "Work Email:\n" + email + "\n" + 
	    						"Work Phone Number:\n"  + phoneNumber + "\n" + "Most Recent Higher Education Location:\n" + university +
	    							"\n" + "Field of Study:\n" + study + "\n" + "Years Attended:\n" + years + "\n" + "Languages spoken:\n" + 
	    								languages + "\n" + "Current specialties/skills:\n" + specialties + "\n" + "Professional Statement:\n" + 
	    									statement;

	    	patientOutput += "\n}";
            writer.write(patientOutput);//write all doctor info out to file
            writer.close();
	    }
	    catch(IOException e){
	    	e.printStackTrace();
	    }

    }

    //retrieves the doctors that a patient has previously visited
    public void pastDoctorsVisted(ArrayList<String> patientInfo)
    {
    	list = patientInfo;
    	Scanner reader = new Scanner(System.in);
    	Boolean prevMeds = list.contains("Doctor's Previously Seen:");

    	if(prevMeds == true){
    		int index = list.indexOf("Doctor's Previously Seen:") + 1;
    		System.out.println(list.get(index));
    	}
    	else
    		System.out.println("No previous doctors found");
    }
    //set the root directory for the SmartDoctor folder in this class to reference
    public void homeDirectory(String dir)
    {
    	rootDir = dir;
    }
} 