package com.STIW3054_A2_253123;

import java.util.ArrayList;

public class T3_SocList implements Runnable{

	ArrayList<String> socList;
	int socCourse =0;
	
	public T3_SocList(ArrayList<String> arr){	
		socList = arr;
	}
	
	public void run() {
	    System.out.println("\nSOC Course List");
	    System.out.println("===============");
		for(int x=0;x<socList.size();x++) {
			if(socList.get(x).charAt(0)=='S' && socList.get(x).charAt(1)=='T' 
			   && socList.get(x).charAt(3)!='V' ) {
				socCourse++;
				System.out.println(socList.get(x));
			}
		}
	}
}
