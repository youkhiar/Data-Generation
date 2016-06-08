package com.datio.dataTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class DataIO {
	
	
	static void closeWriter(BufferedWriter writer) {
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}
	
	static List<Field> readFields(String inputFilePath) {
		String jsonString = readFile(inputFilePath);		
		List<Field> list = objectifyTypesOfFields(jsonString);
		return list;
	}
	
	private static List<Field> objectifyTypesOfFields(String jsonString) {
		List<Field> list = null;		
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = mapper.readValue(jsonString, new TypeReference<List<Field>>(){});
		} 
		catch (Exception e) {
			// TODO Distinguish between different exceptions
			e.printStackTrace();
		}
		return list;
	}
	
	static void writeLine(String csvline, BufferedWriter writer) {
		try {
			writer.append(csvline);
			writer.append('\n');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	static BufferedWriter createAWriter(String outputDirectory, int indexOutput) {
		BufferedWriter writer = null;		
		try {
			writer = new BufferedWriter(new FileWriter(outputDirectory+"/"+"output_"+indexOutput+".csv"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return writer;
	}	
   
	static String readFile(String path) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		   Charset encoding = Charset.defaultCharset();
		   return new String(encoded, encoding);
	}
	

}
