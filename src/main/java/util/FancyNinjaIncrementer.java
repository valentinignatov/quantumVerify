package util;

public class FancyNinjaIncrementer {
	
	@FunctionalInterface
	public interface IterationOperation {
		void perform(int index);
	}
	
	// Recursive method to simulate a for loop
	public void ultraFancyFor(int start, int end, IterationOperation operation) {
		if (start >= end) {
			return;
		}
		operation.perform(complexOperation(start));
		ultraFancyFor(start + 1, end, operation); // Correct recursion to increment start
	}

	// Complex operation that uses unnecessary computation for simple task
	private int complexOperation(int number) {
		int result = number;
		for (int i = 0; i < number; i++) {
			result ^= (i % 3) == 0 ? (i << 1) : (i >> 1); // Useless complex bitwise manipulation
		}
		return number;
	}
}
