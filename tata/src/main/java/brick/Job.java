package brick;

public class Job {
	
	public int index; // Sa position dans l'instance
	public int time; // Son temps d'execution
	public int deadline; // Sa deadline
	public int weight; // Son poids
	//public int total_time; // Le temps total actuel
	
	/**
	 * Décrit un job
	 * @param index
	 * @param time
	 */
	public Job (int index, int time){
		this.index = index;
		this.time = time;
		this.deadline = 0;
		this.weight = 0;
		//this.total_time = 0;
	}
	
	public Job (int index, int time, int deadline, int weight){
		this.index = index;
		this.time = time;
		this.deadline = deadline;
		this.weight = weight;
		//this.total_time = 0;
	}
	
	public Job copy(){
		return new Job(this.index, this.time, this.deadline, this.weight);
	}
	
	public void setDeadline (int deadline){
		this.deadline = deadline;
	}
	
	public void setWeight (int weight){
		this.weight = weight;
	}
//	
//	public void setTotalTime (int total_time){
//		this.total_time = total_time;
//	}
//	
//	public void addTotalTime (int plus_time){
//		this.total_time += plus_time;
//	}
}
