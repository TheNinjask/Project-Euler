package projecteuler.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem13 implements Problem {

	private BigInteger result;
	
	@Override
	public String getCommand() {
		return "problem_13";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.valueOf(0);
			BufferedReader reader = new BufferedReader(new InputStreamReader(Problem13.class.getResourceAsStream("/Problem13_data.txt")));
			String line;
			try {
				while((line = reader.readLine())!=null) {
					result = result.add(new BigInteger(line));
				}
				BigInteger val = BigInteger.valueOf(10).pow(result.toString().length()-10);
				result = result.divide(val);
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}

}
