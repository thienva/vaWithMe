package thienva;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Bai2 {
	public static void main(String[] args) {
		try {
			String input = readFile();
			if (input != null && !"".equals(input)) {
				List<String> inpp = Arrays.asList(input.split(" "));
				Map<String, Integer> process = new HashMap<>();
				Integer count;
				for (String str : inpp) {
					count = process.get(str);
					if (count != null) {
						process.put(str, count + 1);
						continue;
					}
					process.put(str, 1);
				}
				createResult(process);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String readFile() throws IOException, Exception {
		String everything;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line.trim());
				sb.append(" ");
				line = br.readLine();
			}
			everything = sb.toString();

		} finally {
			br.close();
		}
		return everything;
	}

	public static void createResult(Map<String, Integer> result) throws IOException, Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
		if (result == null || result.isEmpty())
			return;
		Iterator it = result.entrySet().iterator();
		while (it.hasNext()) {
			Entry pair = (Entry) it.next();
			pw.println(pair.getKey() + " : " + pair.getValue());
		}
		pw.close();
	}

}
