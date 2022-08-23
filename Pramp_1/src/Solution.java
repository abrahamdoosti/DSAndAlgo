
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = { 4, 2, 5, 7, 8, 2 };
		int[] myArray1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] myArray2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] myArray3 = { 1 };
		pancakeSort(myArray);
		pancakeSort(myArray1);
		pancakeSort(myArray2);
		pancakeSort(myArray3);
		printArray(myArray);
		printArray(myArray1);
		printArray(myArray2);
		printArray(myArray3);
	}

	
	static void pancakeSort(int[] arr) {
	    //1st iteration { 4, 2, 5, 7, 8, 2 }->{8,7,5,2,4,2}->{2,4,2,5,7,8}
		//2nd iteration {2,4,2,5,7,8}->{7,5,2,4,2,8}->{2,4,2,5,7,8}
		// limit tells you how many of the elements of the array are not in their proper position yet
		for (int limit = arr.length; limit > 0; limit--) {
			int maxNumIndex = 0;
			//find the largest element from the subset of the array.
			for (int i = 0; i < limit; i++) {
				if (arr[i] > arr[maxNumIndex]) {
					maxNumIndex = i;
				}
			}
			flip(arr, maxNumIndex + 1);
			flip(arr, limit);
		}
		
	}
	 

	// {4,2,5,7,8,2}
	static void flip(int[] arr, int k) {
		if (arr == null || arr.length <= 1) {
			return;
		} else {
			for (int i = 0; i < k / 2; i++) {
				int temp = arr[k - 1 - i];
				arr[k - 1 - i] = arr[i];
				arr[i] = temp;
			}
		}

	}

	static void printArray(int[] myArray) {
		System.out.print("{");
		for (int i = 0; i < myArray.length; i++) {
			if(i>0) {
				System.out.print(" , " );
			}
			System.out.print( myArray[i]);
		}
		System.out.print("}");
		System.out.println();
	}

}
