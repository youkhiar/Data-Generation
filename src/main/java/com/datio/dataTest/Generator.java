package com.datio.dataTest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.RandomStringUtils;

public class Generator {

	private final static String[] boolStr = { "true", "false" };

	static String generateData(String type, String size, String[] posibilities) {

		if (posibilities != null)
			return pickFromAList(posibilities);

		String item = "";
		switch (type) {
		case Types.ALPHA_NUMERIC:
			item = generateAlphaNumeric(Integer.parseInt(size));
			break;

		case Types.ALPHABETIC:
			item = generateAlphabet(Integer.parseInt(size));
			break;

		case Types.BOOLEAN:
			item = generateBoolean();
			break;

		case Types.DECIMAL:
			item = generateDecimal();
			break;

		case Types.NUMERIC:
			item = generateNumeric(Integer.parseInt(size));
			break;

		default:
			System.err.println("Type " + type + " not supported");
			break;
		}
		return item;
	}

	private static String pickFromAList(String[] posibilities) {
		return posibilities[(int) (Math.random() * posibilities.length)];
	}

	private static String generateAlphabet(int size) {
		return RandomStringUtils.randomAlphabetic(size);
	}

	private static String generateAlphaNumeric(int size) {
		return RandomStringUtils.randomAlphanumeric(size);
	}

	private static String generateBoolean() {
		return boolStr[(int) (Math.random() * boolStr.length)];
		// return "true";
	}

	private static String generateNumeric(int size) {
		return String.valueOf(RandomStringUtils.randomNumeric(size));
	}

	private static String generateDecimal() {
		int minimum = 1;
		int maximum = 999999;
		Double val = minimum + (Math.random() * ((maximum - minimum) + 1));
		NumberFormat formatter = new DecimalFormat("#0.00");
		String valPrecision2 = formatter.format(val);
		return valPrecision2;
	}
}
