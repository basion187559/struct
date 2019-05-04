package cn.basion.queue;

public class Main {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}

}
