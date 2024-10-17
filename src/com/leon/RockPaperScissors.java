package com.leon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RockPaperScissors {

	public static void main(String[] args) throws IOException {

		File inputDirectory = new File("C:/Users/leo/eclipse-workspace/rockpaperscissors/input/level1/");
		String outputDirectory = "C:/Users/leo/eclipse-workspace/rockpaperscissors/output/level1/";

		// File inputDirectory = new File("C:/Users/leo/Desktop/level1r/");
		// String outputDirectory = "C:/Users/leo/Desktop/level1r/";

		if (inputDirectory.isDirectory()) {

			File[] files = inputDirectory.listFiles((dir, name) -> name.endsWith(".in"));

			if (files != null) {
				int i = 1;
				for (File file : files) {
					if (file.isFile()) {

						try {

							String[] fightingStylesArray = readInputFile(file.getPath());

							writeOutputValue(outputDirectory + "output1_" + i + ".out", fightingStylesArray);

						} catch (IOException e) {
							e.printStackTrace();
						}

					}
					i++;
				}
			}
		}

	}

	private static String[] readInputFile(String path) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));

		int length = Integer.parseInt(reader.readLine()), i = 0;

		String[] fightingStylesArray = new String[length];

		while (reader.ready()) {
			fightingStylesArray[i] = reader.readLine();
			i++;
		}

		return fightingStylesArray;
	}

	private static char[] calculateWinner(String[] fightingStylesArray) {

		int size = fightingStylesArray.length;
		char[] fightingStyleArray = new char[size];

		Map<String, Character> outcomes = new HashMap<>();
		outcomes.put("PR", 'P');
		outcomes.put("RP", 'P');
		outcomes.put("PP", 'P');
		outcomes.put("SR", 'R');
		outcomes.put("RS", 'R');
		outcomes.put("RR", 'R');
		outcomes.put("SP", 'S');
		outcomes.put("PS", 'S');
		outcomes.put("SS", 'S');

		for (int i = 0; i < size; i++) {
			String fightingStyles = fightingStylesArray[i];

			fightingStyleArray[i] = outcomes.get(fightingStyles);
		}
		return fightingStyleArray;
	}

	private static void writeOutputValue(String outputPath, String[] fightingStylesArray) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
		char[] fightingStyleArray = calculateWinner(fightingStylesArray);

		for (char fightingStyle : fightingStyleArray) {
			writer.write(fightingStyle);
			writer.newLine();
		}
		writer.close();
	}
}
