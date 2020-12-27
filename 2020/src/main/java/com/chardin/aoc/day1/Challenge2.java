package com.chardin.aoc.day1;

import java.util.List;

public class Challenge2{

	public static int Resolver(List<String> entries){

		for (int i = 0; i < entries.size(); i++){

			for (int j = 0; j < entries.size(); j++){

				for (int k = 0; k < entries.size(); k++) {

					int[] numbers = {Integer.parseInt(entries.get(i)), Integer.parseInt(entries.get(j)), Integer.parseInt(entries.get(k))};

					if (numbers[0] + numbers[1] + numbers[2] == 2020)
						return numbers[0] * numbers[1] * numbers[2];
				}
			}
		}
		return 0;
	}
}
