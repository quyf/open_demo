package com.java.base.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类说明 
 *
 * @author Van
 * @date 2017-2-15
 */
public class Demo {

	public String name ;
	private int age;
	public int id;
	
	public Demo(){}
	public Demo(String name){};
	
	private Demo(int id){};
	
	public void sayHello(){};
	private void sayBye(){};
	
	public static void main(String[] args) {
		Class c = Demo.class;
		System.out.println(  c.getName());
		System.out.println(  c.getSimpleName());
		System.out.println(  c.getCanonicalName());
		System.out.println("=======================");
		Method[] ms = c.getMethods();
		for(Method m:ms){
			System.out.println( m.getName());
		}
		System.out.println("=======================");
		Method[] pms = c.getDeclaredMethods();
		for(Method p:pms){
			System.out.println( p.getName());
		}
		System.out.println("=======================");
		Field[] fs = c.getFields();
		for(Field f:fs){
			System.out.println( f.getName());
		}
		System.out.println("=======================");
		
		
	}
}
