package com.STIW3054_A2_253123;

import java.util.ArrayList;

public class T1_TotalCourse implements Runnable{
	
	int listedCourse;
	
	public T1_TotalCourse(ArrayList<String> arr){
		listedCourse = arr.size();
	}
	
	public void run() {
		System.out.println("Number of All Listed Course");
		System.out.println("===========================");
		System.out.println("Total number of course listed: "+ listedCourse);
	}
	
	
}
