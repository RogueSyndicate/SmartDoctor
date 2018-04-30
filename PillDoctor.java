/*
    Group Number: 10
    Group Members: Robert Reilly, Hemil Patel, Dharmendra Sindha, Kiran Patel
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Class will handle and retrieve information regarding medication and allergies
public class PillDoctor {
	//Initialize objects and declare variables
	String rootDir;
	ArrayList<String> list = new ArrayList<String>();

	//set the root directory for the SmartDoctor folder in this class to reference
    public void homeDirectory(String dir){
    	rootDir = dir;
    }

    //When the doctor wants to add more medication to the patient's file this method will invoked
    public void prescribeMeds(ArrayList<String> patientInfo){
    	Scanner reader = new Scanner(System.in);
    	SmartDoctor sendInfo = new SmartDoctor();
    	list = patientInfo; //set patient info to list in this class for all methods to access
    	int index;
    	int medCount;
    	String arlist = "";

    	Boolean prevMeds = list.contains("Medications:"); //checks if medications exist

    	if(prevMeds == true){//if medications exist then add into the list

    		index = list.indexOf("Medications:") + 1;    	

	    	System.out.println("");
	    	System.out.print("How many new medications do you want to prescribe? (Enter number): ");
	    	medCount = reader.nextInt();

	    	if(medCount != 0){

		    	for (int i = 1; i <= medCount; i++) {
		    		
		    		System.out.println("");
	    			System.out.print("List the medication (" + i + ") you want to prescribe: ");
	    			arlist += (", " + reader.next());
	    		
		    	}
	    	}

	    	list.set(index, list.get(index) + arlist);
	    	sendInfo.outputToFile(list);
    	}
    	else{//if medications weren't specified then we will add a new section into the patient file to faciliatate that
    		if(list.indexOf("Allergies") != -1)
    			index = list.indexOf("Allergies:") + 2;
    		else
    			index = list.indexOf("Insurance Phone Number:") + 2;

    		list.add(index, "Medications:");

    		System.out.println("");
	    	System.out.print("How many new medications do you want to prescribe? (Enter number): ");
	    	medCount = reader.nextInt();

	    	if(medCount != 0){

		    	for (int i = 1; i <= medCount; i++) {
		    		
		    		if(i == 1){
			    		System.out.println("");
		    			System.out.print("List the medication (" + i + ") you want to prescribe: ");
		    			arlist += reader.next();
	    			}
	    			else{
			    		System.out.println("");
		    			System.out.print("List the medication (" + i + ") you want to prescribe: ");
		    			arlist += (", " + reader.next());
	    			}
		    	}
	    	}

    		list.add(index+1, arlist);
    		sendInfo.outputToFile(list);
    	}


    }
    //this method is called when patient or doctor want to view the current medications a patient is taking
    public void currentMeds(ArrayList<String> patientInfo){

    	list = patientInfo;

		int i = list.indexOf("Medications:");
		System.out.println("");
		System.out.println("Current Medications taken by Patient: " + list.get(i+1));
    	
    }
    //When the doctor wants to add more allergies to the patient's file this method will invoked
    public void addAllergies(ArrayList<String> patientInfo){
    	Scanner reader = new Scanner(System.in);
    	SmartDoctor sendInfo = new SmartDoctor();
    	list = patientInfo;//set patient info to list in this class for all methods to access
    	int index;
    	int allergyCount;
    	String arlist = "";

    	Boolean prevMeds = list.contains("Allergies:");//checks if Allergies exist

    	if(prevMeds == true){//if Allergies exist then add into the list

    		index = list.indexOf("Allergies:") + 1;    	

	    	System.out.println("");
	    	System.out.print("How many new Allergies do you want to add to patient file? (Enter number): ");
	    	allergyCount = reader.nextInt();

	    	if(allergyCount != 0){

		    	for (int i = 1; i <= allergyCount; i++) {
		    		
		    		System.out.println("");
	    			System.out.print("List the allergy (" + i + ") you want to add: ");
	    			arlist += (", " + reader.next());
	    		
		    	}
	    	}

	    	list.set(index, list.get(index) + arlist);
	    	sendInfo.outputToFile(list);
    	}
    	else{//if Allergies weren't specified then we will add a new section into the patient file to faciliatate that
    		index = list.indexOf("Insurance Phone Number:") + 2;
    		list.add(index, "Allergies:");

    		System.out.println("");
	    	System.out.print("How many new Allergies do you want to add to patient file? (Enter number): ");
	    	allergyCount = reader.nextInt();

	    	if(allergyCount != 0){

		    	for (int i = 1; i <= allergyCount; i++) {
		    		
		    		if(i == 1){
			    		System.out.println("");
		    			System.out.print("List the allergy (" + i + ") you want to add: ");
		    			arlist += reader.next();
	    			}
	    			else{
			    		System.out.println("");
		    			System.out.print("List the allergy (" + i + ") you want to add: ");
		    			arlist += (", " + reader.next());
	    			}
		    	}
	    	}

    		list.add(index+1, arlist);
    		sendInfo.outputToFile(list);
    	}


    }
    //this method is called when patient or doctor want to view the current Allergies a patient has
    public void currentAllergies(ArrayList<String> patientInfo){

    	list = patientInfo;

		int i = list.indexOf("Allergies:");
		System.out.println("");
		System.out.println("Current Allergies that Patient has: " + list.get(i+1));
    	
    }
} 