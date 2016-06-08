package com.datio.dataTest;

public class Field {
	
	private String name;
	private String type;
	private String length = "";
	private String[] values;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	
	@Override
	public String toString() {
		
		return name + ";" + type + ";" + length;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}

}
