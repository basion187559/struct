package cn.basion.tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.AbstractDocument.LeafElement;

public class BinaryTreeTest<E extends Comparable<E>> {
	private Node root;

	private int size;

	public void remove(E e) {
		root = remove(root, e);

	}

	private Node remove(Node node, E e) {

		if (this.empty()) {
			throw new RuntimeException("���Ķ��д�СΪ��");
		}
		if (node == null) {
			return null;
		}
		if (e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else {
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}

			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// �ڵ������������
			Node successor = min(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			
			node.left = node.right = null;
			return successor;

		}

	}

	public E removeMax() {
		E e = max();
		root = removeMax(root);
		return e;
	}

	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}

	public E max() {
		if (this.empty()) {
			throw new RuntimeException("���Ķ��д�СΪ��");
		}
		return max(root).e;
	}

	private Node max(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	// ɾ����Сֵ
	public E removeMin() {
		E e = min();
		root = removeMin(root);
		return e;
	}

	// ɾ����Сֵ������ɾ����Сֵ��ĸ��ڵ�
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	public void add(E e) {
		root = add(root, e);
	}

	public E min() {
		if (this.empty()) {
			throw new RuntimeException("���Ķ��д�СΪ��");
		}
		return min(root).e;

	}

	// ������Сֵ
	private Node min(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	// ���
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}
		if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	// ����
	public boolean contains(E e) {
		if (this.empty()) {
			throw new RuntimeException("���Ķ��д�СΪ��");
		} else {
			return contains(root, e);
		}

	}

	// ǰ���ѯ
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void levelOrder() {
		levelOrder(root);
	}

	private void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<BinaryTreeTest<E>.Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BinaryTreeTest<E>.Node cur = queue.poll();
			System.err.println(cur.e);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		} else {
			if (e.compareTo(node.e) == 0) {
				return true;
			} else if (e.compareTo(node.e) < 0) {
				return contains(node.left, e);
			} else {
				return contains(node.right, e);
			}
		}
	}

	public boolean empty() {
		return size == 0;
	}
	// ��ѯ

	private class Node {
		E e;
		private Node left;
		private Node right;

		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

}
