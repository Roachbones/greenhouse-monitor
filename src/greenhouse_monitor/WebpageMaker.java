package greenhouse_monitor;

import java.util.*;
import java.io.*;

public class WebpageMaker {

	public static void main(String[] args) throws IOException {
		colorTest();
		String dataPath = "data.csv";
		String templatePath = "template.html";
		System.out.println("hello world");
		int n = 30;
		String[] dataLines = new String[n];
		Scanner dataScanner = new Scanner(new File(dataPath));
		int i = 0;
		while (dataScanner.hasNextLine()) {
			dataLines[i] = dataScanner.nextLine();
			i++;
		}
		dataScanner.close();
		FileWriter fw = new FileWriter("index.html");
		
		// write first half of template
		Scanner templateScanner = new Scanner(new File(templatePath));
		String line = null;
		while (! "<!--[[DATAROWS]]-->".equals(line)) {
			line = templateScanner.nextLine();
			fw.write(line + "\n");
		}
		
		// write data table
		for (i = n - 1; i >= 0; i--) {
			String[] row = dataLines[i].split(",");
			fw.write("<tr>");
			// todo: add colors with style attribute and tempColor/humidColor
			fw.write("<td>" + row[0] + "</td>");
			fw.write("<td>" + row[1] + "</td>");
			fw.write("<td>" + row[2] + "</td>");
			fw.write("</tr>\n");
		}
		
		// write second half of template
		while (templateScanner.hasNextLine()) {
			line = templateScanner.nextLine();
			fw.write(line + "\n");
		}
		templateScanner.close();
		
		fw.close();
	}
	
	// todo: make these pretty and useful gradients
	public static String tempColor(int temp) {
		return String.format(
				"#%02x%02x%02x",
				Math.min(255, 3 * temp), // red
				250 - Math.abs(temp - 70) * 2, // green
				Math.max(0, 255 - 2 * temp) // blue
		);
	}
	public static String humidColor(int humid) {
		return String.format(
				"#%02x%02x%02x",
				245, // red
				245 - Math.max(0, 25 - humid)*3, // green
				245 - Math.max(0, 25 - humid)*5 // blue
		);
	}
	
	public static void colorTest() throws IOException {
		String colorTestPath = "colortest.html";
		FileWriter fw = new FileWriter(colorTestPath);
		fw.write("<h1>color test</h1>");
		
		// test temperature colors
		fw.write("<h2>temperatures</h2>");
		for (int i = 0; i < 130; i++) {
			fw.write(String.format(
					"<span style='background-color:%s'>%d</span> ",
					tempColor(i), i
			));
		}
		
		// test humidity colors
		fw.write("<h2>humidities</h2>");
		for (int i = 0; i < 100; i++) {
			fw.write(String.format(
					"<span style='background-color:%s'>%d</span> ",
					humidColor(i), i
			));
		}
		
		fw.close();
	}

}
