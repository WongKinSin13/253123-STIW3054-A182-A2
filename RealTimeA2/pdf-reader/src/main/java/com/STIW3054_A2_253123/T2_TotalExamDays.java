package com.STIW3054_A2_253123;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;

public class T2_TotalExamDays implements Runnable{
	
	ArrayList<Date> exmDates;
	long days;
	
	public T2_TotalExamDays(ArrayList<Date> arr){
	exmDates = arr;
	}

	public void run() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		//sort from earliest to latest
		Collections.sort(exmDates);
		//formatting date objects in list
		for(Date d:exmDates) {
			sdf.format(d);
		}
		
		System.out.println("\nExam Duration(Days)");
		System.out.println("===================");
		System.out.println("The first day of exam is "+ sdf.format(exmDates.get(0)));
		System.out.println("The final day of exam is "+ sdf.format(exmDates.get(exmDates.size()-1)));
		
		//difference of first and last day
		days = ( exmDates.get(0).getTime()-exmDates.get(exmDates.size()-1).getTime() )/86400000;
		System.out.println("The exam will last for "+ Math.abs(days) + " days.");

	}
}
