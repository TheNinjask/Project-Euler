package projecteuler.problem;

import java.math.BigInteger;

public class Problem20 implements Problem {

	private BigInteger result;
	
	@Override
	public String getCommand() {
		return "problem_20";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.ONE;
			for(int i=100; i>0; i--) {
				result = result.multiply(BigInteger.valueOf(i));
			}
			BigInteger total = BigInteger.ZERO;
			for (char digit : result.toString().toCharArray()) {
				total = total.add(BigInteger.valueOf(Character.getNumericValue(digit)));
			}
			result = total;
		};
	}

}
