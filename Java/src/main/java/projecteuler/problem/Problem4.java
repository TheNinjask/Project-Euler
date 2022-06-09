package projecteuler.problem;

public class Problem4 implements Problem {

	private long result;

	@Override
	public String getCommand() {
		return "problem_4";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = 0L;
			for (long plusle = 999L; plusle > 100L; plusle--) {
				for (long minun = 999L; plusle > 100L; minun--) {
					Object val = plusle * minun;
					if (result >= (long) val)
						break;
					val = Long.toString((long) val);
					if (((String) val).length() % 2 == 0) {
						String part1 = ((String) val).substring(0, ((String) val).length() / 2);
						String part2 = new StringBuilder(((String) val).substring(((String) val).length() / 2))
								.reverse().toString();
						if (part1.equals(part2))
							result = Long.parseLong((String) val);
					} else {
						String part1 = ((String) val).substring(0, ((String) val).length() / 2);
						String part2 = new StringBuilder(((String) val).substring(((String) val).length() / 2 + 1))
								.reverse().toString();
						if (part1.equals(part2))
							result = Long.parseLong((String) val);
					}
				}
			}
		};
	};
}