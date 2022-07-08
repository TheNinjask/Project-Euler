package projecteuler.problem;

import java.math.BigInteger;
import java.util.stream.IntStream;

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

	private static final String convertInt(BigInteger i) {
		String data = i.toString();
		if (data.length() < 10)
			data = "0" + data;
		return data;
	}

	private boolean legit = true;

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			BigInteger start = new BigInteger("0123456789");
			for (int i = 0; i < MILLIONTH; start = start.add(BigInteger.valueOf(9)),progress.updateProgress(i)) {
				String data = convertInt(start);
				legit = true;
				IntStream.range(0,10).forEach(num->{
					if(data.indexOf(Character.forDigit(num, 10))==-1)
						legit = false;
				});
				if(!legit)
					continue;
				i++;
				result = start;
			}
		};
	}

}
