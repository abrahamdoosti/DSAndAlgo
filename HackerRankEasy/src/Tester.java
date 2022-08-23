
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(15);
	}

	public static void fizzBuzz(int n) {
		// Write your code here
		for (int i = 1; i <= n; i++) {

			if (i % 5 != 0 && i % 3 != 0) {
				System.out.print(i);

			}
			if (i % 3 == 0) {
				System.out.print("Fizz");
			}
			if (i % 5 == 0) {
				System.out.print("Buzz");
			}
			System.out.println();

		}
	}

}
