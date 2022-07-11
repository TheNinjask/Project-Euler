package projecteuler.problem;

import java.math.BigInteger;

public class Problem25 implements Problem {

	private BigInteger result;
	
	private static final int DIGIT_AMOUNT = 1000;
	
	@Override
	public String getCommand() {
		return "problem_25";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.TWO;
			for(BigInteger x = BigInteger.ONE, y = BigInteger.ONE;  y.toString().length() < DIGIT_AMOUNT; ) {
				BigInteger tmp = y.add(x);
				x = y;
				y = tmp;
				result = result.add(BigInteger.ONE);
			}
		};
	}

}
