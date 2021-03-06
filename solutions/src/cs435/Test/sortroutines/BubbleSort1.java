package cs435.Test.sortroutines;

import java.util.Arrays;

import cs435.Test.runtime.Sorter;

/**
 * This is the slowest version of BubbleSort
 * No optimization for already sorted arrays.
 * Doesn't take into account the fact that
 * largest elements are pushed to the right.
 *
 */
public class BubbleSort1 extends Sorter {
	
	int[] arr;
	public int[] sort(int[] array){
		this.arr = array;
		bubbleSort();
		return arr;
		
	}
	private void bubbleSort(){
		boolean bSwap = false;
		for (int i = arr.length-1; i > 0 ; i--) {
			bSwap = false;
			for (int j = 0; j < i; j++) {
				if (arr[j]>arr[j+1]){
					swap(j,j+1);
					bSwap = true;
				}
			}
			if (!bSwap)
				return;
		}
	}
	
	int[] swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
		
	}
	public static void main(String[] args){
		int[] test = {21,13,1,-22, 51, 5, 18};
		BubbleSort bs = new BubbleSort();
		
		System.out.println(Arrays.toString(bs.sort(test)));
		
	}

}
