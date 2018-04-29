/*
    Group Number:
    Group Members: Hemil Patel, ....
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Main class will coordinate all other classes (PillDoctor, HistoryDoctor)
public class SmartDoctor {
	static String rootDir = "";
	static String patientType = "LOOP";
    static String patientName;
	static ArrayList<String> list = new ArrayList<String>();
	static Scanner reader = new Scanner(System.in);
	static Scanner reader2 = new Scanner(System.in);
	static String type;

    public static void main(String args[]) {
        WelcomeDoctor startHere = new WelcomeDoctor();
        PillDoctor medInfo = new PillDoctor();
        HistoryDoctor pastInfo = new HistoryDoctor();
        int doctorCommand = -1;
        String patientName = "Blank";

        File folder = new File(System.getProperty("user.home")); // results in /Users/Hemil

		//System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
		createDirectory(folder);

		startHere.homeDirectory(rootDir);
		medInfo.homeDirectory(rootDir);
		pastInfo.homeDirectory(rootDir);

    	System.out.println("Hello! Welcome to Smart Doctor!");

    	System.out.println("Are you a Doctor or Patient?");
    	type = reader.nextLine();
    	type = type.toLowerCase();
    	
    	if(type.equals("patient") || type.equals("p"))
    	{
	    	while(!patientType.equals("new") && !patientType.equals("existing") && !patientType.equals("n") && !patientType.equals("e")){
		    	System.out.println("Are you a New (N) or Existing (E) patient?");
		    	patientType = reader.nextLine();
		    	patientType = patientType.toLowerCase();
	    	}

	    	if(patientType.equals("new") || patientType.equals("n")){
	    		startHere.welcomeScreen();
	    	}
	    	if(patientType.equals("existing") || patientType.equals("e"))
	    	{
	    		retrievePatientInfo("P");
	    	}
    	}
    	else if (type.equals("doctor") || type.equals("d"))
    	{
    		System.out.println("Welcome to the Doctor's Hub");

    		while(true){
		    	System.out.println();
		    	System.out.println("1 - Pull up a specific Patient's Info");
		    	System.out.println("2 - Prescribe meds to patient (Pull up patient info first)");
		    	System.out.println("3 - View current medications for patient (Pull up patient info first)");
		    	System.out.print("Doctor commands (Pick a number from the list above or -1 to quit): ");
		    	doctorCommand = reader.nextInt();
	    	

		    	if(doctorCommand == 1){
		    		retrievePatientInfo("D");
		    	}
		    	else if(doctorCommand == 2){
		    		medInfo.prescribeMeds(list);
		    	}
		    	else if(doctorCommand == 3){
		    		medInfo.currentMeds(list);
		    	}
		    	else if(doctorCommand == -1){
		    		break;
		    	}
	    	}
    	}
    	else{
    		System.out.println();
			System.out.println("Sorry that is an invalid command. Goodbye :)");
    	}
    	//Prints a goodbye message and ends the program.
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

	public static void retrievePatientInfo(String type){
    	try{

    		System.out.println();
    		System.out.println("Enter patient's full name?");
    		patientName = reader2.nextLine();
    		Scanner fileReader = new Scanner(new File(rootDir, patientName + ".txt"));//Implement a check to make sure the patient file exists
    		list = new ArrayList<String>();
    		while(fileReader.hasNextLine()){
    			list.add(fileReader.nextLine());
    		}
    		fileReader.close();

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

    public static void outputToFile(ArrayList<String> newInfo){
    	
    	try{

	    	String fullName;
	    	list = newInfo;

	    	System.out.println("");
	    	System.out.print("Modification to Patient file detected! Please enter the legal Full Name for verification: ");
	    	reader.nextLine();
	    	fullName = reader.nextLine();

	    	File newPatient = new File(rootDir, (fullName + ".txt"));

	    	if(newPatient.exists())
	    		newPatient.delete();

	    	newPatient.createNewFile();

	    	FileWriter writer = new FileWriter(newPatient.getPath());

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
} 