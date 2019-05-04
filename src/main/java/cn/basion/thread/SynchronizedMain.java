package cn.basion.thread;

public class SynchronizedMain {
    
    private static int result=0;
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t=new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						compute();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t.start();
		}

	}
	
	
	public static synchronized void compute() throws InterruptedException{
		result+=5;
		System.out.println(Thread.currentThread().getName()+" ==> "+result);
		Thread.sleep(2000);
		
	}

}
