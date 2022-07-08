package projecteuler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.reflections.Reflections;

import net.engio.mbassy.listener.Handler;
import projecteuler.problem.Problem;
import pt.theninjask.externalconsole.console.ExternalConsole;
import pt.theninjask.externalconsole.event.ExternalConsoleClosingEvent;

public class App {

	public static void main(String[] args) {
		// ExternalConsole.setSystemStreams();
		ExternalConsole.setConsoleTitle("Project Euler's Console");
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
		Reflections reflections = new Reflections("projecteuler.problem");
		List<Class<? extends Problem>> problems = reflections.getSubTypesOf(Problem.class).stream().toList();
		try {
			for (Class<? extends Problem> problem : problems) {
				ExternalConsole.addCommand(problem.getDeclaredConstructor().newInstance());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
