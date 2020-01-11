package dp;

/**
 * F[0] = 0, F[1] = 1
 * F[i] = F[i-1] + F[i-2]
 */
public class Fibonacci {
	public static int calculate(int N) {
		int before_previous = 0;
		int previous = 1;
		for (int i = 2; i < N+1; i++) {
			int temp = previous;
			previous = before_previous + previous;
			before_previous = temp;
		}

		return previous;
	}
}
