package projecteuler.problem;

import java.math.BigInteger;

public class Problem21 implements Problem {

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_21";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			for (int i = 2; i < 10000; i++) {
				int sum = 1;
				for (int d = 2; d < Math.sqrt(i); d++) {
					if (i % d == 0) {
						sum += d;
						if (i / d != d)
							sum += i / d;
					}
				}
				if(i==sum)
					continue;
				int iMirror = 1;
				for (int d = 2; d < Math.sqrt(sum); d++) {
					if (sum % d == 0) {
						iMirror += d;
						if (sum / d != d)
							iMirror += sum / d;
					}
					if (iMirror > i)
						break;
				}
				if (iMirror == i)
					result = result.add(BigInteger.valueOf(i));
			}
		};
	}

}
