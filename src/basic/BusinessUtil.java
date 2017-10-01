package basic;

/**
 * @author tatsuya.makibuchi
 *
 */
public class BusinessUtil {

	/**
	 * @param n
	 * @return true:is a prime number,
	 *         false: is not a prime number
	 *
	 * judge where the argument is a prime number or not.
	 */
	boolean isPrime(Integer n) {
		if(n%2 == 0){
			return false;  //is a even number
		}
		for(int i=3; i<n; i=i+2){
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
