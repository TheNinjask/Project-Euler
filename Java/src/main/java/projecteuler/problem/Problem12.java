package projecteuler.problem;

import java.util.stream.LongStream;

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

	private long nTriangle(long n) {
		return (long) n*(n+1)/2;
	}
	
	@Override
	public Runnable getSolution() {
		return ()->{
			long minimum = 500L;
			long amount = 0L;
			result = 0;
			while(amount <= minimum) {
				result++;
				amount = 0L;
				long factor = nTriangle(result);
				long from = 1;
				long to = (long) Math.sqrt(factor);
				for(long x : LongStream.range(from, to).map(l->to-l+from-1).toArray()) {
					if(factor%x == 0)
						amount++;
				}
			}
		};
	}

}
