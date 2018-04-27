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

    	Boolean prevMeds = list.contains("Medications: ");

    	if(prevMeds == true){

    		index = list.indexOf("Medications: ") + 1;    	

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
    		list.remove(list.size()-1);
    		list.add("Medications: ");
    		list.add("");
    		index = list.indexOf("Medications: ") + 1;

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

    		list.add("\n}");
    		list.set(index, list.get(index) + arlist);
    		sendInfo.outputToFile(list);
    	}


    }
    /*public void currentMeds(ArrayList<String> patientInfo){
    	list = patientInfo;

    	Boolean prevMeds = list.contains("Medications: ");

    	if(prevMeds == true){

    		int i = list.indexOf("Medications: ")
    		System.out.println("Current Medications taken by Patient: " + list.get(i+1));
    	}
    }*/
} 