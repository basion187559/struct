package cn.basion.tree;

import java.util.TreeMap;

public class Trie {
	
	private Node root;
	private int size;
	public Trie(){
		this.root=new Node();
		size=0;
	}
	public int getSize(){
		return size;
	}
   
	//向Trie中添加一个新的单词word
	public void add(String word){
		Node cur=root;
		for (int i = 0; i < word.length(); i++) {
			char c=word.charAt(i);
			if(cur.next.get(c)==null){
				cur.next.put(c, new Node());
			}
			cur=cur.next.get(c);
		}
		if(!cur.isWord){
			cur.isWord=true;
			size++;
		}
	}
	
	public boolean  cotains(String word){
		Node cur=root;
		for (int i = 0; i < word.length(); i++) {
			char c=word.charAt(i);
		    if(cur.next.get(c)==null){
		    	return false;
		    }else{
		    	cur=cur.next.get(c);
		    }
		}
		return cur.isWord;
	}
	
	//
	public boolean isPrefix(String prefix){
		Node cur=root;
		for (int i = 0; i < prefix.length(); i++) {
			char c=prefix.charAt(i);
		    if(cur.next.get(c)==null){
		    	return false;
		    }else{
		    	cur=cur.next.get(c);
		    }
		}
		return true;
	}

	
	class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}
		
		public Node(){
			this(false);
		}
	}

}
