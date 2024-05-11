import java.util.Arrays;

public class RemoveElement {
	/**
	 * Given an array and a target number, go through the array and if an element is
	 * equal to the target number then replace it with the nearest next element that
	 * is not equal to target and return the total number of elements that are not
	 * equal to target.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 5, 2, 3 };
		int[] arr1 = { 2, 1, 3, 4 };
		System.out.println("arr " + getNonTargetCount(arr, 2));
		System.out.println("arr " + Arrays.toString(arr));
		System.out.println("arr1 " + getNonTargetCount(arr1, 2));
		System.out.println("arr1 " + Arrays.toString(arr1));

	}

	public static int getNonTargetCount(int[] inputArr, int target) {
		// This pointer keeps track of the value that needs to be replaced.
		// At the end of looping wherever this pointer stops , we have already all the
		// non-target numbers to our left.
		int leftPointer = 0;

		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i] != target) {
				inputArr[leftPointer] = inputArr[i];
				leftPointer++;
			}
		}
		return leftPointer;
	}

}
