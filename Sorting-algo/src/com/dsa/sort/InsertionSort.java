package com.dsa.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {20,1,-15,7,-22,35,55};
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
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
