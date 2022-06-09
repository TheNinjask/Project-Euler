package projecteuler.problem;

import java.util.ArrayList;
import java.util.stream.LongStream;

public class Problem10 implements Problem {

	private long result;

	@Override
	public String getCommand() {
		return "problem_10";
	}

	@Override
	public Object getResult() {
		return result;
	}

	/*private Object[] isPrime(long number) {
		return isPrime(number, new ArrayList<Long>());
	}*/

	private Object[] isPrime(long number, ArrayList<Long> primes) {
		if (number == 1)
			return new Object[] { false, primes };
		else if (number < 4) {
			primes.add(number);
			return new Object[] { true, primes };
		} else if (number % 2 == 0)
			return new Object[] { false, primes };
		else if (number < 9) {
			primes.add(number);
			return new Object[] { true, primes };
		} else if (number % 3 == 0)
			return new Object[] { false, primes };
		else {
			double r = Math.floor(Math.sqrt(number));
			for (double f = 5; f <= r; f += 6) {
				if (number % f == 0)
					return new Object[] { false, primes };
				if (number % (f + 2) == 0)
					return new Object[] { false, primes };
			}
			primes.add(number);
			return new Object[] { true, primes };
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Runnable getSolution() {
		return () -> {
			long target = 2000000L;
			result = 0L;
			Object[] calc = new Object[] { null, new ArrayList<Long>() };
			for (long elem : LongStream.range(2, target).toArray()) {
				calc = isPrime(elem, (ArrayList<Long>) calc[1]);
				if ((boolean) calc[0])
					result += elem;
			}
		};
	}

}
