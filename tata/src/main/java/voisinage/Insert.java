package voisinage;


import brick.Solution;
import brick.Solutions;

public class Insert implements Choose {

	@Override
	public Solutions generate(Solution sol) {
		Solutions sols = new Solutions();
		int lenSol = sol.size();
		for (int i = 0; i < lenSol; i++){ // permutation de la liste d'entier par insertion (je prends i que j'insère à la position j) 
			int j = ( (i+2) % lenSol);
			while (j != i){
				sols.add(this.shift(sol, i, j));
	            j = (j+1)%lenSol;
			}
		}
		return sols;
	}

	/**
	 * Insertion, i.e., insérer un job de la position i à la position j
	 * @param sol
	 * @param i
	 * @param j
	 * @return
	 */
	private Solution shift(Solution sol, int i, int j){
		Solution newSol = sol.copy();
		int toAdd = newSol.remove(i);
		newSol.add(toAdd, j);
		return newSol;
	}

}
