package projecteuler.problem;

import java.math.BigInteger;

public class Problem28 implements Problem{
	
	private BigInteger result;
	
	@Override
	public String getCommand() {
		return "problem_28";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.ONE;
			for(int n=3; n<=1001;n+=2)
				for(int i=0; i<4; i++)
				result = result.add(BigInteger.valueOf(n*n - (n - 1)*i));
		};
	}

}
