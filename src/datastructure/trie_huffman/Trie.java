package datastructure.trie_huffman;

import java.util.ArrayList;
import java.util.List;

class TrieNode1{
    char data;
    boolean isTerminating;
    TrieNode1 children[];
    int childCount;

    public TrieNode1(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode1[26];
        childCount = 0;
    }
}


public class Trie {

    private TrieNode1 root;
    private int numWords;

    public Trie() {
        root = new TrieNode1('\0');
        numWords = 0;
    }


    public void remove(String word){
        if(remove(root, word)) {
            numWords--;
        }
    }


    private boolean remove(TrieNode1 root, String word) {
        if(word.length() == 0){
            if(root.isTerminating) {
                root.isTerminating = false;
                return true;
            }
            else {
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode1 child = root.children[childIndex];
        if(child == null){
            return false;
        }
        boolean ans = remove(child, word.substring(1));
        // We can remove child node only if it is non terminating and its number of children are 0

        if(!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
        return ans;
    }

    private boolean add(TrieNode1 root, String word){
        if(word.length() == 0){
            if(root.isTerminating) {
                return false;
            }
            else {
                root.isTerminating = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode1 child = root.children[childIndex];
        if(child == null){
            child = new TrieNode1(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return add(child, word.substring(1));
    }

    public void add(String word){
        if(add(root, word)) {
            numWords++;
        }
    }

    public int countWords() {
        // Write your code here
        return numWords;
    }

    private void insertSuffixes(String word) {
        for (int i = 0; i < word.length(); i++) {
            add(root, word.substring(i));
        }
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode1 root, String word) {
        if (word.length() == 0) {
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode1 child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }

    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code herefor (String word : vect) {
        for (String word : vect) {
            add(word);
            insertSuffixes(word);
        }
        return search(pattern);
    }


    //for palindrome words
    public boolean isPalindromePair(ArrayList<String> words) {
        //Your code goes here
        //first we add all the words in the trie
        String input1,p="";
        for(int i =0;i<words.size();i++){
            if(!search(root,words.get(i)))
                add(words.get(i));
        }

        //below for loop is used for , reversing all the words and then search for that reversed word in the trie , if found
        //return true
        for(int i =0;i<words.size();i++){
            p="";
            input1 = words.get(i);
            for(int k =0;k<input1.length();k++){
                p=input1.charAt(k)+p;
            }
            // System.out.println(p);
            if(search(root,p)){
                return true;
            }
        }

        // below for loop is used for concating two words from the list and the
        //words that made after concating is checked for palindrome , if it is palindrome it returns true

        for (int i = 0; i< words.size()-1; i++)
        {
            for (int j = i+1; j< words.size() ; j++)
            {
                String check_str = "";

                // concatenate both strings
                check_str = check_str + words.get(i) + words.get(j);

                // check if the concatenated string is
                // palindrome
                if (isPalindrome(check_str))
                    return true;

                check_str = words.get(j) + words.get(i);

                // check if the concatenated string is
                // palindrome
                if (isPalindrome(check_str))
                    return true;
            }
        }
        return false;
    }

    static boolean isPalindrome(String str)
    {
        int len = str.length();

        // compare each character from starting
        // with its corresponding character from last
        for (int i = 0; i < len/2; i++ )
            if (str.charAt(i) != str.charAt(len-i-1))
                return false;

        return true;
    }
    
    
    
    //for auto complete words
    public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
        Trie trie = new Trie();

        // Build the Trie using the input dictionary of words
        for (String dictWord : input) {
            trie.add(dictWord);
        }

        List<String> autoCompleteWords = trie.getAutoCompleteWords(word);

        for (String autoCompleteWord : autoCompleteWords) {
            System.out.println(autoCompleteWord);
        }

    }

    public List<String> getAutoCompleteWords(String prefix) {
        List<String> autoCompleteWords = new ArrayList<>();
        TrieNode1 prefixNode = searchPrefix(prefix);

        if (prefixNode != null) {
            findWordsFromNode(prefixNode, prefix, autoCompleteWords);
        }

        return autoCompleteWords;
    }

    private TrieNode1 searchPrefix(String prefix) {
        TrieNode1 current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    private void findWordsFromNode(TrieNode1 node, String word, List<String> result) {
        if (node.isTerminating) {
            result.add(word);
        }

        for (int i = 0; i < 26; i++) {
            TrieNode1 child = node.children[i];
            if (child != null) {
                char ch = (char) (i + 'a');
                findWordsFromNode(child, word + ch, result);
            }
        }
    }

}
