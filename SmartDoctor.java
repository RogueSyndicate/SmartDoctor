/*
    Group Number: 10
    Group Members: Robert Reilly, Hemil Patel, Dharmendra Sindha, Kiran Patel
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Main class will coordinate all other classes (PillDoctor, HistoryDoctor) and is centralized
public class SmartDoctor {
	//Initialize objects and declare variables
	static String rootDir = "";
	static String patientType = "LOOP";
	static String doctorType = "LOOP";
    static String patientName;
    static String doctorName;
    static String reportFile;
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> list2 = new ArrayList<String>();
	static Scanner reader = new Scanner(System.in);
	static Scanner reader2 = new Scanner(System.in);
	static String type;

	//Main method for the entire project
    public static void main(String args[]) {
        WelcomeDoctor startHere = new WelcomeDoctor();
        PillDoctor medInfo = new PillDoctor();
        HistoryDoctor pastInfo = new HistoryDoctor();
        int doctorCommand = -1;
        int patientCommand = -1;
        String patientName = "Blank";

        //gets the base directory on the system you are using
        File folder = new File(System.getProperty("user.home")); // example results in /Users/Hemil when run locally
		createDirectory(folder);

		//send the root directory path to the other classes
		startHere.homeDirectory(rootDir);
		medInfo.homeDirectory(rootDir);
		pastInfo.homeDirectory(rootDir);

		//welcome message to the overall program
    	System.out.println("Hello! Welcome to Smart Doctor!");

    	//asks user what type of person they are
    	System.out.println("Are you a Doctor or Patient?");
    	type = reader.nextLine();
    	type = type.toLowerCase();
    	
    	//if they are a patient from the above statement then do the following
    	if(type.equals("patient") || type.equals("p"))
    	{
    		//once the patient menu is selected then it will keep asking if they are a new or existing patient in the system
	    	while(!patientType.equals("new") && !patientType.equals("existing") && !patientType.equals("n") && !patientType.equals("e")){
		    	System.out.println("Are you a New (N) or Existing (E) patient?");
		    	patientType = reader.nextLine();
		    	patientType = patientType.toLowerCase();
	    	}

	    	//If the patient is new to the program then go to WelcomeDoctor to create a patient profile
	    	if(patientType.equals("new") || patientType.equals("n")){
	    		startHere.welcomeScreen();
	    	}

	    	System.out.println();
			System.out.println("Welcome to the Patient's Hub"); //Once profile is build or already exists then patient hub of commands is visible

	    	while(true){
		    	System.out.println();
		    	System.out.println("1 - View your medical info");
		    	System.out.println("2 - See the previous doctor's you have seen");
		    	System.out.println("3 - View current medications");
		    	System.out.println("4 - View current allergies on file");
		    	System.out.print("Patient commands (Pick a number from the list above or -1 to quit): ");
		    	patientCommand = reader.nextInt();
	    	
		    	//invoke one of the following commands based on user input.
		    	if(patientCommand == 1){
		    		retrievePatientInfo("P");
		    	}
		    	else if(patientCommand == 2){
		    		pastInfo.pastDoctorsVisted(list);
		    	}
		    	else if(patientCommand == 3){
		    		retrievePatientInfo("D");
		    		medInfo.currentMeds(list);
		    	}
		    	else if(patientCommand == 4){
		    		retrievePatientInfo("D");
		    		medInfo.currentAllergies(list);
		    	}
		    	else if(patientCommand == -1){
		    		break;
		    	}
	    	}
    	}
    	//if they are a doctor from the previous question then do the following
    	else if (type.equals("doctor") || type.equals("d"))
    	{
    		System.out.println("Welcome to the Doctor's Hub"); //Welcomes user to doctor hub

			//once the doctor menu is selected then it will keep asking if they are a new or existing doctor in the system
    		while(!doctorType.equals("new") && !doctorType.equals("existing") && !doctorType.equals("n") && !doctorType.equals("e")){
		    	System.out.println("Are you a New (N) or Existing (E) doctor?");
		    	doctorType = reader.nextLine();
		    	doctorType = doctorType.toLowerCase();
	    	}

    		if(doctorType.equals("new") || doctorType.equals("n")){
	    		pastInfo.buildProfile();
	    		System.out.println();
		    	System.out.println("Now that your Doctor's profile has been saved, here are the commands available to you: ");
	    	}

    		while(true){
		    	System.out.println();
		    	System.out.println("1 - View a specific Patient's Info");
		    	System.out.println("2 - Prescribe meds to patient");
		    	System.out.println("3 - View current medications for patient");
		    	System.out.println("4 - Add new allergies to patient file");
		    	System.out.println("5 - View current allergies for patient");
		    	System.out.println("6 - View your medical profile");
		    	System.out.println("7 - Create report");
		    	System.out.print("Doctor commands (Pick a number from the list above or -1 to quit): ");
		    	doctorCommand = reader.nextInt();
	    	
		    	//invoke one of the following commands based on user input.
		    	if(doctorCommand == 1){
		    		retrievePatientInfo("P");
		    	}
		    	else if(doctorCommand == 2){
		    		retrievePatientInfo("D");
		    		medInfo.prescribeMeds(list);
		    	}
		    	else if(doctorCommand == 3){
		    		retrievePatientInfo("D");
		    		medInfo.currentMeds(list);
		    	}
		    	else if(doctorCommand == 4){
		    		retrievePatientInfo("D");
		    		medInfo.addAllergies(list);
		    	}
		    	else if(doctorCommand == 5){
		    		retrievePatientInfo("D");
		    		medInfo.currentAllergies(list);
		    	}
		    	else if(doctorCommand == 6){
		    		retrieveDoctorInfo();
		    	}
		    	else if(doctorCommand == 7){
		    		createReport();
		    	}
		    	else if(doctorCommand == -1){
		    		break;
		    	}
	    	}
    	}
    	//if user input is anything but patient or doctor then it will exit out of program with a goodbye message
    	else{
    		System.out.println();
			System.out.println("Sorry that is an invalid command. Goodbye :)");
    	}
    	//After program is done being used this prints a goodbye message and ends the program.
		System.out.println();
		System.out.println("HOPE YOU HAD A PRODUCTIVE TIME WITH SMARTDOCTOR :)");
    }

    //Creates a SmartDoctor directory on the desktop
    public static void createDirectory(File folder) {

		File dir = new File(new File(folder, "Desktop"), "SmartDoctor"); // results in /Users/Hemil/Desktop/SmartDoctor
		//System.out.println(dir);
		if (!dir.exists()){
			dir.mkdirs();
		}
		rootDir = dir.getPath();
	}

	//This method retrieves patient info from text files into a list
	public static void retrievePatientInfo(String type){
    	try{

    		System.out.println();
    		System.out.println("Enter patient's full name?");
    		patientName = reader2.nextLine();
    		Scanner fileReader = new Scanner(new File(rootDir, patientName + ".txt"));
    		list = new ArrayList<String>();
    		while(fileReader.hasNextLine()){
    			list.add(fileReader.nextLine());
    		}
    		fileReader.close();

    		//if it is a patient requesting to see their file then it will print their file, if its a doctor then it wont unless asked specifically.
    		if(type.equals("P"))
	    		for(int i = 0; i < list.size(); i++){

	    			System.out.println("");
		    		System.out.println(list.get(i));
			    }
    	}
	    catch(IOException e){
	    	e.printStackTrace();
	    }
    }

    //retrieves doctor's medical profile from text file and prints it to the console 
    public static void retrieveDoctorInfo(){
    	try{

    		System.out.println();
    		System.out.println("Enter doctor's full name?");
    		doctorName = reader2.nextLine();
    		Scanner fileReader = new Scanner(new File(rootDir, doctorName + ".txt"));
    		list = new ArrayList<String>();
    		while(fileReader.hasNextLine()){
    			list.add(fileReader.nextLine());
    		}
    		fileReader.close();

    		for(int i = 0; i < list.size(); i++){

    			System.out.println("");
	    		System.out.println(list.get(i));
			}
    	}
	    catch(IOException e){
	    	e.printStackTrace();
	    }
    }

    /*If information such as allergies or medications are added then this method is invoked, it verifies the user's name, once verified,
	they will be able to modify the text file
    */
    public static void outputToFile(ArrayList<String> newInfo){
    	
    	try{

	    	String fullName;
	    	list = newInfo;

	    	//verification step with name
	    	System.out.println("");
	    	System.out.print("Modification to Patient file detected! Please enter the legal Full Name for verification: ");
	    	reader.nextLine();
	    	fullName = reader.nextLine();

	    	File newPatient = new File(rootDir, (fullName + ".txt"));

	    	//since we are modifying it implies the file exists so we delete the old file and create new one
	    	if(newPatient.exists())
	    		newPatient.delete();

	    	newPatient.createNewFile();

	    	FileWriter writer = new FileWriter(newPatient.getPath());

	    	//transfers info from arraylist to new text file
	    	String tempRestructure = "";
	    	for(int count = 0; count < list.size(); count++){
	    		if(count == 0)
	    			tempRestructure += list.get(count);
	    		else
	    			tempRestructure += "\n" + list.get(count);
	    	}
	    	writer.write(tempRestructure);
			writer.close();
		}
		catch(IOException e){
	    	e.printStackTrace();
	    }
    }

    /* CreateReport method allows doctor to compile a html file with all of the patient files and data in one central file. 
    */
    public static void createReport(){
    	try{
    		System.out.println();
    		System.out.println("Enter file name?"); //specify file name for the report data
    		reportFile = reader2.nextLine();
    		Scanner fileReader = new Scanner(new File(rootDir, "template.html")); //gets initial template for the html file
    		list = new ArrayList<String>();
    		while(fileReader.hasNextLine()){
    			list.add(fileReader.nextLine());
    		}
    		fileReader.close();
    		File newReport = new File(rootDir, (reportFile + ".html")); //creates the new report file object
    		BufferedWriter writeToFile = new BufferedWriter(new FileWriter(newReport.getPath()));//object to write to file
    		if(newReport.exists())//if report exists with the current file name then delete and recreate
	    		newReport.delete();

	    	newReport.createNewFile();

	    	FileWriter writer = new FileWriter(newReport.getPath());

	    	//adds the template html code to the final html code output
	    	String htmlFile = "";
	    	for(int count = 0; count < list.size(); count++){
	    		if(count == 0)
	    			htmlFile += list.get(count);
	    		else
	    			htmlFile += "\n" + list.get(count);
	    	}
	    	System.out.println();

	    	//variables for ending html tags
			String endtable = "\n</table>";
			String endBody = "\n</body>";
			String endHTML = "\n</html>";
			String startRow = "<tr>";
			String startDef = "<td>";
			String endDef = "</td>";
			String endRow = "</tr>";

			File folder = new File(rootDir);
			File[] listOfFiles = folder.listFiles(); //gets the files in the SmartDoctor directory

			//runs through all the files, gets the info, checks if its a patient file
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].exists()) {

					String checker = "break";
		    		Scanner fileReader2 = new Scanner(new File(rootDir, listOfFiles[i].getName()));
		    		list2 = new ArrayList<String>();
		    		while(fileReader2.hasNextLine()){//get data from current chosen file in SmartDoctor directory
		    			list2.add(fileReader2.nextLine());
		    		}
		    		fileReader2.close();
		    		if(!list2.isEmpty()){//if the file is empty then skip to next file
		    			checker = list2.get(0);
		    		}
		    		if(!checker.contains("Information")){//checks if its a patient file, if its not then skip this loop iteration
		    			continue;
		    		}

		    		int tempIndex = -1;

		    		/*this body of code gets the information required from each file for the html output file and puts it into 
		    			table row or table definition
		    		*/
		    		htmlFile += "\n" + startRow;
		    		tempIndex = list2.indexOf("Full Name:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Address:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Phone Number:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("SSN:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Gender:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Birthday:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Email:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Allergies:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Medications:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Emergency Contact:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Emergency Contact Number:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Insurance Comapany Name:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Insurance ID:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Insurance Group:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;
		    		tempIndex = list2.indexOf("Insurance Phone Number:") + 1;
		    		htmlFile += "\n" + startDef + list2.get(tempIndex) + endDef;

		    		htmlFile += "\n" + endRow;
				}
				else
					System.out.println("Unknown File ");
			}

			htmlFile += endtable + endBody + endHTML; //add the closing table, body, html tags.
	    	writer.write(htmlFile);//write the html code out to file
			writer.close();
    	}
	    catch(IOException e){
	    	e.printStackTrace();
	    }
    }
} 