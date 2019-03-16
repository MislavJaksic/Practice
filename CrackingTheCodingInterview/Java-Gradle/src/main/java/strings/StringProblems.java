package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringProblems {
	public static boolean IsUnique(String input) {
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		char character;
		for (int i = 0; i < input.length(); i++) {
			character = input.charAt(i);

			if (chars.get(character) != null) {
				return false;
			} else {
				chars.put(character, 1);
			}
		}
		return true;
	}

	public static boolean IsPermutation(String one, String two) {
		if (one.length() != two.length()) {
			return false;
		}

		Map<Character, Integer> map = StringProblems.CountCharacters(one);

		char character;
		Integer number;
		for (int i = 0; i < two.length(); i++) {
			character = two.charAt(i);
			number = map.get(character);

			if (number == null) {
				return false;
			} else if (number > 1) {
				map.put(character, number - 1);
			} else {
				map.remove(character);
			}
		}

		if (map.size() > 0) {
			return false;
		}

		return true;
	}

	public static char[] URLify(char[] string, int true_length) {
		int i = true_length - 1;
		int j = string.length - 1;
		while (j > i) {
			if (string[i] != ' ') {
				string[j] = string[i];
				j--;
				i--;
			} else {
				string[j - 2] = '%';
				string[j - 1] = '2';
				string[j] = '0';
				j = j - 3;
				i--;
			}
		}

		return string;
	}

	public static boolean PalindromePermutation(String input) {
		Map<Character, Integer> map = StringProblems.CountCharacters(input);

		Set<Character> chars = map.keySet();
		int odd = 0;
		for (char character : chars) {
			if (map.get(character) % 2 != 0) {
				odd++;
				if (odd > 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean OneAway(String source, String target) {
		int diff = source.length() - target.length();
		if (diff > 1 || diff < -1) {
			return false;
		} else if (diff > 0) {
			String sentinel = source;
			source = target;
			target = sentinel;
		}
		
		int i = 0;
		int j = 0;
		int count = 0;
		char source_char;
		char target_char;
		while (i < target.length() && j < source.length()) {
			target_char = target.charAt(i);
			source_char = source.charAt(j);
			
			if (target_char != source_char) {
				count++;
				if (diff != 0) {
					j--;
				}
			}
			i++;j++;
		}
		
		if (count > 1) {
			return false;
		}
		
		return true;
	}
	
	public static String StringCompression(String uncompressed) {
		StringBuilder builder = new StringBuilder();
		
		char previous = uncompressed.charAt(0);
		char current;
		int count = 1;
		for (int i = 1; i < uncompressed.length(); i++) {
			current = uncompressed.charAt(i);
			if (current == previous) {
				count++;
			} else {
				builder.append(previous); builder.append(count);
				count = 1;
			}
			previous = current;
		}
		
		builder.append(previous); builder.append(count);
		
		String compressed = builder.toString();
		if (compressed.length() >= uncompressed.length()) {
			return uncompressed;
		}
		
		return compressed;
	}

	public static Map<Character, Integer> CountCharacters(String input) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char character;
		Integer number;
		for (int i = 0; i < input.length(); i++) {
			character = input.charAt(i);
			number = map.get(character);

			if (number != null) {
				map.put(character, number + 1);
			} else {
				map.put(character, 1);
			}
		}

		return map;
	}
}
