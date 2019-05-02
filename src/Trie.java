import java.util.HashMap;
import java.util.Map;


public class Trie {

	class TrieNode {
		Map<Character, TrieNode> entries;
		int count;
		boolean endOfWord;

		public TrieNode() {
			entries = new HashMap<>();
			endOfWord = false;
		}
	}

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}
	
	public  void insert(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.entries.get(ch);
			if(node == null) {
				node = new TrieNode();
				current.entries.put(ch, node);
			}
			current.count++;
			current = node;
		}
		current.count++;
		current.endOfWord = true;
	}

	public boolean searchFullWord(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.entries.get(ch);
			if(node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}
	
	public int searchPartial(String part) {
		TrieNode current = root;
		for(int i=0; i<part.length(); i++) {
			char ch = part.charAt(i);
			TrieNode node = current.entries.get(ch);
			if(node == null) {
				return 0;
			}
			current = node;
		}
		return current.count;
	}
	
	public void delete(String word) {
		
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hackerrank1");
		trie.insert("hackerrank");
		System.out.println("Partial Search: " + trie.searchPartial("hackerrank"));
		System.out.println("Partial Search: " + trie.searchPartial("hackerrank1"));
		System.out.println("Search for word abdc: " + trie.searchFullWord("abcd"));
		System.out.println("Search for word abcd: " + trie.searchFullWord("abdc"));
	}
}
