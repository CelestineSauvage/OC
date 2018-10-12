package brick;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.Instance;

/**
 * Classe représentant UNE SEULE solution. Dans notre cas : une solution est un ensemble de jobs ordonnancés. On associe un score de pénalité à chaque solution
 * @author sauvage
 *
 */
public class Solution {
	
	public List<Integer> solution;
	
	/**
	 * Solution vide, pas encore construite
	 */
	public Solution(){
		this.solution = new ArrayList<Integer>();
	}
	
	/**
	 * Solution avec déjà une liste, mais pas de pénalité (peut-être différent d'une array list)
	 * @param solution
	 */
	public Solution(List<Integer> solution){
		this.solution = solution;
	}
	
	public int size(){
		return this.solution.size();
	}
	
	/**
	 * Retourne la pénalité lié à une solution : F(O) := ∑j=1,...,n wj . Tj  =   w1 . T1 + w2 . T2 + ... + wn . Tn 
	 * @param ins
	 * @return
	 */
	public int getPenality(Instance ins){
		int pen = 0;
		int total_time = 0;
		Iterator<Integer> it = this.solution.iterator();
		while (it.hasNext()){
			int job = it.next();
			int time = ins.getTime(job); // son temps d'exécution
			
			total_time += time;
			int deadline = ins.getDeadline(job); // son temps d'exécution
			
			if (deadline < total_time){
				int tj = total_time - deadline;
				int weight = ins.getWeight(job); // son temps d'exécution
				//System.out.println("Penalité de "+ weight * tj);
				pen+= (weight * tj); // Si oui on l'ajoute
			}
		}
		return pen;
	}
	
	public int remove(int i){
		return this.solution.remove(i);
	}
	
	public void add(int toAdd, int i){
		this.solution.add(i, toAdd);
	}
	
	public int get(int i){
		return this.solution.get(i);
	}
	
	public Solution copy(){
		return new Solution(this.solution);
	}

}
//for (int i=0; i<ins.size; i++) {
//	Job job = ins.jobs.get(i); // quel job va être exécuté?
//
//	int time = job.time; // son temps d'exécution
//
//	//System.out.println(" job numéro "+index+" de durée "+job+", "+"temps total : "+total_time); // pour la forme
//	total_time += time; // on ajoute au temps total
//
//	int deadline = job.deadline;
//	int weight = job.weight;
//
//	if (deadline < total_time){ // Est-ce qu'on va avoir une pénalité
//		int tj = total_time - deadline ;
//		//System.out.println("Penalité de "+ weight * tj);
//		penality += (weight * tj); // Si oui on l'ajoute
//	}