package initiale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import brick.Job;
import brick.Solution;
import brick.Solutions;
import main.Instance;

public class HMDD implements Initiale {

	@Override
	public Solution init(Instance ins) {
		return this.mdd(ins);
	}
	
	private Solution mdd (Instance ins){
		int total_time = 0; // temps total exécuté
		
		Solution sol = new Solution();
		
		ArrayList<Job> listJobs = new ArrayList<Job>();
		for (int i=0; i<ins.size; i++) {
			listJobs.add(ins.jobs.get(i).copy());
		}
		
		while (listJobs.size() > 0){ // tant qu'il y a encore des jobs à placer
			
			Collections.sort(listJobs, new DynamicJobComparator(total_time)); // On trie suivant les temps modifiés

			Job j1 = listJobs.remove(0);

			sol.addJob(j1.index);
			int job = j1.time; // son temps d'exécution

			total_time += job; // on ajoute au temps total

		}
		return sol;

	}
	
	private static class DynamicJobComparator implements Comparator<Job>{
		
		private int compareBy = 0;
		
		public DynamicJobComparator(int compareBy) {
	        this.compareBy = compareBy;
	    }

		@Override
		public int compare(Job o1, Job o2) {
			return Math.max(o1.deadline, this.compareBy + o1.time) 
					- Math.max(o2.deadline, this.compareBy + o2.time);
		}
		
	}

}
