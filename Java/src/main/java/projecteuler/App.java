package projecteuler;

import net.engio.mbassy.listener.Handler;
import projecteuler.problem.*;
import pt.theninjask.externalconsole.console.ExternalConsole;
import pt.theninjask.externalconsole.event.ExternalConsoleClosingEvent;

public class App {

	public static void main(String[] args) {
		//ExternalConsole.setSystemStreams();
		ExternalConsole.registerEventListener(new Object() {
			@Handler
			public void onClose(ExternalConsoleClosingEvent event) {
				System.exit(0);
			}
		});
		addProblems();
		ExternalConsole.setViewable(true);
	}
	
	private static void addProblems() {
		ExternalConsole.addCommand(new Problem1());
		ExternalConsole.addCommand(new Problem2());
		ExternalConsole.addCommand(new Problem3());
		ExternalConsole.addCommand(new Problem4());
		ExternalConsole.addCommand(new Problem5());
		ExternalConsole.addCommand(new Problem6());
		ExternalConsole.addCommand(new Problem7());
		ExternalConsole.addCommand(new Problem8());
		ExternalConsole.addCommand(new Problem9());
		ExternalConsole.addCommand(new Problem10());
		ExternalConsole.addCommand(new Problem11());
		ExternalConsole.addCommand(new Problem12());
		ExternalConsole.addCommand(new Problem13());
		ExternalConsole.addCommand(new Problem14());
		ExternalConsole.addCommand(new Problem15());
		ExternalConsole.addCommand(new Problem16());
		ExternalConsole.addCommand(new Problem17());
	}

}
