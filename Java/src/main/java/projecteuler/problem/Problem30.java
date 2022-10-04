package projecteuler.problem;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem30 implements Problem {

	private BigInteger result;

	@Override
	public String getCommand() {
		return "problem_30";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			int cycle = 11;
			int[] digits = Arrays.stream(String.valueOf(cycle).split("")).mapToInt(Integer::parseInt).toArray();
			for (; cycle < Math.pow(9, 5)*digits.length; cycle++, digits = Arrays.stream(String.valueOf(cycle).split("")).mapToInt(Integer::parseInt).toArray()) {
				int sum = 0;
				for(int digit : digits)
					sum += digit;
				boolean skip = false;
				for(int digit : digits)
					if(sum == digit) {
						skip = true;
						break;
					}
				if(skip)
					continue;
				sum = 0;
				for(int digit : digits)
					sum += Math.pow(digit, 5);
				if(sum==cycle)
					result = result.add(BigInteger.valueOf(cycle));
					//logData(cycle, sum, digits);
			}
		};
	}
	
	/*private void logData(int cycle, int sum, int[] digits) {
		String print = String.format("%s = %s = ", 
				cycle, sum);
		for(int i=0; i<digits.length; i++)
			print += String.format("%s^5%s", digits[i], i+1==digits.length? "" : " + ");
		System.out.println(print);
	}*/

}
