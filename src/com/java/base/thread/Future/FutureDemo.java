package com.java.base.thread.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *@author   quyf
 *@version  1.0.0
 *@date 	2015-8-31  上午9:47:48 
 */

public class FutureDemo {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				System.out.println("calling..");
				Thread.sleep(3000);
				return 12;
			}
			
		});
		System.out.println("开始拿");
		try {
			System.out.println("拿到了："+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		//===================
		
	}

}
