package projecteuler.problem;

import java.util.ArrayList;

public class Problem7 implements Problem {

	private long result;
	
	@Override
	public String getCommand() {
		return "problem_7";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			long count = 0L;
			long stop = 10001L;
			long inc = 2L;
			ArrayList<Long> bag = new ArrayList<Long>();
			while(true) {
				boolean add = true;
				for (Long elem : bag)
					if(inc%elem==0) {
						add=false;
						break;
					}
				if(add) {
					bag.add(inc);
					result = inc;
					count++;
					if(count==stop)
						break;
				}
				inc++;
			}
		};
	}

}
