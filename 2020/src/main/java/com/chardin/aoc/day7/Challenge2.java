package com.chardin.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class Challenge2{

	private static final String BAG = "shiny gold";

	public static int Resolver(List<String> entries){

		Node root = new Node("root");

		formatEntries(entries);

		for (int i = 0; i < entries.size(); i++)
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

		List<Node> shinyGolds = new ArrayList<>(extractBag(sonsRoot));

		if(shinyGolds.isEmpty())
			return 0;

		extractSonsBags(sonsRoot, shinyGolds);

		expandNodes(shinyGolds);

		for (int i = shinyGolds.size() - 1; i > 0; i--) {

			Node remove = shinyGolds.get(i);

			shinyGolds.forEach(sg -> {

				sg.getSons().forEach(sgs -> {

					if(sgs.getData().equals(remove.getData()))
						sgs.setSons(remove.getSons());
				});
			});
		}

		int difference = shinyGolds.size();
		getNodes(shinyGolds.remove(0), shinyGolds);

		return shinyGolds.size() - difference;
	}

	private static List<Node> extractBag(List<Node> toExtract){

		List<Node> toAdd = new ArrayList<>();

		for (int i = 0; i < toExtract.size(); i++) {

			if(toExtract.get(i).getData().contains(BAG)){
			   	toAdd.add(toExtract.remove(i));
				break;
			}
		}

		return toAdd;
	}

	private static void extractSonsBags(List<Node> toExtract, List<Node> toAdd){

		while (toExtract.stream().anyMatch(te ->
					toAdd.stream().anyMatch(ta ->
						ta.getSons().stream().anyMatch(tas ->
							tas.getData().contains(te.getData()))))) {

			toExtract.forEach(to -> {

				if(toAdd.stream().anyMatch(ta -> ta.getSons().stream().anyMatch(tas -> tas.getData().contains(to.getData()))))
					toAdd.add(to);
			});

			toAdd.forEach(ta -> toExtract.remove(ta));
		}
	}

	private static void expandNodes(List<Node> nodes){

		nodes.forEach(n -> {

			List<Node> expandedNodes = new ArrayList<>();

			n.getSons().forEach(ns -> {

				String[] splitData = ns.getData().split(" ");

				for (int i = 0; i < Integer.parseInt(splitData[0]); i++)
					expandedNodes.add(new Node(splitData[1].concat(" ").concat(splitData[2])));
			});

			n.setSons(expandedNodes);
		});

	}

	public static void getNodes(Node node, List<Node> nodes){

		getNodes(node, nodes, 0);
	}

	public static void getNodes(Node node, List<Node> nodes, int tabs){

		nodes.add(node);
		System.out.println("\t".repeat(tabs).concat(node.getData()));

		for (Node son : node.getSons())
			getNodes(son, nodes, tabs + 1);
	}
}
