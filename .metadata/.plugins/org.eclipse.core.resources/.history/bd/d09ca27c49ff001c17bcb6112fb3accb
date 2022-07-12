package com.interview.coding;

public class Pallindrome {

	public static void main(String[] args) {
		int num = 566;
		Pallindrome test2 = new Pallindrome();
		System.out.println(test2.isPallindrome(num));
		
	}
	
	public boolean isPallindrome(int num) {
		int original = num;
		int sum = 0;
		while(num > 0) {
			int rem = num%10;
			sum = rem + sum * 10;
			num = num/10;
		}
		
		System.out.println(sum);
		System.out.println(original);
		if(original == sum) {
			return true;
		}
		return false;
	}

}
