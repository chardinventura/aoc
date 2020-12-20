package com.chardin.aoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.chardin.aoc.day4.Challenge1;

public class Main{

	public static void main(String[] args) throws IOException{

		List<String> entries = Files.readAllLines(new File("src/main/resources/input4.txt").toPath());

		System.out.println(Challenge1.Resolver(entries));
	}
}
