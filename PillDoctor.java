/*
    Group Number:
    Group Members: Hemil Patel, ....
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Class will handle and retrieve information regarding medication and their details such as their primary effects, side effects, etc.
public class PillDoctor {
	String rootDir;
	ArrayList<String> list = new ArrayList<String>();

    public void homeDirectory(String dir){
    	rootDir = dir;
    }

    public void prescribeMeds(ArrayList<String> patientInfo){
    	Scanner reader = new Scanner(System.in);
    	SmartDoctor sendInfo = new SmartDoctor();
    	list = patientInfo;
    	int index;
    	int medCount;
    	//ArrayList<String> temp = new ArrayList<String>();
    	String arlist = "";

    	Boolean prevMeds = list.contains("Medications:");

    	if(prevMeds == true){

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
    	else{
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
    public void currentMeds(ArrayList<String> patientInfo){

    	list = patientInfo;

		int i = list.indexOf("Medications:");
		System.out.println("");
		System.out.println("Current Medications taken by Patient: " + list.get(i+1));
    	
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addAllergies(ArrayList<String> patientInfo){
    	Scanner reader = new Scanner(System.in);
    	SmartDoctor sendInfo = new SmartDoctor();
    	list = patientInfo;
    	int index;
    	int allergyCount;
    	String arlist = "";

    	Boolean prevMeds = list.contains("Allergies:");

    	if(prevMeds == true){

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
    	else{
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
    public void currentAllergies(ArrayList<String> patientInfo){

    	list = patientInfo;

		int i = list.indexOf("Allergies:");
		System.out.println("");
		System.out.println("Current Allergies that Patient has: " + list.get(i+1));
    	
    }
} 