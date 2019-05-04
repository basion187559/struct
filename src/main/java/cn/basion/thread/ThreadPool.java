package cn.basion.thread;

public interface ThreadPool<Job extends Runnable> {
	
	void execute(Job job);
	
	void shutdown();
	
	void addWorkers(int num);
	
	void removeWorker(int num);
	//得到正在等待执行的任务数量
	int getJobSize();
	
	

}
