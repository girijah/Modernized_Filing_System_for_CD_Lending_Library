import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Rent {

	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // DateFormat
																			// class
																			// format
																			// date
																			// using
																			// SimpleDateFormat
																			// method

	String itemName, itemType, status, borrowerName;
	Date rentedDate, dueDate;

	public Rent(String itemName, String itemType, String borrowerName) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.borrowerName = borrowerName;
		// Calculated Values
		this.status = "Issued"; // initializes the String variable status inside
								// constructor
		this.rentedDate = new Date(); // initializes rentedDate variable to
										// current time
		if (itemType.equalsIgnoreCase("Weekly")) {
			this.dueDate = addDays(rentedDate, 7);
		} else if (itemType.equalsIgnoreCase("Overnight")) {
			this.dueDate = addDays(rentedDate, 1);
		}
	}

	public Rent(String itemName, String itemType, String borrowerName, String status, Date rentedDate, Date dueDate) {
		this(itemName, itemType, borrowerName); // second constructor for the
												// class

		this.rentedDate = rentedDate;
		this.status = status;
		this.dueDate = dueDate;
	}

	public Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance(); // returns Calendar object which
												// have been initialized with
												// current date, time and also
												// location
		c.setTime(date); // sets the current Date to Calendar's time for
							// operation purpose
		c.add(Calendar.DATE, days); // Calendar.Date returns int value of the
									// date; day of the month
		return c.getTime();
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public Date getRentedDate() {
		return rentedDate;
	}

	public void setRentedDate(String rentedDate) {
		try {
			this.rentedDate = dateFormat.parse(rentedDate); // String date to
															// Date date
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public Date getDueDate() {
		return dueDate;
	}

	public String getStatus() {
		return status;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}

	public void setDueDate(String date) {
		try {
			this.dueDate = dateFormat.parse(date); // String date to Date
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public void printRent() {
		System.out.printf("    %-14s", getItemName());
		System.out.printf("    %-11s", getItemType());
		System.out.printf("    %-14s", getBorrowerName());
		System.out.printf("   %-35s", getRentedDate());
		System.out.printf("%-35s", getDueDate());
		System.out.printf("%-15s", getStatus());
		System.out.println();
	}

	public String getStandardData() {
		return itemName + "," + itemType + "," + borrowerName + "," + status + "," + dateFormat.format(rentedDate) + "," + dateFormat.format(dueDate) + String.format("%n");
	}

}
