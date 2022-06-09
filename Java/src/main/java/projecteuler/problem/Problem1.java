package projecteuler.problem;

public class Problem1 implements Problem{

	private int sum;
	
	@Override
	public String getCommand() {
		return "problem_1";
	}

	@Override
	public Object getResult() {
		return sum;
	}

	@Override
	public Runnable getSolution() {
		return ()->{
			boolean done3 = false;
			boolean done5 = false;
			int mult = 1;
			while(!done3 || !done5) {	
			    if(!done3) {
			    	int mult3 = 3*mult;
			    	if(mult3 >= 1000)
			    		done3 = true;
			    	else
			    		sum += mult3;		    	
			    }
			    if(!done5 && !(mult%3==0)) {
			    	int mult5 = 5*mult;
			    		if (mult5 >= 1000)
			    			done5 = true;
			    		else
			    			sum += mult5;
			    }
			    mult += 1;
			}
		};
	}

}
