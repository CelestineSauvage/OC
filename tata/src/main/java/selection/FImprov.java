package selection;

import brick.Solution;
import brick.Solutions;
import main.Instance;

/**
 * Sélectionne la première solution améliorante
 * @author sauvage
 *
 */
public class FImprov implements SelectImprov{

	@Override
	public Solution select(Instance ins, Solutions solutions, Solution best, int penality) {
		Solution maybe = null; // Peut-être la meilleure solution ?
		while((maybe = solutions.next()) != null){ // On parcourt l'ensemble des solutions (aka les voisins d'une solution générés avec voisinage)
			if (maybe.getPenality(ins) < penality) // Si on a un meilleur score
				return maybe; // on retourne
		}
		return null;
	}



}
