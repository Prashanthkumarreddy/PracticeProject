package com.capgem.firstclass;

import java.util.TreeSet;

 class FirstGrade {
    
    
	public static void main(String[] args) {
		
		String s= new String("aravind");
		
		int position= s.replace("a","*").substring(2,5).indexOf("i");
		
		System.out.println(position);
		
			
	}

}
