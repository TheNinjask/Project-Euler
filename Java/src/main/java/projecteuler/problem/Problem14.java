package projecteuler.problem;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem14 implements Problem {

	private BigInteger[] result;
	
	@Override
	public String getCommand() {
		return "problem_14";
	}

	@Override
	public Object getResult() {
		return result[1];
	}

	private BigInteger[] collatzSequence(BigInteger start, HashMap<BigInteger, BigInteger> bag) {
		BigInteger i = start;
		BigInteger chain = BigInteger.ONE;
		while(i.compareTo(BigInteger.ONE)!=0) {
			if(i.remainder(BigInteger.TWO).compareTo(BigInteger.ZERO)==0) {
				i = i.divide(BigInteger.TWO);
			}else {
				i = i.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
			}
			if(bag.containsKey(i)) {
				chain = chain.add(bag.get(i));
				bag.put(start, chain);
				return new BigInteger[] {chain, start};
			}
			chain = chain.add(BigInteger.ONE);
		}
		bag.put(start, chain);
		return new BigInteger[] {chain, start};
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			HashMap<BigInteger, BigInteger> bag = new HashMap<BigInteger, BigInteger>();
			bag.put(BigInteger.ONE, BigInteger.ONE);
			result = new BigInteger[] {BigInteger.ONE, BigInteger.ONE};
			BigInteger cap = new BigInteger("1000000");
			for(BigInteger i = BigInteger.TWO; i.compareTo(cap)<0 ;i = i.add(BigInteger.ONE)) {
				BigInteger[] output = collatzSequence(i, bag);
				if(result[0].compareTo(output[0])<0)
					result = output;
			}
		};
	}

}
