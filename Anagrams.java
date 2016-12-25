// Elizabeth Koshelev
// COSI 12B, Spring 2016
// Programming Assignment Extra Credit, 4/2/16
// This program returns a list of anagrams of a phrase.
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams {
	private Set<String> dictionary;
	private String phrasee;
	private ArrayList<String> anagramprint;
	private ArrayList<String> anagramlist;
	private LetterInventory word;
//The constructor initializes the fields
	public Anagrams(Set<String> dictionary){
		if (dictionary == null) {
			throw new IllegalArgumentException();
		}
		this.dictionary=dictionary;
		this.phrasee="";
		this.anagramprint = new ArrayList<String>();
	}
//The method getWords() parses the dictionary and puts all words that the phrase contains in a set.
	public Set<String> getWords(String phrase){
		if (phrase == null) {
			throw new IllegalArgumentException();
		}
		this.phrasee=phrase;
		Set anagrams = new TreeSet<String>();
		LetterInventory word = new LetterInventory(phrase);
		Iterator<String> parsedict= dictionary.iterator();
		ArrayList anagramqueue = new ArrayList<String>();
		while (parsedict.hasNext()){
			String checkword= parsedict.next();
			if (word.contains(checkword)){
				anagrams.add(checkword);
				anagramqueue.add(checkword);
			}
		}
		this.anagramlist = anagramqueue; 
		this.word = word;
		return anagrams;
	}
//This method recursively prints the anagrams.
	public void print(String phrase) throws IllegalArgumentException{
		if (phrase == null) {
			throw new IllegalArgumentException();
		}
		if (word.isEmpty() ){
			System.out.println(anagramprint);
		} else {
			for (int i=0; i<anagramlist.size(); i++){	
				String newword = anagramlist.get(i); 
				if (word.contains(newword)){ 
					anagramprint.add(newword); //This is a backtracking recursion, where the letterinventory is decreased until it is empty for a solution.
					word.subtract(newword);
					print(phrase);
					word.add(newword);
					anagramprint.remove(anagramprint.size()-1);
				} 		
			}
		}
	}
//This method recursively prints the anagrams with a max number of words.
	public void print(String phrase, int max) throws IllegalArgumentException{
		if (phrase == null || max < 0) {
			throw new IllegalArgumentException();
		}
		if (anagramprint.size()==max && word.isEmpty()){
			System.out.println(anagramprint);//The recursion stops when the list size is the max size.
		} else if (0==max && word.isEmpty()) {
			System.out.println(anagramprint); //If max is 0, print everything regardless of size.
		} else{
			for (int i=0; i<anagramlist.size(); i++){	
				String newword = anagramlist.get(i); 
				if (word.contains(newword)){ 
					anagramprint.add(newword);
					word.subtract(newword);
					print(phrase, max); 
				word.add(newword);
				anagramprint.remove(anagramprint.size()-1);
				} 
		}
		}
	}
}