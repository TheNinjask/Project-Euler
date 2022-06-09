package projecteuler.problem;

import java.util.ArrayList;
import java.util.stream.LongStream;

public class Problem5 implements Problem {

	private long result;
	
	@Override
	public String getCommand() {
		return "problem_5";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			ArrayList<Long> bag = new ArrayList<Long>();
			result = 1L;
			for(long elem : LongStream.range(2, 21).toArray()) {
				for(long item : bag)
					if(elem%item==0)
						elem = elem/item;
				if(elem!=1)
					bag.add(elem);
			}
			for(long elem : bag)
				result *= elem;
		};
	}

}
