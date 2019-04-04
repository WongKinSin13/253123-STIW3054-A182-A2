package com.STIW3054_A2_253123;

import java.util.ArrayList;
import java.util.Scanner;

public class T5_FindCourse implements Runnable{
	
	ArrayList<String> socList;

	Scanner scan = new Scanner(System.in);
	
	public T5_FindCourse(ArrayList<String> arr) {
	socList = arr;
	}

	public void run() {
		System.out.println("\nCourse Search Engine");
		System.out.println("====================");
		System.out.print("Example:\nEnter the course code to view details: STIW3054");
	
		for(int x=0;x<socList.size();x++) {
			if(socList.get(x).contains("STIW3054")) {
			System.out.println("\nResult of STIW3054\n"+ x + " " + socList.get(x));
		}
		}
		System.out.print("\nEnter the course code to view details: ");
		String targetCourse = scan.nextLine();
		int found = 0;
		for(int x=0;x<socList.size();x++) {
			if(socList.get(x).contains(targetCourse.toUpperCase())) {
			System.out.println("Result of "+ targetCourse.toUpperCase() +"\n"+ x + " " + socList.get(x));
			found = 1;
			break;
		}	
		}
		if(found==0) {
		System.out.println("Invalid code, result not found.");
		}
	}
}
