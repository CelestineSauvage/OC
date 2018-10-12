package brick;

import java.util.ArrayList;
import java.util.Random;

public class Solutions {
	
	private ArrayList<Solution> sols;
	private int index;
	//private int[] parcours;
	
	public Solutions () {
		this.sols = new ArrayList<>();
		this.index = 0;
		//parcours = new Random().ints(1, 50).distinct().limit(6).toArray();
	}
	
	public int size(){
		return this.sols.size();
	}
	
	public void add (Solution toAdd){
		sols.add(toAdd);
	}
	
	public Solution next(){
		if (this.index < sols.size())
			return sols.get(this.index++);
		else
			return null;
	}
	
	public void reset(){
		this.index = 0;
	}
}
