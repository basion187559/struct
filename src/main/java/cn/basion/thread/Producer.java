package cn.basion.thread;

import java.util.Queue;

public class Producer<E> {
	
	private Queue<E> queue;
	
	public Producer(Queue<E> queue){
		this.queue=queue;
	}
    
	public void producer(E e) throws InterruptedException{
		while(true){
			synchronized(queue){
				//生产者
				if(queue.size()==10){
					//唤醒消费
					queue.notify();
					
					//生产进入休眠
					queue.wait();
					
				}else{
					queue.add(e);
					System.out.println("生产添加信息"+e+" 当前队列大小"+queue.size());
					Thread.sleep(10);
				}
			}
		}
	
	}
}
