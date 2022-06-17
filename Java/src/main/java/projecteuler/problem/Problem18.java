package projecteuler.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem18 implements Problem {

	private BigInteger result;

	private Map<String, BigInteger> cache = new HashMap<>();

	private Map<String, BigInteger> pyramid = new HashMap<>();

	private int pyramidSize;

	@Override
	public String getCommand() {
		return "problem_18";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			// 1. Transform data into a easy to handle format
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(Problem18.class.getResourceAsStream("/Problem18_data.txt")));
			String line;
			int iLine = 0;
			try {
				while ((line = reader.readLine()) != null) {
					int iPos = 0;
					for (String num : line.split(" ")) {
						pyramid.put(String.format("%s_%s", iLine, iPos), new BigInteger(num));
						iPos++;
					}
					iLine++;
				}
				pyramidSize = iLine;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			// 2. Actual Sol
			for (int height = pyramidSize - 1; height >= 0; height--) {
				for (int i = 0; i <= height; i++) {
					if (height + 1 == pyramidSize)
						cache.put(String.format("%s_%s", height, i), pyramid.get(String.format("%s_%s", height, i)));
					else {
						BigInteger left = cache.get(String.format("%s_%s", height+1, i));
						BigInteger right = cache.get(String.format("%s_%s", height+1, i+1));
						if(left.compareTo(right) > 0)
							cache.put(String.format("%s_%s", height, i), pyramid.get(String.format("%s_%s", height, i)).add(left));
						else
							cache.put(String.format("%s_%s", height, i), pyramid.get(String.format("%s_%s", height, i)).add(right));
					}
				}
			}
			result = cache.get(String.format("%s_%s", 0,0));
		};
	}

}
