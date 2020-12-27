package com.chardin.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class Node{

	private String data;
	private List<Node> sons;

	public Node(String data) {
		this.data = data;
		sons = new ArrayList<>();
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Node> getSons() {
		return sons;
	}
	public void setSons(List<Node> sons) {
		this.sons = sons;
	}
}
