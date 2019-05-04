package cn.basion.heap;

import cn.basion.array.Array;

public class MaxHeap<E extends Comparable<E>> {

	private Array<E> array;

	public MaxHeap() {
		this.array = new Array();
	}
    
	public MaxHeap(E[] arr){
		array=new Array<E>(arr);
		//��ȡ���һ����Ҷ�ӽڵ������
		int index=parent(array.getSize()-1);
		//��β��ǰ����siftdown����
		for (int i = index; i >=0; i--) {
			siftDown(i);
		}
		
	}
	public int getSize() {
		return array.getSize();
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

	private int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("index-0 dosen't have parent");
		}
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return (2 * index) + 1;
	}

	private int rightChild(int index) {
		return (2 * index) + 2;
	}

	// ���Ԫ��
	public void add(E e) {
		// ������������Ԫ�� Ȼ��ʼ�ϸ�����
		array.addLast(e);
		siftUp(array.getSize() - 1);
	}

	public E findMax() {
		if (array.getSize() == 0) {
			throw new IllegalArgumentException("the heap is empty");
		}
		return array.get(0);
	}

	public E extractMax() {
		E ret = findMax();
		array.swap(0, array.getSize() - 1);
		array.removeLast();
		siftDown(0);
		return ret;

	}

	/**
	 * 
	 */
	private void siftDown(int index) {

		while (leftChild(index) < array.getSize()) {

			int j = leftChild(index);
			if (j + 1 < array.getSize() && array.get(j + 1).compareTo(array.get(j)) > 0) {
				j = rightChild(index);
			}
			if (array.get(index).compareTo(array.get(j)) > 0) {
				break;
			}
			array.swap(index, j);
			index = j;
		}

	}

	private void siftUp(int index) {
		// ����>0 �� �Լ��Ľڵ��ֵ���ڸ��ڵ��ֵ
		while (index > 0 && array.get(index).compareTo(array.get(parent(index))) > 0) {
			array.swap(index, parent(index));
			index = parent(index);
		}
	}
	//ȡ���������Ԫ�أ������滻��Ԫ��e
	public E replace(E e){
		E ret=findMax();
		array.set(0, e);
		siftDown(0);
		return ret;
	}
	
	
}
