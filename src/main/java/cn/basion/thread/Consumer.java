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
					//����������
					queue.notify();
					//���ѽ�������
					queue.wait();
				}else{
					System.out.println("������Ϣ"+queue.poll()+" ��ǰ���д�С"+queue.size());
					Thread.sleep(10);
				}
			}
		}
	}
}
