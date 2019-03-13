package algo;

import java.util.List;

import brick.Solution;
import brick.Solutions;
import initiale.Initiale;
import main.Instance;
import selection.SelectImprov;
import voisinage.Choose;

public class VNDRand {
	
	public Solution solve(Instance ins, Initiale solInit, SelectImprov slct, List<Choose> choose){
		// Solution initiale
		Solution sol = solInit.init(ins);
		int penal = sol.getPenality(ins);
		Solutions nS = null; 
		Solution newSol = null;
		
		int i = (int)(Math.random() * ( choose.size())); // liste aléatoire pour le VND
		// Tant que on trouve une nouvelle solution meilleure
		do {
			nS = choose.get(i).generate(sol);
			newSol = slct.select(ins, nS, sol, penal);
			if (newSol != null){
				sol = newSol;
				penal = newSol.getPenality(ins);
			}
			else 
				i = (int)(Math.random() * ( choose.size()));
		} while(i < choose.size());
		return sol;
	}

}
