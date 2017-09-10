package thienva;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Common {
	public static int random(int min, int max) {
		try {
			Random rd = new Random();
			int rang = max - min + 1;
			return min + rd.nextInt(rang);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int getFreq(String str, String[] arrStr) {
		int count = 0;
		for (String key : arrStr)
			if (key.equals(str)) {
				count++;
			}

		return count;
	}

	/**
	 * chuyen array sang set
	 * 
	 * @param str
	 * @return
	 */
	public static Set<String> convert(String[] str) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < str.length; i++) {
			set.add(str[i]);
		}

		// System.out.println(set);
		return set;
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}


	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue2(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return -(o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
