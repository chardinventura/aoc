package com.chardin.aoc.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Challenge1{

	public static int Resolver(List<String> entries){

		int highestId = 0;

		for (int i = 0; i < entries.size(); i++){

			int row = getRow(entries.get(i).substring(0, 7));
			int column = getColumn(entries.get(i).substring(7, 10));

			highestId = Integer.max(highestId, row * 8 + column);
		}
		return highestId;
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

/*  Solution like binary
	private static byte getRow(String seat){

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < seat.length(); i++) {

			if (seat.charAt(i) == 'F')
				stringBuilder.append('0');
			else
				stringBuilder.append('1');
		}

		return Byte.parseByte(stringBuilder.toString(), 2);
	}

	private static byte getColumn(String seat){

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < seat.length(); i++) {

			if (seat.charAt(i) == 'L')
				stringBuilder.append('0');
			else
				stringBuilder.append('1');
		}

		return Byte.parseByte(stringBuilder.toString(), 2);
	}*/
}
