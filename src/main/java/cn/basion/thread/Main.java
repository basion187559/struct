package cn.basion.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Integer num = new Integer(1);

	public static void main(String[] args) throws InterruptedException {

		Queue<Integer> queue = new LinkedList<>();
		Producer<Integer> producer = new Producer<>(queue);
		Consumer<Integer> consumer = new Consumer<>(queue);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer.producer(num);
					num++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					consumer.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t2.start();
		while (true) {
			Thread.sleep(10000);
		}

	}

}
