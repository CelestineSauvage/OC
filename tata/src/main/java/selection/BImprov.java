package selection;

import brick.Solution;
import brick.Solutions;
import main.Instance;

public class BImprov implements SelectImprov {

	@Override
	public Solution select(Instance ins, Solutions solutions, Solution best, int penality) {
		Solution maybe = null; // Peut-être la meilleure solution ?
		Solution real = null;
		int realPenality = penality;
		while((maybe = solutions.next()) != null){ // On parcourt l'ensemble des solutions (aka les voisins d'une solution générés avec voisinage)
			int maybePenality = maybe.getPenality(ins); 
			if (maybePenality < realPenality){ // Si on a un meilleur score
				real = maybe; // on stocke
				realPenality = maybePenality;
			}
		}
		return real;
	}

}
