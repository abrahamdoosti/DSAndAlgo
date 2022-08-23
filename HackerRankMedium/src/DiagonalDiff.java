import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiagonalDiff {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	/*	 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        List<List<Integer>> arr = new ArrayList<>();

	        IntStream.range(0, n).forEach(i -> {
	            try {
	                arr.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .map(Integer::parseInt)
	                        .collect(Collectors.toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        int result = diagonalDifference(arr);

	        //bufferedWriter.write(String.valueOf(result));
	        //bufferedWriter.newLine();

	        bufferedReader.close();
	        //bufferedWriter.close();*/
		List<List<Integer>> arr=new ArrayList<List<Integer>>();
		List<Integer> row0=new ArrayList<Integer>();
		row0.add(3);
		arr.add(row0);
		List<Integer> row1=new ArrayList<Integer>();
		row1.add(11);
		row1.add(2);
		row1.add(4);
		arr.add(row1);
		List<Integer> row2=new ArrayList<Integer>();
		row2.add(4);
		row2.add(5);
		row2.add(6);
		arr.add(row2);
		List<Integer> row3=new ArrayList<Integer>();
		row3.add(10);
		row3.add(8);
		row3.add(-12);
		arr.add(row3);
		
		int result = diagonalDifference(arr);
		
		
	}
	public static int diagonalDifference(List<List<Integer>> arr) {
	    // Write your code here
	    int leftToRight=0;
	    int rightToLeft=0;
	    int n=arr.get(0).get(0);  
	  
	    for(int i=1;i<=n;i++){
	        for(int j=0;j<n;j++){
	            if(i==j+1){
	                leftToRight+=arr.get(i).get(j);
	            }
	            if(j==n-i){
	               rightToLeft+=arr.get(i).get(j); 
	            }
	        }
	    }
	    int result=Math.abs(leftToRight-rightToLeft);    
	   return result;
	    }

	

}
