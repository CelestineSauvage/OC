package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import brick.Job;


public class Instance
{
	public List<Job> jobs;
	//public List<Integer> j_weights;
	//public List<Integer> j_deadlines;
	
	public int jump;
	public int size;
	
	/**
	 * Représente un job
	 * @author sauvage
	 *
	 */

	public Instance (String filename, int size, int line, int nIns){
		jobs = new ArrayList<Job>();
//		List<Integer> j_weights = new ArrayList<Integer>();
//		List<Integer> j_deadlines = new ArrayList<Integer>();
		
		this.size = size;
		
		try
		{ 
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(filename);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);
			
			this.jump = line * 3;
			for (int cpt = 0 ; cpt < jump*nIns; cpt++)
				bufferedReader.readLine();

			this.readTime(bufferedReader, line);
			this.readWeight(bufferedReader, line);
            this.readDeadline(bufferedReader, line);
            
            bufferedReader.close();
            fileReader.close();
		}
		catch (Exception ex){
			System.out.println("Error reading file '"+ filename +"'");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String printJobs(){
		String s = "";
		int length = this.jobs.size();
		for (int index = 0; index < length; index++){
			s+= Integer.toString(index)+" - time : "+ Integer.toString(jobs.get(index).time)
			+ " - weight : "+ Integer.toString(jobs.get(index).weight)
			+  " - deadline : "+ Integer.toString(jobs.get(index).deadline) + "\n";
		}
		return s;
	}

	/**
	 * Parse les jobs
	 * @param bufferedReader
	 * @param line
	 * @throws Exception
	 */
	private void readTime(BufferedReader bufferedReader, int line) throws Exception {
		String read = null;
		int key = 0;
		for (int cpt = 0; cpt < line; cpt++){
			read = bufferedReader.readLine();
			String[] split = read.split(" ");
			for (int l = 0; l < split.length; l++){
				try {
					jobs.add(new Job(key,Integer.parseInt(split[l].replaceAll("[^0-9]",""))));
					key++;
				}
				catch (Exception E){}
			}
		}
	}

	/**
	 * Parse les poids
	 * @param bufferedReader
	 * @param line
	 * @throws Exception
	 */
	private void readWeight(BufferedReader bufferedReader, int line) throws Exception {
		String read = null;
		int key = 0;
		for (int cpt = 0; cpt < line; cpt++){
			read = bufferedReader.readLine();
			String[] split = read.split(" ");
			for (int l = 0; l < split.length; l++){
				try {
					jobs.get(key).setWeight(Integer.parseInt(split[l].replaceAll("[^0-9]","")));
					key++;
				}
				catch (Exception E){}
			}
		}
	}

	/**
	 * Parse les deadlines
	 * @param bufferedReader
	 * @param line
	 * @throws Exception
	 */
	private void readDeadline(BufferedReader bufferedReader, int line) throws Exception {
		String read = null;
		int key = 0;
		for (int cpt = 0; cpt < line; cpt++){
			read = bufferedReader.readLine();
			String[] split = read.split(" ");
			for (int l = 0; l < split.length; l++){
				try {
					jobs.get(key).setDeadline(Integer.parseInt(split[l].replaceAll("[^0-9]","")));
					key++;
				}
				catch (Exception E){}
			}
		}
	}
	
	/**
	 * Retourne le poids du job n°<index>
	 * @param index
	 */
	public int getWeight(int index){
		return this.jobs.get(index).weight;
	}
	
	/**
	 * Retourne le poids du job n°<index>
	 * @param index
	 */
	public int getTime(int index){
		return this.jobs.get(index).time;
	}

	
	/**
	 * Retourne le poids du job n°<index>
	 * @param index
	 */
	public int getDeadline(int index){
		return this.jobs.get(index).deadline;
	}


}
