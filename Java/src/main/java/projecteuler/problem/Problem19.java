package projecteuler.problem;

import java.math.BigInteger;

public class Problem19 implements Problem {

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_19";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			int time = 365;
			for (int y = 1901; y <= 2000; y++) {
				for (int m = 1; m <= 12; m++) {
					switch (m) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						if (time % 7 == 6)
							result = result.add(BigInteger.ONE);
						time += 31;
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						if (time % 7 == 6)
							result = result.add(BigInteger.ONE);
						time += 30;
						break;
					case 2:
						int day = 28;
						if (y % 4 == 0 && (!(y % 100 == 0) || y % 400 == 0))
							day++;
						if (time % 7 == 6)
							result = result.add(BigInteger.ONE);
						time += day;
						break;
					default:
						result = BigInteger.valueOf(-1);
						return;
					}
				}
			}
		};
	}

}
