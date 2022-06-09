package projecteuler.problem;

import java.util.stream.IntStream;

public class Problem9 implements Problem {

	private long result;
	
	@Override
	public String getCommand() {
		return "problem_9";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			for(int partb : IntStream.range(2, 1000).toArray())
				for(int parta : IntStream.range(2, partb-1).toArray()) {
					double partc = Math.sqrt(Math.pow(parta, 2)+Math.pow(partb, 2));
					if(parta + partb + partc ==1000) {
						result = (long) (parta * partb * partc);
						return;
					}
						
				}
		};
	}

}
