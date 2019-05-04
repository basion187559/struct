package cn.basion.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Main {

	

	public static void main(String[] args) {
	Queue<Integer> queue=new LinkedList<Integer>();
	
	BSTSet<Integer> set=new BSTSet<Integer>();
	set.add(1);
	set.add(2);
	set.add(3);
	System.out.println(set.getSize());
	set.add(3);
	System.out.println(set.getSize());
	
	
	}
   

}
