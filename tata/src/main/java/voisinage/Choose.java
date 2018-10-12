package voisinage;

import brick.Solution;
import brick.Solutions;

public interface Choose {
	
	/**
	 * Va générer un ensemble de solutions voisines par rapport à une solution suivant différentes méthodes
	 * @param sol
	 * @return
	 */
	public Solutions generate(Solution sol);

}
