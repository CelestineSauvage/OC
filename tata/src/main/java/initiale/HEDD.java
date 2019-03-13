package initiale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import brick.Job;
import brick.Solution;
import brick.Solutions;
import main.Instance;

public class HEDD implements Initiale {

	@Override
	public Solution init(Instance ins) {
		return this.edd(ins);
	}

	/**
	 * trier les jobs par ordre croissant de leurs dj. Cette heuristique s'appelle EDD (Earliest Due Date).   
	 * @param ins
	 * @return");
	 */
	public Solution edd (Instance ins){
		int total_time = 0; // temps total exécuté

		Solution sol = new Solution();
		
		ArrayList<Job> listJobs = new ArrayList<Job>();
		for (int i=0; i<ins.size; i++) {
			listJobs.add(ins.jobs.get(i).copy());
		}

		Collections.sort(listJobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o1.time - o2.time;
			}
		});

		for (Job j : listJobs){ // tant qu'il y a encore des jobs à placer

			sol.addJob(j.index);
			int job = j.time; // son temps d'exécution

			total_time += job; // on ajoute au temps total

		}
		return sol;

	}

}
