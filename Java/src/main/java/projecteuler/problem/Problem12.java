package projecteuler.problem;

public class Problem12 implements Problem {

	private long result;

	@Override
	public String getCommand() {
		return "problem_12";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			long minimum = 500L;
			long amount = 0L;
			result = 0;
			long inc = 1;
			while (amount < minimum) {
				result += inc;
				inc++;
				amount = 0L;
				for (long i = 1; i <= Math.sqrt(result); i++)
					if (result % i == 0)
						if (result / i == i)
							amount++;
						else
							amount += 2;
			}
		};
	}

}
