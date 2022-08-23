import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayManipulation {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, m).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		// long result = arrayManipulation(n, queries);
		long result = arrayManipulationOptimized(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		long[] arr = new long[n];
		long max = 0;
		for (int i = 0; i < queries.get(0).size(); i++) {
			int startIndex = queries.get(i).get(0);
			int lastIndex = queries.get(i).get(1);
			int increment = queries.get(i).get(2);
			for (int j = 1; j <= arr.length; j++) {
				if (j >= startIndex && j <= lastIndex) {
					arr[j - 1] += increment;
					if (arr[j - 1] > max) {
						max = arr[j - 1];
					}
				}
			}

		}
		return max;
	}

	public static long arrayManipulationOptimized(int n, List<List<Integer>> queries) {
		long[] arr = new long[n];
		/*
		  For every a,b,k increase a's element by k and decrease b+1's(except when b+1> arr's last element) element by k
		  The above gives the slop(points where there is increase or decrease in value)		 
		  when input is  5 3
                         1 2 100
                         2 5 100
                         3 4 100
           first loop results in [100,0,-100,0,0] 
           second loop results in [100,100,-100,0,0]
           third look results in [100,100,0,0,-100] 
          Note: array is 1 based with length 5 in this case            
		 */
		for (int i = 0; i < queries.size(); i++) {
			int startIndex = queries.get(i).get(0);
			int lastIndex = queries.get(i).get(1);
			int increment = queries.get(i).get(2);
			arr[startIndex - 1] += increment;
			if (lastIndex < arr.length) {
				arr[lastIndex] -= increment;
			}

		}
		long sum = 0;
		long maxSum = 0;
       /* While looping keep adding the deltas(slops) and keep track of 
        * the highest sum you have reached till you finish the loop 
        */
		for (int i = 0; i < arr.length; i++) {			
				sum += arr[i];
				if(sum>maxSum) {
					maxSum=sum;
				}			
		}
		return maxSum;
	}

}
