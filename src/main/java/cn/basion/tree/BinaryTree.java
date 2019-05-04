package cn.basion.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ����������,��ڵ�<���ڵ�<�ҽڵ�
 * 
 * @author Administrator
 *
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>> {
	private Node root;

	private int size;
	
	public void remove(E e){
		root=remove(root,e);
	}
	  // ɾ������nodeΪ���Ķ�����������ֵΪe�Ľڵ�, �ݹ��㷨
    // ����ɾ���ڵ���µĶ����������ĸ�
	private Node remove(Node node, E e) {
		if(node==null){
			return null;
		}
		if(e.compareTo(node.e)<0){
			node.left=remove(node.left, e);
			return node;
		}else if(e.compareTo(node.e)>0){
			node.right=remove(node.right, e);
			return node;
		}else{
			// ��ɾ���ڵ�������Ϊ�յ����
			if(node.left==null){
				Node rightNode=node.right;
				node.right=null;
				size--;
				return rightNode;
			}
			  // ��ɾ���ڵ�������Ϊ�յ����
			if(node.right==null){
				Node leftNode=node.left;
				node.left=null;
				size--;
				return leftNode;
			}
			 // ��ɾ���ڵ�������������Ϊ�յ����

            // �ҵ��ȴ�ɾ���ڵ�����С�ڵ�, ����ɾ���ڵ�����������С�ڵ�
            // ������ڵ㶥���ɾ���ڵ��λ��
			Node successor=min(node.right);
			successor.right=removeMin(node.right);
			successor.left=node.left;
			node.left=node.right=null;
			return successor;
		}
	}

	public void add(E e) {
		root = add(root, e);
	}
   
	public E removeMin(){
		E ret = min();
		root=removeMin(root);
		return ret;
		
	}
	
	public E removeMax(){
		E e = max();
		root=removeMax(root);
		return e;
	}
	
	
	
	private Node removeMax(Node node) {
		if(node.right==null){
			BinaryTree<E>.Node leftNode = node.left;
			node.left=null;
			size--;
			return leftNode;
		}
		node.right=removeMax(node.right);
		return node;
		
	}

	public E min(){
		if(this.size<=0){
			throw new RuntimeException("���Ĵ�СΪ��");
		}
		return min(root).e;
	}
	private Node min(Node node){
		if(node.left==null){
			return node;
		}else{
			return min(node.left);
		}
	}
	
	//ɾ������nodeΪ���Ķ����������е���С�ڵ�
		//����ɾ���ڵ���µĶ����������ĸ�
		private Node removeMin(Node node){
			if(node.left==null){
				BinaryTree<E>.Node rightNode = node.right;
				node.right=null;
				size--;
				return rightNode;
			}
			node.left=removeMin(node.left);
			return node;
		}
	public E max(){
		if(this.size<=0){
			throw new RuntimeException("���Ĵ�СΪ��");
		}
		return max(root).e;
	}
	private Node max(Node node){
		if(node.right==null){
			return node;
		}else{
			return max(node.right);
		}
	}
	//����nodeΪ���Ķ����������в���Ԫ��e,�ݹ��㷨
	//���ز����½ڵ������������ĸ�
	public Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;

	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	public boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		} else if (e.compareTo(node.e) == 0) {
			return true;
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else {
			return contains(node.right, e);
		}

	}

	// public void add(Node node,E e){
	// if(node.e.equals(e)){
	// return;
	// }else if(e.compareTo(node.e)<0 && node.left==null){
	// node.left=new Node(e);
	// size++;
	// return;
	// }else if(e.compareTo(node.e)>0 && node.right==null){
	// node.right=new Node(e);
	// size++;
	// return;
	// }
	// if(e.compareTo(node.e)<0){
	// node=node.left;
	// add(node,e);
	// }else{
	// node=node.right;
	// add(node,e);
	// }
	//
	// }
	public void preOrder() {
		preOrder(root);
	}

	public void inOrder() {
		inOrder(root);
	}

	public void postOrder() {
		postOrder(root);
	}

	public void levelOrder() {
		levelOrder(root);
	}

	public void levelOrder(Node node) {
       //����һ������ʵ�ֹ�������㷨
		Queue<Node> queue=new LinkedList<BinaryTree<E>.Node>();
		if(node!=null){
			queue.add(node);
		}
		while(!queue.isEmpty()){
			BinaryTree<E>.Node cur = queue.remove();
			System.out.println(cur.e);
			if(cur.left!=null){
				queue.add(cur.left);
			}
			if(cur.right!=null){
				queue.add(cur.right);
			}
		}

	}

	// ���� ǰ��
	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
    public void preOrderUnRecursion(){
    	preOrderUnRecursion(root);
    }
    
    private void preOrderUnRecursion(Node node){
    	//����һ��ջ�ṹʵ��ǰ������ķǵݹ�д��
    	Stack<Node> stack=new Stack<BinaryTree<E>.Node>();
    	if(root!=null){
    		stack.push(node);
    	}
    	while(!stack.isEmpty()){
    		BinaryTree<E>.Node cur = stack.pop();
        	System.out.println(cur.e);
        	if(cur.right!=null){
        		stack.push(cur.right);
        	}
        	if(cur.left!=null){
        		stack.push(cur.left);
        	}
    	}
    	
    }
	
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	public boolean empty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public BinaryTree() {
		this.root = null;
		this.size = 0;
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
