package com.dsa.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {20,35,-15,7,55,1,-22};
		
		for(int i=arr.length-1; i > 0; i--) {
			for(int j=0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		list.forEach(System.out::println);
	}
	
	public static void swap(int[] arr, int i, int j) {
		
		if(i==j) {
			return;
		}
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
