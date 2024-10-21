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

		File inputDirectory = new File("C:/Users/leo/eclipse-workspace/rockpaperscissors/input/level3/");
		String outputDirectory = "C:/Users/leo/eclipse-workspace/rockpaperscissors/output/level3/";

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

							writeOutputValue(outputDirectory + "output3_" + i + ".out", fightingStylesArray);

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

			fightingStylesArray[i] = generateChain(reader.readLine());
		}

		reader.close();
		return fightingStylesArray;
	}

	private static String generateChain(String input) {
		int rCount = 0, pCount = 0, sCount = 0;

		String[] parts = input.split(" ");
		for (String part : parts) {
			int count = Integer.parseInt(part.substring(0, part.length() - 1));
			char type = part.charAt(part.length() - 1);
			if (type == 'R') {
				rCount = count;
			} else if (type == 'P') {
				pCount = count;
			} else if (type == 'S') {
				sCount = count;
			}
		}

		// create initial path
		StringBuilder chain = new StringBuilder();

		
	/*	while(rCount > 0) {
			chain.append("R");
			// Every R must be followed by a P to be eliminated.
			if (pCount > 0 && chain.toString().contains("RR")) {
				chain.append("P");
				pCount--;
			}*/
			
			 /*
				 * else if (sCount > 0) { chain.append("S"); sCount--; }
		
				 *
				 */
			
			//rCount--;
		//}
		
		
		// Construire le motif "RRPR"
	    while (rCount > 2 && pCount >= 1) {
	        chain.append("RRPR");
	        rCount -= 3;
	        pCount -= 1;
	    }

	    // Optionnel : ajouter les R restants s'il y en a
	    for (int i = 0; i < rCount; i++) {
	        chain.append("R");
	    }
	//	if (rCount % pCount == 0) {
		
		/*	for (int i = 0; i < rCount; i++) {
				chain.append("R");
				// Every R must be followed by a P to be eliminated.
				if (pCount > 0 && pCount >= rCount) {
					chain.append("P");
					pCount--;
				}*/
				 /*
					 * else if (sCount > 0) { chain.append("S"); sCount--; }
			
					 *
					 */
				
				//rCount--;
			//}
		//}
		// To ensure that there is no R in the second round,
		// we must ensure that all R are against P and S.
		/*for (int i = 0; i < rCount; i++) {
			chain.append("R");
			// Every R must be followed by a P to be eliminated.
			if (pCount > 0) {
				chain.append("P");
				pCount--;
			} 

		}*/

		// Add the rest of the P and S.
		for (int i = 0; i < pCount; i++) {
			chain.append("P");
			if (sCount > 0) {
				chain.append("S");
				sCount--;
			}
		}
		for (int i = 0; i < sCount; i++) {
			chain.append("S");
		}

		return chain.toString();
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
