package voisinage;

import brick.Solution;
import brick.Solutions;

public class Swap implements Choose {

	@Override
	public Solutions generate(Solution sol) {
		Solutions sols = new Solutions();
		int lenSol = sol.size();
		for (int i = 0; i < lenSol; i++){ // permutation de la liste d'entier par insertion (je prends i que j'insère à la position j) 
			for (int j = i+1; j < lenSol; j++){
				sols.add(this.swap(sol, i, j));
			}
		}
		return sols;
	}
	
	public Solution swap(Solution sol, int i, int j){
		Solution newSol = sol.copy();
		newSol.swap(i, j);
		return newSol;
	}

}
