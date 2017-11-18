import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CDUniverse {

	CDCollection cDCollection = new CDCollection();
	MemberCollection memberCollection = new MemberCollection();
	RentCollection rentCollection = new RentCollection();

	Scanner scan = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);
	String input, obsoleteInput;

	public void case1() {
		do {
			System.out.println("Enter data for a new CD\nEnter Language: ");
			String input1 = scan.nextLine();
			System.out.println("Enter Album: ");
			String input2 = scan.nextLine();
			System.out.println("Enter Name: ");
			String input3 = scan.nextLine();
			System.out.println("Enter Composer: ");
			String input4 = scan.nextLine();
			System.out.println("Enter Artist: ");
			String input5 = scan.nextLine();
			System.out.println("Enter Year: ");
			String input6 = scan.nextLine();
			System.out.println("Enter Tracks per CD: ");
			String input7 = scan.nextLine();
			System.out.println("Enter No of CD Collections: ");
			String input8 = scan.nextLine();

			cDCollection.addCD(new CD(input1, input2, input3, input4, input5, input6, input7, Integer.parseInt(input8)));
			System.out.println("If completed feeding, type OK, To add more ENTER");
			input = scan.nextLine();

		} while (!input.equalsIgnoreCase("OK"));

		try {
			cDCollection.saveDataToFile();
		} catch (Exception ex) {
		}
		cDCollection.printCDCollection();
	}

	public void case2() {
		String user_Input;
		do {

			System.out.println("Enter data for a new member\nEnter Borrower Name: ");
			String userInput1 = scan.nextLine();
			System.out.println("Enter Borrower Address: leave spaces to seperate segments");
			String userInput2 = scan.nextLine();
			System.out.println("Enter Mobile Number: ");
			String userInput3 = scan.nextLine();

			memberCollection.addMember(new Member(userInput1, userInput2, userInput3));
			System.out.println("If completed feeding, type OK, To add more ENTER");
			user_Input = scan.nextLine();

		} while (!user_Input.equalsIgnoreCase("OK"));

		try {
			memberCollection.saveDataToFile();
		} catch (Exception ex) {
		}

		memberCollection.printMemberCollection();
	}

	public void case3() {
		String userInput;
		do {
			System.out.println("Add a new Rental\nEnter ItemName: ");
			String userInput4 = scan.nextLine();

			int rentcnt = rentCollection.getPendingRentsbyItemName(userInput4);
			int cdcnt = cDCollection.getCDByName(userInput4).getNoOfCds();

			if (rentcnt < cdcnt) {

				System.out.println("Enter Rental Type Weekly or Overnight: ");
				String userInput5 = scan.nextLine();

				System.out.println("Enter Borrower Name: ");
				String userInput7 = scan.nextLine();

				System.out.println("Enter Rented Date: dd-MM-yyyy HH:mm:ss");
				String rentedInput = scan.nextLine();

				System.out.println("Enter Due Date: dd-MM-yyyy HH:mm:ss ");
				String dueInput = scan.nextLine();

				Rent r = new Rent(userInput4, userInput5, userInput7);
				r.setRentedDate(rentedInput);
				r.setDueDate(dueInput);

				rentCollection.addRent(r);
			} else {
				System.out.println("All " + userInput4 + " CDs are rented out.");
			}

			System.out.println("If Completed Rentals, Type OK, To add more ENTER");
			userInput = scan.nextLine();

		} while (!userInput.equalsIgnoreCase("OK"));

		try {
			rentCollection.saveDataToFile();
		} catch (Exception ex) {
		}

		rentCollection.printRentCollection();
	}

	public void case4(){
		System.out.print("Enter the item name:");
		String iName = scan.nextLine();
		System.out.print("Enter the borrower name:");
		String borrower = scan.nextLine();
		Rent r = null;
							
		
		try {
			 r = rentCollection.getRentByItemNameAndBorrower(iName, borrower);	
		}catch (NullPointerException ex) {
		}
		if(r==null){
			System.out.println("No such rent found!");	
		}
		r.setStatus("Returned"); // edits a Rent
		rentCollection.saveDataToFile(); // save changes to file 
	}

	public void case9() {

		do {

			System.out.println("Remove data from CD List\nEnter Index: ");
			int removeIndexInput = Integer.parseInt(scan.nextLine());

			cDCollection.remove(removeIndexInput);

			System.out.println("If you want to remove another CD press ENTER, else type OK");
			obsoleteInput = scan.nextLine();

		} while (!obsoleteInput.equalsIgnoreCase("OK"));

		try {
			cDCollection.saveDataToFile();
		} catch (Exception ex) {
		}
		cDCollection.printCDCollection();
	}

	public void case10() {
		do {
			System.out.println("Check for CD by name\nEnter Name: ");
			String nameInput = scan.nextLine();
			
			cDCollection.getCDByName(nameInput).printCD();
			
			System.out.println("If Completed Checking, Type OK, To check more ENTER");
			obsoleteInput = scan.nextLine();

		} while (!obsoleteInput.equalsIgnoreCase("OK"));

	}

	public void case11() {
		System.out.println("CD Details\n");
		cDCollection.printCDCollection();
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("Member Details\n");
		memberCollection.printMemberCollection();
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("Rent Details\n");
		System.out.println("\tItem Name\t   Item Type     Borrower Name\t\tRentedDate\t\t\tDueDate\t\t\t\tStatus");

		rentCollection.printRentCollection();
		System.out
				.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}

	public void case13() {
		do {
			System.out.println("Remove member from member List\nEnter Index: ");
			int removeIndexInput = Integer.parseInt(scan.nextLine());
			memberCollection.remove(removeIndexInput);
			System.out.println("If you want to remove another member press ENTER, else type OK");
			obsoleteInput = scan.nextLine();

		} while (!obsoleteInput.equalsIgnoreCase("OK"));
		try {
			memberCollection.saveDataToFile();
		} catch (Exception ex) {
		}
		memberCollection.printMemberCollection();

	}

	public void case14() {
		do {
			System.out.println("Remove rental from rental List\nEnter  Rental Index: ");
			int removeIndexInput = Integer.parseInt(scan.nextLine());
			rentCollection.remove(removeIndexInput);
			System.out.println("If you want to remove another rental press ENTER, else type OK");
			obsoleteInput = scan.nextLine();

		} while (!obsoleteInput.equalsIgnoreCase("OK"));
		try {
			rentCollection.saveDataToFile();
		} catch (Exception ex) {
		}
		rentCollection.printRentCollection();

	}

	public void case15() {
		
		System.out.print(" 1 # Delete Mobile No\t2 # Edit Mobile No");
		int sug = Integer.parseInt(scan.nextLine());
		switch (sug) {
		case 1:
			System.out.print("Enter the member name:");
			String iName = scan.nextLine();
			Member m = memberCollection.deleteMobileNo(iName);
			m.setMobileNumber("        ");			
			// memberCollection.saveDataToFile();
			// try {
			// memberCollection.saveDataToFile();
			// } catch (IOException e) {
			// }
			memberCollection.printMemberCollection();
			break;

		case 2:
			System.out.print("Enter the member name:");
			 iName = scan.nextLine();
			System.out.print("Enter the new mobile number :");
			String edit = scan.nextLine();
			m = memberCollection.deleteMobileNo(iName);
			m.setMobileNumber(edit);			
			// memberCollection.saveDataToFile();
			// try {
			// memberCollection.saveDataToFile();
			// } catch (IOException ex) {
			// }
			memberCollection.printMemberCollection();
			break;
		}

	}

	int dirInput;

	public void Run() {

		System.out
				.println("\n------------------------------------------ CD UNIVERSE ------------- CD UNIVERSE ------------- CD UNIVERSE -------------- CD UNIVERSE --------------- CD UNIVERSE ---------------- CD UNIVERSE --------------------- CD UNIVERSE --------------------- CD UNIVERSE --------------------- CD UNIVERSE --------------------- CD UNIVERSE --------------------- CD UNIVERSE --------------------- CD UNIVERSE --------------------- CD UNIVERSE -----------------------------------------------------------\n");
		System.out.println("  WELCOME TO CD UNIVERSE ");
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		do {
			System.out
					.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Date: " + d + "\n" + "Time: " + dateFormat.format(d));
			System.out
					.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\tFind Your Direction: ");
			System.out
					.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			System.out
					.println(" 1  # Add New CD      \t\t 5 # View CD List   \t\t 9  # Remove CD   \n 2  # Add New Member   \t\t 6 # View Member List \t\t 10 # Check CD  \n 3  # Add New Rental   \t\t 7 # View Rent List   \t\t 11 # View All Lists  \n 4  # Return Rental\t\t 8 # View Reminder List\t\t 12 # Exit System\n 13 # Remove member \t\t 14# Remove Rental \t\t 15 # Delete or Edit MobileNo in Member Detail\n");
			do {
				while (!sc.hasNextInt()) {
					System.out.println("Please Point Your Direction Between 1 to 15:");
					sc.next();
				}
				dirInput = sc.nextInt();

				if (!(dirInput >= 1 && dirInput <= 15)) {
					System.out.println("Invalid Choice!");
				}
			} while (dirInput < 1 || dirInput > 15);

			switch (dirInput) {
			case 1:
				case1();
				break;

			case 2:
				case2();
				break;

			case 3:
				case3();
				break;

			case 4:
				case4();
				break;

			case 5:
				cDCollection.printCDCollection();
				break;

			case 6:
				memberCollection.printMemberCollection();
				break;

			case 7:
				rentCollection.printRentCollection();
				break;

			case 8:
				rentCollection.printOverDueRents();
				break;

			case 9:
				case9();
				break;

			case 10:
				case10();
				break;

			case 11:
				case11();
				break;

			case 12:
				System.out.println("You're out!");
				scan.close(); // Scanner is closed before system exit
				System.exit(0);
				break;
			case 13:
				case13();
				break;
			case 14:
				case14();
				break;
			case 15:
				case15();
				break;

			}// switch's brace
		} while (true);
	}

}
