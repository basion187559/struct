package cn.basion.collection;

import cn.basion.tree.BinaryTree;

public  class BSTSet<E extends Comparable<E>>  implements Set<E>{
    private BinaryTree tree;
    
    public BSTSet(){
    	this.tree=new BinaryTree<E>();
    }

	
	public void add(E e) {
      tree.add(e);
		
	}

	public void remove(E e) {
		tree.remove(e);
		
	}

	public boolean contains(E e) {
		
		return tree.contains(e);
	}

	public int getSize() {
		
		return tree.getSize();
	}

	public boolean isEmpty() {

		return tree.empty();
	}

}
