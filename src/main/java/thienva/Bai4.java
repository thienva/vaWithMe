package thienva;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Bai4 {

	public static void main(String[] args) {
		try {
			Set<String> data = new HashSet<String>();
			createData(800, 800, 8000, 400, data);
			createData(4000, 800, 18000, 500, data);
			createData(2400, 2400, 30000, 600, data);
			List<String> dataList = data.stream().collect(Collectors.toList());
			Collections.shuffle(dataList);
			createResult(dataList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void createData(int xsource, int ysource, int quantity, int radius, Set<String> data) {
		// pitago
		Double canh = Math.sqrt(radius * radius / 2);
		canh = (double) (Math.round(canh * 1) / 1);
		int canhfinal = canh.intValue() - 1;

		int x, y;
		while (data.size() < quantity) {
			x = Common.random(-canhfinal, canhfinal);
			y = Common.random(-canhfinal, canhfinal);
			x = x + xsource;
			y = y + ysource;
			data.add(x + "," + y);
		}
	}

	public static void createResult(List<String> result) throws IOException, Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream("output4.txt"));
		if (result == null || result.isEmpty())
			return;
		for (String item : result) {
			pw.println(item);
		}
		pw.close();
	}

}
