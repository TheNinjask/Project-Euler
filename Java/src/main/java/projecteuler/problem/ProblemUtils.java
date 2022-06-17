package projecteuler.problem;

import pt.theninjask.externalconsole.console.ExternalConsole;
import pt.theninjask.externalconsole.console.LoadingProcess;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printProgress(Problem problem, long start, Object[] loading, int i) {
		ExternalConsole.executeCommand("cls");
		String msg = String.format("Loading %s\nTime Elapsed: %ss\nHypothesis: %s", loading[i],
				(System.currentTimeMillis() - start) / 1000, problem.getResult());
		ExternalConsole.println(msg);
	}

}
