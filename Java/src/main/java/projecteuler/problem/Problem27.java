package projecteuler.problem;

import java.math.BigInteger;

import projecteuler.problem.ProblemUtils.Prime;

public class Problem27 implements Problem {

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_27";
	}

	@Override
	public Object getResult() {
		return result;
	}

	private long quadForm(long n, long a, long b) {
		return n * n + a * n + b;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			long biggestChain = 0;
			Prime checker = new Prime() {
			};
			for (int a = -999; a < 1000; a++) {
				for (int b = -1000; b <= 1000; b++) {
					boolean stillPrime = true;
					long primeCounter = 0;
					for (long n = 0; stillPrime; n++) {
						long formRes = quadForm(n, a, b);
						stillPrime = checker.isPrime(formRes);
						if (stillPrime)
							primeCounter++;
					}
					if(primeCounter>biggestChain) {
						biggestChain = primeCounter;
						result = BigInteger.valueOf(a*b);
					}
				}

			}

		};
	}

}
