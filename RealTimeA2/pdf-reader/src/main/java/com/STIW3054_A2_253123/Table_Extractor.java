package com.STIW3054_A2_253123;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Table_Extractor extends PDF_Reader{
	
	public ArrayList<String> courseCode(String theRegex, String string2Check){
		ArrayList<String> courseCode = new ArrayList<String>();
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher( string2Check );
		
		while ( regexMatcher.find() ){
			if (regexMatcher.group().length() != 0){
				courseCode.add( regexMatcher.group().trim() );
			}
		}
		return(courseCode);
	}
	
	public ArrayList<String> courseDetails(String theRegex, String string2Check){
		ArrayList<String> courseDetails = new ArrayList<String>();
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher( string2Check );
		
		while ( regexMatcher.find() ){
			if (regexMatcher.group().length() != 0){
				courseDetails.add( regexMatcher.group().trim() );
			}
		}
		return(courseDetails);
	}
	
	public ArrayList<String> socList(String theRegex, String string2Check){
		ArrayList<String> socList = new ArrayList<String>();
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher( string2Check );
		
		while ( regexMatcher.find() ){
			if (regexMatcher.group().length() != 0){
				socList.add( regexMatcher.group().trim() );
			}
		}
		return(socList);
	}
	
	public ArrayList<Date> dateTime(String theRegex, String string2Check) throws ParseException{
		ArrayList<Date> date = new ArrayList<Date>();
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher( string2Check );
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		
		while ( regexMatcher.find() ){
			if (regexMatcher.group().length() != 0){
				date.add( formatter1.parse(regexMatcher.group().trim()) );
			}
		}
		return(date);
	}
	
}
