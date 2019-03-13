package stop;

import brick.Solution;
import main.Instance;

public class OptiLoc implements StopCdt {

	@Override
	public boolean stop(int k, int av, int ap) {
		return (av <= ap);
	}

}
