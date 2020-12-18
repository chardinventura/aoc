package com.chardin.aoc.day2;

import java.util.List;

public class Challenge2{

	public static int Resolver(List<String> entries){

		int counter = 0;

		for (int i = 0; i < entries.size(); i++){

			String[] passwordPolicy = entries.get(i).split(" ");

			int[] policy = getPolicy(passwordPolicy[0]);
			char letter = passwordPolicy[1].split(":")[0].charAt(0);
			String password = passwordPolicy[2];

			if ((password.charAt(policy[0] - 1) == letter) ^ (password.charAt(policy[1] - 1) == letter))
				counter++;
		}
		return counter;
	}

	private static int[] getPolicy(String entry){

		String[] numbers = entry.split("-");

		return new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])};
	}
}
