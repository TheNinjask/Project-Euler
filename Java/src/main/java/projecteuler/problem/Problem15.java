package projecteuler.problem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem15 implements Problem {

	private BigInteger result;

	private Map<String, BigInteger> cache = new HashMap<>();
	
	@Override
	public String getCommand() {
		return "problem_15";
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public Runnable getSolution() {
		return () -> {
			result = BigInteger.ZERO;
			int x = 20;
			int y = 20;
			Object[] starting = new Object[] {x,y,null,false,false};
			Object[] quota = starting;
			do {
				if((int)quota[0]==0) {
					cache.put(String.format("%s_%s", quota[0],quota[1]), BigInteger.ONE);
					cache.put(String.format("%s_%s", quota[1],quota[0]), BigInteger.ONE);
					((Object[])quota[2])[3] = true;
					quota = (Object[]) quota[2];
				}else if((int)quota[1]==0) {
					cache.put(String.format("%s_%s", quota[0],quota[1]), BigInteger.ONE);
					cache.put(String.format("%s_%s", quota[1],quota[0]), BigInteger.ONE);
					((Object[])quota[2])[4] = true;
					quota = (Object[]) quota[2];
				}else if((boolean)quota[3] && (boolean)quota[4]) {
					if(((Object[])quota[2])[1] == quota[1])
						((Object[])quota[2])[3] = true;
					else
						((Object[])quota[2])[4] = true;
					BigInteger caching = cache.get(String.format("%s_%s", (int)quota[0]-1,quota[1]));
					caching = caching.add(cache.get(String.format("%s_%s", quota[0],(int)quota[1]-1)));
					cache.put(String.format("%s_%s", quota[0],quota[1]), caching);
					cache.put(String.format("%s_%s", quota[1],quota[0]), caching);
					quota = (Object[]) quota[2];
				}else if((int)quota[0]>0 && !((boolean)quota[3])) {
					if(cache.containsKey(String.format("%s_%s", quota[0],quota[1]))) {
						quota[3] = true;
						continue;
					}
					Object[] nextQuota = new Object[] {(int)quota[0]-1,quota[1],quota,false,false};
					quota = nextQuota;
				}else if((int)quota[1]>0 && !((boolean)quota[4])) {
					if(cache.containsKey(String.format("%s_%s", quota[0],quota[1]))) {
						quota[4] = true;
						continue;
					}
					Object[] nextQuota = new Object[] {quota[0],(int)quota[1]-1,quota,false,false};
					quota = nextQuota;
				}
			}while(quota!=starting);
			result = cache.get(String.format("%s_%s", x-1,y));
			result = result.add(cache.get(String.format("%s_%s", x,y-1)));
		};
	}

}
