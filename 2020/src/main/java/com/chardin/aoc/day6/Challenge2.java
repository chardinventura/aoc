package com.chardin.aoc.day6;

import java.util.ArrayList;
import java.util.List;

public class Challenge2{

	public static int Resolver(List<String> entries){

		int totalQuestions = 0;

		List<Character> groupQuestions = new ArrayList<>();
		groupQuestions.add(' ');

		for (int i = 0; i < entries.size(); i++){

			if (!entries.get(i).isBlank() && !groupQuestions.isEmpty())
				addQuestions(groupQuestions, entries.get(i));
			else if (groupQuestions.isEmpty() && !entries.get(i).isBlank())
				continue;

			if (entries.get(i).isBlank() || (i == entries.size() - 1)) {

				totalQuestions += groupQuestions.size();

				groupQuestions.clear();
				groupQuestions.add(' ');
			}
		}

		return totalQuestions;
	}

	private static void addQuestions(List<Character> groupQuestions, String questions){

		if(groupQuestions.contains(' ')){

			groupQuestions.clear();

			for (int i = 0; i < questions.length(); i++)
				groupQuestions.add(questions.charAt(i));

				return;
		}

		groupQuestions.removeIf(q -> !questions.contains(q.toString()));
	}
}
