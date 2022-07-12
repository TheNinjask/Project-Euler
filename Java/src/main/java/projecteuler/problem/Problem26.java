package projecteuler.problem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem26 implements Problem {

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_26";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			int size = 0;
			for (int d = 1000; d > 1 && d > size; d--) {
				Map<String, Integer> map = new HashMap<>();
				int pos = -1;
				BigInteger numerator = null;
				BigInteger[] digit_rem;
				for (pos = 0, numerator = BigInteger.ONE, digit_rem = numerator.divideAndRemainder(BigInteger
						.valueOf(d)), digit_rem[0] = digit_rem[0].mod(BigInteger.TEN); digit_rem[1].intValue() != 0
								&& !map.containsKey(
										"%s_%s".formatted(digit_rem[0], digit_rem[1])); pos++, numerator = numerator
												.multiply(BigInteger.TEN), digit_rem = numerator.divideAndRemainder(
														BigInteger.valueOf(d)), digit_rem[0] = digit_rem[0]
																.mod(BigInteger.TEN)) {
					map.put("%s_%s".formatted(digit_rem[0], digit_rem[1]), pos);
				}
				if (digit_rem[1].intValue() == 0)
					continue;
				int recurring = pos - map.get("%s_%s".formatted(digit_rem[0], digit_rem[1]));
				if (size < recurring) {
					result = BigInteger.valueOf(d);
					size = recurring;
				}
			}
		};
	}

}
