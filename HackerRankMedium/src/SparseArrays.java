import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparseArrays {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		/*
		 * System.out.println(System.getenv()); Map<String, String>
		 * envMap=System.getenv(); for(Entry<String, String> e:envMap.entrySet()) {
		 * System.out.println(e.getKey()+" : "+e.getValue()); }
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());

		List<Integer> res = matchingStrings(strings, queries);

		bufferedWriter.write(res.stream().map(Object::toString).collect(Collectors.joining("\n"))
		 + "\n");

		bufferedReader.close();
		bufferedWriter.close();

	}

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		// Write your code here

		int stringLen = strings.size();
		int queryLen = queries.size();
		Integer[] occurance = new Integer[queryLen];
		if (stringLen == 0 || queryLen == 0) {
			return null;
		}
		for (int i = 0; i < queryLen; i++) {
			if (null == occurance[i]) {
				occurance[i] = 0;
			}
			for (int j = 0; j < stringLen; j++) {
				if (queries.get(i).equals(strings.get(j))) {

					occurance[i] += 1;

				}
			}
		}
		return Arrays.asList(occurance);

	}

}
