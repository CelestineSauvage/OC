package algo;

import brick.Solution;
import brick.Solutions;
import initiale.Initiale;
import main.Instance;
import selection.SelectImprov;
import stop.StopCdt;
import voisinage.Choose;

public class HillClimbing {
	
	/**
	 * algorithme de descente en jouant sur différents 'paramètres'
	 * @param ins
	 * @param solInit Solution initiale
	 * @param slct stratégie de sélection
	 * @param choose Choix du voisinage
	 */
	public Solution solve(Instance ins, Initiale solInit, SelectImprov slct, Choose choose){
		Solution sol = solInit.init(ins);
		int penal = sol.getPenality(ins);
		System.out.println(penal);
		Solutions nS = null; 
		Solution newSol = null;
		boolean arret = true;
		do {
			nS = choose.generate(sol);
			newSol = slct.select(ins, nS, sol, penal);
			if (newSol != null){
				sol = newSol;
				penal = newSol.getPenality(ins);
			}
			else 
				arret = false;
		} while(arret);
		return sol;
	}

}
