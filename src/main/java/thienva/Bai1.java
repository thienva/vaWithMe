package thienva;

import java.util.*;
import java.util.stream.Collectors;

public class Bai1 {
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		try {
			Set<Integer> set1 = getData();
			Set<Integer> set2 = getData();
			Set<Integer> union = new HashSet<Integer>();
			union.addAll(set1);
			union.addAll(set2);
			List<Integer> intersect = union.stream().filter(x -> set2.contains(x)).collect(Collectors.toList());

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("time : " + (System.currentTimeMillis() - t));
    }
	
	public static Set getData() {
		 Set<Integer> set = new HashSet<Integer>();
		 while (set.size() < 200000) {
			 set.add(Common.random(0, 9999999));
		 }
		 return set;
	}
 
    
}
