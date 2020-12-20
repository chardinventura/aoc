package com.chardin.aoc.day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge1{

	public static int Resolver(List<String> entries){

		int validPassports = 0;

		Map<String, String> passports = new HashMap<>();

		for (int i = 0; i < entries.size(); i++){

			if (!entries.get(i).isBlank()) {

				if (entries.get(i).contains(" "))
					addPassport(passports, entries.get(i).split(" "));
				else
					addPassport(passports, entries.get(i));
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

	private static void addPassport(Map<String, String> passports, String... fields){

		for (String string : fields) {

			String[] item = string.split(":");
			passports.put(item[0], item[1]);
		}
	}
}
