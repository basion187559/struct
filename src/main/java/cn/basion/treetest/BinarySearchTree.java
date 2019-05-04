package cn.basion.treetest;

/**
 * 二分搜索树 左节点<根节点<右节点
 * 
 * @author Administrator
 *
 */
public class BinarySearchTree<E extends Comparable<E>> {
	/* 根节点 */
	private Node root;

	private int size;

	
	public void add(E e) {
		add(root, e);
	}
	
	public boolean contain(E e){
		return contain(root,e);
	}
	
	public void preOrder(){
		preOrder(root);
	}
	


	//使用递归的方式添加节点
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		//小于节点内容
		if(e.compareTo(node.e) <0){
			node.left=add(node.left, e);
		}
		//大于节点内容
		if(e.compareTo(node.e)>0){
			node.right=add(node.right, e);
		}   
		return node;
	}
	
	private boolean contain(Node node,E e){
		while(node!=null){
			if(e.compareTo(node.e)==0){
				return true;
			}else if(e.compareTo(node.e)<0){
				return contain(node.left,e);
			}else{
				return contain(node.right, e);
			}
		}
		return false;
		
	}
	
    private void preOrder(Node node) {
	  	
	 	
	}
    
	private class Node {
		private E e;
		private Node left;
		private Node right;

		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}

	}

}
