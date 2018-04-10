package com.xiaoqing.testcollection;

import java.util.Date;


public class Test01 {

	public static void main(String[] args) {
		MyArrayList list=new MyArrayList(3);
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		System.out.println(list.size());
		list.add("bbb");
		System.out.println(list.get(3));
		System.out.println(list.size());
		list.set(1, "ccc");
		System.out.println(list.get(1));
		list.remove(0);
		System.out.println(list.get(0));
		System.out.println(list.size());
	}

}
class Dog{
	String name="xixi";
}