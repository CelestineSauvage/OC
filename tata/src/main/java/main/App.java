package main;

import algo.HillClimbing;
import brick.Solution;
import initiale.*;
import selection.BImprov;
import selection.FImprov;
import selection.SelectImprov;
import voisinage.*;

/**
 * Hello world!
 *
 */
public class App
{
	public static Initiale chooseInit(int init){
		if (init == 0){
			return new Random();
		}
		else if (init == 1){
			return new HEDD();
		}
		else if (init == 2){
			return new HMDD();
		}
		else {
			System.out.println("Problème pour l'initialisation");
			return null;
		}
	}
	
	public static Choose chooseVois(int init){
		if (init == 0){
			return new Exchange();
		}
		else if (init == 1){
			return new Insert();
		}
		else if (init == 2){
			return new Swap();
		}
		else {
			System.out.println("Problème pour l'initialisation");
			return null;
		}
	}
	
	public static SelectImprov chooseSelect(int init) {
		if (init == 0){
			return new BImprov();
		}
		else if (init == 1){
			return new FImprov();
		}
		else {
			System.out.println("Problème pour l'initialisation");
			return null;
		}
	}
	
    public static void main( String[] args )
    {
        Instance mypb = new Instance("../Instances/wt100.txt", 100, 5, 0);
        
        int init = Integer.parseInt(args[0]);
        int slct = Integer.parseInt(args[1]);
        int cho = Integer.parseInt(args[2]);
        
        Initiale initiale = chooseInit(init);
        Choose choose = chooseVois(cho);
        SelectImprov sltimp = chooseSelect(slct);
        
        HillClimbing hlcl = new HillClimbing();
        
        Solution sol = hlcl.solve(mypb, initiale, sltimp, choose);
        System.out.println(sol.getPenality(mypb));
        
    }
}
