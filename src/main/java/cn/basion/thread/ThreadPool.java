package cn.basion.thread;

public interface ThreadPool<Job extends Runnable> {
	
	void execute(Job job);
	
	void shutdown();
	
	void addWorkers(int num);
	
	void removeWorker(int num);
	//�õ����ڵȴ�ִ�е���������
	int getJobSize();
	
	

}
