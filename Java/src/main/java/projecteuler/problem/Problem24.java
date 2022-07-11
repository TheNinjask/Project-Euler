package projecteuler.problem;

import java.math.BigInteger;

import projecteuler.problem.ProblemUtils.Factorial;

public class Problem24 implements Problem {

	private static final int MILLIONTH = 1000000;

	private ProblemProgress progress = new ProblemProgress(20, MILLIONTH);

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_24";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Object getLoading() {
		return progress;
	}

	private static final int factorialToIndex(int factI, String stringy) {
		return stringy.length() - factI;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			String stringy = new StringBuilder("0123456789").reverse().toString();
			int i = -1;
			int curr = -1;
			Factorial fact = new Factorial() {
			};
			result = new BigInteger(stringy);
			for (i = stringy.length(), curr = fact.factorial(i); curr != MILLIONTH && i > 0; i--) {
				int j = -1;
				for (j = i; curr >= MILLIONTH && j > 0; curr -= fact.factorial(i - 1), j--) {
				}
				j++;
				curr += fact.factorial(i - 1);
				int convI = factorialToIndex(i, stringy);
				int convJ = factorialToIndex(j, stringy);
				if (convI == convJ)
					continue;
				stringy = new StringBuilder().append(stringy, factorialToIndex(stringy.length(), stringy), convI)
						.append(stringy.charAt(convJ)).append(stringy.charAt(convI)).append(stringy, convI + 1, convJ)
						.append(stringy.substring(convJ + 1)).toString();
				result = new BigInteger(stringy);
			}
		};
	}

}
