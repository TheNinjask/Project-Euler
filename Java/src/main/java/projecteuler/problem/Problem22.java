package projecteuler.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem22 implements Problem {
	
	private BigInteger result;
	
	@Override
	public String getCommand() {
		return "problem_22";
	}

	@Override
	public Object getResult() {
		return result;
	}

	private int convertChar(char c, char starting) {
		return (int)c - starting + 1;
	}
	
	@Override
	public Runnable getSolution() {
		return ()->{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(Problem22.class.getResourceAsStream("/Problem22_data.txt")));
			result = BigInteger.ZERO;
			StringBuilder builder = new StringBuilder();
			List<String> names = new ArrayList<>();
			int i;
			try {
				boolean mode = false;
				while ((i = reader.read()) != -1) {
					char c = (char)i;
					switch (c) {
					case '"':
						mode = !mode;
						if(mode)
							builder = new StringBuilder();
						else
							names.add(builder.toString());
						break;
					case ',':
						break;
					default:
						if(mode)
							builder.append(c);
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			Collections.sort(names);
			int pos = 1;
			for (String name : names) {
				int total = 0;
				for (char letter : name.toCharArray()) {
					total += convertChar(letter, 'A');
				}
				result = result.add(BigInteger.valueOf(total).multiply(BigInteger.valueOf(pos)));
				pos++;
			}
		};
	}

}
