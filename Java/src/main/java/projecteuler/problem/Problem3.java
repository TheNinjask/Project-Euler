package projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem3 implements Problem {

	private long result;
	
	@Override
	public String getCommand() {
		return "problem_3";
	}

	@Override
	public Object getResult() {
		return result;
	}

	/*private Object[] isPrime(long number) {
		return isPrime(number, new ArrayList<Long>(Arrays.asList(2L)));
	}*/
	
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Runnable getSolution() {
		return ()->{
			long target = 600851475143L;
			long cap = target;
			Object[] calc = new Object[] {null, new ArrayList<Long>(Arrays.asList(2L))};
			for(long elem=2; elem<target; elem++) {
				calc = isPrime(elem, (ArrayList<Long>) calc[1]);
				if((boolean)calc[0] && cap%elem==0) {
					result = elem;
					cap = cap/elem;
				}
				if(cap<elem)
					break;
			}
		};
	}

}
