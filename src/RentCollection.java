import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RentCollection {
	String file = "RentCollection.txt";

	ArrayList<Rent> rents = new ArrayList<Rent>();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	public RentCollection() {
		try {
			LoadDataFromFile();
		} catch (Exception ex) {
		}
	}

	public void addRent(Rent rent) {
		rents.add(rent);
	}

	public void remove(int index) {
		rents.remove(index);
	}

	public Rent getMemberByIndex(int index) {
		return rents.get(index);
	}

	public Rent getRentByItemNameAndBorrower(String itemName, String borrower) {
		for (Rent rent : rents) {
			if (rent.getItemName().equalsIgnoreCase(itemName) && rent.getBorrowerName().equalsIgnoreCase(borrower)) {
				return rent;
			}
		}
		return null;
	}

	public int getPendingRentsbyItemName(String item) {
		int cnt = 0;

		for (Rent rent : rents) {
			if (rent.getItemName().equalsIgnoreCase(item) && rent.getStatus().equalsIgnoreCase("Issued")) {
				cnt++;
			}
		}
		return cnt;
	}

	public void printRentCollection() {
		for (Rent rent : rents) {
			System.out.print(rents.indexOf(rent) + " # ");
			rent.printRent();
		}
	}

	public ArrayList<Rent> getOverDueRents() {
		ArrayList<Rent> dued = new ArrayList<Rent>(); // store over-due rent
														// item in array list
		Date date = new Date(); // get the current date and time
		for (Rent rent : rents) {
			if (rent.getDueDate().before(date) // due date which dates are
												// before the current date
					&& rent.getStatus().equalsIgnoreCase("Issued")) {
				dued.add(rent);
			}
		}
		return dued;
	}

	public void printOverDueRents() {

		Date date = new Date();
		for (Rent rent : rents) {
			if (rent.getDueDate().before(date) && rent.getStatus().equalsIgnoreCase("Issued")) {
				rent.printRent();
			}
		}
	}

	public void saveDataToFile() {
		FileWriter writer;
		try {
			writer = new FileWriter(file);

			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			for (Rent rent : rents) {
				writer.write(rent.getStandardData());
			}
			writer.flush();
			writer.close();
			bufferedWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void LoadDataFromFile() throws IOException, ParseException {

		BufferedReader br = new BufferedReader(new FileReader(file));
		for (String line; (line = br.readLine()) != null;) {
			String[] data = line.split(",");
			Rent r = new Rent(data[0], data[1], data[2], data[3], dateFormat.parse(data[4]), dateFormat.parse(data[5]));
			// r.setStatus(data[3]);
			addRent(r);
		}
		br.close();
	}

}
