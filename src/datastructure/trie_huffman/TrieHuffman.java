package datastructure.trie_huffman;

class TrieNode{
    private Character data;
    private boolean isTerminating;

    private TrieNode []children;

    private int childCount;

    public TrieNode(char data){
        this.data=data;
        isTerminating=false;
        children= new TrieNode[26];
        childCount=0;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public boolean isTerminating() {
        return isTerminating;
    }

    public void setTerminating(boolean terminating) {
        isTerminating = terminating;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }
}
public class TrieHuffman {

   private TrieNode root;
   private int numWords;

    public int getNumWords() {
        return numWords;
    }

    public void setNumWords(int numWords) {
        this.numWords = numWords;
    }

    public TrieHuffman(){
       root=new TrieNode('\0');
       numWords=0;
   }

    public void insert(String word){
       if(insertHelper(root,word)){
           numWords++;
       }
    }

    private boolean insertHelper(TrieNode root,String word){

        if(word.length() == 0){
            if(root.isTerminating()) {
                return false;
            }
            else {
                root.setTerminating(true);
                return true;
            }
        }

        int childIndex=word.charAt(0)-'a';
        TrieNode[] childrens = root.getChildren();
        TrieNode child = childrens[childIndex];
        if(child==null){
             child=new TrieNode(word.charAt(0));
             childrens[childIndex]=child;
             root.setChildCount(root.getChildCount()+1);
        }

      return   insertHelper(child,word.substring(1));

    }

    public boolean search(String word){
        // Write your code here
       return searchHelper(root,word);
    }

    private boolean searchHelper(TrieNode root,String word){
        // Write your code here
        if(word.length()==0){
            return root.isTerminating();
        }

        int childIndex=word.charAt(0)-'a';
        TrieNode[] childrens = root.getChildren();
        TrieNode child = childrens[childIndex];
        if(child==null){
            return false;
        }else{
         return searchHelper(child,word.substring(1));
        }
    }

    public void remove(String word){
        if(removeHelper(root,word)){
            numWords--;
        }
    }

    private boolean removeHelper(TrieNode root,String word){
        if(word.length() == 0){
            if(root.isTerminating()) {
                root.setTerminating(false);;
                return true;
            }
            else {
                return false;
            }
        }

        int childIndex=word.charAt(0)-'a';
        TrieNode[] childrens = root.getChildren();
        TrieNode child = childrens[childIndex];
        if(child==null){
            return false;
        }
        boolean ans= removeHelper(child,word.substring(1));

        if(!child.isTerminating() && child.getChildCount()==0){
            childrens[childIndex]=null;
               child=null;
               root.setChildCount(root.getChildCount()-1);
        }
       return ans;
    }

    public int countWords() {
        // Write your code here
        return numWords;
    }
}
