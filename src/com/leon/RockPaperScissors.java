package com.leon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RockPaperScissors {

	public static void main(String[] args) throws IOException {

		File inputDirectory = new File("C:/Users/leo/eclipse-workspace/rockpaperscissors/input/level2/");
		String outputDirectory = "C:/Users/leo/eclipse-workspace/rockpaperscissors/output/level2/";

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

							writeOutputValue(outputDirectory + "output2_" + i + ".out", fightingStylesArray);

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

		String[] firstLine = reader.readLine().split(" ");
		int numberOfTournaments = Integer.parseInt(firstLine[0]);

		String[] fightingStylesArray = new String[numberOfTournaments];

		for (int i = 0; i < numberOfTournaments; i++) {

			fightingStylesArray[i] = fightingStylesAfterTwoRounds(reader.readLine());
		}

		reader.close();
		return fightingStylesArray;
	}

	private static String fightingStylesAfterTwoRounds(String line) {

		int length = line.length();

		// while (line.length() > 2) {

		for (int j = 0; j < 2; j++) {

			String pairs = "";
			for (int i = 0; i < line.length(); i += 2) {
				pairs += calculateWinner(line.substring(i, Math.min(length, i + 2)));
			}
			line = pairs;
			// }

		}
		return line;
	}

	private static String calculateWinner(String fightingStyles) {

		Map<String, String> outcomes = new HashMap<>();
		outcomes.put("PR", "P");
		outcomes.put("RP", "P");
		outcomes.put("PP", "P");
		outcomes.put("SR", "R");
		outcomes.put("RS", "R");
		outcomes.put("RR", "R");
		outcomes.put("SP", "S");
		outcomes.put("PS", "S");
		outcomes.put("SS", "S");

		return outcomes.get(fightingStyles);
	}

	private static void writeOutputValue(String outputPath, String[] fightingStylesArray) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

		for (String fightingStyles : fightingStylesArray) {
			writer.write(fightingStyles);
			writer.newLine();
		}
		writer.close();
	}
}
