package initiale;

import java.util.ArrayList;
import java.util.Collections;

import brick.Solution;
import main.Instance;

public class Random implements Initiale{

	@Override
	public Solution init(Instance ins) {
//		 Liste d'entiers représentant les indices des jobs
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i=0; i<ins.size; i++) {
					list.add(new Integer(i));
				}

		// Qu'on mélange aléatoirement
		Collections.shuffle(list);
		
		return new Solution(list);
	}
	
	

}
