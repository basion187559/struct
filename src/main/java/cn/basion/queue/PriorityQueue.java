package cn.basion.queue;

import cn.basion.heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> heap;
	
	public PriorityQueue(){
		this.heap=new MaxHeap<E>();
	}

	public void enqueue(E e) {
		heap.add(e);
	}

	public E dequeue() {
		return heap.extractMax();
	}

	public E getFront() {
		
		return heap.findMax();
	}

	public int getSize() {
		
		return heap.getSize();
	}

	public boolean isEmpty() {
		
		return heap.isEmpty();
	}

}
