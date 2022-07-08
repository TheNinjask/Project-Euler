package projecteuler.problem;

public class ProblemProgress {

	private int progress;

	private int bar;

	private int goal;

	public ProblemProgress(int goal) {
		this(10, goal);
	}

	public ProblemProgress(int bar, int goal) {
		this.bar = bar < 0 ? 10 : bar;
		this.goal = goal;
		this.progress = 0;
	}

	public void updateProgress(int progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		StringBuilder loadbar = new StringBuilder();
		int criteria = goal / bar + goal % bar;
		for (int i = 0; i < bar; i++) {
			if (criteria > progress)
				loadbar.append(' ');
			else
				loadbar.append('|');
			criteria += goal / bar;
		}
		return String.format("[%s]", loadbar.toString());
	}

}
