package com.chardin.aoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.chardin.aoc.day1.Challenge2;

public class Main{

	public static void main(String[] args) throws IOException{

		List<String> entries = Files.readAllLines(new File("src/main/resources/input1.txt").toPath());

		System.out.println(Challenge2.Resolver(entries));
	}
}
