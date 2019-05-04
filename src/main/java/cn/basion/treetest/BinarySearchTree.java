package cn.basion.treetest;

/**
 * ���������� ��ڵ�<���ڵ�<�ҽڵ�
 * 
 * @author Administrator
 *
 */
public class BinarySearchTree<E extends Comparable<E>> {
	/* ���ڵ� */
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
	


	//ʹ�õݹ�ķ�ʽ��ӽڵ�
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		//С�ڽڵ�����
		if(e.compareTo(node.e) <0){
			node.left=add(node.left, e);
		}
		//���ڽڵ�����
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
