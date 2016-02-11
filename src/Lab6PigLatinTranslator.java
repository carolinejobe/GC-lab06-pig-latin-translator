import java.util.Scanner;

/**
 * @author Caroline
 *
 *         Task: Translate from English to Pig Latin
 *
 *         Application will: -prompt user for a word -translate the text to Pig
 *         Latin and displays it on the console. -ask the user if s/he wants to
 *         translate another word.
 *
 *         Build Specifications: 1.Convert each word to a lowercase before
 *         translating. 2.If a words starts with a vowel, just add "way" onto
 *         the ending. 3.If a word starts with a consonant, move all of the
 *         consonants that appear before the first vowel to the end of the word,
 *         then add "ay" to the end of the word.
 *
 *         Hints -treat "y" as a consonant. **unless it is only vowel-CHJ
 *         -Murach's Beginning Java, Chap 9
 */
public class Lab6PigLatinTranslator {

	static Scanner input = new Scanner(System.in);
	static String play;
	static String words;

	public static void main(String[] args) {

		System.out.println("Wecome to the Pig Latin Translator!");
		play = "y"; // initialize object to enter while loop

		while (play.equalsIgnoreCase("y")) {

			System.out.println("Enter word or sentence to be translated. ");
			String sentence1 = input.nextLine();
			sentence1 = sentence1.toLowerCase();
			String[] sentence1Split = sentence1.split(" ");
			
			
			//use for loop to translate each word (array element) until all are translated
			for (int k = 0; k < sentence1Split.length; k++) { 
				words = sentence1Split[k];

				int a = words.indexOf("a");
				int e = words.indexOf("e");
				int i = words.indexOf("i");
				int o = words.indexOf("o");
				int u = words.indexOf("u");
				int y = words.indexOf("y");

				int[] vowelIndex = { a, e, i, o, u };

				// if string starts with vowel, add "way" to end:
				if (a == 0 || e == 0 || i == 0 || o == 0 || u == 0) {
					System.out.print(words + "way" + " ");
				}

				// if string contains a vowel, excluding "y", and begins with a consonant, translate to pig latin:
				else if (a > 0 || e > 0 || i > 0 || o > 0 || u > 0) {
					consonantFirstTranslate(words, vowelIndex);
				}
				// if string's only vowel is "y," treat "y" as a vowel and translate to Pig Latin:
				else if (a < 0 && e < 0 && i < 0 && o < 0 && u < 0 && y>=0) {
					yOnlyVowelTranslate(words);
				}
				else {
					System.out.print(words + " ");
				}
			}
			continueOrQuit(input);
		}
		System.out.println("oodgay-yebay!");
	}

	private static void yOnlyVowelTranslate(String word1Lower) {
		int yIndex = word1Lower.indexOf("y");

		String substringNewStart = words.substring(yIndex);
		String substringNewMiddle = words.substring(0, yIndex);
		System.out.print(substringNewStart + substringNewMiddle + "ay"+ " ");
	}

	private static void consonantFirstTranslate(String word1Lower, int[] vowelIndex) {
		int min = 100000000;
		for (int x = 0; x < 5; x++) {
			if (vowelIndex[x] >= 1 && vowelIndex[x] < min)
				min = vowelIndex[x];
		}

		// Returns a new a substring that starts at a specified index
		String substringNewStart = words.substring(min);
		String substringNewMiddle = words.substring(0, min);
		System.out.print(substringNewStart + substringNewMiddle + "ay" + " ");
	}

	// prompt user to continue or not. initialized to "y"
	private static void continueOrQuit(Scanner input) {
		System.out.println("\nTranslate another line? (y/n)");
		play = input.nextLine();
	}

}
