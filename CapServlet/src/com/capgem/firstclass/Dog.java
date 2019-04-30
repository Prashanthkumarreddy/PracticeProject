package com.capgem.firstclass;

public class Dog<T> implements Comparable<T> {

	 int size;
	 
	 Dog(int s){
		 size=s;
	 }

	@Override
	public int compareTo(T arg0) {
		
		return 0;
	}
}
