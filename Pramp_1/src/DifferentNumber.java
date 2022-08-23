
public class DifferentNumber {
	
	public static void main(String[] args) {
		int[] arr= {5,0,8};
		System.out.println(getDifferentNumber(arr));
		
	}
	/**
	 * gets the smallest non negative integer that is not found in the given array 
	 * @param arr
	 * @return
	 */
	static int getDifferentNumber(int[] arr) {
		int maxNum=0;		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>maxNum) {
				maxNum=arr[i];
			}
		}
		
		boolean[] newArray=new boolean[maxNum+1];
		for(int i=0;i<arr.length;i++) {
			newArray[arr[i]]=true;
		}
		
		for(int i=0;i<newArray.length;i++) {
			if(newArray[i]==false) {
				return i;				
			}
		}
		return newArray.length;
	}

}
