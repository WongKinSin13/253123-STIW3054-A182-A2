package com.STIW3054_A2_253123;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.text.PDFTextStripper;

public class PDF_Reader{

	public static void main(String args[]) throws IOException, InterruptedException, ParseException {
		   
		Table_Extractor extractor1 = new Table_Extractor();
		
	      //Loading an existing document 
	      File file = new File("A2.pdf"); 
	      PDDocument document = PDDocument.load(file);    
	      PDFTextStripper pdf1 = new PDFTextStripper();
	      
	      System.out.println("PDF loaded.\n"); 
	      
	      try {
	          String pdfTexts = pdf1.getText(document);
	          //save code in courseCode
	          ArrayList<String> courseCode = extractor1.courseCode("([A-Z]{2,4}[0-9]{2,4})", pdfTexts);
	          
	          //save code, name, date, time in courseDetails
	          ArrayList<String> courseDetails
	          = extractor1.courseDetails("(([A-Z]{2,4}[0-9]{2,4}) (\\w{1,20})?( |-|, )?(\\w{1,20})( |-)?(\\w{1,20})"
	          		+ "( |-)?(\\w{1,20})?( |-|/)?(\\w{1,20})?( |-|/)?(\\w{1,20})( |-|/)?(\\w{1,20})?( |-|/|:)?"
	          		+ "(\\w{1,20})?( |-|/|:)?(\\w{1,20})( |-|/|:)?(\\w{1,20})( |-|/|:)?)", pdfTexts);
	          
	          //Thread1
	          Thread t1 = new Thread(new T1_TotalCourse(courseCode));
	          t1.start(); 
	          t1.join();
	          Thread.sleep(2000);
	          
	          //Thread2
	          ArrayList<Date> dateTime = extractor1.dateTime("([0-9]+/+[0-9]+/+[0-9]{2,4})", pdfTexts);
	          Thread t2 = new Thread(new T2_TotalExamDays(dateTime));
	          t2.start();
	          t2.join();
	          Thread.sleep(2000);
	          
	          //Thread4
	          Thread t4 = new Thread(new T4_SocNum(courseCode));
	          t4.start();
	          t4.join();
	          Thread.sleep(2000);
	          
	          //Thread3
	          Thread t3 = new Thread(new T3_SocList(courseDetails));
	          t3.start();
	          t3.join();
	          Thread.sleep(2000);
	          
	          //Thread5
	          Thread t5 = new Thread(new T5_FindCourse(courseDetails));
	          t5.start();
	          t5.join();
	          Thread.sleep(2000);
         
	      }
	      catch(FileNotFoundException ex) {
	          System.out.println(
	              "Unable to open file '" + 
	              file + "'");                
	      }
	      catch(IOException ex) {
	          System.out.println(
	              "Error reading file '" 
	              + file + "'");                  
	      }	
	      document.close();   
	   }  

}
