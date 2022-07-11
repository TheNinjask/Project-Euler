package projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem26 implements Problem {

	private BigInteger result;
	
	@Override
	public String getCommand() {
		return "problem_26";
	}

	@Override
	public Object getResult() {
		return result;
	}

	private Object[] isPrime(long number, ArrayList<Long> primes) {
		if(number<2)
			return new Object[] {false, primes};
	    if(number==2)
	    	return new Object[] {true, primes};
	    for (Long elem : primes) {
			if(number%elem==0)
				return new Object[] {false, primes};
		}		
	    primes.add(number);
	    return new Object[] {true, primes};
	}
	
	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.ZERO;
			int size = 0;
			ArrayList<Long> primes = new ArrayList<Long>();
			for(int d=2; d<1000; d++) {
				boolean hasRecurring = (boolean) isPrime(d, primes)[0] && d!=2 && d!=5;
				if(!hasRecurring)
				for (Long prime : primes) {
					if(prime==2 || prime==5)
						continue;
					if(d%prime==0) {
						hasRecurring = true;
						break;
					}
				}
				if(!hasRecurring)
					continue;
				int recurring = 0;
				Map<Integer, Integer> rem = new HashMap<>();
				int numerator = 1;
				int denominator = d;
				for(int res = -1; res!=0;) {
					
				}
				if(size<Integer.toString(recurring).length()) {
					result = BigInteger.valueOf(d);
					size = Integer.toString(recurring).length();
				}
			}
		};
	}

}
