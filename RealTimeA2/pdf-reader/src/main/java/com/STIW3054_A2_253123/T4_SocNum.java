package com.STIW3054_A2_253123;

import java.util.ArrayList;

public class T4_SocNum implements Runnable{
	
	ArrayList<String> socList;
	int socCount =0;
	
	public T4_SocNum(ArrayList<String> arr){
		socList = arr;
	}
	
	public void run() {
		for(int x=0;x<socList.size();x++) {
			if(socList.get(x).charAt(0)=='S' && socList.get(x).charAt(1)=='T' 
			   && socList.get(x).charAt(3)!='V' ) {
				socCount++;
			}
		}
		System.out.println("\nNumber of All Listed SOC Course");
		System.out.println("===============================");
		System.out.println("Total number of SOC course listed: "+ socCount);
	
	}
}
