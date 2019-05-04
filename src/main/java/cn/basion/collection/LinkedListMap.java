package cn.basion.collection;

public class LinkedListMap<K, V> implements Map<K, V> {
	private Node<K, V> first;

	private Node<K, V> last;

	private int size;

	public void add(K key, V value) {
		V node = get(key);
		if (first == null) {
			first = new Node(key, value);
			last = new Node(key, value);
			size++;
		} else {
			Node cur = new Node(key, value);
			last.next = cur;
			last = cur;
			size++;
		}

	}

	public V remove(K key) {
        Node<K, V> cur = first; 
        if(key.equals(cur.key)){
        	first=null;
        	last=null;
        	return cur.value;
        }
        Node temp = cur.next;
        while(temp!=null){
        	if(key.equals(temp.key)){
        		
        	}
        }
		
		return null;
	}

	public boolean contains(K key) {
		return get(key)!=null;
	}

	public V get(K key) {
		Node<K, V> cur = first;
		while (cur != null) {
			if (key.equals(cur.key)) {
				return cur.value;
			}
			cur = cur.next;
		}
		return null;
	}

	public void set(K key, V value) {
		Node<K, V> cur = first;
		while (cur != null) {
			if (key.equals(cur.key)) {
				cur.value = value;
			}
			cur = cur.next;
		}

	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private static class Node<K, V> {
		private K key;
		private V value;
		private Node next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

	}

}
