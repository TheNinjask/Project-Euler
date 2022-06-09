package projecteuler.problem;

public class Problem2 implements Problem {

	private int sum_even;
	
	@Override
	public String getCommand() {
		return "problem_2";
	}

	@Override
	public Object getResult() {
		return sum_even;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			int cap = 4000000;
			sum_even = 2;
			int	first = 1;
			int second = 2;
			while(second<cap) {
				int tmp = first+second;
				first = second;
				second = tmp;
				if (tmp%2==0)
					sum_even +=tmp;
			}
		};
	}

}
