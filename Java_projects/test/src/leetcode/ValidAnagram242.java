package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			if (map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
			} else {
				return false;
			}
		}
		Set<Character> keys = map.keySet();
		for (Character character : keys) {
			if (map.get(character) != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] container = new int[26];
		for (int i = 0; i < s.length(); i++) {
			container[s.charAt(i) - 'a']++;
			container[t.charAt(i) - 'a']--;
		}
		for (int i : container) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ValidAnagram242().isAnagram2("anagram", "nagaram"));
	}
}