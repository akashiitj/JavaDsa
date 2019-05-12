package Trie;

import java.util.HashMap;

class TrieNode{
    char value;
    boolean ifEnd;
    int prefixCount;
    HashMap<Character,TrieNode> child;

    public TrieNode(char val) {
        value = val;
        ifEnd = false;
        prefixCount = 0;
        child = new HashMap<>();
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isIfEnd() {
        return ifEnd;
    }

    public void setIfEnd(boolean ifEnd) {
        this.ifEnd = ifEnd;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public void increasePrefixCount() {
        prefixCount++;
    }

    public HashMap<Character, TrieNode> getChild() {
        return child;
    }

    public void setChild(HashMap<Character, TrieNode> child) {
        this.child = child;
    }
}

class Trie{
    TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    void insert(String s){
        TrieNode it = root;
        TrieNode childIt;
        for (int i = 0; i < s.length() ; i++) {
            childIt = it.getChild().get(s.charAt(i));
            if(childIt == null){
                childIt = new TrieNode(s.charAt(i));
                it.getChild().put(s.charAt(i),childIt);
            }
            childIt.increasePrefixCount();
            it = childIt;
        }
        it.setIfEnd(true);
    }

    boolean search(String s){
        TrieNode it = root;
        for (int i = 0; i < s.length(); i++) {
            it = it.getChild().get(s.charAt(i));
            if(it==null)
                return false;
        }
        return it.isIfEnd();
    }

    int getPrefixCount(String s){
        TrieNode it = root;
        for (int i = 0; i < s.length(); i++) {
            it = it.getChild().get(s.charAt(i));
            if(it==null)
                return 0;
        }
        return it.getPrefixCount();
    }
}


public class TrieBasics {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Trie demo = new Trie();
        demo.insert("akash");
        demo.insert("ak");
        demo.insert("bcd");
        System.out.println(demo.search("bv"));
        System.out.println(demo.search("bcd"));
        System.out.println(demo.getPrefixCount("ak"));



    }
}
