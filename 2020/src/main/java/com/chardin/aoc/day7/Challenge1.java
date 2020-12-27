package com.chardin.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class Challenge1{

	private static final String BAG = "shiny gold";

	public static int Resolver(List<String> entries){

		Node root = new Node("root");

		formatEntries(entries);

		for (int i = 0; i < entries.size(); i++)
			if(entries.get(i).contains(","))
				root.getSons().add(createBag(entries.get(i)));

		return countShinyGolds(root);
	}

	private static void formatEntries(List<String> entries){

		for (int i = 0; i < entries.size(); i++) {

			StringBuilder stringBuilder = new StringBuilder(); ;

			String[] commas = entries.get(i).replaceAll("(bags|bag)|(contain no other)|\\.", "").replace("contain", ",").split(",");

			for (int j = 0; j < commas.length; j++){

				stringBuilder.append(commas[j].trim());

				if(j != commas.length - 1)
					stringBuilder.append(',');
			}

			entries.set(i, stringBuilder.toString());
		}
	}

	private static Node createBag(String entry){

		String[] bags = entry.split(",");

		Node bag = new Node(bags[0]);

		for (int i = 1; i < bags.length; i++)
			bag.getSons().add(new Node(bags[i]));

		return bag;
	}

	private static int countShinyGolds(Node root){

		List<Node> sonsRoot = root.getSons();

		List<Node> shinyGolds = new ArrayList<>();

		for (int i = 0; i < sonsRoot.size(); i++) {

			if(sonsRoot.get(i).getData().equals(BAG)){
			   	shinyGolds.add(sonsRoot.remove(i));
				break;
			}
		}

		do {
			sonsRoot.stream().forEach(sr -> {
				if (sr.getSons().stream().anyMatch(srs -> shinyGolds.stream().anyMatch(sg -> srs.getData().contains(sg.getData()))))
					shinyGolds.add(sr);
			});

			shinyGolds.forEach(sg -> sonsRoot.remove(sg));

		} while (sonsRoot.stream().anyMatch(sr ->
				sr.getSons().stream().anyMatch(srs ->
					shinyGolds.stream().anyMatch(sg ->
					   	srs.getData().contains(sg.getData())))));

		return shinyGolds.size() - 1;
	}
}
