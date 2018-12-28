package fr.feavy.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

	public static int currentLine;
	public static Color[] goodCombination;
	public static boolean terminated = false;
	
	private static List<Color> colors = new ArrayList<>();
	
	public static void initialize() {
		currentLine = 0;
		goodCombination = new Color[4];
		colors = new ArrayList<Color>(Arrays.asList(Color.values()));
		colors.remove(0);
		Random r = new Random();
		for(int i = 0; i < 4; i++) {
			goodCombination[i] = colors.get(r.nextInt(colors.size()));
			colors.remove(goodCombination[i]);
			System.out.println(goodCombination[i]);
		}
	}
	
	public static Integer[] getColorIndexes(Color c) {
		List<Integer> indexes = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++)
			if(goodCombination[i] == c)
				indexes.add(i);
		return indexes.toArray(new Integer[indexes.size()]);
	}
	
}
