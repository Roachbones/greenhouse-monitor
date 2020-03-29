package greenhouse_monitor;

import java.util.*;
import java.io.*;

public class WebpageMaker {

	public static void main(String[] args) throws IOException {
		String dataPath = "data.csv";
		String templatePath = "template.html";
		System.out.println("hello world");
		int n = 30;
		String[] data = new String[n];
		Scanner dataScanner = new Scanner(new File(dataPath));
		int i = 0;
		while (dataScanner.hasNextLine()) {
			data[i] = dataScanner.nextLine();
			i++;
		}
		dataScanner.close();
		FileWriter fw = new FileWriter("output.html");
		// todo: make this write into some kind of template
		Scanner templateScanner = new Scanner(new File(templatePath));
		fw.write("<table>");
		for (i = n - 1; i >= 0; i--) {
			String[] row = data[i].split(",");
			fw.write("<tr>");
			// todo: add colors with style attribute and tempColor/humidColor
			fw.write("<td>" + row[0] + "</td>");
			fw.write("<td>" + row[1] + "</td>");
			fw.write("<td>" + row[2] + "</td>");
			fw.write("</tr>");
		}
		fw.write("</table>");
		fw.close();
	}
	
	// todo: make these pretty and useful gradients
	public static String tempColor(int temp) {
		if (temp > 80) {
			return "#ee8888";
		}
		else if (temp < 50) {
			return "#bbc0ee";
		}
		else {
			return "#559966";
		}
	}
	public static String humidColor(int temp) {
		return "#333333";
	}

}
