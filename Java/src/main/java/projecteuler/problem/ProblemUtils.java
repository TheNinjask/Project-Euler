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
			proc.start();
			Object[] loading = loading1;
			int i = 3;
			long start = System.currentTimeMillis();
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
		String msg = String.format("Loading %s\nTime Elapsed: %ss\nHypothesis: %s", loader,
				(System.currentTimeMillis() - start) / 1000, problem.getResult());
		ExternalConsole.println(msg);
	}

	public interface Factorial {
		
		public Map<Integer, Integer> cache = new HashMap<>();
		
		public default int factorial(int n) {
			if(n==0)
				return 1;
			Integer result = cache.get(n);
			if(result==null) {
				result = n*factorial(n-1);
				cache.put(n, result);
			}
			return result;
		}
		
	}

}
