package Exercise2;

public class InvalidRangeException {
    /*
   What it does: Creates a special error type for when numbers are outside your range
   Why: Java needs to know what kind of error to throw when the number is too big or too small
    */
    // Custom exception class
    static class OutOfRangeException extends Exception {
        public OutOfRangeException(String message) {
            super(message);
        }
    }
}
