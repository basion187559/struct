package cn.basion.link;

public class SingleLinkList<E> {

	private Node first;

	private Node last;

	private int size;

	public SingleLinkList() {
	}

	public void add(E e) {
		if (first == null) {
			size++;
			first = new Node<E>(e);
			last = first;
		} else {
			size++;
			Node<E> cur = new Node<E>(e);
			last.next = cur;
			last = cur;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contain(E e) {
		Node cur = first;
		while (cur != null) {
			if (e.equals(cur.e)) {
				return true;
			}
			cur=cur.next;
		}
		return false;
	}

	private static class Node<E> {
		E e;
		Node next;
		public Node(E e) {
			this.e = e;
			this.next = null;
		}
	}

}
