package projecteuler.problem;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Map;

import pt.theninjask.externalconsole.console.ExternalConsole;
import pt.theninjask.externalconsole.console.util.LoadingProcess;

public class ProblemUtils {

	private static final LoadingProcess loop = (i, loading) -> {
		return ++i == loading.length ? 3 : i;
	};

	private static final Object[] loading1 = { loop, 100, 0, "|", "/", "-", "\\" };

	public static void runTimer(Problem problem) {
		try {
			Thread proc = new Thread(problem.getSolution());
			long start = System.currentTimeMillis();
			proc.start();
			Object[] loading = loading1;
			int i = 3;
			while (proc.isAlive()) {
				printProgress(problem, start, loading, i);
				proc.join((int) loading[1]);
				i = ((LoadingProcess) loading[0]).nextLoading(i, loading);
			}
			printProgress(problem, start, loading, i);
			StringSelection selection = new StringSelection(problem.getResult().toString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printProgress(Problem problem, long start, Object[] loading, int i) {
		ExternalConsole.executeCommand("cls");
		Object loader = problem.getLoading() == null ? loading[i] : problem.getLoading();
		long ms = System.currentTimeMillis() - start;
		String msg = String.format("Loading %s\nTime Elapsed: %ss (%sms)\nHypothesis: %s", loader,
				ms / 1000, ms ,problem.getResult());
		ExternalConsole.println(msg);
	}

	public interface Factorial {

		public static final Map<Integer, Integer> cache = new HashMap<>();

		public default int factorial(int n) {
			if (n == 0)
				return 1;
			Integer result = cache.get(n);
			if (result == null) {
				result = n * factorial(n - 1);
				cache.put(n, result);
			}
			return result;
		}

	}

	public interface Prime {
		public default boolean isPrime(long number) {
			if (number <= 1)
				return false;
			else if (number < 4)
				return true;
			else if (number % 2 == 0)
				return false;
			else if (number < 9)
				return true;
			else if (number % 3 == 0)
				return false;
			else {
				double r = Math.floor(Math.sqrt(number));
				for (double f = 5; f <= r; f += 6) {
					if (number % f == 0)
						return false;
					if (number % (f + 2) == 0)
						return false;
				}
				return true;
			}
		}
	}
}
