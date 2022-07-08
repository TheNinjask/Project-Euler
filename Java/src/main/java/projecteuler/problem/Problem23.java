package projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem23 implements Problem {

	private BigInteger result;
	
	private ProblemProgress progress = new ProblemProgress(20, 28123);
	
	private List<Integer> abundant = new ArrayList<>();
	
	@Override
	public String getCommand() {
		return "problem_23";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override 
	public Object getLoading() {
		return progress;
	}
	
	@Override
	public Runnable getSolution() {
		return ()->{
			result = BigInteger.ZERO;
			for(int i=1; i<=28123;i++) {
				progress.updateProgress(i);
				int sum = 1;
				for (int d = 2; d <= Math.sqrt(i); d++) {
					if (i % d == 0) {
						sum += d;
						if (i / d != d)
							sum += i / d;
					}
				}
				if(i<sum)
					abundant.add(i);
				boolean can = false;
				for (int other : abundant) {
					if(abundant.contains(i-other)) {
						can = true;
						break;
					}
				}
				if(!can)
					result = result.add(BigInteger.valueOf(i));
			}
		};
	}

}
