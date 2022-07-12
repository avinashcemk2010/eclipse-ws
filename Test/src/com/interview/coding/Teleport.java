package com.interview.coding;

public class Teleport {

	public static void main(String[] args) {
		Integer[] arr = {5,7,3,6,8,5};
		
		for(int i=0;i < arr.length;i++) {
			boolean max = true;
			for(int j=i+1;j < arr.length;j++) {
				if(arr[i] < arr[j]) {
					max = false;
					break;
				}
				
			}
			if(max == true) {
				System.out.println(arr[i]);
			}
		}
		
		System.out.println("New output:");
		int max = arr[arr.length-1];
		System.out.println(max);
		for(int i=arr.length-1;i >= 0;i--) {
			
			if(arr[i] > max) {
				System.out.println(arr[i]);
				max = arr[i];
			}
			
		}
	}

}
