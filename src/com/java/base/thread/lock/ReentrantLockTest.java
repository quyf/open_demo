package com.java.base.thread.lock;

/**
 *@author   quyf
 *@version  1.0.0
 *@date 	2015-9-2  上午11:28:53 
 */

public class ReentrantLockTest {

	public static void main(String[] args) {
		Td t1=new Td(1);
		Td t2=new Td(2);
		Td t3=new Td(3);
		t1.start();
		t2.start();
		t3.start();
	}

}
