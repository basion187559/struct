package cn.basion.thread;

import java.util.Queue;

public class Consumer<E> {
	private Queue<E> queue;
	
	public Consumer(Queue<E> queue){
		this.queue=queue;
	}
	
	public void consumer() throws InterruptedException{
		while(true){
			synchronized(queue){
				if(queue.size()==0){
					//唤醒生产者
					queue.notify();
					//消费进入休眠
					queue.wait();
				}else{
					System.out.println("消费信息"+queue.poll()+" 当前队列大小"+queue.size());
					Thread.sleep(10);
				}
			}
		}
	}
}
