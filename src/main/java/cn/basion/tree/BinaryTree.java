package cn.basion.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二分搜索树,左节点<根节点<右节点
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
	  // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
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
			// 待删除节点左子树为空的情况
			if(node.left==null){
				Node rightNode=node.right;
				node.right=null;
				size--;
				return rightNode;
			}
			  // 待删除节点右子树为空的情况
			if(node.right==null){
				Node leftNode=node.left;
				node.left=null;
				size--;
				return leftNode;
			}
			 // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
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
			throw new RuntimeException("树的大小为空");
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
	
	//删除掉以node为根的二分搜索树中的最小节点
		//返回删除节点后新的二分搜索树的根
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
			throw new RuntimeException("树的大小为空");
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
	//向以node为根的二分搜索树中插入元素e,递归算法
	//返回插入新节点后二分搜索树的根
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
       //借助一个队列实现广度优先算法
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

	// 遍历 前序
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
    	//借助一个栈结构实现前序遍历的非递归写法
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
