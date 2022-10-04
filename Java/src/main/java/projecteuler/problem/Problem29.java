package projecteuler.problem;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 implements Problem {

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_29";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.ZERO;
			HashSet<Double> set = new HashSet<>();
			for (int a=2; a<=100;a++)
				for(int b=2; b<=100; b++) {
					set.add(Math.pow(a, b));
					result = BigInteger.valueOf(set.size());
				}	
		};
	}

}
