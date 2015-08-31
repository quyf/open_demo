package com.java.base.thread;

/**
 * 无论何种方式，启动一个线程，就要给它一个名字！这对排错诊断
	系统监控有帮助。否则诊断问题时，无法直观知道某个线程的用途
 *
 */
public class ThreadName {

	
	public static void main(String[] args) {
		//示例1
		Thread t1=new Thread("thread 1.."){
			public void run(){
				System.out.println( this.getName());
			}
		};
		t1.start();
		//示例2
		ThreadName1 t2=new ThreadName1();
		t2.start();
		//示例3
		Thread t3=new Thread(){
			public void run(){
				System.out.println(this.getName());
			}
		};
		t3.setName("thread3---");
		t3.start();
		
		
	}

}

class ThreadName1 extends Thread{
	
	public ThreadName1(){
		super("thread1 name...");
	}
	public void run(){
		System.out.println( this.getName());
	}
}

