package projecteuler.problem;

import java.math.BigInteger;

public class Problem16 implements Problem {

	private BigInteger result;
	
	@Override
	public String getCommand() {
		return "problem_16";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.TWO.pow(1000);
			String[] tmp = result.toString().split("");
			result = BigInteger.ZERO;
			for (String tmpy : tmp) {
				result = result.add(BigInteger.valueOf(Long.parseLong(tmpy)));
			}
		};
	}

}
