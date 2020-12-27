package com.chardin.aoc.day1;

import java.util.List;

public class Challenge1{

	public static int Resolver(List<String> entries){

		for (int i = 0; i < entries.size(); i++){

			for (int j = 0; j < entries.size(); j++){

				int[] numbers = {Integer.parseInt(entries.get(i)), Integer.parseInt(entries.get(j))};

				if (numbers[0] + numbers[1] == 2020)
					return numbers[0] * numbers[1];
			}
		}
		return 0;
	}
}
