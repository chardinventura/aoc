package com.chardin.aoc.day2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Challenge1{

	public static int Resolver(List<String> entries){

		int counter = 0;

		for (int i = 0; i < entries.size(); i++){

			String[] passwordPolicy = entries.get(i).split(" ");

			int[] range = getRange(passwordPolicy[0]);
			String letter = passwordPolicy[1].split(":")[0];
			String password = passwordPolicy[2];

			int ocurrences = StringUtils.countMatches(password, letter);

			if (range[0] <= ocurrences && ocurrences <= range[1] )
				counter++;
		}
		return counter;
	}

	private static int[] getRange(String entry){

		String[] numbers = entry.split("-");

		return new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])};
	}
}
