package com.datio.dataTest;

import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.List;


public class Runner {	
	
   public static void main(String [] args)
   {
	   long startTime = System.currentTimeMillis();
  
       if (args.length != 4) {
           System.err.println("Not the args expected! Try with: genData pathInput pathOutput numFiles linesPerFiles");
       }
       else{    	   
    	   System.out.println("..Starting");
    	   
    	   String pathInput = args[0];
    	   String pathOutput = args[1];
    	   int numFiles = 0, linesPerFile = 0;    	   
    	   try {
				numFiles = Integer.valueOf(args[2]);
				linesPerFile = Integer.valueOf(args[3]);
				generateData(pathInput, pathOutput, numFiles, linesPerFile);       	   	      
		    	printDuration(startTime, pathOutput);
    	   } catch (NumberFormatException e) {			
				System.err.println("numFiles and numLinesPerFile should be int");
    	   }       	       	   
       }	  	   
   }


   private static void printDuration(long startTime, String pathOutput) {
	   
	   long stopTime = System.currentTimeMillis();
	   long elapsedTime = stopTime - startTime;
	   
	   String duration;
	   
	   if (elapsedTime > 60000) { // bigger than a min
		   int min = (int) (elapsedTime / (1000 * 60)) % 60;
		   duration = min +"min " + (elapsedTime / 1000) % 60 + "s";
	   }
	   else if (elapsedTime > 1000) // bigger than a sec
		   duration = elapsedTime/1000 + "s";		   
	   else
		   duration = elapsedTime + "ms";
		   
	   System.out.println("..Completed in "+duration);
	   System.out.println("..Check generated files on: "+pathOutput);
	}   
   
   
   private static void generateData(String inputFilePath, String outputDirectory, int numFiles, int linesPerFile) {

	   List<Field> list = DataIO.readFields(inputFilePath);
		List<String> itemsLine = new LinkedList<>();		
		BufferedWriter writer;
		
		for (int indexOutput = 1; indexOutput <= numFiles; indexOutput++) {
			writer = DataIO.createAWriter(outputDirectory, indexOutput);
			for (int line = 0; line < linesPerFile; line++) {
				
				for (Field field : list) {
					generateAndAddData(itemsLine, field);
				}							
				DataIO.writeLine(String.join(";", itemsLine), writer); //csvline = String.join(";", itemsLine);	
				itemsLine.clear();
			}		
			DataIO.closeWriter(writer);
			System.out.println("..");	   
		}
	}			
	
	
	private static void generateAndAddData(List<String> itemsLine, Field field) {
		String item = Generator.generateData(field.getType(), field.getLength(), field.getValues());
		itemsLine.add(item);
	}
	
}