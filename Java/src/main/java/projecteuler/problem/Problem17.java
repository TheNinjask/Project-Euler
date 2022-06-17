package projecteuler.problem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem17 implements Problem {

	private BigInteger result;

	private static final BigInteger AND = BigInteger.valueOf("AND".length());
	
	private Map<Integer, BigInteger> cache = new HashMap<>();
	
	private Map<Integer, String> intToWord = Map.ofEntries(Map.entry(1, "one"), Map.entry(2, "two"),
			Map.entry(3, "three"), Map.entry(4, "four"), Map.entry(5, "five"), Map.entry(6, "six"),
			Map.entry(7, "seven"), Map.entry(8, "eight"), Map.entry(9, "nine"), Map.entry(10, "ten"),
			Map.entry(11, "eleven"), Map.entry(12, "twelve"), Map.entry(13, "thirteen"), Map.entry(14, "fourteen"),
			Map.entry(15, "fifteen"), Map.entry(16, "sixteen"), Map.entry(17, "seventeen"), Map.entry(18, "eighteen"),
			Map.entry(19, "nineteen"), Map.entry(20, "twenty"), Map.entry(30, "thirty"), Map.entry(40, "forty"),
			Map.entry(50, "fifty"), Map.entry(60, "sixty"), Map.entry(70, "seventy"), Map.entry(80, "eighty"),
			Map.entry(90, "ninety"), Map.entry(100, "%shundred"), Map.entry(1000, "%sthousand"));

	@Override
	public String getCommand() {
		return "problem_17";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			for (int i = 1; i <= 1000; i++) {
				if (i < 20) {
					BigInteger size = BigInteger.valueOf(intToWord.get(i).length());
					cache.put(i, size);
					result = result.add(size);
				} else if (i < 100) {
					int tenth = (i / 10) * 10;
					BigInteger size = BigInteger.valueOf(intToWord.get(tenth).length());
					int unit = i % 10;
					if (unit != 0)
						size = size.add(cache.get(unit));
					cache.put(i, size);
					result = result.add(size);
				} else if(i < 1000) {
					BigInteger size = BigInteger.valueOf(String.format(intToWord.get(100), intToWord.get(i/100)).length());
					int unit = i % 100;
					if (unit != 0)
						size = size.add(cache.get(unit).add(AND));
					cache.put(i, size);
					result = result.add(size);
				} else if(i < 10000) {
					BigInteger size = BigInteger.valueOf(String.format(intToWord.get(1000), intToWord.get(i/1000)).length());
					int unit = i % 1000;
					if (unit != 0)
						size = size.add(cache.get(unit).add(AND));
					cache.put(i, size);
					result = result.add(size);
				}
			}
		};
	}

}
