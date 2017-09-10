package thienva.bai3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * xu ly 1 luong
 * @author 
 *
 */
public class WordCount {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		String data = "";
		StringBuffer databuff = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("myfile.txt"), "UTF-8"));

		while ((data = br.readLine()) != null) {
			data = data.trim();
			databuff.append(data);
			databuff.append(" ");
		}
		String result = new String(databuff);
		while (result.indexOf("  ") != -1) {
			result = result.replace("  ", " ");
		}
//		System.out.println(result);

		String[] str = result.split(" ");
		Set<String> tmp = convert(str);

		for (String key : tmp) {
			int count = getFreq(key, str);
//			System.out.println("Count of [" + key + "] is : " + count);
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

	public static Set<String> convert(String[] str) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < str.length; i++) {
			set.add(str[i]);
		}

//		System.out.println(set);
		return set;
	}

}