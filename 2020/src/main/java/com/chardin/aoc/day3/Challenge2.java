package com.chardin.aoc.day3;

import java.util.List;

public class Challenge2{

	public static long Resolver(List<String> entries){

		long totalTrees = 1;

		int[][] slope = {
			{1, 1},
			{3, 1},
			{5, 1},
			{7, 1},
			{1, 2}
		};

		for (int i = 0; i < slope.length; i++) {

			int positionX = 0;
			int trees = 0;

			for (int j = slope[i][1]; j < entries.size(); j+=slope[i][1]){

				positionX += slope[i][0];

				if (isTree(entries.get(j), positionX))
					trees++;

				if (entries.get(j).length() <= positionX + slope[i][0])
					positionX -= entries.get(j).length();
			}
			totalTrees *= trees;
		}
		return totalTrees;
	}

	private static boolean isTree(String entry, int positionX){

		return entry.charAt(positionX) == '#' ? true : false;
	}
}
