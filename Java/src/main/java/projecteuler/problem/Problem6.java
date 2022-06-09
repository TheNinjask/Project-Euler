package projecteuler.problem;

public class Problem6 implements Problem {

	private long result;
	
	@Override
	public String getCommand() {
		return "problem_6";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			long val = 100L;
			result = (long) (Math.pow(val*(val+1)/2,2) - val*(val+1)*(2*val+1)/6);
		};
	}

}
