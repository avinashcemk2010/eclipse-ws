package com.dsa.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//select the max element and keep adding it to the last location
public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {20,1,-15,7,-22,35,55};
		
		int max_index = 0;
		for(int i = arr.length-1; i > 0; i--) {
			max_index = 0;
			for(int j = 0; j <= i; j++) {
				if(arr[j] > arr[max_index]) {
					max_index = j;
				}
			}
			swap(arr, max_index, i);
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
