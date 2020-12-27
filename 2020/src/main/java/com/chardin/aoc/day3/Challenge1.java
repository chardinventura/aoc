package com.chardin.aoc.day3;

import java.util.List;

public class Challenge1{

	public static int Resolver(List<String> entries){

		int trees = 0;

		int[] slope = {3, 1};
		int positionX = 0;

		for (int i = slope[1]; i < entries.size(); i+=slope[1]){

			positionX += slope[0];

			if (isTree(entries.get(i), positionX))
				trees++;

			if (entries.get(i).length() <= positionX + slope[0])
				positionX -= entries.get(i).length();
		}
		return trees;
	}

	private static boolean isTree(String entry, int positionX){

		return entry.charAt(positionX) == '#' ? true : false;
	}
}
