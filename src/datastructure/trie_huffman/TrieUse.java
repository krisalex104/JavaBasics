package datastructure.trie_huffman;

import java.util.ArrayList;

public class TrieUse {

    public static void main(String[] args) {
        Trie t=new Trie();
        t.add("bag");
        t.add("news");
        t.add("note");
        t.add("vote");
        System.out.println(t.search("news"));
        System.out.println(t.countWords());
        t.remove("news");
        System.out.println(t.search("news"));
        System.out.println(t.countWords());

        ArrayList<String> lt=new ArrayList<>();
        lt.add("news");
        lt.add("ghi");

        boolean patternMatching = t.patternMatching(lt, "hi");
        System.out.println(patternMatching);

    }
}
