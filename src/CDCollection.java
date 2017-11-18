import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CDCollection {
	String file = "CDCollection.txt";

	private ArrayList<CD> cDs = new ArrayList<CD>();

	public CDCollection() {
		try {
			LoadDataFromFile();
		} catch (Exception ex) {
		}
	}

	public void addCD(CD c) {
		cDs.add(c);
	}

	public CD getCDByIndex(int index) {
		return cDs.get(index);
	}

	public void remove(int index) {
		cDs.remove(index);
	}

	public void remove(CD cd) { //
		cDs.remove(cd); //
	}

	public CD getCDByName(String name) {
		for (CD c : cDs) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;
	}

	public void printCDCollection() {
		for (CD c : cDs) {
			System.out.print(cDs.indexOf(c) + " # ");
			c.printCD();
		}
	}

	public void saveDataToFile() throws IOException {
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		for (CD c : cDs) {
			writer.write(c.getStandardData());
		}
		writer.flush();
		writer.close();
		bufferedWriter.close();
	}

	public void LoadDataFromFile() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));
		for (String line; (line = br.readLine()) != null;) {
			String[] data = line.split(",");
			addCD(new CD(data[0], data[1], data[2], data[3], data[4], data[5], data[6], Integer.parseInt(data[7])));
		}
		br.close();
	}

}