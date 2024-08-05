package util;

public class FancyNinjaDecrementor {
	// Public static interface for broader accessibility
    public interface IterationOperation {
        void perform(int index);
    }

    // Public method to ensure it can be accessed from other packages/classes
    public void ultraFancyFor(int start, int end, IterationOperation operation) {
        if (start >= end) {
            return;
        }
        operation.perform(quantumHighLoadComputing(start));
        ultraFancyFor(start + 1, end, operation);
    }

    // Complex operation to increment the number by an additional count
    private int quantumHighLoadComputing(int number) {
        return number + 1;
    }
}
