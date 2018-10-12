//package main;
//
//import java.util.List;
//
//import brick.Job;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Solveur {
//
//	public int penality;
//	public int total_time;
//	public Instance ins;
//
//
//	public static int order(Instance ins){
//		int penality = 0; // score de pénalité
//		int total_time = 0; // temps total exécuté
//
//		// On parcourt la liste aléatoire pour savoir comment les jobs vont être séquencés
//		for (int index=0; index<ins.size; index++) {
//			Job job = ins.jobs.get(index); // son temps d'exécution
//
//			int time = job.time;
//
//			//System.out.println(" job numéro "+index+" de durée "+job+", "+"temps total : "+total_time); // pour la forme
//			total_time += time; // on ajoute au temps total
//
//			int deadline = job.deadline;
//			int weight = job.weight;
//
//			if (deadline < total_time){ // Est-ce qu'on va avoir une pénalité
//				int tj = total_time - deadline ;
//				//System.out.println("Penalité de "+ weight * tj);
//				penality += (weight * tj); // Si oui on l'ajoute
//			}
//
//		}
//		return penality;
//	}
//
//	/**
//	 * Solveur aléatoire
//	 * @param ins
//	 * @return
//	 */
//	public static int randomGenerate(Instance ins){
//		int penality = 0; // score de pénalité
//		int total_time = 0; // temps total exécuté
//
//		// Liste d'entiers représentant les indices des jobs
//		//		ArrayList<Integer> list = new ArrayList<Integer>();
//		//		for (int i=0; i<ins.size; i++) {
//		//			list.add(new Integer(i));
//		//		}
//
//		// Qu'on mélange aléatoirement
//		Collections.shuffle(ins.jobs);
//
//		// On parcourt la liste aléatoire pour savoir comment les jobs vont être séquencés
//		for (int i=0; i<ins.size; i++) {
//			Job job = ins.jobs.get(i); // quel job va être exécuté?
//
//			int time = job.time; // son temps d'exécution
//
//			//System.out.println(" job numéro "+index+" de durée "+job+", "+"temps total : "+total_time); // pour la forme
//			total_time += time; // on ajoute au temps total
//
//			int deadline = job.deadline;
//			int weight = job.weight;
//
//			if (deadline < total_time){ // Est-ce qu'on va avoir une pénalité
//				int tj = total_time - deadline ;
//				//System.out.println("Penalité de "+ weight * tj);
//				penality += (weight * tj); // Si oui on l'ajoute
//			}
//
//		}
//		return penality;
//	}
//
//	/**
//	 * trier les jobs par ordre croissant de leurs dj. Cette heuristique s'appelle EDD (Earliest Due Date).   
//	 * @param ins
//	 * @return");
//	 */
//	public static int edd (Instance ins){
//		int penality = 0; // score de pénalité
//		int total_time = 0; // temps total exécuté
//
//		Collections.sort(ins.jobs, new Comparator<Job>() {
//
//			@Override
//			public int compare(Job o1, Job o2) {
//				return o1.time - o2.time;
//			}
//		});
//
//		for (Job j : ins.jobs) {
//
//			int time = j.time; // son temps d'exécution
//
//			//System.out.println("job numéro "+index+", "+"temps total : "+total_time); // pour la forme
//			total_time += time; // on ajoute au temps total
//
//			int deadline = j.deadline;
//			int weight = j.weight;
//
//			//System.out.println("Temps d'exécution : "+ j.time);
//			if (deadline < total_time){ // Est-ce qu'on va avoir une pénalité
//				int tj = total_time - deadline ;
//
//				//				System.out.println("Penalité de "+ weight * tj);
//				penality += (weight * tj); // Si oui on l'ajoute
//			}
//		}
//
//		return penality;
//	}
//
//	public static int mdd (Instance ins){
//		int penality = 0; // score de pénalité
//		int total_time = 0; // temps total exécuté
//
//		// 1er tri : on trie par deadline
//		Comparator<Job> comparator =  new Comparator<Job>() {
//
//			// max{C + pj , dj}
//			@Override
//			public int compare(Job o1, Job o2) {
//				return Math.max(o1.deadline, o1.total_time + o1.time) 
//						- Math.max(o2.deadline, o2.total_time + o2.time);
//			}
//		};
//
//		while (ins.jobs.size() > 0){ // tant qu'il y a encore des jobs à placer
//			
//			Collections.sort(ins.jobs, comparator); // On trie suivant les temps modifiés
//
//			Job j1 = ins.jobs.remove(0);
//
//			int job = j1.time; // son temps d'exécution
//			int deadline = j1.deadline; 
//			int weight = j1.weight;
//
//			total_time += job; // on ajoute au temps total
//
//			if (deadline < total_time){ // Est-ce qu'on va avoir une pénalité
//				int tj = total_time - deadline ;
//				penality += (weight * tj); // Si oui on l'ajoute
//			}
//			
//			// set total_time for all jobs
//			for (Job j : ins.jobs){
//				j.setTotalTime(total_time);
//			}
//		}
//		return penality;
//
//	}
//
//	/**
//	 * trier les jobs par ordre croissant de leurs échéances modifiées mddj := max{C + pj , dj} 
//	 * où C est la somme des temps d'exécution des jobs déjà ordonnancés. Cette heuristique s'appelle MDD (Modified Due Date).
//	 * @param ins
//	 * @return
//	 */
//	public static int quipue (Instance ins){
//		int penality = 0; // score de pénalité
//		int total_time = 0; // temps total exécuté
//
//		List<Job> result = new ArrayList<Job>();
//
//		// 1er tri : on trie par deadline
//		Collections.sort(ins.jobs, new Comparator<Job>() {
//
//			@Override
//			public int compare(Job o1, Job o2) {
//				return o1.deadline - o2.deadline;
//			}
//		});
//
//		while (ins.jobs.size() > 0){
//
//			Job j1 = ins.jobs.remove(0);
//
//			int job = j1.time; // son temps d'exécution
//			int deadline = j1.deadline; 
//			int weight = j1.weight;
//
//			total_time += job; // on ajoute au temps total
//
//			if (deadline < total_time){ // Est-ce qu'on va avoir une pénalité
//				int tj = total_time - deadline ;
//				penality += (weight * tj); // Si oui on l'ajoute
//			}
//
//			mySort(ins.jobs, ins.jobs.size(), total_time);
//		}
//		return penality;
//
//	}
//
//	/**
//	 * Trie seulement 2 valeurs dans la tableau, s'arrête dès que 2 valeurs ont été switch.
//	 * @param jobs
//	 * @param size
//	 * @param total_time
//	 */
//	private static void mySort(List<Job> jobs, int size, int total_time){
//		int val = -1;
//		int i1 = 0;
//		int i2 = 1;
//
//		while ((i2 < size) && (val < 0)){
//			val = switch2values(i1, i2, jobs, total_time);
//			i1++;
//			i2++;
//		}
//	}
//
//	/**
//	 * Switche 2 valeurs dans le tableau.
//	 * @param i1
//	 * @param i2
//	 * @param jobs
//	 * @param total_time
//	 * @return
//	 */
//	private static int switch2values(int i1, int i2, List<Job> jobs, int total_time){
//		if (mycompare (jobs.get(i1), jobs.get(i2), total_time ) > 0){
//			Job temp = jobs.get(i1);
//			jobs.set(i1, jobs.get(i2));
//			jobs.set(i2, temp);
//			return 1;
//		}
//		return -1;
//	}
//
//	/**
//	 * Compare 2 jobs
//	 * @param o1
//	 * @param o2
//	 * @param total_time
//	 * @return
//	 */
//	private static int mycompare(Job o1, Job o2, int total_time){
//		return Math.max(o1.deadline, total_time + o1.time) 
//				- Math.max(o2.deadline, total_time + o2.time);
//	}
//
//
//}
