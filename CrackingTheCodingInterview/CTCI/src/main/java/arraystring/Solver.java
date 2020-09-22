package arraystring;

import java.util.HashMap;

public class Solver {
	public Boolean isUnique(String string) {
		if (string == null) {
			return true;
		}

		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();

		Character character;
		for (int i=0; i < string.length(); i++) {
			character = string.charAt(i);
			if (map.get(character) == null) {
				map.put(character, true);
			} else {
				return false;
			}
		}

		return true;
	}


}
