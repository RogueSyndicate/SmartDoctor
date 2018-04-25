//PseudoCode
//Each line breaks indicates a distinction between different classes
    
//Main class will coordinate all other classes (PillDoctor, HistoryDoctor, WelcomeDoctor)
public class SmartDoctor {
    public static void main(String args[]) {
        /* 
        The main method will be used to coordinate all other classes. 
        Essentially using the other classes as a means to retrieve information and
        compile data for the command used by the doctor.
    	*/
    }

    private void doctorhub(){
    	/* If a doctor is accessing the program then this method will be invoked.
			
			The doctor will be given a list of commands that they will be able to use
			to find information regarding patients such as medication information, 
			previous doctor information, etc.

			Based on the command, it will go to the coressponding methods in their 
			respective classes.
    	*/
    }
} 

---------------------------------------------------------------------------------

//Class will handle welcoming/recognizing past patients
public class WelcomeDoctor {

	Declare necessary variables & objects

    
    public void welcomeScreen(){
  
  		// This method will welcome the user and check to see if the person is a patient or doctor

  		If patient is new then go to newPatientInfo() method

  		else if patient is existing then go to currentPatientInfo() method

  		else go to doctorhub() method in SmartDoctor Class

    }

    private void newPatientInfo(){
    	/* If a new patient is accessing the program then this method will be invoked.
			
			They will be asked for basic information like full name, 
			home address, phone number, ssn, gender, height, weight, 
			allergies, any medication previously prescribed.
    	*/
    }

    private void currentPatientInfo(){
    	/* If a existing patient is accessing the program then this method will be invoked.
			
			They will be asked to check their existing information and update it if needed like full name, 
			home address, phone number, ssn, gender, height, weight, 
			allergies, any medication previously prescribed.
    	*/
    }

    private void patientChangeLog(){
    	/* If patient information has changed then this method will confirm with the user
    	which changes are being updated as a form of validation before changes are made to 
    	the external file
    	*/
    	

    }
} 

---------------------------------------------------------------------------------
 
public class PillDoctor {

	Declare necessary variables & objects

    public static medicationRetreiever()) {
        /*
        	Class will retrieve information regarding medication and their details 
        	such as their primary effects, side effects, etc.
        */
    }

    public static medicationHandler()) {
        /*
        	Class will loop through medication to find information if specific one is being 
        	researched by a doctor.
        */
    }
} 

---------------------------------------------------------------------------------

public class HistoryDoctor {

	Declare necessary variables & objects

    public static historyRetriever()) {
        /*
        Class will handle doctor information such as which doctors the patient has seen before 
        or what medication was prescribed to them previously and by which doctor.
        */
    }
} 