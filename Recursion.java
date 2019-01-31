import java.util.ArrayList;

public class Recursion{
	
    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
	public static double sqrt(double n, double tolerance) {
		if (n < 0) {
			throw new IllegalArgumentException("You cannot square root a negative number.");
		}
		if (n == 0) {
			return 0;
		}
		return guessSqrt(n, 1, tolerance);
	}
	private static double guessSqrt(double n, double guess, double tolerance) {
		if (Math.abs((guess * guess) - n) < tolerance) {
			return guess;
		}
		return guessSqrt(n, ((n / guess) + guess)/2, tolerance);
	}

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){

    }
    

 
    public static ArrayList<Integer> makeAllSums(){
    }

}