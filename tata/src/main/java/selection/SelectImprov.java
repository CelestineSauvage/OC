package selection;

import brick.Solution;
import brick.Solutions;
import main.Instance;

/**
 * Sélectionne une solution selon un certain critère
 * @author sauvage
 *
 */
public interface SelectImprov {

	/**
	 * Sélectionne la meilleure solution parmi les voisins
	 * @param ins : l'instance du problème
	 * @param solutions : l'ensemble des solutions
	 * @param best : la meilleure solution actuelle
	 * @param penality : penalité
	 * @return
	 */
	public Solution select(Instance ins, Solutions solutions, Solution best, int penality);
}
