package com.chardin.aoc.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Challenge2{

	public static int Resolver(List<String> entries){

		List<Integer> seats = new ArrayList<>();

		for (int i = 0; i < entries.size(); i++){

			int row = getRow(entries.get(i).substring(0, 7));
			int column = getColumn(entries.get(i).substring(7, 10));

			seats.add(row * 8 + column);
		}

		return findIdOfMySeat(seats);
	}

	private static int getRow(String seat){

		List<Integer> rows = new ArrayList<>(128);
		IntStream.range(0, 128).forEach(rows::add);

		for (int i = 0; i < seat.length(); i++) {

			if (seat.charAt(i) == 'F')
				rows.removeIf(r -> rows.indexOf(r) >= (rows.size() / 2));
			else
				rows.removeIf(r -> rows.indexOf(r) < (rows.size() / 2));
		}

		return rows.get(0);
	}

	private static int getColumn(String seat){

		List<Integer> rows = new ArrayList<>(8);
		IntStream.range(0, 8).forEach(rows::add);

		for (int i = 0; i < seat.length(); i++) {

			if (seat.charAt(i) == 'L')
				rows.removeIf(r -> rows.indexOf(r) >= (rows.size() / 2));
			else
				rows.removeIf(r -> rows.indexOf(r) < (rows.size() / 2));
		}

		return rows.get(0);
	}

	private static int findIdOfMySeat(List<Integer> seats){

		for (int i = 0; i < seats.size(); i++)
			if (!seats.contains(seats.get(i) + 1) && seats.contains(seats.get(i) + 2))
				return seats.get(i) + 1;

		return -1;
	}
}
