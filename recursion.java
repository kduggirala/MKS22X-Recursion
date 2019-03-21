import java.util.ArrayList;

public class recursion{
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			testFib(i);
		}
		for (int j = 0; j < 5; j++) {
			testSqrt(j);
		}
	}
	public static boolean closeEnough(double a, double b){
	    if(a==0.0 && b==0.0)return true;
	    if(a==0.0)return b < 0.00000000001;
	    if(b==0.0)return a < 0.00000000001;
	    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

	}


	//testcase must be a valid index of your input/output array
	public static void testFib(int testcase){
	  recursion r = new recursion();
	  int[] input = {0,1,2,3,5,30};
	  int[] output ={0,1,1,2,5,832040};
	  int max = input.length;
	  if(testcase < input.length){
	    int in = input[testcase];
	    try{
	     
	      int ans = r.fib(in);
	      int correct = output[testcase];
	      if(ans == correct){
	        System.out.println("PASS test fib "+in+". "+correct);
	      }
	      else{
	        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);
	       
	      }
	    }catch(IllegalArgumentException n){
	      if(in < 0){
	        System.out.println("PASS test fib"+in+" IllegalArgumentException");
	      }else{
	        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
	      }
	    }catch(Exception e){
	      System.out.println(" FAIL Some exception in test case:"+in);
	    }
	  }
	}


	//testcase must be a valid index of your input/output array
	public static void testSqrt(int testcase){
	  recursion r = new recursion();
	  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
	  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
	  int max = input.length;
	  if(testcase < input.length){
	    double in = input[testcase];
	    try{
	     
	      double ans = r.sqrt(in,.00001);
	      double correct = Math.sqrt(in);
	      if(closeEnough(ans,correct)){
	        System.out.println("PASS test sqrt "+in+" "+ans);
	      }
	      else{
	        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);
	       
	      }
	    }catch(IllegalArgumentException n){
	      if(in < 0){
	        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
	      }else{
	        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
	      }
	    }catch(Exception e){
	      System.out.println(" FAIL Some exception in test case:"+in);
	    }
	  }
	}
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
     *fib(0) = 0; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
    	if (n < 0) {
    		throw new IllegalArgumentException("There are no negative fibonnaci numbers.");   
    	}
    	return fibHelp(n, 0, 1, 0);
    }
    private static int fibHelp(int n, int a, int b, int i) {
    	if (i == n) {
    		return a;
    	}
    	return fibHelp(n, b, a+b, i+1);
    }

 
    public static ArrayList<Integer> makeAllSums(int n){
    	ArrayList<Integer> allSums = new ArrayList<Integer>();
    	if (n < 0) {
    		makeAllSumsHelp(-n, 0, allSums);
    	}
    	else {
    		makeAllSumsHelp(n, 0, allSums);
    	}
    	//If n < 0, make all elements negative
    	if (n < 0) {
    		ArrayList<Integer> negativeInts = new ArrayList<Integer>();
    		for (Integer i : allSums) {
    			negativeInts.add(-1 * i);
    		}
    		allSums = negativeInts;
    	}
    	return allSums;
    }
    private static void makeAllSumsHelp(int n, int sum, ArrayList<Integer> l) {
    	if (n == 0) {
    		l.add(sum);
    	}
    	else {
    		makeAllSumsHelp(n - 1, sum, l);
    		makeAllSumsHelp(n - 1, sum + n, l);
    	}
    }
}
