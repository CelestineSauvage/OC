package voisinage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import brick.Solution;
import brick.Solutions;

public class Exchange implements Choose {

	@Override
	public Solutions generate(Solution sol) {
		Solutions sols = new Solutions();
		int lenSol = sol.size();
		for (int i = 0; i < lenSol; i++){ // permutation de la liste d'entier par insertion (je prends i que j'insère à la position j) 
			sols.add(this.swap(sol, i, ((i+1)%lenSol)));
		}
		return sols;
	}

	public Solution swap(Solution sol, int i, int j){
		Solution newSol = sol.copy();
		newSol.swap(i, j);
		return newSol;
	}
}
