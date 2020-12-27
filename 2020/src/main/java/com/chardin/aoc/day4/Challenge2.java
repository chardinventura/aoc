package com.chardin.aoc.day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge2{

	public static int Resolver(List<String> entries){

		int validPassports = 0;

		Map<String, String> passports = new HashMap<>();

		for (int i = 0; i < entries.size(); i++){

			if (!entries.get(i).isBlank()) {

				if (entries.get(i).contains(" ")){
					if(!addFields(passports, entries.get(i).split(" ")))
						continue;
				}
				else
					if(!addFields(passports, entries.get(i)))
						continue;
			}

			if(entries.get(i).isBlank() || (i == entries.size() - 1)){

				if (passports.size() == 8)
					validPassports++;
				else if (passports.size() == 7 && !passports.containsKey("cid"))
					validPassports++;

				passports.clear();
			}
		}
		return validPassports;
	}

	private static boolean addFields(Map<String, String> passports, String... fields){

		for (String string : fields) {

			String[] item = string.split(":");

			if(isValidField(item))
				passports.put(item[0], item[1]);
			else
				return false;
		}

		return false;
	}

	private static boolean isValidField(String[] field){

		switch(field[0]){
			case "byr":
				return isValidByr(field[1]);
			case "iyr":
				return isValidIyr(field[1]);
			case "eyr":
				return isValidEyr(field[1]);
			case "hgt":
				return isValidHgt(field[1]);
			case "hcl":
				return isValidHcl(field[1]);
			case "ecl":
				return isValidEcl(field[1]);
			case "pid":
				return isValidPid(field[1]);
			case "cid":
				return isValidCid(field[1]);
			default:
				return false;
		}
	}

	private static boolean isValidByr(String value){

		if (value.length() == 4)
			if (Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2002)
				return true;

		return false;
	}

	private static boolean isValidIyr(String value){

		if (value.length() == 4)
			if (Integer.parseInt(value) >= 2010 && Integer.parseInt(value) <= 2020)
				return true;

		return false;
	}

	private static boolean isValidEyr(String value){

		if (value.length() == 4)
			if (Integer.parseInt(value) >= 2020 && Integer.parseInt(value) <= 2030)
				return true;

		return false;
	}

	private static boolean isValidHgt(String value){

		if (value.matches(".*[cm|in]")){

			int number = Integer.parseInt(value.substring(0, value.length() - 2));

			if (value.matches(".*cm")){
				if (number >= 150 && number <= 193)
					return true;
			}
			else
				if (number >= 59 && number <= 76)
					return true;
		}

		return false;
	}

	private static boolean isValidHcl(String value){

		if (value.matches("#[0-9a-f]{6}"))
			return true;

		return false;
	}

	private static boolean isValidEcl(String value){

		for (String item : new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"})
			if(item.equals(value))
				return true;

		return false;
	}

	private static boolean isValidPid(String value){

		if (value.matches("[0-9]{9}"))
			return true;

		return false;
	}

	private static boolean isValidCid(String value){

		return true;
	}
}
