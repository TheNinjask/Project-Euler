package projecteuler.problem;

import pt.theninjask.externalconsole.console.ExternalConsoleCommand;

public interface Problem extends ExternalConsoleCommand{

	public default int executeCommand(String... args) {
		ProblemUtils.runTimer(this);
		return 0;
	}
	
	public Object getResult();
	
	public Runnable getSolution();
	
}
