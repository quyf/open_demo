package com.java.base.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *@author   quyf
 *@version  1.0.0
 *@date 	2015-9-2  上午11:25:39 
 */

public class Td extends Thread{

	public static final ReentrantLock lock = new ReentrantLock();
//	public  final ReentrantLock lock = new ReentrantLock();
	
	private int threadId;
	
	public Td(int id) {
		this.threadId = id;
	}
	
	public void run(){
		try{  
			lock.lock();
			System.out.println("thread-"+threadId+";lock");
			System.out.println("thread-"+threadId+";unlock");
		}finally{
			lock.unlock();
		}
	}
}
