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
				//������
				if(queue.size()==10){
					//��������
					queue.notify();
					
					//������������
					queue.wait();
					
				}else{
					queue.add(e);
					System.out.println("���������Ϣ"+e+" ��ǰ���д�С"+queue.size());
					Thread.sleep(10);
				}
			}
		}
	
	}
}
