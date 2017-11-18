import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemberCollection {
	String file = "MemberCollection.txt";

	ArrayList<Member> members = new ArrayList<Member>();

	public MemberCollection() {
		try {
			LoadDataFromFile();
		} catch (Exception ex) {
		}
	}

	public void addMember(Member member) {
		members.add(member);
	}

	public Member getMemberByIndex(int index) {
		return members.get(index);
	}

	public void remove(int index) {
		members.remove(index);
	}

	public Member deleteMobileNo(String name) {
		for (Member member : members) {
			if (member.getName().equalsIgnoreCase(name)) {
				return member;
			}
		}
		return null;
	}

	public Member getMemberByName(String name) {
		for (Member member : members) {
			if (member.getName().equalsIgnoreCase(name)) {
				return member;
			}
		}
		return null;
	}

	public Member getMemberByMobileNo(String mobileNumber) {
		for (Member member : members) {
			if (member.getMobileNumber().equalsIgnoreCase(mobileNumber)) {
				return member;
			}
		}
		return null;
	}

	public void printMemberCollection() {
		for (Member member : members) {
			System.out.print(members.indexOf(member) + " # ");
			member.printMember();
		}
	}

	public void saveDataToFile() throws IOException {
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		for (Member member : members) {
			writer.write(member.getStandardData());
		}
		writer.flush();
		writer.close();
		bufferedWriter.close();
	}

	public void LoadDataFromFile() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));
		for (String line; (line = br.readLine()) != null;) {
			String[] data = line.split(",");
			addMember(new Member(data[0], data[1], data[2]));
		}
		br.close();
	}
}
