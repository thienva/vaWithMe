package thienva.bai3;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import thienva.Common;

/**
 * Thread, dem so lan xuat hien cua cac tu trong tung dong van ban
 * @author 
 *
 */

public class WordCountThread implements Runnable {

	private String str;
	private Map<String, Integer> result;

	public WordCountThread(String str) {
		super();
		result = new HashMap<>();
		this.str = str;
	}

	@Override
	public void run() {
		getStrFreq(str);
	}

	public void getStrFreq(String str) {

		while (str.indexOf("  ") != -1) {
			str = str.replace("  ", " ");
		}
//		System.out.println(str);

		String[] strArr = str.split(" ");
		Set<String> tmp = Common.convert(strArr);

		for (String key : tmp) {
			int count = Common.getFreq(key, strArr);
			result.put(key, count);
		}

	}

	public String getStr() {
		return str;
	}

	public Map<String, Integer> getResult() {
		return result;
	}

}
