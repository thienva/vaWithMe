package thienva.bai3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import thienva.Common;

/**
 * xu ly da luong
 * @author
 *
 */
public class Bai3 {

	public static void main(String[] args) throws Exception {
		new Bai3().count();
	}

	/**
	 * multi thread
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public void count() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));

		//khoi tao thread pool chua toi da 10 luong
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<WordCountThread> threads = new ArrayList<>();

		String data = "";
		while ((data = br.readLine()) != null) {
			data = data.trim();

			WordCountThread thread = new WordCountThread(data);
			threads.add(thread);
			executor.execute(thread);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		Map<String, Integer> result = processThread(threads);
		result = Common.sortByValue(result);
		
		Iterator it = result.entrySet().iterator();
		int i =0;
		System.out.println("10 tu xuat hien it nhat");
		while (it.hasNext() && i < 10) {
			Entry pair = (Entry) it.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
			i++;
		}
		
		result = Common.sortByValue2(result);
		it = result.entrySet().iterator();
		System.out.println("10 tu xuat hien nhieu nhat");
		i =0;
		while (it.hasNext() && i < 10) {
			Entry pair = (Entry) it.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
			i++;
		}
//		System.out.println(result);
		
	}

	/**
	 * gop ket qua cua tat ca cac thread
	 * 
	 * @param threads
	 * @return
	 */
	public Map<String, Integer> processThread(List<WordCountThread> threads) {
		Map<String, Integer> m = new HashMap<>();

		for (WordCountThread wordCountThread : threads) {
			for (Map.Entry<String, Integer> entry : wordCountThread.getResult().entrySet()) {
				String key = entry.getKey();
				int number = entry.getValue();

				if (m.containsKey(key)) {
					m.put(key, m.get(key) + number);
				} else
					m.put(key, number);
			}
		}

		return m;
	}
}
