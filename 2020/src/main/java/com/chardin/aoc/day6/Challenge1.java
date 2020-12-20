package com.chardin.aoc.day6;

import java.util.ArrayList;
import java.util.List;

public class Challenge1{

	public static int Resolver(List<String> entries){

		int totalQuestions = 0;

		List<Character> groupQuestions = new ArrayList<>();

		for (int i = 0; i < entries.size(); i++){

			if (!entries.get(i).isBlank())
				addQuestions(groupQuestions, entries.get(i));

			if (entries.get(i).isBlank() ^ (i == entries.size() - 1)) {

				totalQuestions += groupQuestions.size();
				groupQuestions.clear();
			}
		}

		return totalQuestions;
	}

	private static void addQuestions(List<Character> groupQuestionsquestions, String questions){

		for (int i = 0; i < questions.length(); i++)
			if (!groupQuestionsquestions.contains(questions.charAt(i)))
				groupQuestionsquestions.add(questions.charAt(i));
	}
}
