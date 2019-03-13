package oups;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import brick.Solution;
import brick.Solutions;
import voisinage.Exchange;

public class TestExchange {


	@Test
	public void test() {
		Exchange exch = new Exchange();
		List<Integer> lint = new ArrayList<Integer>();
		lint.add(1);
		lint.add(2);
		lint.add(3);
		lint.add(4);
		lint.add(5);
		Solution sol = new Solution(lint);
		Solutions sols = exch.generate(sol);
		System.out.println("------");
		System.out.println(sols);
		fail("Not yet implemented");
	}

}
